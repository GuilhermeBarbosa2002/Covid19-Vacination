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
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author guilh
 */
public class JanelaFazerMarcacaoGestor extends javax.swing.JFrame {

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
     * @param utente
     */
    public JanelaFazerMarcacaoGestor(Sistema sistema, Serializacao.Serializacao bd, Utente utente) {
        initComponents();
        this.sistema = sistema;
        this.bd = bd;
        this.utente = utente;
        this.setResizable(false);
        this.setTitle("Fazer próxima marcação");
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jDateMarcacao = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Escolha uma data para a próxima marcação:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 339, 29));

        jButton1.setText("Marcar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(199, 133, 104, -1));
        getContentPane().add(jDateMarcacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons/Janela Fazer Marcaçao Gestor.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 190));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String cod = utente.getCentrovacinacao().getLocalidade(); // para passarmos ao construtor da janela UtenesAVacinar

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
        CentroVacinacao centro = utente.getCentrovacinacao();

        LocalDate diaMinimo = hoje.plusDays(utente.getVacina().getIdadeMinima()); // dia minimo para vacinar
        LocalDate diaMaximo = hoje.plusDays(utente.getVacina().getIdadeMaxima()); // dia maximo para vacinar

        if (dataMarcacao.isAfter(diaMinimo) && dataMarcacao.isBefore(diaMaximo)) {
            try {

                centro.fazerMarcacao(dataMarcacao, utente);
                JanelaUtentesParaVacinar j = new JanelaUtentesParaVacinar(sistema, bd, cod);
                j.setVisible(true);
                dispose();

            } catch (Marcacao.MarcacaoJaExistente ex) {
                JOptionPane.showMessageDialog(rootPane, "Marcação já existente", "ERRO", HEIGHT);
            } catch (CentroVacinacao.LimiteMarcacoesUltrapassado ex) {
                JOptionPane.showMessageDialog(rootPane, "Limite de marcações utltrapassado", "ERRO", HEIGHT);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Data inválida, o utente só pode ser vacinado entre o dia " + diaMinimo.format(DateTimeFormatter.ofPattern("d/MM/uuuu")) + " e " + diaMaximo.format(DateTimeFormatter.ofPattern("d/MM/uuuu")), "Dias específicos", HEIGHT);
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateMarcacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
