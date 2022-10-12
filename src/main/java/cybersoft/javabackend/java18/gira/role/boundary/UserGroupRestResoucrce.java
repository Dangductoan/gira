package cybersoft.javabackend.java18.gira.role.boundary;

import cybersoft.javabackend.java18.gira.common.util.ResponseUtils;
import cybersoft.javabackend.java18.gira.role.dto.UserGroupDTO;
import cybersoft.javabackend.java18.gira.role.model.UserGroup;
import cybersoft.javabackend.java18.gira.role.service.UserGroupService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/usergroups")
@CrossOrigin
public class UserGroupRestResoucrce {
    private final UserGroupService userGroupService;

    public UserGroupRestResoucrce(UserGroupService userGroupService) {
        this.userGroupService = userGroupService;
    }

    @GetMapping
    public Object findAllUserGroup() {
       return ResponseUtils.get(
               userGroupService.findAllDto(UserGroupDTO.class) ,
               HttpStatus.OK
       );
    }
    @GetMapping("/include-users")
    public Object findAllUserGroupIncludeUsers() {
        return ResponseUtils.get(
                userGroupService.findAllDtoIncludeUsers() ,
                HttpStatus.OK
        );
    }
    @PostMapping
    public Object saveUserGroup(@RequestBody @Valid UserGroupDTO userGroupDTO) {
        return ResponseUtils.get(
                userGroupService.save(userGroupDTO, UserGroup.class,UserGroupDTO.class),
                HttpStatus.CREATED
        );
    }
    @PostMapping("/{user-group-id}/add-users")
    public Object addUsers(
            @RequestBody List<UUID> ids,
            @PathVariable("user-group-id") UUID userGroupID
            ) {
        return ResponseUtils.get(
                userGroupService.addUsers(userGroupID,ids),
                HttpStatus.OK
        );
    }

}
