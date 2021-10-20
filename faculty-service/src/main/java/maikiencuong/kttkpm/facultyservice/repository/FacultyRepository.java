package maikiencuong.kttkpm.facultyservice.repository;

import maikiencuong.kttkpm.facultyservice.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
