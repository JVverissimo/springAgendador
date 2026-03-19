package com.verissimo.agendador_horarios.infrastruture.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "Scheduling")



public class SchedulingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String servico;
    private String  profissinoal;
    private String  cliente;
    private String telCliente;
    private LocalDateTime dataHoraAgendamento;
    private LocalDateTime  dataInsercao = LocalDateTime.now();

}
