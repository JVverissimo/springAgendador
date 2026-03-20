package com.verissimo.agendador_horarios.infrastruture.repository;

import java.time.LocalDateTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.verissimo.agendador_horarios.infrastruture.entity.SchedulingEntity;
import jakarta.transaction.Transactional;

@Repository
public interface SchedulingRepository extends JpaRepository<SchedulingEntity, Long> {    

    // Corrigido: Removido 'ServiceSchedulingEntity' e ajustado para 'Servico'
    SchedulingEntity findByServicoAndDataHoraAgendamentoBetween(String servico, LocalDateTime dataInicio, LocalDateTime datafim);

    @Transactional
    // Corrigido: Removido 'SchedulingEntityClient' e ajustado para 'Cliente'
    void deleteByClienteAndDataHoraAgendamento(String cliente, LocalDateTime dataHoraAgendamento);

    SchedulingEntity findByDataHoraAgendamentoBetween(LocalDateTime dataHoraInicial, LocalDateTime dataHoraFinal);

    // Corrigido: Removido 'SchedulingEntityClient' e ajustado para os campos reais
    SchedulingEntity findByClienteAndDataHoraAgendamento(String cliente, LocalDateTime dataHoraAgendamento);
}