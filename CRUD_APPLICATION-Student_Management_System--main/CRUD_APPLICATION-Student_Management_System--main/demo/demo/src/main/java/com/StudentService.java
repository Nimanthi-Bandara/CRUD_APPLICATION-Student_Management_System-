package com;
import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(long id);
    Student updateStudent(Student student, long id);
    void deleteStudent(long id);
    void deleteByYearofEnrollment(String year);
    List<Student> getStudentByYearofEnrollment(String yearOfEnrollment);
    String getDepartmentByStudentId(long id);

}
