package fortylines.io.fortylines_hr.mapper.Impl;

import fortylines.io.fortylines_hr.dto.HeadOfRequest;
import fortylines.io.fortylines_hr.dto.HeadOfResponse;
import fortylines.io.fortylines_hr.enams.Role;
import fortylines.io.fortylines_hr.entity.Auth;
import fortylines.io.fortylines_hr.entity.HeadOf;
import fortylines.io.fortylines_hr.mapper.HeadOfMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class HeadOfMapperImpl implements HeadOfMapper {

    @Override
    public HeadOf create(HeadOfRequest headOfRequest) {
        if (headOfRequest == null) {
            return null;
        }
        HeadOf headOf = new HeadOf();
        headOf.setFirstName(headOfRequest.getFirstName());
        headOf.setLastName(headOfRequest.getLastName());

        Auth auth = new Auth();
        auth.setRole(Role.HEADOF);
        auth.setEmail(headOfRequest.getEmail());
        auth.setPassword(headOfRequest.getPassword());

        headOf.setAuth(auth);
        return headOf;
    }

    @Override
    public HeadOf update(HeadOf headOf, HeadOfRequest headOfRequest) {
        headOf.setFirstName(headOfRequest.getFirstName());
        headOf.setLastName(headOfRequest.getLastName());
        headOf.getAuth().setRole(Role.HEADOF);
        headOf.getAuth().setEmail(headOfRequest.getEmail());
        headOf.getAuth().setPassword(headOfRequest.getPassword());
        return headOf;
    }

    @Override
    public HeadOfResponse view(HeadOf headOf) {
        HeadOfResponse headOfResponse = new HeadOfResponse();

        headOfResponse.setId(headOf.getId());
        headOfResponse.setFirstName(headOf.getFirstName());
        headOfResponse.setLastName(headOf.getLastName());
        headOfResponse.setEmail(headOf.getAuth().getEmail());

        return headOfResponse;
    }

    @Override
    public List<HeadOfResponse> views(List<HeadOf> headOfs) {
        List<HeadOfResponse> headOfResponses = new ArrayList<>();
        for (HeadOf h : headOfs) {
            headOfResponses.add(view(h));
        }
        return headOfResponses;
    }
}
