package br.senac.sp.tads.dsw.exemplo6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.senac.sp.tads.dsw.exemplo6.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
