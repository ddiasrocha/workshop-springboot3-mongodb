package com.david.workshopmongo.dto;

import com.david.workshopmongo.domain.User;
import java.io.Serializable;
import java.util.Optional;

public class UserDTO implements Serializable {//DTO significa Data Transfer Object, é um objeto reduzido onde se pode usar para buscar tipos de dados de um objeto selecionando o que se deseja

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    public UserDTO(){
    }

    public UserDTO(User obj){
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
