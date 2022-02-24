package com.senac.starter.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
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

}
