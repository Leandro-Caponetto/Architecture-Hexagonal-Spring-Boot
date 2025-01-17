package com.leandro.application.service;

import com.leandro.application.ports.input.IStudentServicePort;
import com.leandro.application.ports.output.IStudentPersistencePort;
import com.leandro.domain.exception.StudentNotFoundException;
import com.leandro.domain.model.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentServicePort {

    private final IStudentPersistencePort persistencePort;


    @Override
    public Student findById(Long id) {
        return persistencePort.findById(id)
                .orElseThrow(StudentNotFoundException::new);
    }

    @Override
    public List<Student> findAll() {
        return persistencePort.findAll();
    }

    @Override
    public Student save(Student student) {
        return persistencePort.save(student);
    }

    @Override
    public Student update(Long id, Student student) {
        return persistencePort.findById(id)
                .map(savedStudent -> {
                    savedStudent.setFirstname(student.getFirstname());
                    savedStudent.setLastname(student.getLastname());
                    savedStudent.setAge(student.getAge());
                    savedStudent.setAddress(student.getAddress());
                    return persistencePort.save(savedStudent);
                })
                .orElseThrow(StudentNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if (persistencePort.findById(id).isEmpty()){
            throw new StudentNotFoundException();
        }
    }
}
