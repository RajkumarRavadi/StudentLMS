package com.example.lms.studentLMS.Services;
import com.example.lms.studentLMS.Models.Student;
import com.example.lms.studentLMS.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public String addStudent(Student student){
        studentRepository.save(student);
        return "Student has been save to the DB";
    }

    public List<Student> findAllStudents(){
        return studentRepository.findAll();
    }
}
