package com.david.workshopmongo.resources;

import com.david.workshopmongo.domain.User;
import com.david.workshopmongo.dto.UserDTO;
import com.david.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserResource {//controlador REST

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET) //or pode ser usado @GetMapping... o tipo de metodo http de aquisição dos dados, o metodo de requisição é o GET é para obter informações no padrão REST
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User obj = service.findById(id);
        return ResponseEntity.ok().body(new UserDTO(obj));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){ //retorna um tipo vazio void, pois irá apenas inserir um dado | usa um requestbody
        User obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri(); //pega o endereço do novo objeto inserido
        return ResponseEntity.created(uri).build(); //retorna um código 201 ok(o created o faz), com um cabeçalho contendo a localização do novo recurso criado
    }

}
