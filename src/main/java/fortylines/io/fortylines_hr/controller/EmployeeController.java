package fortylines.io.fortylines_hr.controller;

import fortylines.io.fortylines_hr.dto.EmployeeRequest;
import fortylines.io.fortylines_hr.dto.EmployeeResponse;
import fortylines.io.fortylines_hr.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeResponse create(@RequestBody EmployeeRequest employeeRequest) {
        return employeeService.create(employeeRequest);
    }

    @PutMapping("/update/{id}")
    public EmployeeResponse update(@PathVariable("id") Long id, @RequestBody EmployeeRequest employeeRequest) {
        return employeeService.update(id, employeeRequest);
    }

    @GetMapping("/{id}")
    public EmployeeResponse getById(@PathVariable("id") Long id) {
        return employeeService.getById(id);
    }

    @DeleteMapping("{id}")
    public EmployeeResponse deleteById(@PathVariable("id") Long id) {

        return employeeService.deleteById(id);
    }

    @GetMapping("/all")
    public List<EmployeeResponse> getAll() {
        return employeeService.getAll();
    }
}


