package cybersoft.javabackend.java18.gira.role.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserGroupDTO {
    private UUID id;
    @Size(min = 5, max = 100, message = "{userGroup.name.size}")
    @NotBlank
    private String name;
    @Size(min = 3, max = 10, message = "{userGroup.code.size}")
    @NotBlank
    private String code;
    @NotBlank(message = "{userGroup.description.blank}")
    private String description;
}
