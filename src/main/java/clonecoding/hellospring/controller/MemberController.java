package clonecoding.hellospring.controller;

import clonecoding.hellospring.domain.Member;
import clonecoding.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

// @Controller 어논테이션을 붙이면 스프링 컨테이너에 멤버 컨트롤러 객체를 생성하여 넣음.
/**
 * @Controller
 * 컴포넌트 스캔
 * @Component
 * 컴포넌트 어논테이션은 Controller 내에 있어, 컴포넌트 스캔때문에 스프링 컨테이너에 등록함.
 */
@Controller
public class MemberController {
    // 스프링 컨테이너에 등록하고 쓴다.
    private final MemberService memberService;

    // 스프링 컨테이너에서 가져온다, 외부에서의 주입 ( Dependency Injection )
    // 생성자 주입 방법.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "/members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        model.addAttribute("members", memberService.findMembers());
        return "members/memberList";
    }


}
