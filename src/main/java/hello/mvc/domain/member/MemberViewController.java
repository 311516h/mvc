package hello.mvc.domain.member;

import hello.mvc.domain.member.Member;
import hello.mvc.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/members")
public class MemberViewController {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    //회원 목록
    @GetMapping
    public String list(Model model) {
        List<Member> members = memberRepository.findByAll();
        model.addAttribute("members", members);
        return "members/list";
    }

    //회원 등록 폼
    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("member", new Member());
        return "members/form";
    }

    //회원 등록 처리
    @PostMapping("/new")
    public String save(@ModelAttribute Member member) {
        memberRepository.save(member);
        return "redirect:/members"; // 등록 후 목록으로 이동
    }

    //회원 수정 폼
    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        Member member = memberRepository.findById(id);
        model.addAttribute("member", member);
        return "members/edit";
    }

    //회원 수정 처리
    @PostMapping("{id}/edit")
    public String update(@PathVariable Long id, @ModelAttribute Member updatedMember) {
        memberRepository.update(id, updatedMember);
        return "redirect:/members";
    }

    //회원 삭제
    @PostMapping("{id}/delete")
    public String delete(@PathVariable Long id) {
        memberRepository.delete(id);
        return "redirect:/members";
    }
}
