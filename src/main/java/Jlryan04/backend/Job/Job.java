package Jlryan04.backend.Job;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Job {

    @Id
    private Long id;
    private String title;
    private String description;
    private String location;
    private String category;


    public Job(Long id, String title, String description, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
    }

    public Job() {

    }

    @Override
    public String toString() {
        return String.format("%s %s, %s", title, description, location);
    }
}
