package fortylines.io.fortylines_hr.service;

import fortylines.io.fortylines_hr.dto.CandidateRequest;
import fortylines.io.fortylines_hr.dto.CandidateResponse;

import java.util.List;

public interface CandidateService {

    CandidateResponse create(CandidateRequest candidateRequest);
    CandidateResponse update(Long id,CandidateRequest candidateRequest);
    CandidateResponse getById(Long id);
    CandidateResponse deleteById(Long id);
    List<CandidateResponse> getAll();
}
