package hello.mvc.domain.login;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginMember {

    @NotEmpty
    private String loginId;
    @NotEmpty
    private String name;
    @NotEmpty
    private String password;
}
