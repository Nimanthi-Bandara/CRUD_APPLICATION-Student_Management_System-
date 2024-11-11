package com;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    //CRUD

    Optional<Student> findById(long id);

    void deleteById(long id);

    static Student save(Student student) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    void saveAll(Student existingStudent);
} 
