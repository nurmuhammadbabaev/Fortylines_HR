package fortylines.io.fortylines_hr.controller;

import fortylines.io.fortylines_hr.dto.VacancyRequest;
import fortylines.io.fortylines_hr.dto.VacancyResponse;
import fortylines.io.fortylines_hr.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacancies")
@RequiredArgsConstructor
public class VacancyController {

    private final VacancyService vacancyService;


    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN','HEADOF','EMPLOYEE')")
    public VacancyResponse create(@RequestBody VacancyRequest vacancyRequest) {
        return vacancyService.create(vacancyRequest);
    }

    @PutMapping("/update/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','HEADOF','EMPLOYEE')")
    public VacancyResponse update(@PathVariable Long id, @RequestBody VacancyRequest vacancyRequest) {
        return vacancyService.update(id, vacancyRequest);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','HEADOF')")
    public VacancyResponse getById(@PathVariable Long id) {
        return vacancyService.getById(id);
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','HEADOF')")
    public VacancyResponse deleteById(@PathVariable Long id) {
        return vacancyService.deleteById(id);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyAuthority('ADMIN','HEADOF')")
    public List<VacancyResponse> getAll() {
        return vacancyService.getAll();
    }
}
