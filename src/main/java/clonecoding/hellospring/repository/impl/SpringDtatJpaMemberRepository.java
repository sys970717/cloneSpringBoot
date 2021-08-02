package clonecoding.hellospring.repository.impl;

import clonecoding.hellospring.domain.Member;
import clonecoding.hellospring.repository.MemberRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDtatJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    @Override
    Optional<Member> findByName(String name);
}
