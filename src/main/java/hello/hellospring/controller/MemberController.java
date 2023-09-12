package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private MemberService memberService;

    /*@Autowired
    public void setMemberService(MemberService memberService){ ->setter 이용
        //->public을 유지해야함. 중간에 Service가 바뀔 수 있다는 단점이 있다.
        this.memberService=memberService;
    }*/

    //private final MemberService memberService=new MemberService();
    //위 코드처럼 작성하지 않고 스프링 컨테이너에 등록해서 사용 ->하나만 등록됨
    @Autowired //->어노테이션을 작성하려고 하는 클래스는 스프링 컨테이너에 등록해야 함.
    //private MemberService memberService; ->필드 주입.
    //중간에 바꿀 방법이 없기 때문에 좋은 방법은 아니다.
    public MemberController(MemberService memberService){ //->생성자를 통한 주입
        this.memberService=memberService;
        //java: cannot find symbol
        //  symbol: variable memberService ->스프링이 MemberService를 찾을 수 없음.

    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new") //post방식으로 해당 url가 요청이 오는 경우 매핑
    public String create(MemberForm form){
        //input 태그에 name="name"을 보고 스프링이 MemberFrom의 name 필드에 setName() 메소드로 값을 집어넣음
        Member member=new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members=memberService.findMembers();
        model.addAttribute("members",members);

        return "members/memberList";
    }
}
