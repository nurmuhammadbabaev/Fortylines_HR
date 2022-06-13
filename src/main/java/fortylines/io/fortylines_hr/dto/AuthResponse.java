package fortylines.io.fortylines_hr.dto;

import fortylines.io.fortylines_hr.enams.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthResponse {

    private String firstName;
    private String lastName;
    private Role role;
    private String email;
    private String token;
}
