package fortylines.io.fortylines_hr.mapper;

import fortylines.io.fortylines_hr.dto.CandidateRequest;
import fortylines.io.fortylines_hr.dto.CandidateResponse;
import fortylines.io.fortylines_hr.entity.Candidate;

import java.util.List;

public interface CandidateMapper {

    Candidate create(CandidateRequest candidateRequest);
    Candidate update(Candidate candidate,CandidateRequest candidateRequest);
    CandidateResponse view(Candidate candidate);
    List<CandidateResponse> views(List<Candidate>candidates);
}
