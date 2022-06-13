package fortylines.io.fortylines_hr;

import fortylines.io.fortylines_hr.enams.Role;
import fortylines.io.fortylines_hr.entity.Auth;
import fortylines.io.fortylines_hr.entity.User;
import fortylines.io.fortylines_hr.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
@SpringBootApplication
@RequiredArgsConstructor
public class FortylinesHrApplication {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public static void main(String[] args) {
        SpringApplication.run(FortylinesHrApplication.class, args);
    }

    @GetMapping("/")
    public String greetingPage() {
        return "<h1>Welcome to Fortylines-Io application !!!<h1/>";
    }

    @PostConstruct
    public void init() {
        User user = new User();
        user.setFirstName("Admin");
        user.setLastName("Adminov");

        Auth auth = new Auth();
        auth.setEmail("admin@gmail.com");
        auth.setPassword(passwordEncoder.encode("admin"));
        auth.setRole(Role.ADMIN);
        user.setAuth(auth);
        repository.save(user);

    }
}
