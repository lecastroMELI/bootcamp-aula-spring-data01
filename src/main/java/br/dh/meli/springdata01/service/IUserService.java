package br.dh.meli.springdata01.service;

import br.dh.meli.springdata01.model.UserBD;

public interface IUserService {
    // POR PADRÃO TODO MÉTODO DEFINIDO NUMA INTERFACE É PÚBLICO

    UserBD getUserById(long id);
}
