package br.senac.sp.tads.dsw.exemplo6.dto;

import jakarta.validation.constraints.NotBlank;

public record CategoriaRequestDTO(@NotBlank String nome) {
}
