package fortylines.io.fortylines_hr.service.Impl;

import fortylines.io.fortylines_hr.dto.VacancyRequest;
import fortylines.io.fortylines_hr.dto.VacancyResponse;
import fortylines.io.fortylines_hr.entity.Vacancy;
import fortylines.io.fortylines_hr.exceptions.NotFoundException;
import fortylines.io.fortylines_hr.mapper.VacancyMapper;
import fortylines.io.fortylines_hr.repository.VacancyRepository;
import fortylines.io.fortylines_hr.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {

    private final VacancyMapper vacancyMapper;
    private final VacancyRepository vacancyRepository;

    @Override
    public VacancyResponse create(VacancyRequest vacancyRequest) {
        return vacancyMapper.view(vacancyRepository.save(vacancyMapper.create(vacancyRequest)));
    }

    @Override
    public VacancyResponse update(Long id, VacancyRequest vacancyRequest) {
        Vacancy vacancy = vacancyRepository.findById(id).orElseThrow(() -> {

            throw new NotFoundException(String.format("vacancy with id = %s does not exists", id));
        });
        vacancyMapper.update(vacancy, vacancyRequest);
        return vacancyMapper.view(vacancyRepository.save(vacancy));
    }

    @Override
    public VacancyResponse getById(Long id) {
        return vacancyMapper.view(vacancyRepository.findById(id).orElseThrow(() -> {

            throw new NotFoundException(String.format("vacancy with id = %s does not exists", id));
        }));
    }

    @Override
    public VacancyResponse deleteById(Long id) {
        Vacancy vacancy = vacancyRepository.findById(id).orElseThrow(() -> {

            throw new NotFoundException(String.format("vacancy with id = %s does not exists", id));
        });
        vacancyRepository.deleteById(id);
        return vacancyMapper.view(vacancy);
    }

    @Override
    public List<VacancyResponse> getAll() {
        return vacancyMapper.views(vacancyRepository.findAll());
    }
}
