/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FRONTEND;

import BACKEND.CentroVacinacao;
import BACKEND.Gestor;
import BACKEND.Marcacao;
import BACKEND.RepositorioCentrosVacinacao;
import BACKEND.RepositorioVacinas;
import BACKEND.Sistema;
import BACKEND.StockVacinas;
import BACKEND.Utilizador;
import javax.swing.JOptionPane;

/**
 *
 * @author guilh
 */
public class JanelaAdicionarCentroVacinacao extends javax.swing.JFrame {

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
    public JanelaAdicionarCentroVacinacao(Sistema sistema, Serializacao.Serializacao bd) {
        initComponents();
        this.sistema = sistema;
        this.bd = bd;
        this.setResizable(false);
        preencherGestores();
        this.setTitle("Adicionar Centro Vacinação");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        Llocalidade = new javax.swing.JTextField();
        Lmorada = new javax.swing.JTextField();
        Lcod = new javax.swing.JTextField();
        Lpostos = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Llimite = new javax.swing.JTextField();
        Lgestor1 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Localidade:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 89, 94, 35));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Gestor");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 173, 94, 35));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Codigo:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 43, 94, 34));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Morada:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 130, 94, 35));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Numero de Postos:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 214, 140, 35));

        jButton2.setText("Criar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 104, 37));
        getContentPane().add(Llocalidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 97, 110, -1));
        getContentPane().add(Lmorada, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 138, 110, -1));

        Lcod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LcodActionPerformed(evt);
            }
        });
        getContentPane().add(Lcod, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 51, 110, -1));
        getContentPane().add(Lpostos, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 222, 110, -1));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Limite Vacinações:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 255, 140, 35));
        getContentPane().add(Llimite, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 263, 110, -1));

        getContentPane().add(Lgestor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(162, 178, 110, -1));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons/Janela Adicionar centro vacinacao.png"))); // NOI18N
        jLabel7.setText("jLabel7");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 370, 420));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LcodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LcodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LcodActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (Lcod.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o código", "Dados em falta", JOptionPane.WARNING_MESSAGE);
            Lcod.requestFocus();
            return;
        }
        if (Llocalidade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza a sua localidade", "Dados em falta", JOptionPane.WARNING_MESSAGE);
            Llocalidade.requestFocus();
            return;
        }
        if (Lmorada.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza a sua morada", "Dados em falta", JOptionPane.WARNING_MESSAGE);
            Lmorada.requestFocus();
            return;
        }
        if (Lpostos.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o número de postos", "Dados em falta", JOptionPane.WARNING_MESSAGE);
            Lpostos.requestFocus();
            return;
        }

        if (Llimite.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Introduza o limite máximo de vacinações", "Dados em falta", JOptionPane.WARNING_MESSAGE);
            Llimite.requestFocus();
            return;
        }

        String codigo = Lcod.getText();
        String localidade = Llocalidade.getText();
        String morada = Lmorada.getText();
        int postos = Integer.parseInt(Lpostos.getText());
        String cod_gestor = Lgestor1.getItemAt(Lgestor1.getSelectedIndex());
        int limite = Integer.parseInt(Llimite.getText());

        try {
            sistema.getCentrosVacinacoes().adicionarCentroVacinacaoCodigo(new CentroVacinacao(codigo, morada, localidade, (Gestor) sistema.getUtilizadores().getGestor(cod_gestor), new StockVacinas(), postos, new RepositorioVacinas(sistema.getVacinas().getListavacinas()), new Marcacao(), limite));
            Gestor gestor = (Gestor) sistema.getUtilizadores().getGestor(cod_gestor);
            JOptionPane.showMessageDialog(this, "Centro criado com sucesso!");
            dispose();
        } catch (RepositorioCentrosVacinacao.CentroVacinacaoJaExistenteException ex) {
            JOptionPane.showMessageDialog(rootPane, "Código já existente! Introduze um novo código");
            Lcod.requestFocus();

        }

    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Lcod;
    private javax.swing.JComboBox<String> Lgestor1;
    private javax.swing.JTextField Llimite;
    private javax.swing.JTextField Llocalidade;
    private javax.swing.JTextField Lmorada;
    private javax.swing.JTextField Lpostos;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables

    /**
     *
     */
    private void preencherGestores() {
        for (Utilizador u : sistema.getUtilizadores().getListaUtilizador()) {
            if (u instanceof Gestor) {
                Gestor gestor = (Gestor) u;
                if (sistema.getCentrosVacinacoes().getCentroVacinacaoPorGestor(gestor) == null) {
                    Lgestor1.addItem(u.getUsername());
                }
            }

        }

    }
}
