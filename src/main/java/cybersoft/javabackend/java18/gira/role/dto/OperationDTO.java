package cybersoft.javabackend.java18.gira.role.dto;

import cybersoft.javabackend.java18.gira.role.model.Operation;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OperationDTO {

    private UUID id;
    @Size(min = 5, max = 100, message = "{operation.name.size}")
    @NotBlank
    private String name;
    @Size(min = 3, max = 10, message = "{operation.code.size}")
    @NotBlank
    private String code;
    @NotBlank(message = "{operation.description.blank}")
    private String description;
    private Operation.Type type;

}
