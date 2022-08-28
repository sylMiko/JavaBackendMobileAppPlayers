package ZTUIM.project;

import ZTUIM.project.model.Student;
import ZTUIM.project.service.StudentDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProjectApplicationTests {


    @Autowired
    private StudentDao studentDao;

    @Test
    void addStudentTest() {

        Student student = new Student();

        student.setFirstName("Badam");
        student.setLastName("M<anaAbacki");
        student.setEmail("babacki@gmail.com");
        student.setDateOfBirth("08.04.2001");
        studentDao.save(student);
    }

    @Test
    void readStudentTest() {
        int id = 12;
        Student student = new Student();
        student = studentDao.findById(id);
        System.out.println(student.toString());

    }

}
