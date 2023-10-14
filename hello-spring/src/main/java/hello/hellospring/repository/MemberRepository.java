package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //java8 이후 기능으로 null 대신 Optional로 감싸서 반환할 때 사용한다.
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
