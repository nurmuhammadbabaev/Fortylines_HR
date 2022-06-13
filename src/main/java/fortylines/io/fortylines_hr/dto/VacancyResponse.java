package fortylines.io.fortylines_hr.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VacancyResponse {

    private Long id;
    private String vacancy;
    private String type;
    private String value;
}
