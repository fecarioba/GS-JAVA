package com.gs2025.mentalhealth.dto.paciente;

import java.time.LocalDate;

public record PacienteResponseDTO(
    Long id,
    String nome,
    String email,
    LocalDate dataNascimento
) {}
