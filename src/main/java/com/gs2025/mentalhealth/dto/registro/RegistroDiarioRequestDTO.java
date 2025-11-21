package com.gs2025.mentalhealth.dto.registro;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record RegistroDiarioRequestDTO(

    @NotNull(message = "Data é obrigatória")
    LocalDate dataRegistro,

    @Min(1) @Max(5)
    int nivelHumor,

    @Min(1) @Max(5)
    int nivelAnsiedade,

    @Min(0)
    int horasSono,

    @NotNull(message = "ID do paciente é obrigatório")
    Long pacienteId
) {}
