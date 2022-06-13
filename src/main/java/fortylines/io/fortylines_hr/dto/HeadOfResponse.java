package fortylines.io.fortylines_hr.dto;

import fortylines.io.fortylines_hr.enams.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeadOfResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;

}
