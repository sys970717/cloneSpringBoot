package clonecoding.hellospring.controller;

import clonecoding.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// @Controller 어논테이션을 붙이면 스프링 컨테이너에 멤버 컨트롤러 객체를 생성하여 넣음.
@Controller
@RequestMapping("")
public class MemberController {
    // 스프링 컨테이너에 등록하고 쓴다.
    private final MemberService memberService;

    // 스프링 컨테이너에서 가져온다.
    @Autowired
    // 의존관계를 주입한다. ( DI )
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
