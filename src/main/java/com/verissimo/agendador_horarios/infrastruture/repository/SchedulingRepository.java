package com.verissimo.agendador_horarios.infrastruture.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verissimo.agendador_horarios.infrastruture.entity.SchedulingEntity;

@Repository
public interface SchedulingRepository extends JpaRepository<SchedulingEntity, Long> {    
}