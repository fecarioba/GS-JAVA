package com.gs2025.mentalhealth.dto.registro;

import java.time.LocalDate;

public record RegistroDiarioResponseDTO(
    Long id,
    LocalDate dataRegistro,
    int nivelHumor,
    int nivelAnsiedade,
    int horasSono,
    Long pacienteId
) {}
