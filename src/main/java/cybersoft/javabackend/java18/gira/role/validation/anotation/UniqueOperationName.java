package cybersoft.javabackend.java18.gira.role.validation.anotation;

import cybersoft.javabackend.java18.gira.role.validation.validator.UniqueOperationNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueOperationNameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UniqueOperationName {
    String message() default "{operation.name.existed}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
