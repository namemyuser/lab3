package repository;

import modell.Teacher;

import java.util.List;

public class TeacherRepository extends InMemoryRepository<Teacher, Integer>{

    public TeacherRepository(List<Teacher> repoList) {
        super(repoList);
    }

    @Override
    public Teacher update(Integer ID, Teacher teacher) {
        this.repoList.removeIf(teach -> teach.getTeacherID() == ID);
        this.repoList.add(teacher);
        return teacher;
    }

}
