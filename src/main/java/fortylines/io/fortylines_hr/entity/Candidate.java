package fortylines.io.fortylines_hr.entity;

import fortylines.io.fortylines_hr.enams.Language;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "candidates")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
