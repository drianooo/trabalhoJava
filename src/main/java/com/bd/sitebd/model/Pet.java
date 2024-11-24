package com.bd.sitebd.model;

import java.math.BigDecimal;

public class Pet {
    private int id;
    private String nome;
    private String especie;
    private BigDecimal peso;
    private String nomeTutor;
    private String cpfTutor;

    public Pet(){

    }

    public Pet(int id, String nome, String especie, BigDecimal peso, String nomeTutor, String cpfTutor){
        this.id=id;
        this.nome=nome;
        this.especie=especie;
        this.peso=peso;
        this.nomeTutor=nomeTutor;
        this.cpfTutor=cpfTutor;
    }

    public Pet(String nome, String especie, BigDecimal peso, String nomeTutor, String cpfTutor){
        this.nome=nome;
        this.especie=especie;
        this.peso=peso;
        this.nomeTutor=nomeTutor;
        this.cpfTutor=cpfTutor;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public BigDecimal getPeso() {
        return peso;
    }
    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }
    public String getNomeTutor() {
        return nomeTutor;
    }
    public void setNomeTutor(String nomeTutor) {
        this.nomeTutor = nomeTutor;
    }
    public String getCpfTutor() {
        return cpfTutor;
    }
    public void setCpfTutor(String cpfTutor) {
        this.cpfTutor = cpfTutor;
    }

}
