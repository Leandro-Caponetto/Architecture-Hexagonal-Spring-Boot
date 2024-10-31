package com.leandro.infrastructure.adapters.output.persistence;

import com.leandro.application.ports.output.IStudentPersistencePort;
import com.leandro.domain.model.Student;
import com.leandro.infrastructure.adapters.output.persistence.mapper.IStudentPersistenceMapper;
import com.leandro.infrastructure.adapters.output.persistence.repository.IStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class StudentPersistenceAdapter implements IStudentPersistencePort {

    private final IStudentRepository repository;
    private  final IStudentPersistenceMapper mapper;

    @Override
    public Optional<Student> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toStudent);
    }

    @Override
    public List<Student> findAll() {
        return mapper.toStudentList(repository.findAll());
    }

    @Override
    public Student save(Student student) {
        return mapper.toStudent(repository.save(mapper.toStudentEntity(student)));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
