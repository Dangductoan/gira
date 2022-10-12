package cybersoft.javabackend.java18.gira.user.boundary;

import cybersoft.javabackend.java18.gira.common.util.ResponseUtils;
import cybersoft.javabackend.java18.gira.user.dto.UserDTO;
import cybersoft.javabackend.java18.gira.user.model.User;
import cybersoft.javabackend.java18.gira.user.service.UserService;
import org.apache.tomcat.util.http.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin
public class UserRestResource {
    private final UserService userService;

    public UserRestResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Object findALlUser() {
        return ResponseUtils.get(
                userService.findAllDto(UserDTO.class),
                HttpStatus.OK
        );
    }
    @PostMapping
    public Object saveUser(@RequestBody @Valid UserDTO userDTO) {
        return ResponseUtils.get(
          userService.save(userDTO, User.class, UserDTO.class)  ,
          HttpStatus.CREATED
        );
    }

}
