package cybersoft.javabackend.java18.gira.role.dto;

import cybersoft.javabackend.java18.gira.user.dto.UserDTO;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserGroupWithUsersDTO {
    private UUID id;

    private String name;

    private String code;

    private String description;

    private Set<UserDTO> users = new LinkedHashSet<>();
}
