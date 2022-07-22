package br.dh.meli.springdata01.controller;

import br.dh.meli.springdata01.model.UserBD;
import br.dh.meli.springdata01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        // UserBD userFound = service.getUserById(id);
        Optional<UserBD> userFound = service.getUserById(id);

        if (userFound.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        // O get RETORNA O DADO QUE ESTÁ SENDO RETORNADO PELO MEU OPTIONAL. É PRECISO VALIDAR O QUE TEM DENTRO DELE
        return ResponseEntity.ok(userFound.get());
    }

    @PostMapping
    public ResponseEntity<UserBD> insertUser(@RequestBody UserBD newUser) {
        // TODO: Validar ser o user tem ID: disparar Exception caso não.
        return ResponseEntity.status(HttpStatus.CREATED).body(service.insertUser(newUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable long id) {
        Optional<UserBD> userFound = service.getUserById(id);

        if (userFound.isPresent()) {
            service.deleteUser(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
