import entity.Student;
import entity.Tutor;
import mapper.StudentMapper;
import mapper.TutorMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/12/2
 */
public class TutorTest extends AbstractTest {
    @Test
    public void findCoursesByTutorTest() throws Exception{
        TutorMapper tutorMapper=sqlSession.getMapper(TutorMapper.class);
        Tutor tutor=tutorMapper.findCoursesByTutor(1);
    }
}
