package com.gs2025.mentalhealth.service.impl;

import com.gs2025.mentalhealth.dto.registro.*;
import com.gs2025.mentalhealth.entity.*;
import com.gs2025.mentalhealth.exception.ResourceNotFoundException;
import com.gs2025.mentalhealth.mapper.RegistroDiarioMapper;
import com.gs2025.mentalhealth.repository.PacienteRepository;
import com.gs2025.mentalhealth.repository.RegistroDiarioRepository;
import com.gs2025.mentalhealth.service.RegistroDiarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class RegistroDiarioServiceImpl implements RegistroDiarioService {

    private final RegistroDiarioRepository registroRepo;
    private final PacienteRepository pacienteRepo;

    public RegistroDiarioServiceImpl(RegistroDiarioRepository registroRepo, PacienteRepository pacienteRepo) {
        this.registroRepo = registroRepo;
        this.pacienteRepo = pacienteRepo;
    }

    @Override
    public RegistroDiarioResponseDTO create(RegistroDiarioRequestDTO dto) {
        Paciente paciente = pacienteRepo.findById(dto.pacienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com id " + dto.pacienteId()));
        RegistroDiario entidade = RegistroDiarioMapper.toEntity(dto, paciente);
        entidade = registroRepo.save(entidade);
        return RegistroDiarioMapper.toDTO(entidade);
    }

    @Override
    public List<RegistroDiarioResponseDTO> findAll() {
        return registroRepo.findAll().stream()
                .map(RegistroDiarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RegistroDiarioResponseDTO findById(Long id) {
        RegistroDiario r = registroRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro não encontrado com id " + id));
        return RegistroDiarioMapper.toDTO(r);
    }

    @Override
    public RegistroDiarioResponseDTO update(Long id, RegistroDiarioRequestDTO dto) {
        RegistroDiario existente = registroRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro não encontrado com id " + id));
        Paciente paciente = pacienteRepo.findById(dto.pacienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado com id " + dto.pacienteId()));
        existente.setDataRegistro(dto.dataRegistro());
        existente.setNivelHumor(dto.nivelHumor());
        existente.setNivelAnsiedade(dto.nivelAnsiedade());
        existente.setHorasSono(dto.horasSono());
        existente.setPaciente(paciente);
        existente = registroRepo.save(existente);
        return RegistroDiarioMapper.toDTO(existente);
    }

    @Override
    public void delete(Long id) {
        if (!registroRepo.existsById(id)) {
            throw new ResourceNotFoundException("Registro não encontrado com id " + id);
        }
        registroRepo.deleteById(id);
    }

    @Override
    public List<RegistroDiarioResponseDTO> findByPacienteId(Long pacienteId) {
        return registroRepo.findAll().stream()
                .filter(r -> r.getPaciente() != null && r.getPaciente().getId().equals(pacienteId))
                .map(RegistroDiarioMapper::toDTO)
                .collect(Collectors.toList());
    }
}
