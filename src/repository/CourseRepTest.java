package repository;
import modell.Course;
import modell.Student;
import modell.Teacher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Test.*;

import java.util.List;
import java.util.ArrayList;

class CourseRepTest {


    @Test
    void getAll() {

        List<Course> courses = new ArrayList<>();
        CourseRepository theCourses = new CourseRepository(courses);
        assert (theCourses.getAll().size() == 0);

    }


    @Test
    void create() {

        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        Teacher tch1 = new Teacher(1, "Purcsa", "Lucas" ,courses);
        Course crs1 = new Course(1, "FP", tch1, 6, students,6);
        courses.add(crs1);
        tch1.setCourses(courses);
        Student std1 = new Student("Gigel", "Vinetel", 1, 29, courses);
        students.add(std1);
        crs1.setStudentsEnrolled(students);
        Course  crs2 = new Course(2, "MAP", tch1, 6, students,6);



        CourseRepository  theCourses = new CourseRepository (courses);
        theCourses.create(crs2);
        assert (theCourses.getAll().size() == 2);
    }


    @Test
    void delete() {

        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        Teacher tch1 = new Teacher(1, "Purcsa", "Lucas" ,courses);
        Course crs1 = new Course(1, "FP", tch1, 6, students,6);
        courses.add(crs1);
        tch1.setCourses(courses);
        Student std1 = new Student("Gigel", "Vinetel", 1, 29, courses);
        students.add(std1);
        crs1.setStudentsEnrolled(students);
        Course  crs2 = new Course(2, "MAP", tch1, 6, students,6);
        CourseRepository theCourses = new CourseRepository(courses);
        theCourses.create(crs2);


        assert (theCourses.getAll().size() == 2);
        theCourses.delete(crs2);
        assert (theCourses.getAll().size() == 1);
    }

    @Test
    void update() {

        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        Teacher tch1 = new Teacher(1, "Purcsa", "Lucas" ,courses);
        Course crs1 = new Course(1, "FP", tch1, 6, students,6);
        courses.add(crs1);
        tch1.setCourses(courses);
        Student std1 = new Student("Gigel", "Vinetel", 1, 29, courses);
        students.add(std1);
        crs1.setStudentsEnrolled(students);
        CourseRepository theCourses = new CourseRepository(courses);


        Course  crs2 = new Course(2, "MAP", tch1, 6, students,6);
        theCourses.update(1, crs2);
        assert (theCourses.getAll().size() == 1);
        assert (theCourses.getAll().get(0).getCourseID() == 2);
        assert (theCourses.getAll().get(0).getName().equals("MAP"));
        assert (theCourses.getAll().get(0).getMaxEnrollment() == 6);
        assert (theCourses.getAll().get(0).getCredits() == 6);

    }
}