/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FRONTEND;

import BACKEND.CentroVacinacao;
import BACKEND.Sistema;
import BACKEND.Utente;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guilh
 */
public class JanelaListarUtentesAssociados extends javax.swing.JFrame {

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
     * @param cod
     */
    public JanelaListarUtentesAssociados(Sistema sistema, Serializacao.Serializacao bd, String cod) {
        initComponents();
        this.sistema = sistema;
        this.bd = bd;
        this.centroVacinacao = sistema.getCentrosVacinacoes().CentroVacinacaoPorCod(cod);
        this.setResizable(false);
        this.setTitle("Listar Utentes");
        preencherTabela();
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SNS", "Utente", "Localidade", "Telemóvel", "Vacina"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 436, 375));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons/Janela Listar Utentes Associados.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    /**
     *
     */
    private void preencherTabela() {
        String fabricante;
        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            for (Utente u : sistema.getUtilizadores().getUtentesPorCentro(centroVacinacao)) {
                String username = u.getUsername();
                String nome = u.getNome();
                String telemovel = u.getNumTelemovel();
                String localidade = u.getLocalidade();
                try {
                    fabricante = u.getVacina().getFabricante();  //se ele tiver vacina associada
                } catch (Exception e) {
                    fabricante = "";                             //se não tiver
                }
                model.addRow(new Object[]{username, nome, localidade, telemovel, fabricante});
            }
        } catch (Exception e) {

        }

    }

}
