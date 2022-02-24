package com.senac.starter.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private double totalVenda;
    private String data;
    private String formaDePagamento;
}
