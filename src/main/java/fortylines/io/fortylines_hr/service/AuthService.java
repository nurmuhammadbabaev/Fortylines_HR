package fortylines.io.fortylines_hr.service;

import fortylines.io.fortylines_hr.dto.AuthRequest;
import fortylines.io.fortylines_hr.dto.AuthResponse;

public interface AuthService {

    AuthResponse authenticate(AuthRequest authRequest);
}
