package cybersoft.javabackend.java18.gira.user.dto;

import cybersoft.javabackend.java18.gira.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class UserDTO {
    private UUID id;
    private String username;
    private String password;
    private String email;
    private String displayName;
    private String fullname;
    private String avatar;
    private User.Status status;
}
