package fortylines.io.fortylines_hr.service.Impl;

import fortylines.io.fortylines_hr.dto.CandidateRequest;
import fortylines.io.fortylines_hr.dto.CandidateResponse;
import fortylines.io.fortylines_hr.entity.Candidate;
import fortylines.io.fortylines_hr.exceptions.NotFoundException;
import fortylines.io.fortylines_hr.mapper.CandidateMapper;
import fortylines.io.fortylines_hr.repository.CandidateRepository;
import fortylines.io.fortylines_hr.service.CandidateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidateMapper candidateMapper;
    private final CandidateRepository candidateRepository;

    @Override
    public CandidateResponse create(CandidateRequest candidateRequest) {
        return candidateMapper.view(candidateRepository.save(candidateMapper.create(candidateRequest)));
    }

    @Override
    public CandidateResponse update(Long id, CandidateRequest candidateRequest) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow(() -> {

            throw new NotFoundException(String.format("candidate with id = %s does not exists", id));
        });
        candidateMapper.update(candidate, candidateRequest);
        return candidateMapper.view(candidateRepository.save(candidate));
    }

    @Override
    public CandidateResponse getById(Long id) {
        return candidateMapper.view(candidateRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(String.format("candidate with id = %s does not exists", id));
        }));
    }

    @Override
    public CandidateResponse deleteById(Long id) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow(() -> {
            throw new NotFoundException(String.format("candidate with id = %s does not exists", id));
        });
        candidateRepository.deleteById(id);
        return candidateMapper.view(candidate);
    }

    @Override
    public List<CandidateResponse> getAll() {
        return candidateMapper.views(candidateRepository.findAll());
    }
}
