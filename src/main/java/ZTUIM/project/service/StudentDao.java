package ZTUIM.project.service;

import ZTUIM.project.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentDao {

    @Autowired
    private StudentRepository repository;

    public Student save(Student student) {
        return repository.save(student);
    }

    public void delete(Student student) {
        repository.delete(student);
    }


    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<Student>();
        Streamable.of(repository.findAll()).forEach(students::add);
        return students;
    }

    public Student findById(int parseInt) {

        return repository.findById(parseInt).get();
    }

    public void deleteById(int parseInt) {
        repository.deleteById(parseInt);
    }

}
