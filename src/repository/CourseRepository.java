package repository;

import modell.Course;

import java.util.List;

public class CourseRepository extends InMemoryRepository<Course, Integer>{

    public CourseRepository(List<Course> repoList) {
        super(repoList);
    }

    @Override
    public Course update(Integer ID, Course course) {
        this.repoList.removeIf(course1 -> course1.getCourseID() == ID);
        this.repoList.add(course);
        return course;
    }
}
