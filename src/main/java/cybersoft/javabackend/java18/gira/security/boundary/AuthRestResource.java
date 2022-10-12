package cybersoft.javabackend.java18.gira.security.boundary;

import cybersoft.javabackend.java18.gira.common.util.ResponseUtils;

import cybersoft.javabackend.java18.gira.security.dto.LoginDTO;
import cybersoft.javabackend.java18.gira.security.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("auth")
@CrossOrigin
public class AuthRestResource {
    private static final Logger LOG = LoggerFactory.getLogger(AuthRestResource.class);

    private final AuthService authService;

    public AuthRestResource(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("login")
    public Object login(@RequestBody @Valid LoginDTO loginDTO) {
        LOG.debug("Token requested for user: '{}'", loginDTO.getUsername());
        return ResponseUtils.get(
                authService.login(loginDTO),
                HttpStatus.OK
        );

    }
}
