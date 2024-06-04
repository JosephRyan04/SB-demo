package Jlryan04.backend.Job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class JobService {

    private final JobRepository jobRepository;

    @Autowired
    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Optional<Job> findJobByTitle(String title){
        return jobRepository.findJobByTitle(title);
    }

    public void saveJob(Job job){
        jobRepository.save(job);
    }

    public Page<Job> findPaginated(int page, int size){
        return jobRepository.findAll(PageRequest.of(page, size));
    }
}
