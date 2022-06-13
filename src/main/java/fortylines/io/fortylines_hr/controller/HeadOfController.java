package fortylines.io.fortylines_hr.controller;

import fortylines.io.fortylines_hr.dto.HeadOfRequest;
import fortylines.io.fortylines_hr.dto.HeadOfResponse;
import fortylines.io.fortylines_hr.service.HeadOfService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/heads")
@PreAuthorize("hasAnyAuthority('ADMIN')")
@RequiredArgsConstructor
public class HeadOfController {

    private final HeadOfService headOfService;


    @PostMapping
    public HeadOfResponse create(@RequestBody HeadOfRequest headOfRequest) {
        return headOfService.create(headOfRequest);
    }

    @PutMapping("/update/{id}")
    public HeadOfResponse update(@PathVariable("id") Long id, @RequestBody HeadOfRequest headOfRequest) {
        return headOfService.update(id, headOfRequest);
    }

    @GetMapping("/{id}")
    public HeadOfResponse getById(@PathVariable("id") Long id) {
        return headOfService.getById(id);
    }

    @DeleteMapping("{id}")
    public HeadOfResponse deleteById(@PathVariable("id") Long id) {
        return headOfService.deleteById(id);
    }

    @GetMapping("/all")
    public List<HeadOfResponse> getAll() {
        return headOfService.getAll();
    }
}
