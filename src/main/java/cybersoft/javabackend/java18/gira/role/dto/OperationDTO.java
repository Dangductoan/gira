package cybersoft.javabackend.java18.gira.role.dto;

import cybersoft.javabackend.java18.gira.role.model.Operation;
import cybersoft.javabackend.java18.gira.role.validation.anotation.UniqueOperationName;
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
    @UniqueOperationName
    private String name;

    @NotBlank(message = "{operation.description.blank}")
    private String description;

    private Operation.Type type;

}
