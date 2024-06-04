package Jlryan04.backend.Job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@Slf4j
@RequestMapping("/api/job")
public class JobController {
    private final JobService jobService;

    @Autowired
    public  JobController(JobService jobService){
        this.jobService = jobService;
    }

    @GetMapping("/search")
    public Optional<Job> getJobByTitle(@RequestParam String title){
        try {
            return jobService.findJobByTitle(title);
        }
        catch (Exception e){
            return null;
        }
    }

    @RequestMapping(
            value ="/page",
            params = {"page", "size"},
            method = RequestMethod.GET)
    public Page<Job> findPaginated(
            @RequestParam("page") int page, @RequestParam("size") int size) {
        Page<Job> resultPage = jobService.findPaginated(page, size);
        return resultPage;
    }

    @PostMapping("/test")
    public String test(){
        try {
            final Job testJob = new Job(100L, "testFirstName", "testLastName", "test address line one");
              jobService.saveJob(testJob);
//            saveJobMono.block();
            // Save the Job class to Azure Cosmos DB database.
            return "Success";
        } catch (Exception e){
            return "Failure";
        }

    }


}
