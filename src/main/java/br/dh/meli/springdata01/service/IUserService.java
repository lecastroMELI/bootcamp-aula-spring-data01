package br.dh.meli.springdata01.service;

import br.dh.meli.springdata01.model.UserBD;

import java.util.Optional;

public interface IUserService {
    /* POR PADRÃO QUALQUER MÉTODO DEFINIDO NUMA INTERFACE É PÚBLICO */

    // UserBD getUserById(long id);

    // --------------- [ AULA 2 ] --------------- //

    Optional<UserBD> getUserById(long id);

    UserBD insertUser(UserBD newUser);
}
