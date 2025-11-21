package com.gs2025.mentalhealth.controller;

import com.gs2025.mentalhealth.entity.RegistroDiario;
import com.gs2025.mentalhealth.repository.RegistroDiarioRepository;
import com.gs2025.mentalhealth.repository.PacienteRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registros")
public class RegistroDiarioController {

    private final RegistroDiarioRepository registroRepository;
    private final PacienteRepository pacienteRepository;

    public RegistroDiarioController(RegistroDiarioRepository registroRepository, PacienteRepository pacienteRepository) {
        this.registroRepository = registroRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping
    public List<RegistroDiario> listarTodos() {
        return registroRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegistroDiario> buscarPorId(@PathVariable Long id) {
        return registroRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/paciente/{pacienteId}")
    public ResponseEntity<RegistroDiario> criar(@PathVariable Long pacienteId, @RequestBody RegistroDiario registro) {

        return pacienteRepository.findById(pacienteId).map(paciente -> {
            registro.setPaciente(paciente);
            return ResponseEntity.ok(registroRepository.save(registro));
        }).orElse(ResponseEntity.notFound().build());
    }
}
