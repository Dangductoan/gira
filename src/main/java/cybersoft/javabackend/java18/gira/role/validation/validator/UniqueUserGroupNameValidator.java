package cybersoft.javabackend.java18.gira.role.validation.validator;

import cybersoft.javabackend.java18.gira.role.model.UserGroup;
import cybersoft.javabackend.java18.gira.role.repository.UserGroupRepository;
import cybersoft.javabackend.java18.gira.role.validation.anotation.UniqueUserGroupName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueUserGroupNameValidator implements ConstraintValidator<UniqueUserGroupName, String> {
    private String message;
    private final UserGroupRepository userGroupRepository;

    public UniqueUserGroupNameValidator(UserGroupRepository userGroupRepository) {
        this.userGroupRepository = userGroupRepository;
    }

    @Override
    public void initialize(UniqueUserGroupName constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        Optional<UserGroup> userGroup = userGroupRepository.findByCode(code);
        if(userGroup.isEmpty())
            return true;
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
