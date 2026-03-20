package com.verissimo.agendador_horarios.service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.verissimo.agendador_horarios.infrastruture.entity.SchedulingEntity;
import com.verissimo.agendador_horarios.infrastruture.repository.SchedulingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchedulingService {

    private final SchedulingRepository schedulingRepository;

    public SchedulingEntity saveScheduling(SchedulingEntity entity) {
        LocalDateTime horaAgendamento = entity.getDataHoraAgendamento();
        LocalDateTime horaFim = horaAgendamento.plusHours(1);

        // Busca a lista de agendamentos no intervalo
        List<SchedulingEntity> agendados = schedulingRepository.findByDataHoraAgendamentoBetween(horaAgendamento, horaFim);

        // Verifica se a lista não está vazia
        if (!agendados.isEmpty()) {
            throw new RuntimeException("Horário já preenchido");     
        }

        return schedulingRepository.save(entity);
    }

    public void deleteSchedulingEntity(LocalDateTime dataHoraAgendamento, String client) {
        schedulingRepository.deleteByClienteAndDataHoraAgendamento(client, dataHoraAgendamento);
    }

    public List<SchedulingEntity> buscarAgendamento(LocalDate data) {
        LocalDateTime primeiraHoraDia = data.atStartOfDay();
        LocalDateTime horaFinalDia = data.atTime(23, 59, 59);
        return schedulingRepository.findByDataHoraAgendamentoBetween(primeiraHoraDia, horaFinalDia);
    }
    public SchedulingEntity altereAgendamento(SchedulingEntity agendamento, String cliente, LocalDateTime dataHoraAgendamento) {
        // Busca o agendamento existente para obter o ID
        SchedulingEntity agendaExistente = schedulingRepository.findByClienteAndDataHoraAgendamento(cliente, dataHoraAgendamento);
        /*  */
        if (Objects.isNull(agendaExistente)) {
            throw new RuntimeException("Agendamento não encontrado para este cliente nesta data");
        }

        // Mantém o ID original para realizar o UPDATE em vez de um novo INSERT
        agendamento.setId(agendaExistente.getId());
        return schedulingRepository.save(agendamento);
    }
}