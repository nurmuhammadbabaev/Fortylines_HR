package fortylines.io.fortylines_hr.service.Impl;

import fortylines.io.fortylines_hr.config.jwt.JwtUtils;
import fortylines.io.fortylines_hr.dto.AuthRequest;
import fortylines.io.fortylines_hr.dto.AuthResponse;
import fortylines.io.fortylines_hr.entity.Auth;
import fortylines.io.fortylines_hr.entity.Employee;
import fortylines.io.fortylines_hr.entity.HeadOf;
import fortylines.io.fortylines_hr.entity.User;
import fortylines.io.fortylines_hr.exceptions.NotFoundException;
import fortylines.io.fortylines_hr.repository.AuthRepository;
import fortylines.io.fortylines_hr.repository.EmployeeRepository;
import fortylines.io.fortylines_hr.repository.HeadOfRepository;
import fortylines.io.fortylines_hr.repository.UserRepository;
import fortylines.io.fortylines_hr.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final AuthRepository authInfoRepository;
    private final UserRepository userRepository;
    private final HeadOfRepository headOfRepository;
    private final EmployeeRepository employeeRepository;

    public AuthResponse authenticate(AuthRequest authRequest) {
        Authentication authentication;

        authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authRequest.getEmail(),
                authRequest.getPassword()
        ));

        String generatedToken = jwtUtils.generateToken(authentication);

        Auth authInfo = authInfoRepository.findByEmail(authRequest.getEmail())
                .orElseThrow(() -> {
                    log.error("User with email = {} does not exist", authRequest.getEmail());
                    throw new NotFoundException(
                            String.format("User with email = %s does not exist", authRequest.getEmail())
                    );
                });

        String firstName = "";
        String lastName = "";
        for (User u : userRepository.findAll()) {
            if (u.getAuth().getEmail().equals(authInfo.getEmail())) {
                firstName = u.getFirstName();
                lastName = u.getLastName();
            }
            for (HeadOf h : headOfRepository.findAll()) {
                if (h.getAuth().getEmail().equals(authInfo.getEmail())) {
                    firstName = h.getFirstName();
                    lastName = h.getLastName();
                }
            }
            for (Employee e : employeeRepository.findAll()) {
                if (e.getAuth().getEmail().equals(authInfo.getEmail())) {
                    firstName = e.getFirstName();
                    lastName = e.getLastName();
                }
            }
        }

        return AuthResponse.builder()
                .firstName(firstName)
                .lastName(lastName)
                .role(authInfo.getRole())
                .email(authRequest.getEmail())
                .token(generatedToken)
                .build();
    }
}

