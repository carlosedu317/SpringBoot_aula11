package br.senac.sp.tads.dsw.exemplo6.dto;

import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(
    @NotBlank String login,
    @NotBlank String senha,
    @NotBlank String role
) {
    
}
