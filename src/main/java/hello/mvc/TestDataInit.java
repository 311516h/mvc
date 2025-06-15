package hello.mvc;

import hello.mvc.domain.login.LoginMember;
import hello.mvc.domain.login.LoginMemberRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final LoginMemberRepository loginMemberRepository;

    @PostConstruct
    public void init() {
        LoginMember member = new LoginMember();
        member.setLoginId("testUser");
        member.setName("테스트유저");
        member.setPassword("1234");

        loginMemberRepository.save(member);
    }
}
