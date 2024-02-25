package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 동시성 문제가 고려되어 있지 않음. 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 */
public class MemberRepository {

    private Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository(); //아무나 생성할 수 없도록 해야함

    public static MemberRepository getInstance() {
        return instance;
    }

    public MemberRepository() {
    }

    public Member save(Member memeber) {
        memeber.setId(++sequence);
        store.put(memeber.getId(), memeber);
        return memeber;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
        //새로운 List를 생성해서 값을 넘겨준다. ->store에 있는 값을 건들지 않고 새로 담아서 넘겨주기 때문에 외부에서 변경해도 영향이 없음.(store 자체를 보호하기 위함)
    }

    public void clearStore() {
        store.clear();
    }
}
