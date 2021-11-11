package repository;

import modell.Student;

import java.util.List;

public class StudentRepository extends InMemoryRepository<Student, Integer>{

    public StudentRepository(List<Student> repoList) {
        super(repoList);
    }

    @Override
    public Student update(Integer ID, Student student) {
        this.repoList.removeIf(stud -> stud.getStudentId() == ID);
        this.repoList.add(student);
        return student;
    }


}
