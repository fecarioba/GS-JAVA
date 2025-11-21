package com.gs2025.mentalhealth.service.impl;

import com.gs2025.mentalhealth.dto.paciente.*;
import com.gs2025.mentalhealth.entity.Paciente;
import com.gs2025.mentalhealth.exception.ResourceNotFoundException;
import com.gs2025.mentalhealth.mapper.PacienteMapper;
import com.gs2025.mentalhealth.repository.PacienteRepository;
import com.gs2025.mentalhealth.service.PacienteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public PacienteResponseDTO create(PacienteRequestDTO dto) {
        Paciente paciente = PacienteMapper.toEntity(dto);
        paciente = pacienteRepository.save(paciente);
        return PacienteMapper.toDTO(paciente);
    }

    @Override
    public List<PacienteResponseDTO> findAll() {
        return pacienteRepository.findAll()
                .stream()
                .map(PacienteMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PacienteResponseDTO findById(Long id) {
        Paciente p = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com id " + id));
        return PacienteMapper.toDTO(p);
    }

    @Override
    public PacienteResponseDTO update(Long id, PacienteRequestDTO dto) {
        Paciente existente = pacienteRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com id " + id));
        existente.setNome(dto.nome());
        existente.setEmail(dto.email());
        existente.setDataNascimento(dto.dataNascimento());
        existente = pacienteRepository.save(existente);
        return PacienteMapper.toDTO(existente);
    }

    @Override
    public void delete(Long id) {
        if (!pacienteRepository.existsById(id)) {
            throw new ResourceNotFoundException("Paciente não encontrado com id " + id);
        }
        pacienteRepository.deleteById(id);
    }
}
