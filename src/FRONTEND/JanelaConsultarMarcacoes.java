/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FRONTEND;

import BACKEND.Sistema;
import BACKEND.Utente;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author guilh
 */
public class JanelaConsultarMarcacoes extends javax.swing.JFrame {

    /**
     *
     */
    private Sistema sistema;

    /**
     *
     */
    private Serializacao.Serializacao bd;

    /**
     *
     */
    private Utente utente;

    /**
     *
     * @param sistema
     * @param bd
     */
    public JanelaConsultarMarcacoes(Sistema sistema, Serializacao.Serializacao bd) {
        initComponents();
        this.sistema = sistema;
        this.utente = (Utente) sistema.getUtilizadorligado();
        this.bd = bd;
        this.setTitle("CONSULTAR MARCAÇÃO");
        this.utente = (Utente) sistema.getUtilizadorligado();
        this.setResizable(false);
        preencherData();

    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 11, 260, 70));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons/consultar marcaçao.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 100));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    /**
     *
     */
    private void preencherData() {
        try {
            LocalDate data = utente.getCentrovacinacao().getAgendaMarcacoes().dataProximaMarcacao(utente);
            jLabel1.setText("Data da próxima vacinação " + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        } catch (Exception e) {
            jLabel1.setText(" Ainda não existe data da próxima vacinação");
        }

    }
}
