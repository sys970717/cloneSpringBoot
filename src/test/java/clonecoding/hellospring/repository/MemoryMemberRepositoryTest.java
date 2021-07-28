package clonecoding.hellospring.repository;

import clonecoding.hellospring.domain.Member;
import clonecoding.hellospring.repository.impl.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        // 테스트 시 순서를 보장할 수 없기에 의존성 문제가 발생하지 않도록 한다.
        // 한 개의 테스트가 끝나면 데이터를 초기화한다.
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("HIHIHI");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }
    
    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("member1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("member2");
        repository.save(member2);

        Member result = repository.findByName("member1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
