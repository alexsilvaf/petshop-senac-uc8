package com.senac.starter.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Boolean casado;
    private String email;
    private String telefone;
    private String telefoneSecundario;
    private String dataNascimento;
    private String cep;
    private String rua;
    private Integer numero;
    private String cidade;
    private String estado;

    public void update(Usuario usuario){
        this.nome = usuario.nome;
        this.casado = usuario.casado;
        this.email = usuario.email;
        this.telefone = usuario.telefone;
        this.telefoneSecundario = usuario.telefoneSecundario;
        this.dataNascimento = usuario.dataNascimento;
        this.cep = usuario.cep;
        this.rua = usuario.rua;
        this.numero = usuario.numero;
        this.cidade = usuario.cidade;
        this.estado = usuario.estado;
    }
}
