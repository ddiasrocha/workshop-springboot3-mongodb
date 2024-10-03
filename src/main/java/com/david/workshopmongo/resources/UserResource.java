package com.david.workshopmongo.resources;

import com.david.workshopmongo.domain.User;
import com.david.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {//controlador REST

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET) //or pode ser usado @GetMapping... o tipo de metodo http de aquisição dos dados, o metodo de requisição é o GET é para obter informações no padrão REST
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

}
