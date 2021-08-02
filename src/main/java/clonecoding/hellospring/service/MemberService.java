package clonecoding.hellospring.service;

import clonecoding.hellospring.domain.Member;
import clonecoding.hellospring.repository.MemberRepository;
import clonecoding.hellospring.repository.impl.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

/**
 * 현재는 순수 자바코드이다.
 * 스프링 컨테이너에 등록이 되지않았음.
 * java 소스로 직접 등록함.
 */
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입.
     * 
     * @param member
     * @return
     */
    public Long join(Member member) {
        // TODO 같은 이름이 있는 중복 회원 x
        validateDuplicate(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicate(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }


    /**
     * 전체 회원 조회
     * @return
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long id) {
        return memberRepository.findById(id);
    }

}
