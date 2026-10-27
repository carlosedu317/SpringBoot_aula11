package br.senac.sp.tads.dsw.exemplo6.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.senac.sp.tads.dsw.exemplo6.dto.ProdutoRequestDTO;
import br.senac.sp.tads.dsw.exemplo6.dto.ProdutoResponseDTO;
import br.senac.sp.tads.dsw.exemplo6.model.Categoria;
import br.senac.sp.tads.dsw.exemplo6.model.Produto;
import br.senac.sp.tads.dsw.exemplo6.repository.CategoriaRepository;
import br.senac.sp.tads.dsw.exemplo6.repository.ProdutoRepository;

@Service
public class ProdutoService {
    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;

    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<ProdutoResponseDTO> listar() {
        return produtoRepository.findAll().stream()
                .map(p -> new ProdutoResponseDTO(p.getId(), p.getNome(), p.getPreco(), p.getCategoria().getNome()))
                .toList();
    }

    public ProdutoResponseDTO criar(ProdutoRequestDTO dto) {
        Categoria cat = categoriaRepository.findById(dto.categoriaId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Categoria inexistente"));

        Produto p = new Produto();
        p.setNome(dto.nome());
        p.setPreco(dto.preco());
        p.setCategoria(cat);
        p = produtoRepository.save(p);

        return new ProdutoResponseDTO(p.getId(), p.getNome(), p.getPreco(), p.getCategoria().getNome());
    }
    // ... (Implemente buscarPorId, atualizar e apagar)
}
