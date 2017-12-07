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

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.After;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/12/2
 */
public class StudentTest {
    SqlSession sqlSession;
    String resource="mybatis-config.xml";
    StudentMapper studentMapper;
    @Before
    public void befor() throws Exception {
        Reader reader =null;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        sqlSession=sqlSessionFactory.openSession();
//        studentMapper=sqlSession.getMapper(StudentMapper.class);
    }
    @After
    public void after() throws Exception{
        sqlSession.close();
    }
    @Test
    public void findStudentByIdTest() throws Exception{
//        Student student=studentMapper.findStudentById(1);
        Student student = sqlSession.selectOne("mapper.StudentMapper.findStudentById",1);
        System.out.println(student.toString());
        sqlSession.commit();
    }
    @Test
    public void insertStudentTest() throws Exception{
        Student student=new Student();
        student.setName("wangsen");
        student.setEmail("5472@qq.com");
        student.setDob(new Date());
        int i=sqlSession.insert("mapper.StudentMapper.insertStudent",student);
        System.out.println(student.toString());
    }
    @Test
    public void listAllPeople()throws Exception{
        List<Student> studentList=sqlSession.selectList("mapper.StudentMapper.findAllStudents");
        for(Student student : studentList){
            System.out.println(student.toString());
        }
    }
}
