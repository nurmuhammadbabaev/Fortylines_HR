package fortylines.io.fortylines_hr.repository;

import fortylines.io.fortylines_hr.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}
