package com.dugeun.dugeunbackend.domain.professor.ability;

import com.dugeun.dugeunbackend.api.ability.dto.AbilityListDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AbilityRepository extends JpaRepository<Ability, Long> {

    @Query("SELECT new com.dugeun.dugeunbackend.api.ability.dto.AbilityListDto(AVG(a.assignment), AVG(a.kindness), AVG(a.teaching), AVG(a.humanity), AVG(a.sensibility)) FROM Ability a WHERE a.professor.id = :id")
    AbilityListDto findAvgByProfessorId(@Param("id") Long id);
}
