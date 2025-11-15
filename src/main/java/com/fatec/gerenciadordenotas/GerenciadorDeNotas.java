/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.fatec.gerenciadordenotas;

import javax.swing.JOptionPane;

public class GerenciadorDeNotas {

    public static void main(String[] args) {
        
       
        String nome = JOptionPane.showInputDialog(null, "Nome:", "1", JOptionPane.PLAIN_MESSAGE);
        if (nome == null || nome.trim().isEmpty()) return;
        Aluno aluno = new Aluno(nome.trim());

        
        try {
            for (String p : new String[]{"TP1", "TP2", "TP3"}) {
                String notaStr = JOptionPane.showInputDialog(null, "Nota " + p + ":", "2", JOptionPane.PLAIN_MESSAGE);
                if (notaStr == null) return;
                
                double nota = Double.parseDouble(notaStr.replace(',', '.').trim());
                if (nota < 0 || nota > 10) return; 
                
                aluno.getNotas().add(nota);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro na entrada. Fim.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
       
        if (!aluno.isNotasLancadas()) return;

        double media = aluno.calcularMedia();
        String status = aluno.avaliarDesempenho();

        String relatorio = String.format(
            "ALUNO: %s\nMédia: %.2f\nSTATUS: %s", 
            aluno.getNome(), media, status
        );
        
        int tipoMsg = status.equals("Reprovado") ? JOptionPane.ERROR_MESSAGE : JOptionPane.INFORMATION_MESSAGE;
        
        JOptionPane.showMessageDialog(null, relatorio, "Resultado", tipoMsg);
    }
}