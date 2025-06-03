package hello.mvc.domain;

public class MemberService {

    MemberRepository memberRepository = MemberRepository.getInstance();

    public void validateDuplicateMember(Member member) {
        Member existing = memberRepository.findByName(member.getUsername());
        if (existing != null) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
}
