package cybersoft.javabackend.java18.gira.role.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {
    private UUID id;
    private String name;
    private String code;
    private String description;
}
