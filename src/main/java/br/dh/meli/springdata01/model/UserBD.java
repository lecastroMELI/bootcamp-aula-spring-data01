package br.dh.meli.springdata01.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tb_user") // DEFINE O NOME DA TABELA, SE NÃO SERÁ USADO O NOME DA CLASSE
public class UserBD {
    @Id // indica que é a chave primária
    @GeneratedValue(strategy =  GenerationType.IDENTITY) // indica geração sequencial
    private long id;

    @Column(name = "name", length = 100, nullable = false) // VALIDAÇÕES QUE SERÃO FEITAS NO BANCO. UMA VEZ CRIADO QUALQUER ALTERAÇÃO DEVE SER FEITA NO BANCO
    private String name;

    // SE NÃO DEFINIR UM NOME, VAI USAR O NOME DO CAMPO
    @Column(length = 80, nullable = false, unique = true) // VALIDAÇÕES QUE SERÃO FEITAS NO BANCO
    private String email;

}
