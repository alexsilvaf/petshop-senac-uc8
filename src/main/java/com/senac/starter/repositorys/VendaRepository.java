package com.senac.starter.repositorys;

import com.senac.starter.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda,Long> {
    Venda findVendaById(Long id);
}
