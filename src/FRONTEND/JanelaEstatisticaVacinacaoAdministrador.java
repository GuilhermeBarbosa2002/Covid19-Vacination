/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FRONTEND;

import BACKEND.Sistema;
import BACKEND.Utente;
import BACKEND.Utilizador;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author guilh
 */
public class JanelaEstatisticaVacinacaoAdministrador extends javax.swing.JFrame {

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
    public JanelaEstatisticaVacinacaoAdministrador(Sistema sistema, Serializacao.Serializacao bd) {
        initComponents();
        this.sistema = sistema;
        this.bd = bd;
        this.setResizable(false);
        this.setTitle("Estatísitica da Vacinação ");
        long numTotalVacinasAdministradas = 0;
        jLabel1.setText("Total de Vacinas Administradas: " + Long.toString(numTotalVacinasAdministradas()));
        jLabel3.setText("Total de Utentes Vacinados: " + Long.toString(numeroTotalVacinados()));
        jLabel4.setText("Total de Utentes registados por vacinar: " + Long.toString(numeroTotalNaoVacinados()));
        preencherTabelaEfeitos();
        preencherTabelaVacinados();
        preencherTabelaAVacinar();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaEfeitos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaVacinados = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaAVacinar = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 489, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("jLabel1");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 489, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("jLabel1");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 489, -1));

        tabelaEfeitos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Utente", "Numero SNS", "Centro Vacinação", "Efeitos Secundários"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabelaEfeitos);
        if (tabelaEfeitos.getColumnModel().getColumnCount() > 0) {
            tabelaEfeitos.getColumnModel().getColumn(0).setResizable(false);
            tabelaEfeitos.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jTabbedPane1.addTab("Efeitos secundários registados na vacinação", jPanel1);

        tabelaVacinados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Utente", "Numero SNS", "Centro Vacinação", "Vacina"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tabelaVacinados);
        if (tabelaVacinados.getColumnModel().getColumnCount() > 0) {
            tabelaVacinados.getColumnModel().getColumn(0).setResizable(false);
            tabelaVacinados.getColumnModel().getColumn(1).setResizable(false);
            tabelaVacinados.getColumnModel().getColumn(2).setResizable(false);
            tabelaVacinados.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(180, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Utentes Vacinados", jPanel2);

        tabelaAVacinar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Utente", "Numero SNS", "Centro Vacinação", "Vacina"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tabelaAVacinar);
        if (tabelaAVacinar.getColumnModel().getColumnCount() > 0) {
            tabelaAVacinar.getColumnModel().getColumn(0).setResizable(false);
            tabelaAVacinar.getColumnModel().getColumn(1).setResizable(false);
            tabelaAVacinar.getColumnModel().getColumn(2).setResizable(false);
            tabelaAVacinar.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Utentes a vacinar", jPanel3);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 710, 390));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/icons/Janela Estatistica Admin.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tabelaAVacinar;
    private javax.swing.JTable tabelaEfeitos;
    private javax.swing.JTable tabelaVacinados;
    // End of variables declaration//GEN-END:variables

    /**
     *
     * @return
     */
    private long numeroTotalVacinados() {
        long total = 0;
        for (Utilizador u : sistema.getUtilizadores().getListaUtilizador()) {
            if (u instanceof Utente) {
                Utente utente = (Utente) u;
                if (utente.isVacinado()) {
                    total++;
                }
            }

        }
        return total;
    }

    /**
     *
     * @return
     */
    private long numeroTotalNaoVacinados() {
        long total = 0;
        for (Utilizador u : sistema.getUtilizadores().getListaUtilizador()) {
            if (u instanceof Utente) {
                Utente utente = (Utente) u;
                if (!utente.isVacinado()) {
                    total++;
                }
            }

        }
        return total;
    }

    /**
     *
     * @return
     */
    private long numTotalVacinasAdministradas() {
        return sistema.getCentrosVacinacoes().totalVacinasAdministradasEmTodosOsCentros();

    }

    /**
     *
     */
    private void preencherTabelaEfeitos() {
        String centro;
        DefaultTableModel model = (DefaultTableModel) tabelaEfeitos.getModel();  //get model para usar o metodo do defaultmodeltable
        for (Utilizador u : sistema.getUtilizadores().getListaUtilizador()) {
            if (u instanceof Utente) {
                Utente utente = (Utente) u; //cast para podermos aceder aos metodos do utente
                String username = utente.getUsername();
                try {
                    centro = utente.getCentrovacinacao().getLocalidade();  //se ele não tiver centro de vacinação quer dizer que não foi vacinado
                } catch (Exception e) {
                    centro = "";
                }
                String nome = utente.getNome();
                for (String efeito : utente.getEfeitosSecundarios().getDoencas()) {
                    model.addRow(new Object[]{nome, username, centro, efeito});  // adiciona uma linha
                }

            }

        }
    }

    /**
     *
     */
    private void preencherTabelaVacinados() {
        String centro;
        DefaultTableModel model = (DefaultTableModel) tabelaVacinados.getModel();  //get model para usar o metodo do defaultmodeltable
        for (Utilizador u : sistema.getUtilizadores().getListaUtilizador()) {
            if (u instanceof Utente) {
                Utente utente = (Utente) u; //cast para podermos aceder aos metodos do utente

                if (utente.isVacinado()) {
                    String username = utente.getUsername();
                    String nome = utente.getNome();
                    try {
                        centro = utente.getCentrovacinacao().getLocalidade();  //se ele não tiver centro de vacinação quer dizer que não foi vacinado
                    } catch (Exception e) {
                        centro = "";
                    }
                    String fabricante = utente.getVacina().getFabricante();
                    model.addRow(new Object[]{nome, username, centro, fabricante});
                }// adiciona uma linha

            }
        }
    }

    /**
     *
     */
    private void preencherTabelaAVacinar() {
        DefaultTableModel model = (DefaultTableModel) tabelaAVacinar.getModel();  //get model para usar o metodo do defaultmodeltable
        String fabricante;
        String centro;
        for (Utilizador u : sistema.getUtilizadores().getListaUtilizador()) {
            if (u instanceof Utente) {
                Utente utente = (Utente) u; //cast para podermos aceder aos metodos do utente
                if (!utente.isVacinado()) {
                    String username = utente.getUsername();
                    String nome = utente.getNome();
                    try {
                        centro = utente.getCentrovacinacao().getLocalidade();  //se ele não tiver centro de vacinação quer dizer que não foi vacinado
                    } catch (Exception e) {
                        centro = "";
                    }
                    try {
                        fabricante = utente.getVacina().getFabricante();          //se ele não conseguir aceder ao getVacina, quer dizer que ele ainda não foi vacinado pela primeira vez
                    } catch (Exception e) {                                       // se ele conseguir, foi vacinado, mas faltam tomas
                        fabricante = "";
                    }
                    model.addRow(new Object[]{nome, username, centro, fabricante});
                }// adiciona uma linha

            }
        }
    }
}
