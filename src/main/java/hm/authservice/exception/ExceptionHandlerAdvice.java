package hm.authservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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

    @ExceptionHandler (RuntimeException.class)
    public ResponseEntity<String> authHandlerRuntimeException (RuntimeException e) {
        System.out.println(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
    }
}
