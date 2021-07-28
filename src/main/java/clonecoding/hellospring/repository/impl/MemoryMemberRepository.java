package clonecoding.hellospring.repository.impl;

import clonecoding.hellospring.domain.Member;
import clonecoding.hellospring.repository.MemberRepository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {
    // 실무에서는 동시성 문제로 인해 concurrentHashMap 사용.
    private static Map<Long, Member> store = new HashMap<>();
    // 실무에서는 동시성 문제로 인해 AtomicLong 사용.
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
