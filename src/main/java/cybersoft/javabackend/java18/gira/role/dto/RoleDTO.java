package cybersoft.javabackend.java18.gira.role.dto;

import cybersoft.javabackend.java18.gira.role.validation.anotation.UniqueRoleCode;
import cybersoft.javabackend.java18.gira.role.validation.anotation.UniqueRoleName;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDTO {
    private UUID id;
    @Size(min = 5, max = 100, message = "{role.name.size}")
    @NotBlank
    @UniqueRoleName
    private String name;
    @Size(min = 3, max = 10, message = "{role.code.size}")
    @NotBlank
    @UniqueRoleCode
    private String code;
    @NotBlank(message = "{role.description.blank}")
    private String description;
}
