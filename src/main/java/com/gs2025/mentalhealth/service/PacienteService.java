package com.gs2025.mentalhealth.service;

import com.gs2025.mentalhealth.dto.paciente.*;

import java.util.List;

public interface PacienteService {
    PacienteResponseDTO create(PacienteRequestDTO dto);
    List<PacienteResponseDTO> findAll();
    PacienteResponseDTO findById(Long id);
    PacienteResponseDTO update(Long id, PacienteRequestDTO dto);
    void delete(Long id);
}
