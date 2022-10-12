package cybersoft.javabackend.java18.gira.role.validation.validator;

import cybersoft.javabackend.java18.gira.role.model.Operation;
import cybersoft.javabackend.java18.gira.role.repository.OperationRepository;
import cybersoft.javabackend.java18.gira.role.validation.anotation.UniqueOperationName;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

public class UniqueOperationNameValidator implements ConstraintValidator<UniqueOperationName, String> {
    private final OperationRepository operationRepository;
    private String message;

    public UniqueOperationNameValidator(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @Override
    public void initialize(UniqueOperationName constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        Optional<Operation> operation = operationRepository.findByName(name);
        if(operation.isEmpty())
            return true;
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();
        return false;
    }
}
