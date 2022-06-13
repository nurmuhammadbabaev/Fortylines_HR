package fortylines.io.fortylines_hr.mapper;

import fortylines.io.fortylines_hr.dto.HeadOfRequest;
import fortylines.io.fortylines_hr.dto.HeadOfResponse;
import fortylines.io.fortylines_hr.entity.HeadOf;

import java.util.List;

public interface HeadOfMapper {

    HeadOf create(HeadOfRequest headOfRequest);
    HeadOf update(HeadOf headOf,HeadOfRequest headOfRequest);
    HeadOfResponse view(HeadOf headOf);
    List<HeadOfResponse> views(List<HeadOf>headOfs);
}
