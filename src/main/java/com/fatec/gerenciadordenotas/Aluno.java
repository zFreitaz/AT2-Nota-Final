/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package com.fatec.gerenciadordenotas;

import java.util.ArrayList; 
import java.util.List;

/**
 * Classe Aluno: Implementa o modelo de dados e a lógica de negócio.
 * @author fatec-dsm2
 */
public class Aluno {
    
    private String nome;
    private final ArrayList<Double> notas = new ArrayList<>();
 
    public Aluno(String nome) {
        this.nome = nome;
    }
    
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<Double> getNotas() {
        return notas;
    }
    
    public boolean isNotasLancadas() {
        return notas.size() == 3;
    }
    
    public void limparNotas() {
        this.notas.clear();
    }
    
    public double calcularMedia() {
        if (notas.size() != 3) {
            return 0.0;
        }
        double soma = 0;
        
        for (double nota : notas) {
            soma += nota;
        }

        return soma / notas.size();
    }
    
   
    public String avaliarDesempenho() { 
        if (notas.size() != 3) {
             return "Notas incompletas";
        }
        
        double media = calcularMedia();
        if (media < 6.0) {
            return "Reprovado";               
        } else if (media <= 9.0) {
            return "Aprovado";              
        } else {
            return "Ótimo Aproveitamento";   
        }
    }
}