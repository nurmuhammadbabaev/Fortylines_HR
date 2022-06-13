package fortylines.io.fortylines_hr.mapper;

import fortylines.io.fortylines_hr.dto.EmployeeRequest;
import fortylines.io.fortylines_hr.dto.EmployeeResponse;
import fortylines.io.fortylines_hr.entity.Employee;

import java.util.List;

public interface EmployeeMapper {

    Employee create(EmployeeRequest employeeRequest);

    Employee update(Employee employee, EmployeeRequest employeeRequest);

    EmployeeResponse view(Employee employee);

    List<EmployeeResponse> views(List<Employee> employees);
}
