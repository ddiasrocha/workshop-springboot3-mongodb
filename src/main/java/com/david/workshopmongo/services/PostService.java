package com.david.workshopmongo.services;

import com.david.workshopmongo.domain.Post;
import com.david.workshopmongo.domain.User;
import com.david.workshopmongo.dto.UserDTO;
import com.david.workshopmongo.repository.PostRepository;
import com.david.workshopmongo.repository.UserRepository;
import com.david.workshopmongo.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {//camada de serviço

    @Autowired //essa anotação auto instancia
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return repo.searchTitle(text);
    }

}
