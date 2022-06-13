package fortylines.io.fortylines_hr.controller;

import fortylines.io.fortylines_hr.dto.AuthRequest;
import fortylines.io.fortylines_hr.dto.AuthResponse;
import fortylines.io.fortylines_hr.service.Impl.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.PermitAll;

@RestController
@RequestMapping("/authentication")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServiceImpl authService;

    @PostMapping
    @PermitAll


    public AuthResponse authenticate(@RequestBody AuthRequest authRequest) {
        return authService.authenticate(authRequest);
    }
}
