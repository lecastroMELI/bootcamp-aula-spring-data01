package br.dh.meli.springdata01.repository;

import br.dh.meli.springdata01.model.UserBD;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/* O CrudRepository já possui os métodos de crud declarados
* O JPA vai implementatar os métodos inclusive a classe.
*
*
* O CrudRepository utiliza generics, e espera receber dois parâmentros:
* - Tipo da classe: UserBD
* - Tipo de chave primária (sempre usando a classe), no nosso exemplo é Long
* */
@Repository
public interface IUserDBRepository extends CrudRepository<UserBD, Long> {
    // AS DECLARAÇÕES DOS MÉTODOS ESTÃO NO CrudRepository
}
