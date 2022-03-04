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
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    private String nome;
    private String dataDeFabricacao;
    private String dataDeVencimento;
    private String marca;
    private double precoDeCompra;
    private double precoDeVenda;

    @ManyToOne
    private Venda vendas;

}
