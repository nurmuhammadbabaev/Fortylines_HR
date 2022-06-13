package fortylines.io.fortylines_hr.service.Impl;

import fortylines.io.fortylines_hr.dto.EmployeeRequest;
import fortylines.io.fortylines_hr.dto.EmployeeResponse;
import fortylines.io.fortylines_hr.entity.Employee;
import fortylines.io.fortylines_hr.entity.Validator;
import fortylines.io.fortylines_hr.exceptions.InvalidArgumentException;
import fortylines.io.fortylines_hr.exceptions.NotFoundException;
import fortylines.io.fortylines_hr.mapper.EmployeeMapper;
import fortylines.io.fortylines_hr.repository.EmployeeRepository;
import fortylines.io.fortylines_hr.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private final Validator validator;

    @Override
    public EmployeeResponse create(EmployeeRequest employeeRequest) {
        String email = employeeRequest.getEmail();
        if (!validator.patternMatches(email)) {
            throw new InvalidArgumentException(email + " is not valid");
        }
        checkEmail(email);

        String encoderPassword = passwordEncoder.encode(employeeRequest.getPassword());
        employeeRequest.setPassword(encoderPassword);
        Employee employee = employeeRepository.save(employeeMapper
                .create(employeeRequest));
        log.info(" Employee with name : {} has successfully saved to database", employee.getFirstName());
        return employeeMapper.view(employee);
    }

    @Override
    public EmployeeResponse update(Long id, EmployeeRequest employeeRequest) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> {

            throw new NotFoundException(String.format("employee with id = %s does not exists", id));
        });;
        employeeMapper.update(employee, employeeRequest);
        return employeeMapper.view(employeeRepository.save(employee));
    }

    @Override
    public EmployeeResponse getById(Long id) {
        return employeeMapper.view(employeeRepository.findById(id).orElseThrow(() -> {

            throw new NotFoundException(String.format("employee with id = %s does not exists", id));
        }));
    }

    @Override
    public EmployeeResponse deleteById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> {

            throw new NotFoundException(String.format("employee with id = %s does not exists", id));
        });
        employeeRepository.deleteById(id);
        return employeeMapper.view(employee);
    }

    @Override
    public List<EmployeeResponse> getAll() {
        return employeeMapper.views(employeeRepository.findAll());
    }

    private void checkEmail(String email) {
        boolean exists = employeeRepository.existsByEmail(email);
        if (exists) {
            log.info("Employee with email = {} already exists", email);
            throw new NotFoundException(
                    "Employee with email = " + email + " already exists"
            );
        }
    }
}
