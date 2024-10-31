package com.leandro.infrastructure.adapters.output.persistence.repository;

import com.leandro.infrastructure.adapters.output.persistence.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<StudentEntity, Long> {
}
