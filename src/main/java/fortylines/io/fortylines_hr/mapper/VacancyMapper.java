package fortylines.io.fortylines_hr.mapper;

import fortylines.io.fortylines_hr.dto.VacancyRequest;
import fortylines.io.fortylines_hr.dto.VacancyResponse;
import fortylines.io.fortylines_hr.entity.Vacancy;

import java.util.List;

public interface VacancyMapper {

    Vacancy create(VacancyRequest vacancyRequest);
    Vacancy update(Vacancy vacancy,VacancyRequest vacancyRequest);
    VacancyResponse view(Vacancy vacancy);
    List<VacancyResponse> views(List<Vacancy>vacancies);
}
