package hello.mvc.domain.login;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Repository
public class LoginMemberRepository {
    private static Map<Long, LoginMember> store = new HashMap<>();
    private static long sequence = 0L;

    public LoginMember save(LoginMember loginMember) {
        loginMember.setId(++sequence);
        store.put(loginMember.getId(), loginMember);
        return loginMember;
    }

    public LoginMember findById(Long id) {
        return store.get(id);
    }

    public LoginMember findByLoginId(String loginId) {
        for (LoginMember loginMember : store.values()) {
            if (loginMember.getLoginId().equals(loginId)) {
                return loginMember;
            }
        }
        return null;
    }

    public List<LoginMember> findByAll() {
        return new ArrayList<>(store.values());
    }
}
