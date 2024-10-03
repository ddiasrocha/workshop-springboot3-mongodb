package com.david.workshopmongo.services;

import com.david.workshopmongo.domain.User;
import com.david.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {//camada de serviço

    @Autowired //essa anotação auto instancia
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

}
