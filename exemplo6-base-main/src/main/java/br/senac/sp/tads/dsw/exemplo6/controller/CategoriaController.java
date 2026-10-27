package br.senac.sp.tads.dsw.exemplo6.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import br.senac.sp.tads.dsw.exemplo6.dto.CategoriaRequestDTO;
import br.senac.sp.tads.dsw.exemplo6.dto.CategoriaResponseDTO;
import br.senac.sp.tads.dsw.exemplo6.service.CategoriaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @GetMapping
    public List<CategoriaResponseDTO> listar() {
        return service.listar();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoriaResponseDTO criar(@RequestBody @Valid CategoriaRequestDTO dto) {
        return service.criar(dto);
    }
    // ... (Implemente GET por ID, PUT e DELETE)
}
