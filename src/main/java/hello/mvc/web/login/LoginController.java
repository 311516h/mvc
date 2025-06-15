package hello.mvc.web.login;

import hello.mvc.domain.login.LoginMember;
import hello.mvc.domain.login.LoginService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/login")
    public ResponseEntity<?> loginFormInfo() {
        return ResponseEntity.ok("POST /api/login 에 loginId, password 전달");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid LoginForm form,
                               HttpSession session) {

        LoginMember loginMember = loginService.login(form.getLoginId(), form.getPassword());

        log.info("login: {}", loginMember);

        if (loginMember == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
        }

        session.setAttribute("loginMember", loginMember);

        // 로그인 성공 시 사용자 정보 JSON 반환
        return ResponseEntity.ok(loginMember);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        return ResponseEntity.ok("로그아웃 성공");
    }
}
