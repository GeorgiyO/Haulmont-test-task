package nekogochan.controller.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import nekogochan.repository.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.validation.ConstraintViolationException;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
@Log4j2
public class ExceptionsHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<ApiError> handleValidationExceptions(ConstraintViolationException ex) {
        return apiError(
            HttpStatus.BAD_REQUEST,
            "constraint violation",
            ex.getConstraintViolations()
              .stream()
              .collect(Collectors.toMap(
                  (v) -> v.getPropertyPath().toString(),
                  (v) -> v.getMessage())
              )
        );
    }

    @ExceptionHandler(EntityNotFoundException.class)
    ResponseEntity<ApiError> entityNotFoundHandler(EntityNotFoundException ex) {
        return apiError(HttpStatus.NOT_FOUND, "not found", ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus()
    ResponseEntity<ApiError> invalidArgumentErrorHandler(MethodArgumentTypeMismatchException ex) {
        return apiError(
            HttpStatus.BAD_REQUEST,
            "argument type mismatch",
            Map.of(
                "name", String.valueOf(ex.getName()),
                "message", String.valueOf(ex.getMessage())
            )
        );
    }

    ResponseEntity<ApiError> apiError(HttpStatus code, String type, Object body) {
        return new ResponseEntity<>(new ApiError(code.value(), type, body), code);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    static class ApiError {
        private int code;
        private String type;
        private Object body;
    }

}
