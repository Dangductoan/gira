package cybersoft.javabackend.java18.gira.security.dto;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDTO {
    @NotNull(message="Chưa nhập tên đăng nhập")
    private String username;
    @NotNull(message = "Chưa nhập tên mật khẩu")
    private String password;
}
