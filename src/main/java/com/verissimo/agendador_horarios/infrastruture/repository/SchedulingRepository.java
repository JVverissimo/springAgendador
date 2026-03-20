package com.verissimo.agendador_horarios.infrastruture.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verissimo.agendador_horarios.infrastruture.entity.SchedulingEntity;

@Repository
// No arquivo SchedulingRepository.java
public interface SchedulingRepository extends JpaRepository<SchedulingEntity, Long> {    
    // Altere de SchedulingEntity para List<SchedulingEntity>
    List<SchedulingEntity> findByDataHoraAgendamentoBetween(LocalDateTime dataHoraInicial, LocalDateTime dataHoraFinal);
    
    // Mantenha os outros conforme corrigimos antes
    void deleteByClienteAndDataHoraAgendamento(String cliente, LocalDateTime dataHoraAgendamento);
    SchedulingEntity findByClienteAndDataHoraAgendamento(String cliente, LocalDateTime dataHoraAgendamento);
}