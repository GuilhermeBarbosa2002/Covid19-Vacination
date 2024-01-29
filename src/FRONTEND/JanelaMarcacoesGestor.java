/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FRONTEND;

import BACKEND.CentroVacinacao;
import BACKEND.Sistema;
import BACKEND.Utente;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guilh
 */
public class JanelaMarcacoesGestor extends javax.swing.JFrame {

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
    private CentroVacinacao centroVacinacao;

    /**
     *
     * @param sistema
     * @param bd
     * @param cv
     */
    public JanelaMarcacoesGestor(Sistema sistema, Serializacao.Serializacao bd, CentroVacinacao cv) {
        initComponents();
        this.sistema = sistema;
        this.bd = bd;
        this.centroVacinacao = cv;
        this.setResizable(false);
        this.setTitle("Marcações");
        jLabel2.setText(cv.getCodigo());
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 135, -1));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Insira uma data");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 113, -1));

        jButton1.setText("Ver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 124, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SNS", "Utente", "Localidade", "Telemóvel"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 436, 370));

        jButton2.setText("Cancelar Marcação");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 150, 80));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons/Janela Marcacoes Gestor.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -2, 630, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (jDateChooser1.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Introduza a data", "Dados em falta", JOptionPane.WARNING_MESSAGE);
            jDateChooser1.requestFocus();

        } else {
            Date data = jDateChooser1.getDate();
            LocalDate dataProcurar = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            preencherTabela(dataProcurar);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Date data = jDateChooser1.getDate();
        LocalDate data2 = data.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int col = 0;
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um Utente!");
            return;
        }
        String cod = (String) jTable1.getValueAt(row, col);
        centroVacinacao.getAgendaMarcacoes().remover(data2, (Utente) sistema.getUtilizadores().getUtente(cod));
        model.removeRow(row);
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @param data
     */
    private void preencherTabela(LocalDate data) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        removerDadosTabela();

        try {
            for (Utente u : centroVacinacao.getAgendaMarcacoes().listaUtentesPorData(data)) {
                String username = u.getUsername();
                String nome = u.getNome();
                String telemovel = u.getNumTelemovel();
                String localidade = u.getLocalidade();
                model.addRow(new Object[]{username, nome, localidade, telemovel});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Não existem utentes para esta data", "Dia livre!", HEIGHT);
        }

    }

    /**
     *
     */
    private void removerDadosTabela() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
    }

}
