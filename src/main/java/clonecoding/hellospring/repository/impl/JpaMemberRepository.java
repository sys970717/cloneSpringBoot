package clonecoding.hellospring.repository.impl;

import clonecoding.hellospring.domain.Member;
import clonecoding.hellospring.repository.MemberRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList()
                .stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        //JPQL
        // Member 라는 대상으로 쿼리 실행.
        // 객체 자체를 찾는다.
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
