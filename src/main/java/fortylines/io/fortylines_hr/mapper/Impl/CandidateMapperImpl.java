package fortylines.io.fortylines_hr.mapper.Impl;

import fortylines.io.fortylines_hr.dto.CandidateRequest;
import fortylines.io.fortylines_hr.dto.CandidateResponse;
import fortylines.io.fortylines_hr.entity.Candidate;
import fortylines.io.fortylines_hr.mapper.CandidateMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CandidateMapperImpl implements CandidateMapper {

    @Override
    public Candidate create(CandidateRequest candidateRequest) {
        if (candidateRequest == null) {
            return null;
        }
        Candidate candidate = new Candidate();
        candidate.setFirstName(candidateRequest.getFirstName());
        candidate.setLastName(candidateRequest.getLastName());
        candidate.setPhone(candidateRequest.getPhone());
        candidate.setEmail(candidateRequest.getEmail());
        candidate.setDepartment(candidateRequest.getDepartment());
        candidate.setSkype(candidateRequest.getSkype());
        candidate.setDiscord(candidateRequest.getDiscord());
        candidate.setLanguage(candidateRequest.getLanguage());
        candidate.setYearsOfExperience(candidateRequest.getYearsOfExperience());
        candidate.setDegree(candidateRequest.getDegree());

        return candidate;
    }

    @Override
    public Candidate update(Candidate candidate, CandidateRequest candidateRequest) {
        candidate.setFirstName(candidateRequest.getFirstName());
        candidate.setLastName(candidateRequest.getLastName());
        candidate.setPhone(candidateRequest.getPhone());
        candidate.setEmail(candidateRequest.getEmail());
        candidate.setDepartment(candidateRequest.getDepartment());
        candidate.setSkype(candidateRequest.getSkype());
        candidate.setDiscord(candidateRequest.getDiscord());
        candidate.setLanguage(candidateRequest.getLanguage());
        candidate.setYearsOfExperience(candidateRequest.getYearsOfExperience());
        candidate.setDegree(candidateRequest.getDegree());

        return candidate;
    }

    @Override
    public CandidateResponse view(Candidate candidate) {
        CandidateResponse candidateResponse = new CandidateResponse();
        candidateResponse.setId(candidate.getId());
        candidateResponse.setFirstName(candidate.getFirstName());
        candidateResponse.setLastName(candidate.getLastName());
        candidateResponse.setPhone(candidate.getPhone());
        candidateResponse.setEmail(candidate.getEmail());
        candidateResponse.setDepartment(candidate.getDepartment());
        candidateResponse.setSkype(candidate.getSkype());
        candidateResponse.setDiscord(candidate.getDiscord());
        candidateResponse.setYearsOfExperience(candidate.getYearsOfExperience());
        candidateResponse.setLanguage(candidate.getLanguage());
        candidateResponse.setDegree(candidate.getDegree());

        return candidateResponse;
    }

    @Override
    public List<CandidateResponse> views(List<Candidate> candidates) {
        List<CandidateResponse> candidateResponses = new ArrayList<>();
        for (Candidate c : candidates) {
            candidateResponses.add(view(c));
        }
        return candidateResponses;
    }
}
