package fortylines.io.fortylines_hr.repository;

import fortylines.io.fortylines_hr.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth,Long> {
    Optional<Auth> findByEmail(String email);
}
