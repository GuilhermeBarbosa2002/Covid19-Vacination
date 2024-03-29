/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FRONTEND;

import BACKEND.CentroVacinacao;
import BACKEND.RepositorioDoencas;
import BACKEND.Sistema;
import BACKEND.Utente;
import javax.swing.JOptionPane;

/**
 *
 * @author guilh
 */
public class JanelaEfeitosSecundarios extends javax.swing.JFrame {

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
     */
    private CentroVacinacao centroVacinacao;

    /**
     *
     * @param sistema
     * @param bd
     * @param centroVacinacao
     * @param utente
     */
    public JanelaEfeitosSecundarios(Sistema sistema, Serializacao.Serializacao bd, CentroVacinacao centroVacinacao, Utente utente) {
        initComponents();
        this.sistema = sistema;
        this.bd = bd;
        this.utente = utente;
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Registar Efeitos Secundários");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setText("Registar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 120, 40));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Introduza o efeito secundário:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 178, -1));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 180, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons/Janela Efeitos Secundarios.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 240));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (jTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o efeito Secundário", "Dados em falta", JOptionPane.WARNING_MESSAGE);
            jTextField1.requestFocus();
            return;
        }
        String efeitoSecundario = jTextField1.getText();
        try {
            utente.getEfeitosSecundarios().adicionar(efeitoSecundario);
            jTextField1.setText("");
        } catch (RepositorioDoencas.DoencaJaexistenteException ex) {
            JOptionPane.showMessageDialog(this, "Efeito secundário Repetido", "ERRO", JOptionPane.WARNING_MESSAGE);
            jTextField1.setText("");
        }

        if (JOptionPane.showConfirmDialog(null, "Pretende registar mais algum efeito secundário?", "Efeitos Secundários", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            jTextField1.setText("");
            jTextField1.requestFocus();
        } else {
            if (utente.isVacinado()) {
                JOptionPane.showMessageDialog(rootPane, "Utente vacinado", "Vacinado", HEIGHT);
                dispose();
            } else {
                JanelaFazerMarcacaoGestor j = new JanelaFazerMarcacaoGestor(sistema, bd, utente);
                j.setVisible(true);
                dispose();
            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
