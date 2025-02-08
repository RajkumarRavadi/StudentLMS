package com.example.lms.studentLMS.Controllers;
import com.example.lms.studentLMS.Models.Student;
import com.example.lms.studentLMS.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("student")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
        String result = studentService.addStudent(student);
        return result;
    }

    //this helps us to return the list of all the students
    //if there are no student then it will return the empty list
    @GetMapping("/findAll")
    public List<Student> findAllStudents(){
        List<Student> ansList = studentService.findAllStudents();
        return ansList;
    }
}
