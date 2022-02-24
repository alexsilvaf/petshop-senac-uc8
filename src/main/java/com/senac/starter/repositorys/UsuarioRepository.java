package com.senac.starter.repositorys;

import com.senac.starter.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findUsuarioById(Long id);
}
