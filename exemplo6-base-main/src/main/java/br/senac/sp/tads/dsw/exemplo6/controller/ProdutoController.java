package br.senac.sp.tads.dsw.exemplo6.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import br.senac.sp.tads.dsw.exemplo6.dto.ProdutoRequestDTO;
import br.senac.sp.tads.dsw.exemplo6.dto.ProdutoResponseDTO;
import br.senac.sp.tads.dsw.exemplo6.service.ProdutoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    private final ProdutoService service;

    public ProdutoController(ProdutoService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProdutoResponseDTO> listar() {
        return service.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoResponseDTO criar(@RequestBody @Valid ProdutoRequestDTO dto) {
        return service.criar(dto);
    }
    // ... (Implemente GET por ID, PUT e DELETE)
}
