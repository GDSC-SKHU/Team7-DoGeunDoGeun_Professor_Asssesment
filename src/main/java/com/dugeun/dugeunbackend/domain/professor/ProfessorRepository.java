package com.dugeun.dugeunbackend.domain.professor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    List<Professor> findAllByMajor(Major major);

    @Query("SELECT distinct p FROM Professor p JOIN FETCH p.comments WHERE p.id = :id")
    Optional<Professor> findByIdFetchComment(@Param("id") Long id);


}
