package com.bd.sitebd.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class PetDAO {

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    @PostConstruct
    private void initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserir(Pet pet) {
        String sql = "INSERT INTO pet (nm_Pet, nm_Especie, qt_Peso, nm_Tutor, cd_CpfTutor) VALUES (?, ?, ?, ?, ?);";
        Object[] parametros = new Object[5];
        parametros[0] = pet.getNome();
        parametros[1] = pet.getEspecie();
        parametros[2] = pet.getPeso();
        parametros[3] = pet.getNomeTutor();
        parametros[4] = pet.getCpfTutor();
        jdbc.update(sql, parametros);
    }

    public List<Map<String, Object>> obterTodosPets() {
        String sql = "SELECT * FROM pet;";
        return jdbc.queryForList(sql);
    }
    
    public void atualizarPet(int id, Pet pet) {
        String sql = "UPDATE pet SET nm_Pet = ?, nm_Especie = ?, qt_Peso = ?, nm_Tutor = ?, cd_CpfTutor = ? WHERE cd_Pet = ?";
        jdbc.update(sql, pet.getNome(), pet.getEspecie(), pet.getPeso(), pet.getNomeTutor(), pet.getCpfTutor(), id);
    }
    
    public Pet obterPet(int id) {
        String sql = "SELECT * FROM pet WHERE cd_Pet = ?";
        return Tool.converterPet(jdbc.queryForMap(sql, id));
    }
    
    public void deletarPet(int id) {
        String sql = "DELETE FROM pet WHERE cd_Pet = ?";
        jdbc.update(sql, id);
    }
    
}