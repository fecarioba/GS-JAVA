package com.gs2025.mentalhealth.service;

import com.gs2025.mentalhealth.dto.registro.*;

import java.util.List;

public interface RegistroDiarioService {
    RegistroDiarioResponseDTO create(RegistroDiarioRequestDTO dto);
    List<RegistroDiarioResponseDTO> findAll();
    RegistroDiarioResponseDTO findById(Long id);
    RegistroDiarioResponseDTO update(Long id, RegistroDiarioRequestDTO dto);
    void delete(Long id);
    List<RegistroDiarioResponseDTO> findByPacienteId(Long pacienteId);
}
