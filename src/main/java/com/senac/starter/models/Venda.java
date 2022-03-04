package com.senac.starter.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private double totalVenda;
    private String data;
    private String formaDePagamento;

    @OneToMany(mappedBy = "vendas", fetch = FetchType.LAZY)
    private List<Produto> produtos;
}
