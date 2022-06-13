package fortylines.io.fortylines_hr.repository;

import fortylines.io.fortylines_hr.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<Vacancy,Long> {
}
