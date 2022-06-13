package fortylines.io.fortylines_hr.service.Impl;

import fortylines.io.fortylines_hr.dto.HeadOfRequest;
import fortylines.io.fortylines_hr.dto.HeadOfResponse;
import fortylines.io.fortylines_hr.entity.HeadOf;
import fortylines.io.fortylines_hr.entity.Validator;
import fortylines.io.fortylines_hr.exceptions.InvalidArgumentException;
import fortylines.io.fortylines_hr.exceptions.NotFoundException;
import fortylines.io.fortylines_hr.mapper.HeadOfMapper;
import fortylines.io.fortylines_hr.repository.HeadOfRepository;
import fortylines.io.fortylines_hr.service.HeadOfService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class HeadOfServiceImpl implements HeadOfService {

    private final HeadOfMapper headOfMapper;
    private final HeadOfRepository headOfRepository;
    private final PasswordEncoder passwordEncoder;
    private final Validator validator;

    @Override
    public HeadOfResponse create(HeadOfRequest headOfRequest) {
        String email = headOfRequest.getEmail();
        if (!validator.patternMatches(email)) {
            throw new InvalidArgumentException(email + " is not valid");
        }
        checkEmail(email);

        String encoderPassword = passwordEncoder.encode(headOfRequest.getPassword());
        headOfRequest.setPassword(encoderPassword);
        HeadOf headOf = headOfRepository.save(headOfMapper
                .create(headOfRequest));
        log.info("Head of department with name : {} has successfully saved to database", headOf.getFirstName());
        return headOfMapper.view(headOf);
    }

    @Override
    public HeadOfResponse update(Long id, HeadOfRequest headOfRequest) {
        HeadOf headOf = headOfRepository.findById(id).orElseThrow(() -> {

            throw new NotFoundException(String.format("Head of department with id = %s does not exists", id));
        });
        headOfMapper.update(headOf, headOfRequest);
        return headOfMapper.view(headOfRepository.save(headOf));
    }

    @Override
    public HeadOfResponse getById(Long id) {
        return headOfMapper.view(headOfRepository.findById(id).orElseThrow(() -> {

            throw new NotFoundException(String.format("Head of department with id = %s does not exists", id));
        }));
    }

    @Override
    public HeadOfResponse deleteById(Long id) {
        HeadOf headOf = headOfRepository.findById(id).orElseThrow(() -> {

            throw new NotFoundException(String.format("Head of department with id = %s does not exists", id));
        });
        headOfRepository.deleteById(id);
        return headOfMapper.view(headOf);
    }

    @Override
    public List<HeadOfResponse> getAll() {
        return headOfMapper.views(headOfRepository.findAll());
    }

    private void checkEmail(String email) {
        boolean exists = headOfRepository.existsByEmail(email);
        if (exists) {
            log.info("Head of department with email = {} already exists", email);
            throw new NotFoundException(
                    "Head of department with email = " + email + " already exists"
            );
        }
    }
}
