package com.verissimo.agendador_horarios.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        LocalDateTime horaAgendamento= entity.getDataHoraAgendamento();
        LocalDateTime horaFim = entity.getDataHoraAgendamento().plusHours(1);

        SchedulingEntity agendados =  schedulingRepository.finByServiceSchedulingEntityBetween(entity.getServico(), horaAgendamento, horaFim);


        if (Objects.nonNull(agendados)){
            throw new RuntimeException("Horário já preenchido");     
        }
        schedulingRepository.save(agendados);

        return schedulingRepository.save(entity);
    }
    public void deleteSchedulingEntity(LocalDateTime datagHoraAgendamento, String client ){
        schedulingRepository.deleteBySchedulingEntityClient(datagHoraAgendamento, client);

    }

    public SchedulingEntity buscarAgendamento(LocalDate dataHoraInicio){
        LocalDateTime primeiraHoraDia =  dataHoraInicio.atStartOfDay();
        LocalDateTime horaFinalDia = dataHoraInicio.atTime(23,59,59);
        return schedulingRepository.findByDataHoraAgendamentoBetween(primeiraHoraDia, horaFinalDia);
    }

    public SchedulingEntity altereAgendamento( SchedulingEntity agendamento, String cliente, LocalDateTime dataHoraAgendamento) {
        SchedulingEntity agenda = schedulingRepository.findBySchedulingEntityClient(agendamento, cliente, dataHoraAgendamento);
        if(Objects.isNull(agenda)){
            throw  new RuntimeException("Horário não exite");
        }
        agendamento.setId(agenda.getId());
        return schedulingRepository.save(agendamento);

    }

}