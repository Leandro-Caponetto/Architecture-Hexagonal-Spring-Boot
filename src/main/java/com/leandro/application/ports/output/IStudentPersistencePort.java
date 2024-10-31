package com.leandro.application.ports.output;

import com.leandro.domain.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentPersistencePort {

    Optional<Student> findById(Long id);
    List<Student> findAll();
    Student save(Student student);
    void deleteById(Long id);

}
