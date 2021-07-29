package clonecoding.hellospring;

import clonecoding.hellospring.repository.MemberRepository;
import clonecoding.hellospring.repository.impl.MemoryMemberRepository;
import clonecoding.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
