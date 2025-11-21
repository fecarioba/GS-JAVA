package com.gs2025.mentalhealth.mapper;

import com.gs2025.mentalhealth.dto.paciente.*;
import com.gs2025.mentalhealth.entity.Paciente;

public class PacienteMapper {

    public static Paciente toEntity(PacienteRequestDTO dto) {
        return Paciente.builder()
                .nome(dto.nome())
                .email(dto.email())
                .dataNascimento(dto.dataNascimento())
                .build();
    }

    public static PacienteResponseDTO toDTO(Paciente entity) {
        return new PacienteResponseDTO(
                entity.getId(),
                entity.getNome(),
                entity.getEmail(),
                entity.getDataNascimento()
        );
    }
}
