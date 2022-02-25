package com.senac.starter.repositorys;

import com.senac.starter.models.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao,Long> {
    Permissao findPermissaoById(Long id);
}
