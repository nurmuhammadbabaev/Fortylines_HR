package fortylines.io.fortylines_hr.mapper.Impl;

import fortylines.io.fortylines_hr.dto.VacancyRequest;
import fortylines.io.fortylines_hr.dto.VacancyResponse;
import fortylines.io.fortylines_hr.entity.Vacancy;
import fortylines.io.fortylines_hr.mapper.VacancyMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VacancyMapperImpl implements VacancyMapper {


    @Override
    public Vacancy create(VacancyRequest vacancyRequest) {
        if (vacancyRequest==null) {
            return null;
        }
        Vacancy vacancy =new Vacancy();
        vacancy.setVacancy(vacancyRequest.getVacancy());
        vacancy.setType(vacancyRequest.getType());
        vacancy.setValue(vacancyRequest.getValue());

        return vacancy;
    }

    @Override
    public Vacancy update(Vacancy vacancy, VacancyRequest vacancyRequest) {

        vacancy.setVacancy(vacancyRequest.getVacancy());
        vacancy.setType(vacancyRequest.getType());
        vacancy.setValue(vacancyRequest.getValue());

        return vacancy;
    }

    @Override
    public VacancyResponse view(Vacancy vacancy) {
        VacancyResponse vacancyResponse=new VacancyResponse();
        if (vacancy.getId()!=null){
            vacancyResponse.setId(vacancy.getId());
        }
        vacancyResponse.setVacancy(vacancy.getVacancy());
        vacancyResponse.setType(vacancy.getType());
        vacancyResponse.setValue(vacancy.getValue());
        return vacancyResponse;
    }

    @Override
    public List<VacancyResponse> views(List<Vacancy> vacancies) {
        List<VacancyResponse>vacancyResponses=new ArrayList<>();
        for (Vacancy v:vacancies) {
            vacancyResponses.add(view(v));
        }
        return vacancyResponses;
    }
}
