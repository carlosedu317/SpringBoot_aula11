package br.senac.sp.tads.dsw.exemplo6.dto;

import java.math.BigDecimal;

public record ProdutoResponseDTO(
        Long id,
        String nome,
        BigDecimal preco,
        String nomeCategoria // Facilitando a vida do Front-end!
) {
}
