package br.dh.meli.springdata01.controller;

import br.dh.meli.springdata01.model.UserBD;
import br.dh.meli.springdata01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*") // NÃO VALIDA A ORIGEM DE ONDE ESTÁ VINDO A REQUISIÇÃO. VAI ACEITAR REQUISIÇÕES DE QUALQUER LUGAR.
@RequestMapping("/user")
public class UserBDController {

    // INJEÇÃO DE DEPENDÊNCIA = OBJETO É CRIADO PELO SPRING.
    // O SPRING CUIDA DO CICLO DE VIDA DESTE OBJETO.
    @Autowired
    private UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<UserBD> buscaPorId(@PathVariable long id) {
        UserBD userFound = service.getUserById(id);

        if (userFound != null) {
            return ResponseEntity.ok(userFound);
        }
        return ResponseEntity.notFound().build();
    }
}
