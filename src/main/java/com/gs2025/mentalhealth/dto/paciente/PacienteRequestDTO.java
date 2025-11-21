package com.gs2025.mentalhealth.dto.paciente;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record PacienteRequestDTO(

    @NotBlank(message = "Nome é obrigatório")
    String nome,

    @NotBlank(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    String email,

    @Past(message = "Data de nascimento deve estar no passado")
    LocalDate dataNascimento
) {}
