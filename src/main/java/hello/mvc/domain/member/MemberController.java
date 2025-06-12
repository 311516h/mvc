package hello.mvc.domain.member;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    private final MemberRepository memberRepository = MemberRepository.getInstance();

    @PostMapping
    public ResponseEntity<Member> addMembers(@RequestBody Member member) {
        Member savedMember = memberRepository.save(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMember);
    }

    @GetMapping
    public List<Member> memberList() {
        return memberRepository.findByAll();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMember(
            @PathVariable("id") Long id,
            @RequestBody Member updateParam) {

        Member member = memberRepository.findById(id);
        if (member == null) {
            return ResponseEntity.notFound().build();
        }

        member.setUsername(updateParam.getUsername());
        member.setAge(updateParam.getAge());
        return ResponseEntity.ok("수정 완료");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable("id") Long id) {
        Member member = memberRepository.findById(id);
        if (member == null) {
            return ResponseEntity.notFound().build();
        }
        memberRepository.delete(id);

        return ResponseEntity.ok("삭제 완료");
    }
}
