package fortylines.io.fortylines_hr.controller;

import fortylines.io.fortylines_hr.dto.CandidateRequest;
import fortylines.io.fortylines_hr.dto.CandidateResponse;
import fortylines.io.fortylines_hr.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidates")
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('EMPLOYEE')")
public class CandidateController {

    private final CandidateService candidateService;

    @PostMapping
    public CandidateResponse create(@RequestBody CandidateRequest candidateRequest) {
        return candidateService.create(candidateRequest);
    }

    @PutMapping("/update/{id}")
    public CandidateResponse update(@PathVariable Long id, @RequestBody CandidateRequest candidateRequest) {
        return candidateService.update(id, candidateRequest);
    }

    @GetMapping("/{id}")
    public CandidateResponse getById(@PathVariable Long id) {
        return candidateService.getById(id);
    }

    @DeleteMapping("/{id}")
    public CandidateResponse deleteById(@PathVariable Long id) {
        return candidateService.deleteById(id);
    }

    @GetMapping("/all")
    public List<CandidateResponse> getAll() {
        return candidateService.getAll();
    }
}
