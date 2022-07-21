package br.dh.meli.springdata01.service;

import br.dh.meli.springdata01.model.UserBD;
import br.dh.meli.springdata01.repository.IUserDBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* JPA gera a classe, implementa os métodos e disponibiliza para uso */

@Service
public class UserService {
    /* PARA ACESSAR OS DADOS É NECESSÁRIO USAR O REPOSITORY
    * Portanto implementa-se a injeção de dependência,
    * que gera o objeto e o disponibiliza pronto para uso */
    @Autowired
    private IUserDBRepository repository;

    public UserBD getUserById(long id) {
        /* findById retorna um Optional.
        * Podem ser feitas várias coisas com ele, sendo que
        * uma delas é usar o orElse.
        * Se achar retorna um UserBD, senão retorna null */
        return (UserBD) repository.findById(id).orElse(null);
    }
}
