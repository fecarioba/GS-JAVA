package com.gs2025.mentalhealth.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegistroDiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataRegistro;

    private int nivelHumor; // 1–5
    private int nivelAnsiedade; // 1–5
    private int horasSono;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    @JsonIgnore   // ⬅️ ADICIONE AQUI
    private Paciente paciente;
}
