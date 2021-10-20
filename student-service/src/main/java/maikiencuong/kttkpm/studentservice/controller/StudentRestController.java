package maikiencuong.kttkpm.studentservice.controller;

import maikiencuong.kttkpm.studentservice.dto.StudentDetail;
import maikiencuong.kttkpm.studentservice.entity.Student;
import maikiencuong.kttkpm.studentservice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentRestController {
    @Autowired
    private StudentService studentService;

    @Value("${student.rest.controller.message}")
    private String message;

    @GetMapping
    public String home() {
        return message;
    }

    @PostMapping
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping("/{id}")
    public StudentDetail getStudentDetail(@PathVariable Long id) {
        return studentService.findByIdIncludeFaculty(id);
    }

}
