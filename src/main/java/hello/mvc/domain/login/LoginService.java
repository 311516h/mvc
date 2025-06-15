package hello.mvc.domain.login;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final LoginMemberRepository repository;

    /**
     * return null 이면 로그인 실패
     */
    public LoginMember login(String loginId, String password) {
        LoginMember member = repository.findByLoginId(loginId);
        if (member == null) return null;
        if (!member.getPassword().equals(password)) return null;
        return member;
    }
}
