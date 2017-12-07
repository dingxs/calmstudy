import entity.Student;
import junit.framework.TestCase;
import mapper.StudentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.StudentService;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/12/3
 */

public  class StudentTest extends AbstractTestCase{
    @Autowired
    StudentMapper studentMapper;
    @Test
    public void test(){
        ApplicationContext ctx=null;
        ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentMapper studentMapper=(StudentMapper) ctx.getBean("studentDao");
        studentMapper.findStudentById(1);
    }
    @Test
    public void qwe(){
        studentMapper.findStudentById(1);
    }
}
