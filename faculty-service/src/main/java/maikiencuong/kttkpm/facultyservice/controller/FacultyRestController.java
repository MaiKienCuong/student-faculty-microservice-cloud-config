package maikiencuong.kttkpm.facultyservice.controller;

import maikiencuong.kttkpm.facultyservice.entity.Faculty;
import maikiencuong.kttkpm.facultyservice.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faculty")
public class FacultyRestController {
    @Autowired
    private FacultyService facultyService;

    @Value("${faculty.rest.controller.message}")
    private String message;

    @GetMapping
    public String home() {
        return message;
    }

    @PostMapping
    public Faculty save(@RequestBody Faculty faculty) {
        return facultyService.save(faculty);
    }

    @GetMapping("/{id}")
    public Faculty findById(@PathVariable Long id) {
        return facultyService.findById(id);
    }

}
