package maikiencuong.kttkpm.facultyservice.service;

import maikiencuong.kttkpm.facultyservice.entity.Faculty;
import maikiencuong.kttkpm.facultyservice.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    public Faculty save(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findById(Long id) {
        return facultyRepository.findById(id).orElse(null);
    }
}
