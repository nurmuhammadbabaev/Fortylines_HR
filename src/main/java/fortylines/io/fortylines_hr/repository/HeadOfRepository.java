package fortylines.io.fortylines_hr.repository;

import fortylines.io.fortylines_hr.entity.HeadOf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HeadOfRepository extends JpaRepository<HeadOf, Long> {

    @Query("select case when count(a)>0 then true else false end" +
            " from Auth a where a.email =?1")
    boolean existsByEmail(String email);
}
