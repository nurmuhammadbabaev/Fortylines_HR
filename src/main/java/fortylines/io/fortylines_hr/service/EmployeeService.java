package fortylines.io.fortylines_hr.service;

import fortylines.io.fortylines_hr.dto.EmployeeRequest;
import fortylines.io.fortylines_hr.dto.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    EmployeeResponse create(EmployeeRequest employeeRequest);

    EmployeeResponse update(Long id, EmployeeRequest employeeRequest);

    EmployeeResponse getById(Long id);

    EmployeeResponse deleteById(Long id);

    List<EmployeeResponse> getAll();
}
