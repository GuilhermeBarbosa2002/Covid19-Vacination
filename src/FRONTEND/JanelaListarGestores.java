package FRONTEND;

import BACKEND.CentroVacinacao;
import BACKEND.Sistema;
import BACKEND.Gestor;
import BACKEND.Utilizador;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guilh
 */
public class JanelaListarGestores extends javax.swing.JFrame {

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
    public JanelaListarGestores(Sistema sistema, Serializacao.Serializacao bd) {
        initComponents();
        this.sistema = sistema;
        this.bd = bd;
        this.setResizable(false);
        preencherTabela();
        this.setTitle("Gestores");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        Bcriar = new javax.swing.JButton();
        Bcriar1 = new javax.swing.JButton();
        Bcriar2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Nome", "Email", "Password", "Centro Vacinação"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 51, 640, 380));

        Bcriar.setText("CRIAR");
        Bcriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BcriarActionPerformed(evt);
            }
        });
        getContentPane().add(Bcriar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 120, 80));

        Bcriar1.setText("REMOVER");
        Bcriar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bcriar1ActionPerformed(evt);
            }
        });
        getContentPane().add(Bcriar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 120, 80));

        Bcriar2.setText("EDITAR");
        Bcriar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bcriar2ActionPerformed(evt);
            }
        });
        getContentPane().add(Bcriar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 120, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons/Janela Listar Gestores.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BcriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BcriarActionPerformed
        JanelaAdicionarGestor j = new JanelaAdicionarGestor(sistema, bd);
        j.setVisible(true);
        dispose();

    }//GEN-LAST:event_BcriarActionPerformed

    private void Bcriar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bcriar1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        int col = 0;
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um Gestor!");
            return;
        }
        String username = (String) jTable1.getValueAt(row, col);
        Gestor g = (Gestor) sistema.getUtilizadores().getGestor(username);
        sistema.getUtilizadores().remover(g);
        model.removeRow(row);

    }//GEN-LAST:event_Bcriar1ActionPerformed

    private void Bcriar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bcriar2ActionPerformed
        int col = 0;
        int row = jTable1.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um Gestor!");
            return;
        }
        String username = (String) jTable1.getValueAt(row, col);
        JanelaEditarGestor j = new JanelaEditarGestor(sistema, username, bd);
        j.setVisible(true);
        this.dispose();          // TODO add your handling code here:
    }//GEN-LAST:event_Bcriar2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bcriar;
    private javax.swing.JButton Bcriar1;
    private javax.swing.JButton Bcriar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    /**
     *
     */
    private void preencherTabela() {
        String localidade;
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (Utilizador g : sistema.getUtilizadores().getListaUtilizador()) {
            if (g instanceof Gestor) {
                String username = g.getUsername();
                String nome = g.getNome();
                String email = g.getEmail();
                String password = g.getPassword();
                if (sistema.getCentrosVacinacoes().getCentroVacinacaoPorGestor((Gestor) g) != null) {

                    CentroVacinacao centro = sistema.getCentrosVacinacoes().getCentroVacinacaoPorGestor((Gestor) g);
                    localidade = centro.getLocalidade();
                } else {
                    localidade = "";
                }

                model.addRow(new Object[]{username, nome, email, password, localidade});
            }

        }

    }
}