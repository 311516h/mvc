package hello.mvc.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberRepository memberRepository = MemberRepository.getInstance();
    MemberService memberService = new MemberService();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void validateDuplicateMember() {
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member1", 21);

        memberRepository.save(member1);

        try {
            memberService.validateDuplicateMember(member2);
            fail("예외가 발생해야 하는데 발생하지 않았습니다.");
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }

    }
}