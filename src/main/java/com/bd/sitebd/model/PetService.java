package com.bd.sitebd.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    @Autowired
    PetDAO pdao;

    public void inserir(Pet pet) {
        pdao.inserir(pet);
    }

    public List<Map<String, Object>> obterTodosPets() {
        return pdao.obterTodosPets();
    }

    public void atualizarPet(int id, Pet pet) {
        pdao.atualizarPet(id, pet);
    }

    public Pet obterPet(int id) {
        return pdao.obterPet(id);
    }

    public void deletarPet(int id) {
        pdao.deletarPet(id);
    }
    
}