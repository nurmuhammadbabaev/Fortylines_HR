package fortylines.io.fortylines_hr.service;

import fortylines.io.fortylines_hr.dto.HeadOfRequest;
import fortylines.io.fortylines_hr.dto.HeadOfResponse;

import java.util.List;

public interface HeadOfService {

    HeadOfResponse create(HeadOfRequest headOfRequest);
    HeadOfResponse update(Long id,HeadOfRequest headOfRequest);
    HeadOfResponse getById(Long id);
    HeadOfResponse deleteById(Long id);
    List<HeadOfResponse> getAll();
}
