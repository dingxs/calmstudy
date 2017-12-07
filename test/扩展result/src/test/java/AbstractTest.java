import mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.io.Reader;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/12/2
 */
public abstract class AbstractTest {
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
}
