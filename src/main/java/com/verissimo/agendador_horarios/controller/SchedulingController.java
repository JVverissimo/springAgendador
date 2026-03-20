package com.verissimo.agendador_horarios.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verissimo.agendador_horarios.infrastruture.entity.SchedulingEntity;
import com.verissimo.agendador_horarios.service.SchedulingService;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor

public class SchedulingController {
    private final SchedulingService schedulingService;

    @PostMapping
    public ResponseEntity<SchedulingEntity> salvarAgendamento( @RequestBody SchedulingEntity agendamento){
        return ResponseEntity.accepted().body(schedulingService.saveScheduling(agendamento));
    }

    @DeleteM




}
