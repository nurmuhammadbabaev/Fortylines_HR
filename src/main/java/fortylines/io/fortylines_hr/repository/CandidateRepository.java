package fortylines.io.fortylines_hr.repository;

import fortylines.io.fortylines_hr.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate,Long> {

}
