package br.senac.sp.tads.dsw.exemplo6.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import br.senac.sp.tads.dsw.exemplo6.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    boolean exexistsByLogin(String login);

    Optional<UserDetails> findByLogin(String login);
    
}
