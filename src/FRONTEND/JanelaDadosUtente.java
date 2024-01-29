package FRONTEND;

import BACKEND.RepositorioDoencas;
import BACKEND.Sistema;
import BACKEND.Utente;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guilh
 */
public class JanelaDadosUtente extends javax.swing.JFrame {

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
    public JanelaDadosUtente(Sistema sistema, Utente utente, Serializacao.Serializacao bd) {
        initComponents();
        this.sistema = sistema;
        this.utente = utente;
        this.bd = bd;
        this.setResizable(false);
        this.setTitle("Dados do Utente");
        preencherDados();
        preencherTabela();
        preencherTabelaDatas();

        try {
            String fabricante = utente.getVacina().getFabricante();
            jVacinaAdministrada.setText(fabricante);
        } catch (Exception e) {

        }

    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jVacinaAdministrada = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDoencas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        ola = new javax.swing.JTextField();
        Bregistar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Jdatanascimento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jNOME = new javax.swing.JTextField();
        jTele = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Jemail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jMorada = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        JIdade = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Datas Administração"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
        }

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(431, 20, 350, 330);

        jVacinaAdministrada.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jPanel3.add(jVacinaAdministrada);
        jVacinaAdministrada.setBounds(170, 140, 140, 80);

        jLabel10.setFont(new java.awt.Font("Eras Demi ITC", 0, 18)); // NOI18N
        jLabel10.setText(" Vacina administrada ");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(120, 120, 200, 40);

        jButton4.setText("Ver Centro de Vacinação");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);
        jButton4.setBounds(110, 260, 220, 70);

        jTabbedPane1.addTab("Informação da Vacinação", jPanel3);

        tabelaDoencas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doenças"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaDoencas);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("Adicionar Doença:");

        Bregistar.setText("Registar");
        Bregistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BregistarActionPerformed(evt);
            }
        });

        jButton3.setText("Remover");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ola, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Bregistar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ola, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(Bregistar))
                        .addGap(77, 77, 77)))
                .addGap(43, 43, 43))
        );

        jTabbedPane1.addTab("Doenças", jPanel1);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(92, 163, 810, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("NºSNS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 67, 31));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 120, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("NOME");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 80, 31));

        Jdatanascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JdatanascimentoActionPerformed(evt);
            }
        });
        getContentPane().add(Jdatanascimento, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 140, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("DATA NASCIMENTO");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 130, 31));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("IDADE");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 67, 31));

        jNOME.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNOMEActionPerformed(evt);
            }
        });
        getContentPane().add(jNOME, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 130, -1));

        jTele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTeleActionPerformed(evt);
            }
        });
        getContentPane().add(jTele, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 110, 182, -1));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("TELEFONE");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(582, 104, 67, 31));

        Jemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JemailActionPerformed(evt);
            }
        });
        getContentPane().add(Jemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 70, 182, -1));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("MORADA");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 104, 60, 31));

        jMorada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMoradaActionPerformed(evt);
            }
        });
        getContentPane().add(jMorada, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 183, -1));

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("EMAIL");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 67, 40));
        getContentPane().add(JIdade, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 70, -1));

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons/Dados Utente.png"))); // NOI18N
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

//adicionar doença, se a caixa estiver vazia meter la o mouse, senão ir buscar a doença e tentar adicionar à tabela se não existir esta doença
    private void BregistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BregistarActionPerformed
        if (ola.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Insira a doença", "Dados em falta", JOptionPane.WARNING_MESSAGE);
            ola.requestFocus();
        } else {

            String doenca = ola.getText().trim();

            try {
                utente.getDoencas().adicionar(doenca);
                DefaultTableModel model = (DefaultTableModel) tabelaDoencas.getModel();
                model.addRow(new Object[]{doenca});
                ola.setText("");

            } catch (RepositorioDoencas.DoencaJaexistenteException ex) {
                JOptionPane.showMessageDialog(this, "Doença repetida!", "ERRO", JOptionPane.WARNING_MESSAGE);

            }
        }
    }//GEN-LAST:event_BregistarActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void JdatanascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JdatanascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JdatanascimentoActionPerformed

    private void jNOMEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNOMEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNOMEActionPerformed

    private void jTeleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTeleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTeleActionPerformed

    private void JemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JemailActionPerformed

    private void jMoradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMoradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMoradaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tabelaDoencas.getModel();
        int col = 0;
        int row = tabelaDoencas.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma Doença");
            return;
        }

        String doenca = (String) tabelaDoencas.getValueAt(row, 0);
        utente.getDoencas().remover(doenca);
        model.removeRow(row);


    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Utente u = (Utente) sistema.getUtilizadorligado();

        if (u.getCentrovacinacao() == null) {
            if (sistema.getCentrosVacinacoes().existeCentroVacinacaoPorLocalidade(u.getLocalidade())) {
                utente.setCentrovacinacao(sistema.getCentrosVacinacoes().CentroVacinacaoPorLocalidade(u.getLocalidade()));
                JOptionPane.showMessageDialog(this, "Como na localidade residente do utente existe um Centro de Vacinação, foi adicionado automaticamente!", "JÁ REGISTADO", HEIGHT);
                JanelaConsultarCentroDeVacinacao janela = new JanelaConsultarCentroDeVacinacao(sistema, u, bd);
                janela.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "O utente ainda não tem centro registado!", "ADICIONAR CENTRO!", HEIGHT);
                JanelaEscolherCentroVacinacaosistema janela = new JanelaEscolherCentroVacinacaosistema(sistema, u, bd);
                janela.setVisible(true);
            }

        } else {
            JanelaConsultarCentroDeVacinacao janela = new JanelaConsultarCentroDeVacinacao(sistema, u, bd);
            janela.setVisible(true);

        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bregistar;
    private javax.swing.JTextField JIdade;
    private javax.swing.JTextField Jdatanascimento;
    private javax.swing.JTextField Jemail;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jMorada;
    private javax.swing.JTextField jNOME;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTele;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jVacinaAdministrada;
    private javax.swing.JTextField ola;
    private javax.swing.JTable tabelaDoencas;
    // End of variables declaration//GEN-END:variables

    /**
     *
     */
    private void preencherDados() {
        JIdade.setText(Integer.toString(utente.calcularIdade()));
        jTextField1.setText(utente.getNumSNS());
        jNOME.setText(utente.getNome());
        Jemail.setText(utente.getEmail());
        Jdatanascimento.setText(utente.getDataNasc().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        jTele.setText(utente.getNumTelemovel());
        jMorada.setText(utente.getMorada());
        ola.requestFocus();

    }

    /**
     *
     */
    private void preencherTabela() {
        DefaultTableModel model = (DefaultTableModel) tabelaDoencas.getModel();
        for (String doenca : utente.getDoencas().getDoencas()) {

            model.addRow(new Object[]{doenca});

        }
    }

    /**
     *
     */
    private void preencherTabelaDatas() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        if (utente.getDatasAdministracao() == null) {

        } else {

            for (LocalDate data : utente.getDatasAdministracao().getDatas()) {
                model.addRow(new Object[]{data});
            }
        }
    }

}
