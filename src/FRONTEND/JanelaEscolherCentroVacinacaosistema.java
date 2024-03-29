/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FRONTEND;

import BACKEND.CentroVacinacao;
import BACKEND.Sistema;
import BACKEND.Utente;

/**
 *
 * @author guilh
 */
public class JanelaEscolherCentroVacinacaosistema extends javax.swing.JFrame {

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
     * @param utente
     * @param bd
     */
    public JanelaEscolherCentroVacinacaosistema(Sistema sistema, Utente utente, Serializacao.Serializacao bd) {
        initComponents();
        this.sistema = sistema;
        this.utente = utente;
        this.bd = bd;
        this.setTitle("Escolher Centro Vacinação");
        preencherCentros();
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

        jButton2 = new javax.swing.JButton();
        Lcentro = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Guardar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 96, -1));

        Lcentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LcentroActionPerformed(evt);
            }
        });
        getContentPane().add(Lcentro, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 136, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Escolha um centro de vacinação:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 180, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons/Janela Escolher Centro Vacinacao.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
                jLabel1AncestorMoved(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LcentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LcentroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LcentroActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String localidade = Lcentro.getItemAt(Lcentro.getSelectedIndex());
        CentroVacinacao cv = sistema.getCentrosVacinacoes().CentroVacinacaoPorLocalidade(localidade);
        utente.setCentrovacinacao(cv);
        dispose();


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel1AncestorMoved(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jLabel1AncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1AncestorMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Lcentro;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    /**
     *
     */
    private void preencherCentros() {

        for (CentroVacinacao cv : sistema.getCentrosVacinacoes().getLista()) {
            Lcentro.addItem(cv.getLocalidade());
        }

    }

}
