import entity.Student;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/12/2
 */
public class Main {
    public static  void main(String[] args) {
        Student student=findStudentById(1);
        System.out.println("result is:"+student.toString());
        System.out.println("-------------------------");
        Student student1=new Student();
        student1.setStudId(10);
        student1.setName("111");
        student1.setEmail("222");
        student1.setDob(new Date());
        if(createStudent(student1)>0)
            System.out.println("successful");
        else
            System.out.println("false");
    }

    protected static Connection getDatabaseConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/db_test", "sa", "123456");
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Student findStudentById(int studId) {
        Student student = null;
        Connection conn = null;
        try {
            conn = getDatabaseConnection();
            String sql = "SELECT * FROM STUDENTS WHERE STUD_ID=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, studId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                student = new Student();
                student.setStudId(rs.getInt("stud_id"));
                student.setName(rs.getString("name"));
                student.setEmail(rs.getString("email"));
                student.setDob(rs.getDate("dob"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
        return student;
    }

    public static int createStudent(Student student) {
        Connection conn = null;
        try {
            conn = getDatabaseConnection();
            String sql = "INSERT INTO STUDENTS(STUD_ID,NAME,EMAIL,DOB) VALUES(?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, student.getStudId());
            pstmt.setString(2, student.getName());
            pstmt.setString(3, student.getEmail());
            pstmt.setDate(4, new
                    java.sql.Date(student.getDob().getTime()));
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}
