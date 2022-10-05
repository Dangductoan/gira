package cybersoft.javabackend.java18.gira.common.util;

import lombok.experimental.UtilityClass;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class ExceptionUtils {
    public static final String DEFAULT_UNEXPECTED_MESSAGE = "Some thing is wrong";
    public List<String > getErrors(ConstraintViolationException exception) {
        return exception.getConstraintViolations()
                .stream()
                .map(ConstraintViolation::getMessage)
                .toList();
    }
    public List<String > getErrors(RuntimeException exception) {
       return List.of(DEFAULT_UNEXPECTED_MESSAGE);
    }

    public static List<String> getErrors(MethodArgumentNotValidException exception) {
        return exception.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
    }
}
