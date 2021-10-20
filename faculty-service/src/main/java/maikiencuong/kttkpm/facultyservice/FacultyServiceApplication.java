package maikiencuong.kttkpm.facultyservice;

import maikiencuong.kttkpm.facultyservice.entity.Faculty;
import maikiencuong.kttkpm.facultyservice.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FacultyServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FacultyServiceApplication.class, args);
    }

    @Autowired
    private FacultyRepository facultyRepository;

    @Override
    public void run(String... args) throws Exception {
        facultyRepository.save(Faculty.builder().name("Cong nghe thong tin").build());
        facultyRepository.save(Faculty.builder().name("Ke toan").build());
        facultyRepository.save(Faculty.builder().name("Ngon ngu anh").build());
    }
}
