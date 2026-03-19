package com.verissimo.agendador_horarios.infrastruture.repository;
import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verissimo.agendador_horarios.infrastruture.entity.SchedulingEntity;

import jakarta.transaction.Transactional;

@Repository
public interface SchedulingRepository extends JpaRepository<SchedulingEntity, Long> {    

    SchedulingEntity finByServiceSchedulingEntityBetween(String servico, LocalDateTime dataInicio, LocalDateTime datafim);

    @Transactional
    void deleteBySchedulingEntityClient(LocalDateTime dataHoraAgendamento, String cliente);
   
   
    SchedulingEntity findByDataHoraAgendamentoBetween(LocalDataTime dataHoraInicial, LocalDataTime dataHoraFinal);
    

}

