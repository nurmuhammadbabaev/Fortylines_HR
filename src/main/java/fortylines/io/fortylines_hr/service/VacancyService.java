package fortylines.io.fortylines_hr.service;

import fortylines.io.fortylines_hr.dto.VacancyRequest;
import fortylines.io.fortylines_hr.dto.VacancyResponse;

import java.util.List;

public interface VacancyService {
    VacancyResponse create(VacancyRequest vacancyRequest);

    VacancyResponse update(Long id, VacancyRequest vacancyRequest);

    VacancyResponse getById(Long id);

    VacancyResponse deleteById(Long id);

    List<VacancyResponse> getAll();
}
