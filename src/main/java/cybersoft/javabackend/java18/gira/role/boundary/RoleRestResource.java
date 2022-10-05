package cybersoft.javabackend.java18.gira.role.boundary;

import cybersoft.javabackend.java18.gira.common.util.ResponseUtils;
import cybersoft.javabackend.java18.gira.role.dto.RoleDTO;
import cybersoft.javabackend.java18.gira.role.model.Role;
import cybersoft.javabackend.java18.gira.role.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/roles")
public class RoleRestResource {
    private final RoleService roleService;

    public RoleRestResource(RoleService roleService) {
        this.roleService = roleService;
    }
    @GetMapping
    public Object findAll(){

        return ResponseUtils.get(roleService.findAllDto(RoleDTO.class), HttpStatus.OK);
    }
    @PostMapping
    public Object save(@RequestBody @Valid RoleDTO roleDTO ) {
        return new ResponseEntity<>(roleService.save(roleDTO), HttpStatus.CREATED);
    }
}
