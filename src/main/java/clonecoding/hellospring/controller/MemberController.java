package clonecoding.hellospring.controller;

import clonecoding.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// @Controller 어논테이션을 붙이면 스프링 컨테이너에 멤버 컨트롤러 객체를 생성하여 넣음.
/**
 * @Controller
 * 컴포넌트 스캔
 * @Component
 * 컴포넌트 어논테이션은 Controller 내에 있어, 컴포넌트 스캔때문에 스프링 컨테이너에 등록함.
 */
@Controller
@RequestMapping("/member")
public class MemberController {
    // 스프링 컨테이너에 등록하고 쓴다.
    private final MemberService memberService;
//  @Autowired  private final MemberService memberService; => 필드 주입 방법.
/*
 => setter 주입 방식.
@Autowired
public void setMemberService(MemberService memberService) {
    this.memberService = memberService;
}
 */

    // 스프링 컨테이너에서 가져온다, 외부에서의 주입 ( Dependency Injection )
    // 생성자 주입 방법.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

}
