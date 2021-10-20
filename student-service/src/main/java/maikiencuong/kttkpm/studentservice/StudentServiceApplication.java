package maikiencuong.kttkpm.studentservice;

import maikiencuong.kttkpm.studentservice.entity.Student;
import maikiencuong.kttkpm.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@EnableEurekaClient
@SpringBootApplication
public class StudentServiceApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StudentServiceApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        studentRepository.save(Student.builder()
                .firstName("Mai Kien")
                .lastName("Cuong")
                .dateOfBirth(LocalDate.of(2000, 2, 15))
                .facultyId(1L)
                .build());

        studentRepository.save(Student.builder()
                .firstName("Cuong Mai")
                .lastName("Kien")
                .dateOfBirth(LocalDate.now())
                .facultyId(1L)
                .build());
    }
}
