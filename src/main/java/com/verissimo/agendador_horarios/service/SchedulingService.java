package com.verissimo.agendador_horarios.service;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import com.verissimo.agendador_horarios.infrastruture.entity.SchedulingEntity;
import com.verissimo.agendador_horarios.infrastruture.repository.SchedulingRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchedulingService {

    private final SchedulingRepository schedulingRepository;

    public SchedulingEntity saveScheduling(SchedulingEntity entity) {
        LocalDateTime horaFinal = entity.getDataHoraAgendamento();
        LocalDateTime horafim = entity.getDataHoraAgendamento().plusHours(1);

        


        return schedulingRepository.save(entity);
    }
}