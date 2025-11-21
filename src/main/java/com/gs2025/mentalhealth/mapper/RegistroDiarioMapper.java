package com.gs2025.mentalhealth.mapper;

import com.gs2025.mentalhealth.dto.registro.*;
import com.gs2025.mentalhealth.entity.*;

public class RegistroDiarioMapper {

    public static RegistroDiario toEntity(RegistroDiarioRequestDTO dto, Paciente paciente) {
        return RegistroDiario.builder()
                .dataRegistro(dto.dataRegistro())
                .nivelHumor(dto.nivelHumor())
                .nivelAnsiedade(dto.nivelAnsiedade())
                .horasSono(dto.horasSono())
                .paciente(paciente)
                .build();
    }

    public static RegistroDiarioResponseDTO toDTO(RegistroDiario entity) {
        return new RegistroDiarioResponseDTO(
                entity.getId(),
                entity.getDataRegistro(),
                entity.getNivelHumor(),
                entity.getNivelAnsiedade(),
                entity.getHorasSono(),
                entity.getPaciente().getId()
        );
    }
}
