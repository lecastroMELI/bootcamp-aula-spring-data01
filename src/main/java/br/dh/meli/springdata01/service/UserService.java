package br.dh.meli.springdata01.service;

import br.dh.meli.springdata01.model.UserBD;
import br.dh.meli.springdata01.repository.IUserDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/* JPA gera a classe, implementa os métodos e disponibiliza para uso */

@Service
public class UserService implements IUserService{
    /* PARA ACESSAR OS DADOS É NECESSÁRIO USAR O REPOSITORY
    * Portanto implementa-se a injeção de dependência,
    * que gera o objeto e o disponibiliza pronto para uso */
    @Autowired
    private IUserDBRepository repository;

    //    public UserBD getUserById(long id) {
    //        /* findById retorna um optional.
    //        * podem ser feitas várias coisas com ele, sendo que
    //        * uma delas é usar o orelse.
    //        * se achar retorna um userbd, senão retorna null */
    //
    //        return (UserBD) repository.findById(id).orElse(null);
    //    }

    // -----------------------------------------------[ AULA 2 ]--------------------------------------------------- //

    @Override
    public Optional<UserBD> getUserById(long id) {
        return repository.findById(id);
    }

    @Override
    public UserBD insertUser(UserBD newUser) {
        // RECEBE O USUÁRIO. GRAVA NO BANCO E RETORNA. ESSA IMPLEMENTAÇÃO FUNCIONA.
        // return repository.save(newUser);

        /* PORÉM, O MÉTODO SAVE SERVE TANTO PARA INSERIR QUANTO PARA ATUALIZAR.
        * SE NÃO EXISTE ELE CRIA * SE EXISTE ELE VAI ATUALIZAR.
        *
        * TODAVIA, ESSE MÉTODO QUE ESTOU CRIANDO CHAMA-SE INSERTUSER E A EXPECTATIVA É QUE VENHA UM USUÁRIO SEM UM ID,
        * PORTANTO É NECESSÁRIO FAZER UMA VALIDAÇÃO */
        if (newUser.getId() > 0) return null;
        return repository.save(newUser);
    }
}
