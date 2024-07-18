package com.ccm.bita.student.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccm.bita.student.Repository.StudentRepository;
import com.ccm.bita.student.model.Student;



@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllstudent(){
    List<Student> std = studentRepository.findAll();
    return new ResponseEntity<>(std,HttpStatus.OK);
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/{id}")
        public ResponseEntity <Student> getStudentId (@PathVariable Long id)
    {
        Optional<Student> std = studentRepository .findById(id);
        return new ResponseEntity<>(std.get(),HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleleStudent(@PathVariable Long id){
    studentRepository.deleteById(id);
    return new ResponseEntity<>("Delete data succes", HttpStatus.OK);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,@RequestBody Student std){
        std.setId(id);
        Student existingstudent = studentRepository.findById(std.getId()).get();
        existingstudent.setFirstName(std.getFirstName());
        existingstudent.setSecondName(std.getSecondName());
        existingstudent.setThirdName(std.getThirdName());
        existingstudent.setTellNumber(std.getTellNumber());
        existingstudent.setVisitName(std.getVisitName());
        existingstudent.setAge(std.getAge());
        Student updatedstudent = studentRepository.save(existingstudent);
        return new ResponseEntity<>(updatedstudent, HttpStatus.CREATED);
        }
}

