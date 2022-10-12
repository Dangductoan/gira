package cybersoft.javabackend.java18.gira.role.boundary;

import cybersoft.javabackend.java18.gira.common.util.ResponseUtils;
import cybersoft.javabackend.java18.gira.role.dto.OperationDTO;
import cybersoft.javabackend.java18.gira.role.model.Operation;
import cybersoft.javabackend.java18.gira.role.service.OperationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/operations")
@CrossOrigin
public class OperationRestResource {
    private final OperationService operationService;

    public OperationRestResource(OperationService operationService) {
        this.operationService = operationService;
    }

    @GetMapping
    public Object findAll() {
        return ResponseUtils.get(operationService.findAllDto(OperationDTO.class), HttpStatus.OK) ;
    }
    @PostMapping
    public Object save(@RequestBody @Valid OperationDTO dto) {
        return ResponseUtils.get(
                operationService.save(dto,Operation.class,OperationDTO.class),
                HttpStatus.CREATED) ;
    }


}
