package mapper;

import entity.Tutor;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/12/2
 */
public interface TutorMapper {
    public Tutor findCoursesByTutor(int id);
}
