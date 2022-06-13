package fortylines.io.fortylines_hr.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@Setter
public class ResponseException {
    private HttpStatus httpStatus;
    private String message;
}
