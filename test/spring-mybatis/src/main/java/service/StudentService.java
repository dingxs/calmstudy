package service;

import entity.Student;
import mapper.StudentMapper;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/12/3
 */
public class StudentService {
    private StudentMapper studentMapper;
    public void setStudentMapper (StudentMapper studentMapper) {
        this. studentMapper = studentMapper;
    }
    public Student findStudentById(Integer id){
        return  this.studentMapper.findStudentById(1);
    }
}
