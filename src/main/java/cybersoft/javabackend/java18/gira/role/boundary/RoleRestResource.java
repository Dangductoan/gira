package cybersoft.javabackend.java18.gira.role.boundary;

import cybersoft.javabackend.java18.gira.common.util.ResponseUtils;
import cybersoft.javabackend.java18.gira.role.dto.OperationDTO;
import cybersoft.javabackend.java18.gira.role.dto.RoleDTO;
import cybersoft.javabackend.java18.gira.role.model.Role;
import cybersoft.javabackend.java18.gira.role.service.RoleService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/roles")
@CrossOrigin
public class RoleRestResource {
    private final RoleService roleService;

    public RoleRestResource(RoleService roleService) {
        this.roleService = roleService;
    }
    @GetMapping
    public Object findAll(){

        return ResponseUtils.get(roleService.findAllDto(RoleDTO.class), HttpStatus.OK);
    }
    @GetMapping("/paging")
    public Object findAllDtoPaging(@RequestParam("size") int size,
                                   @RequestParam("index") int index){
        return ResponseUtils.get(
                roleService.findAllDto(Pageable.ofSize(size).withPage(index), RoleDTO.class)
                , HttpStatus.OK
        );
    }
    @PostMapping
    public Object save(@RequestBody @Valid RoleDTO roleDTO ) {
        return new ResponseEntity<>(roleService.save(roleDTO,Role.class, RoleDTO.class), HttpStatus.CREATED);
    }
    @PostMapping("/{role-id}/add-operations")
    public Object addOperations(@RequestBody  List<UUID> ids,
                                @PathVariable("role-id") UUID roleId
                                ) {
        return ResponseUtils.get(
                roleService.addOperations(ids,roleId), HttpStatus.OK
        );
    }
    @PostMapping("{role-id}/add-user-groups")
    public Object addUserGroups(
            @RequestBody List<UUID> ids,
            @PathVariable("role-id") UUID roleId){
        return ResponseUtils.get(
                roleService.addUserGroups(roleId, ids)
                , HttpStatus.OK
        );
    }
}
