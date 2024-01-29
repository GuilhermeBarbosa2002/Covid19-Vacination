/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FRONTEND;

import BACKEND.CentroVacinacao;
import BACKEND.Marcacao;
import BACKEND.Sistema;
import BACKEND.Utente;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author guilh
 */
public class JanelaFazerPrimeiraMarcacao extends javax.swing.JFrame {

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
    public JanelaFazerPrimeiraMarcacao(Sistema sistema, Serializacao.Serializacao bd) {
        initComponents();
        this.sistema = sistema;
        this.utente = (Utente) sistema.getUtilizadorligado();
        this.bd = bd;
        this.setResizable(false);
        this.setTitle("MARCAR DATA VACINAÇÃO");
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jDateMarcacao = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Escolha uma data para a sua primeira Vacinação:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 300, 40));

        jButton1.setText("Marcar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 102, 104, -1));
        getContentPane().add(jDateMarcacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 110, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons/primmarc.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //converter de Date para LocalDate
        Date data = jDateMarcacao.getDate();
        Instant instant = data.toInstant();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate dataMarcacao = instant.atZone(defaultZoneId).toLocalDate();

        LocalDate hoje = LocalDate.now();

        if (dataMarcacao.isBefore(hoje)) {
            JOptionPane.showMessageDialog(rootPane, "Data inválida, escolha outro dia!", "ERRO", HEIGHT);
            jDateMarcacao.requestFocus();
            return;
        }

        CentroVacinacao cv = this.utente.getCentrovacinacao();
        if (cv == null) {
            JOptionPane.showMessageDialog(rootPane, "O Utente ainda não tem um centro de vacinação associado", "ERRO", HEIGHT);
            dispose();

        } else {
            try {
                cv.fazerMarcacao(dataMarcacao, utente);
                dispose();
            } catch (Marcacao.MarcacaoJaExistente ex) {
                Logger.getLogger(JanelaFazerPrimeiraMarcacao.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Já existe uma marcação neste dia!", "ERRO", HEIGHT);
            } catch (CentroVacinacao.LimiteMarcacoesUltrapassado ex) {
                Logger.getLogger(JanelaFazerPrimeiraMarcacao.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(rootPane, "Marcações para este dia esgotadas!", "ERRO", HEIGHT);
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateMarcacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
