package clonecoding.hellospring;

import clonecoding.hellospring.repository.JdbcTemplateMemberRepository;
import clonecoding.hellospring.repository.MemberRepository;
import clonecoding.hellospring.repository.impl.MemoryMemberRepository;
import clonecoding.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
