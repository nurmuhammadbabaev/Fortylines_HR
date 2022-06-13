package fortylines.io.fortylines_hr.dto;

import fortylines.io.fortylines_hr.enams.Language;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CandidateRequest {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String skype;
    private String discord;
    private String department;
    private Language language;
    private String yearsOfExperience;
    private String degree;
}
