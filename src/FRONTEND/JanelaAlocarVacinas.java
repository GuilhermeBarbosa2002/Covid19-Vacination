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
public class JanelaAlocarVacinas extends javax.swing.JFrame {

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
    public JanelaAlocarVacinas(Sistema sistema, Serializacao.Serializacao bd) {
        initComponents();
        this.sistema = sistema;
        this.bd = bd;
        preencherTabelas();
        this.setResizable(false);
        this.setTitle("Centros de Vacinação");
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Localidade", "Morada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 494, 343));

        jButton2.setText("Gerir Vacinas");
        jButton2.setMaximumSize(new java.awt.Dimension(124, 81));
        jButton2.setMinimumSize(new java.awt.Dimension(124, 81));
        jButton2.setPreferredSize(new java.awt.Dimension(124, 81));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 215, 124, 81));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons/alocar vacina.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 700, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int col = 0;
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um Centro de Vacinação!");
            return;
        }
        String cod = (String) jTable1.getValueAt(row, col);
        JanelaGerirVacinas j = new JanelaGerirVacinas(sistema, bd, cod);
        j.setVisible(true);
        dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
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

            model.addRow(new Object[]{cod, localidade, morada});
        }
    }

}
