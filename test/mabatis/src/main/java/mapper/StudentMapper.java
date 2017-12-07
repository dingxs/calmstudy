package mapper;



import entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
    Student findStudentById(Integer id);
    void insertStudent(Student student);
    List<Student> findAllStudents();
}
