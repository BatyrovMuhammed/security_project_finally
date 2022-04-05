package peaksoft.security_project_finally.mapper.viewMapper;

import org.springframework.stereotype.Component;
import peaksoft.security_project_finally.dto.response.CourseResponse;
import peaksoft.security_project_finally.entity.Course;
import java.util.ArrayList;
import java.util.List;

@Component
public class CourseViewMapper {

    public CourseResponse viewCourse(Course course){
        if(course==null){
            return null;
        }
        CourseResponse courseResponse=new CourseResponse();
        if(course.getId() != null){
            courseResponse.setId(String.valueOf(course.getId()));
        }
        courseResponse.setCourseName(course.getCourseName());
        courseResponse.setDuration(course.getDuration());
        return courseResponse;

    }

    public List<CourseResponse> viewCourses(List<Course> courses){
        List<CourseResponse>courseResponses=new ArrayList<>();
        for (Course c:courses
        ) {
            courseResponses.add(viewCourse(c));
        }
        return courseResponses;
    }
}
