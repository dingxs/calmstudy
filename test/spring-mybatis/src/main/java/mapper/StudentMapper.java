package mapper;



import entity.Student;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentMapper {
    public Student findStudentById(Integer id);
}
