/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FRONTEND;

import BACKEND.CentroVacinacao;
import BACKEND.Sistema;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guilh
 */
public class JanelaListarCentroVacinacoes extends javax.swing.JFrame {

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
     * @param sistema
     * @param bd
     */
    public JanelaListarCentroVacinacoes(Sistema sistema, Serializacao.Serializacao bd) {
        initComponents();
        this.sistema = sistema;
        this.bd = bd;
        this.setTitle("Editar Centros Vacinação");
        this.setResizable(false);
        preencherTabelas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToggleButton1 = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Beditar = new javax.swing.JButton();
        Bcriar = new javax.swing.JButton();
        Beditar1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Localidade", "Morada", "Gestor", "Postos", "Limite Vacinações"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 570, 403));

        Beditar.setText("EDITAR");
        Beditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeditarActionPerformed(evt);
            }
        });
        getContentPane().add(Beditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 265, 124, 81));

        Bcriar.setText("CRIAR");
        Bcriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcriarActionPerformed(evt);
            }
        });
        getContentPane().add(Bcriar, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 132, 124, 81));

        Beditar1.setText("REMOVER");
        Beditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Beditar1ActionPerformed(evt);
            }
        });
        getContentPane().add(Beditar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 400, 124, 81));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons/Janela Listar Centro Vacinacoes.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 570));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BcriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcriarActionPerformed
        JanelaAdicionarCentroVacinacao j = new JanelaAdicionarCentroVacinacao(sistema, bd);
        j.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BcriarActionPerformed

    private void BeditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeditarActionPerformed
        int col = 0;
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um centro!");
            return;
        }
        String cod = (String) jTable1.getValueAt(row, col);
        JanelaEditarCentroVacinacao j = new JanelaEditarCentroVacinacao(sistema, cod, bd);
        j.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_BeditarActionPerformed

    private void Beditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Beditar1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int col = 0;
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um centro!");
            return;
        }
        String cod = (String) jTable1.getValueAt(row, col);
        CentroVacinacao cv = sistema.getCentrosVacinacoes().CentroVacinacaoPorCod(cod);
        sistema.getCentrosVacinacoes().remover(cv);
        model.removeRow(row);


    }//GEN-LAST:event_Beditar1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bcriar;
    private javax.swing.JButton Beditar;
    private javax.swing.JButton Beditar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables

    /**
     *
     */
    private void preencherTabelas() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (CentroVacinacao cv : sistema.getCentrosVacinacoes().getLista()) {
            String cod = cv.getCodigo();
            String localidade = cv.getLocalidade();
            String morada = cv.getMorada();
            int postos = cv.getNumeroPostosAtendimento();
            int limite = cv.getNumeroMaximoVacinacaoPorDia();
            String gestor = "";
            try {
                gestor = cv.getGestor().getNome();
            } catch (Exception e) {
                gestor = "Sem gestor";

            }

            model.addRow(new Object[]{cod, localidade, morada, gestor, postos, limite});
        }

    }
}