package fortylines.io.fortylines_hr.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {
    private String firstName;
    private String lastName;

    private String email;
    private String password;
}
