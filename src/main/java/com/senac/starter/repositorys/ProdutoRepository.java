package com.senac.starter.repositorys;

import com.senac.starter.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    Produto findProdutoById(Long id);
}
