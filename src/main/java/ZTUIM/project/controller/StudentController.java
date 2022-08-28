package ZTUIM.project.controller;


import ZTUIM.project.model.Student;
import ZTUIM.project.service.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @GetMapping("/student/getAll")
    public List<Student> getAllStudents() {

        return studentDao.getAllStudents();

    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable long id) {
        Student student = studentDao.findById((int) id);
        return ResponseEntity.ok(student);
    }

    @PostMapping("/student/save")
    public Student save(@RequestBody Student student) {
        return studentDao.save(student);
    }

    @PutMapping("/student/update/{id}")
    public Student update(@RequestBody Student student, @PathVariable String id) {
        Student existingStudent = studentDao.findById(Integer.parseInt(id));
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setDateOfBirth(student.getDateOfBirth());

        return studentDao.save(existingStudent);
    }

    @DeleteMapping("/student/delete/{id}")
    public void delete(@PathVariable String id) {
        studentDao.deleteById(Integer.parseInt(id));
    }
}
