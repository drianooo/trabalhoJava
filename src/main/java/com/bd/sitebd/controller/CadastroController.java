package com.bd.sitebd.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bd.sitebd.model.Tool;

import com.bd.sitebd.model.Pet;
import com.bd.sitebd.model.PetService;

import jakarta.websocket.server.PathParam;

import java.math.BigDecimal;

@Controller
public class CadastroController {
    @Autowired
    private ApplicationContext context;

    @GetMapping("/") 
    public String Principal(){
        return "principal"; 
    }

    @GetMapping("/atualizar/{id}") 
    public String atualizar(Model model, @PathVariable int id){
        PetService ps = context.getBean(PetService.class);
        Pet pet = ps.obterPet(id);
        model.addAttribute("id", id);
        model.addAttribute("pet", pet);
        return "atualizar";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable int id, @ModelAttribute Pet pet){
        PetService ps = context.getBean(PetService.class);
        ps.atualizarPet(id, pet);
        return "redirect:/listagem";
    }

    @GetMapping("/cadastro") 
    public String cadastro(Model model){
        BigDecimal bigDecimal = new BigDecimal("0");
        model.addAttribute("pet", new Pet(0, "", "", bigDecimal, "", ""));
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(Model model, @ModelAttribute Pet pet){
        PetService ps = context.getBean(PetService.class);
        ps.inserir(pet);
        model.addAttribute("cadastroSucesso", true);
        return "cadastro";
    }

    @GetMapping("/listagem")
    public String listagem(Model model){
        PetService ps = context.getBean(PetService.class);
        List<Map<String,Object>> lista = ps.obterTodosPets();
        List<Pet> listaPets = new ArrayList<Pet>();
        for(Map<String,Object> registro : lista){
            listaPets.add(Tool.converterPet(registro));
        }
        model.addAttribute("pets", listaPets);
        return "listagem";
    }

    @PostMapping("/deletar/{id}")
    public String deletar(@PathVariable int id){
        PetService ps = context.getBean(PetService.class);
        ps.deletarPet(id);
        return "redirect:/listagem";
    }

    @GetMapping("/error")
    public String erro(){
        return "error";
    }

}