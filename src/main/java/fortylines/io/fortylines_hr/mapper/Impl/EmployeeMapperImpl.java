package fortylines.io.fortylines_hr.mapper.Impl;

import fortylines.io.fortylines_hr.dto.EmployeeRequest;
import fortylines.io.fortylines_hr.dto.EmployeeResponse;
import fortylines.io.fortylines_hr.enams.Role;
import fortylines.io.fortylines_hr.entity.Auth;
import fortylines.io.fortylines_hr.entity.Employee;
import fortylines.io.fortylines_hr.mapper.EmployeeMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {


    @Override
    public Employee create(EmployeeRequest employeeRequest) {
        if (employeeRequest == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());

        Auth auth = new Auth();
        auth.setEmail(employeeRequest.getEmail());
        auth.setPassword(employeeRequest.getPassword());
        auth.setRole(Role.EMPLOYEE);

        employee.setAuth(auth);
        return employee;
    }

    @Override
    public Employee update(Employee employee, EmployeeRequest employeeRequest) {
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());

        employee.getAuth().setEmail(employeeRequest.getEmail());
        employee.getAuth().setPassword(employeeRequest.getPassword());
        employee.getAuth().setRole(Role.EMPLOYEE);

        return employee;
    }

    @Override
    public EmployeeResponse view(Employee employee) {

        EmployeeResponse employeeResponse = new EmployeeResponse();

        employeeResponse.setId(employee.getId());
        employeeResponse.setFirstName(employee.getFirstName());
        employeeResponse.setLastName(employee.getLastName());
        employeeResponse.setEmail(employee.getAuth().getEmail());

        return employeeResponse;
    }

    @Override
    public List<EmployeeResponse> views(List<Employee> employees) {
        List<EmployeeResponse> employeeResponses = new ArrayList<>();
        for (Employee e : employees) {
            employeeResponses.add(view(e));
        }
        return employeeResponses;
    }
}
