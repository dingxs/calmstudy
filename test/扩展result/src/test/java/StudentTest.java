import entity.Student;
import mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/12/2
 */
public class StudentTest extends AbstractTest {

    @Test
    public void findStudentByIdTest() throws Exception{
        StudentMapper studentMapper=sqlSession.getMapper(StudentMapper.class);
        Student student=studentMapper.findStudentById(1);
//        Student student = sqlSession.selectOne("mapper.StudentMapper.findStudentById",1);
//        System.out.println(student.toString());
//        sqlSession.commit();
    }
}
