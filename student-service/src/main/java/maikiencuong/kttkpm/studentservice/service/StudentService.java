package maikiencuong.kttkpm.studentservice.service;

import maikiencuong.kttkpm.studentservice.dto.Faculty;
import maikiencuong.kttkpm.studentservice.dto.StudentDetail;
import maikiencuong.kttkpm.studentservice.entity.Student;
import maikiencuong.kttkpm.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${url.faculty}")
    private String facultyUrl;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public StudentDetail findByIdIncludeFaculty(Long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if (studentOptional.isPresent()) {
            Faculty faculty = restTemplate.getForObject(facultyUrl + "/" + id, Faculty.class);
            StudentDetail studentDetail = StudentDetail.builder()
                    .student(studentOptional.get())
                    .faculty(faculty)
                    .build();
            return studentDetail;
        }
        return null;
    }

}
