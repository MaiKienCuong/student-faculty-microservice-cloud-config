package maikiencuong.kttkpm.studentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import maikiencuong.kttkpm.studentservice.entity.Student;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDetail {
    private Student student;
    private Faculty faculty;
}
