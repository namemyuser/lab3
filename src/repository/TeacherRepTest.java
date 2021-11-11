package repository;

import modell.Course;
import modell.Student;

import modell.Teacher;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import java.util.List;


class TeacherRepTest {

    @Test
    void testGetAll() {
        List<Teacher> teachers = new ArrayList<>();
        TeacherRepository theTeachers = new TeacherRepository(teachers);
        assert (theTeachers.getAll().size() == 0);
    }

    @Test
    void testCreate() {
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        Teacher tch1 = new Teacher(1, "Purcsa", "Lucas" ,courses);
        Course crs1 = new Course(1, "FP", tch1, 6, students,6);
        courses.add(crs1);
        tch1.setCourses(courses);
        Student std1 = new Student("Tarean", "Radu", 1, 29, courses);
        students.add(std1);
        crs1.setStudentsEnrolled(students);

        Teacher tch2 = new Teacher(2, "Mircea", "Enel" ,courses);
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(tch1);
        TeacherRepository theTeachers = new TeacherRepository(teachers);
        theTeachers.create(tch2);
        assert (theTeachers.getAll().size() == 2);
    }

    @Test
    void testDelete() {
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        Teacher tch1 = new Teacher(1, "Purcsa", "Lucas" ,courses);
        Course crs1 = new Course(1, "FP", tch1, 6, students,6);
        courses.add(crs1);
        tch1.setCourses(courses);
        Student std1 = new Student("Tarean", "Radu", 1, 29, courses);
        students.add(std1);
        crs1.setStudentsEnrolled(students);


        Teacher tch2 = new Teacher(2, "Mircea", "Enel" ,courses);
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(tch1);
        TeacherRepository theTeachers = new TeacherRepository(teachers);
        theTeachers.create(tch2);
        theTeachers.delete(tch2);
        assert (theTeachers.getAll().size() == 1);
    }

    @Test
    void testUpdate() {

        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        Teacher tch1 = new Teacher(1, "Purcsa", "Lucas" ,courses);
        Course crs1 = new Course(1, "FP", tch1, 6, students,6);
        courses.add(crs1);
        tch1.setCourses(courses);
        Student std1 = new Student("Tarean", "Radu", 1, 29, courses);
        students.add(std1);
        crs1.setStudentsEnrolled(students);
        Teacher tch2 = new Teacher(2, "Mircea", "Enel" ,courses);
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(tch1);
        TeacherRepository theTeachers = new TeacherRepository(teachers);


        theTeachers.update(1,tch2);
        assert (theTeachers.getAll().get(0).getTeacherID() == 2);
        assert (theTeachers.getAll().get(0).getFirstName().equals("Mircea"));
        assert (theTeachers.getAll().get(0).getLastName().equals("Enel"));
    }
}