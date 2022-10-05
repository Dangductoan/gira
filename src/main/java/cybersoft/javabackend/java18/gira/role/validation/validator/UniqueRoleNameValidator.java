package cybersoft.javabackend.java18.gira.role.validation.validator;

import cybersoft.javabackend.java18.gira.role.model.Role;
import cybersoft.javabackend.java18.gira.role.repository.RoleRepository;
import cybersoft.javabackend.java18.gira.role.validation.anotation.UniqueRoleName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueRoleNameValidator implements ConstraintValidator<UniqueRoleName,String> {
    private String message;
    private final RoleRepository roleRepository;

    public UniqueRoleNameValidator(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void initialize(UniqueRoleName constraintAnnotation) {
      message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        Optional<Role> roleOpt = roleRepository.findByName(name);
        if(roleOpt.isEmpty())
            return true;
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
