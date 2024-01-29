/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FRONTEND;

import BACKEND.CentroVacinacao;
import BACKEND.Sistema;
import BACKEND.Vacina;
import javax.swing.JOptionPane;

/**
 *
 * @author guilh
 */
public class JanelaAdicionarVacinas extends javax.swing.JFrame {

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
    private CentroVacinacao cv;

    /**
     *
     */
    private Vacina vacina;

    /**
     *
     * @param sistema
     * @param bd
     * @param fabricante
     * @param cv
     */
    public JanelaAdicionarVacinas(Sistema sistema, Serializacao.Serializacao bd, String fabricante, CentroVacinacao cv) {
        initComponents();
        this.sistema = sistema;
        this.bd = bd;
        this.cv = cv;
        this.vacina = sistema.getVacinas().getVacinaPorFabricante(fabricante);
        this.setResizable(false);
        this.setTitle("Adicionar Vacinas");

    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jQuantidade = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Quantidade");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 69, 83, 20));
        getContentPane().add(jQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 104, -1));

        jButton2.setText("Adicionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 125, 91, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons/adic vacinas.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jQuantidade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza a quantidade de Vacinas a alocar", "Dados em falta", JOptionPane.WARNING_MESSAGE);
            jQuantidade.requestFocus();
        }

        try {
            int quantidade = Integer.parseInt(jQuantidade.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tipo de dados introduzidos inválido", "ERRO", HEIGHT);
            jQuantidade.requestFocus();
        }

        int quantidade = Integer.parseInt(jQuantidade.getText());
        cv.getStockvacinas().AdicionarVacinas(vacina, quantidade);
        String cod = cv.getCodigo();
        JanelaGerirVacinas j = new JanelaGerirVacinas(sistema, bd, cod);
        j.setVisible(true);
        dispose();


    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jQuantidade;
    // End of variables declaration//GEN-END:variables

}
