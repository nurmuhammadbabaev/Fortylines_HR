package fortylines.io.fortylines_hr.exceptions.handler;

import fortylines.io.fortylines_hr.dto.ResponseException;
import fortylines.io.fortylines_hr.exceptions.BadRequestException;
import fortylines.io.fortylines_hr.exceptions.InvalidArgumentException;
import fortylines.io.fortylines_hr.exceptions.NotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(NOT_FOUND)
    public ResponseException handleNotFoundException(NotFoundException notFoundException) {
        return ResponseException.builder()
                .httpStatus(NOT_FOUND)
                .message(notFoundException.getMessage())
                .build();
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(BAD_REQUEST)
    public ResponseException handleBadRequestException(BadRequestException badRequestException) {
        return ResponseException.builder()
                .httpStatus(BAD_REQUEST)
                .message(badRequestException.getMessage())
                .build();
    }


    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(UNAUTHORIZED)
    public ResponseException unauthorizedException(BadCredentialsException badCredentialsException) {
        return ResponseException.builder()
                .httpStatus(UNAUTHORIZED)
                .message(badCredentialsException.getMessage())
                .build();
    }

    @ExceptionHandler(InvalidArgumentException.class)
    @ResponseStatus(NOT_ACCEPTABLE)
    public ResponseException invalidArgumentException(InvalidArgumentException invalidArgumentException) {
        return ResponseException.builder()
                .httpStatus(NOT_ACCEPTABLE)
                .message(invalidArgumentException.getMessage())
                .build();
    }
}
