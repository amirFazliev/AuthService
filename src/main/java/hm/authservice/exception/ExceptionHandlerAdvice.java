package hm.authservice.exception;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler (InvalidCredentials.class)
    public ResponseEntity<String> authHandlerInvalidCredentials (InvalidCredentials e) {
        System.out.println(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(400));
    }

    @ExceptionHandler (UnauthorizedUser.class)
    public ResponseEntity<String> authHandlerUnauthorizedUser (UnauthorizedUser e) {
        System.out.println(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatusCode.valueOf(401));
    }

    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity<Object> authHandlerMethodArgumentNotValidException (MethodArgumentNotValidException e) {
        return new ResponseEntity<>(Objects.requireNonNull(e.getDetailMessageArguments())[1], HttpStatusCode.valueOf(415));
    }
}
