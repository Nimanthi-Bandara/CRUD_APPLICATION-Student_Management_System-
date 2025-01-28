package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins="*")

public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        return new ResponseEntity<Student>(studentService.saveStudent(student) , HttpStatus.CREATED); 
    }

    //Getall rest API
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    //get by Id Rest API
    @GetMapping("{id}")

    //localhost:8080/api/student/1
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentId){
        return new ResponseEntity<Student>(studentService.getStudentById(studentId), HttpStatus.OK);
    }

    //update Rest API
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id , @RequestBody Student student){
        return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
    }

    //Delete Rest API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
        //delete student from DB
        studentService.deleteStudent(id);
        return new ResponseEntity<String> ("student deleteed successfully.", HttpStatus.OK);
    }

    @GetMapping("/yearofenrollment/{yearofEnrollment}")
    public ResponseEntity<List<Student>>
    getStudentByYearofEnrollment(@PathVariable("yearofEnrollment")String yearofEnrollment){
        List<Student> students = studentService.getStudentByYearofEnrollment(yearofEnrollment);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<String>
    getDepartmentByStudentId(@PathVariable("id")long id){
        String department = studentService.getDepartmentByStudentId(id);
        return new ResponseEntity<>(department, HttpStatus.OK); 
    }

    @DeleteMapping("{year}")
    public ResponseEntity<String> deleteByYearofEnrollment(@PathVariable("year") String year){
        //delete student from DB
        studentService.deleteByYearofEnrollment(year);
        return new ResponseEntity<String> ("student deleted successfully.", HttpStatus.OK);
    }

}

