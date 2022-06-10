package com.data.resultprocessor.repository;

import com.data.resultprocessor.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultsRepository extends JpaRepository<Student, String> {

}
