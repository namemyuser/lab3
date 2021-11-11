

package repository;

import modell.Course;
import modell.Student;
import modell.Teacher;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class StudentRepTest{

    @Test
    void testGetAll() {
        List<Student> students = new ArrayList<>();
        StudentRepository theStudents = new StudentRepository(students);
        assert (theStudents.getAll().size() == 0);
    }

    @Test
    void testCreate() {
        //basically just data for the tests
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        Teacher tch1 = new Teacher(1, "Purcsa", "Lucas" ,courses);
        Course crs1 = new Course(1, "FP", tch1, 6, students,6);
        courses.add(crs1);
        tch1.setCourses(courses);
        Student std1 = new Student("Tarean", "Radu", 1, 29, courses);
        students.add(std1);
        crs1.setStudentsEnrolled(students);

        //actual test
        Student std2 = new Student("Elon", "Masca", 2, 29, courses);
        StudentRepository theStudents = new StudentRepository(students);
        theStudents.create(std2);
        assert (theStudents.getAll().size() == 2);
    }

    @Test
    void testDelete() {
        //basically just data for the tests
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        Teacher tch1 = new Teacher(1, "Purcsa", "Lucas" ,courses);
        Course crs1 = new Course(1, "Computernetzwerke", tch1, 6, students,6);
        courses.add(crs1);
        tch1.setCourses(courses);
        Student std1 = new Student("Tarean", "Radu", 1, 29, courses);
        students.add(std1);
        crs1.setStudentsEnrolled(students);
        Student std2 = new Student("Elon", "Masca", 2, 29, courses);
        StudentRepository theStudents = new StudentRepository(students);
        theStudents.create(std2);

        //actual test
        theStudents.delete(std2);
        assert (theStudents.getAll().size() == 1);
    }

    @Test
    void testUpdate() {
        //basically just data for the tests
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        Teacher tch1 = new Teacher(1, "Purcsa", "Lucas" ,courses);
        Course crs1 = new Course(1, "Computernetzwerke", tch1, 6, students,6);
        courses.add(crs1);
        tch1.setCourses(courses);
        Student std1 = new Student("Tarean", "Radu", 1, 29, courses);
        students.add(std1);
        crs1.setStudentsEnrolled(students);
        Student std2 = new Student("Elon", "Masca", 2, 29, courses);
        StudentRepository theStudents = new StudentRepository(students);

        //actual test
        theStudents.update(1, std2);
        assert(theStudents.getAll().get(0).getFirstName().equals("Elon"));
        assert(theStudents.getAll().get(0).getLastName().equals("Masca"));
        assert(theStudents.getAll().get(0).getStudentId() == 2);
        assert(theStudents.getAll().get(0).getTotalCredits() == 29);
    }
}
