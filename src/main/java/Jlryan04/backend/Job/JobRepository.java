package Jlryan04.backend.Job;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Job repository ...
 *
 */

@Repository
public interface JobRepository extends JpaRepository<Job, String> {
    // Flux type for asynchronous processing (non-blocking)
    Optional<Job> findJobByTitle(String title);

}
