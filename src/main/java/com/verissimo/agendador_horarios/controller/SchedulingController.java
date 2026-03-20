package com.verissimo.agendador_horarios.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.verissimo.agendador_horarios.infrastruture.entity.SchedulingEntity;
import com.verissimo.agendador_horarios.service.SchedulingService;

import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor

public class SchedulingController {
    private final SchedulingService schedulingService;

    @PostMapping
    public ResponseEntity<SchedulingEntity> salvarAgendamento( @RequestBody SchedulingEntity agendamento){
        return ResponseEntity.accepted().body(schedulingService.saveScheduling(agendamento));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAgendamento(
            @RequestParam String cliente, 
            @RequestParam LocalDateTime dataHoraAgendamento) {
        
        schedulingService.deleteSchedulingEntity(dataHoraAgendamento, cliente);
        
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<SchedulingEntity> buscarAgendamento(@RequestParam LocalDate data){
        return ResponseEntity.ok().body(schedulingService.buscarAgendamento(data));
    }

    @PutMapping
    public ResponseEntity<SchedulingEntity> alterarAgendamento(
        @RequestParam SchedulingEntity agendamento,
        @RequestParam String cliente,
        @RequestParam LocalDateTime dataHoraAgendamento){

            return ResponseEntity.accepted().body(schedulingService.altereAgendamento(agendamento, cliente, dataHoraAgendamento));
    }
}
