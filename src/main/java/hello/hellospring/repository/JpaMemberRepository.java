package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em){
        this.em=em;
    }
    @Override
    public Member save(Member member) {
        em.persist(member); //insert 쿼리를 알아서 만들어서 실행해준다.
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member=em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result=em.createQuery("select m from Member m where m.name =:name", Member.class).setParameter("name",name).getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        return em.createQuery("SELECT M FROM Member M",Member.class).getResultList(); //*이 아닌 Entity 자체를 조회
        //Jpa가 엔티티를 매핑하고 있다. >ORM

    }
}
