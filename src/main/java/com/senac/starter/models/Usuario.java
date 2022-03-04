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
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sexo;
    private String estadoCivil;
    private String email;
    private String telefone;
    private String telefoneSecundario;
    private String dataNascimento;
    private String cep;
    private String rua;
    private Integer numero;
    private String cidade;
    private String estado;

    @OneToMany(mappedBy = "dono", fetch = FetchType.LAZY)
    private List<Animal> animais;

    public void update(Usuario usuario){
        this.nome = usuario.nome;
        this.estadoCivil = usuario.estadoCivil;
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
