package quiz.ui;

import javax.swing.JOptionPane;
import quiz.dao.CapitalDAO;
import quiz.dao.ContinenteDAO;
import quiz.dao.EstadoDAO;
import quiz.dao.PaisDAO;
import quiz.model.Capital;
import quiz.model.Continente;
import quiz.model.Estado;
import quiz.model.Pais;
import quiz.model.TipoCapital;
import quiz.model.Usuario;

public class AdminForm extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminForm.class.getName());
    private Usuario usuarioLogado;

    public AdminForm(Usuario usuario) {
    initComponents();
    this.usuarioLogado = usuario;

    if (!"admin".equals(usuario.getTipo())) {
        JOptionPane.showMessageDialog(this, "Acesso negado");
        dispose();
        return;
    }

    carregarContinentes();
    carregarPaises();
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtxtNomeContinente = new javax.swing.JTextField();
        jbttSalvarContinente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jbttSalvarPais = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtxtNomePais = new javax.swing.JTextField();
        jcbContinentePaís = new javax.swing.JComboBox<Continente>();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jtxtNomeEstado = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jcbPaísEstado = new javax.swing.JComboBox<Pais>();
        jbttSalvarEstados = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jtxtNomeCapital = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jcbTipoCapital = new javax.swing.JComboBox<>();
        jbttSalvarCapitais = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jcbPaísCapital = new javax.swing.JComboBox<Pais>();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jbttSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome:");

        jtxtNomeContinente.setBackground(new java.awt.Color(255, 255, 255));
        jtxtNomeContinente.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jtxtNomeContinente.setForeground(new java.awt.Color(0, 0, 0));
        jtxtNomeContinente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNomeContinenteActionPerformed(evt);
            }
        });

        jbttSalvarContinente.setBackground(new java.awt.Color(0, 0, 0));
        jbttSalvarContinente.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jbttSalvarContinente.setForeground(new java.awt.Color(255, 255, 255));
        jbttSalvarContinente.setText("Salvar");
        jbttSalvarContinente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttSalvarContinenteActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Sitka Heading", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cadastro de Continentes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtNomeContinente, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(343, 343, 343)
                        .addComponent(jbttSalvarContinente, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(264, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel3)
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtxtNomeContinente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addComponent(jbttSalvarContinente)
                .addGap(20, 20, 20))
        );

        jTabbedPane1.addTab("Continentes", jPanel1);

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));

        jbttSalvarPais.setBackground(new java.awt.Color(0, 0, 0));
        jbttSalvarPais.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jbttSalvarPais.setForeground(new java.awt.Color(255, 255, 255));
        jbttSalvarPais.setText("Salvar");
        jbttSalvarPais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttSalvarPaisActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Nome:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Continente:");

        jtxtNomePais.setBackground(new java.awt.Color(255, 255, 255));
        jtxtNomePais.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jtxtNomePais.setForeground(new java.awt.Color(0, 0, 0));
        jtxtNomePais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNomePaisActionPerformed(evt);
            }
        });

        jcbContinentePaís.setBackground(new java.awt.Color(204, 204, 255));
        jcbContinentePaís.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(jbttSalvarPais, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtNomePais, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbContinentePaís, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(280, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtxtNomePais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jcbContinentePaís, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jbttSalvarPais)
                .addGap(18, 18, 18))
        );

        jTabbedPane1.addTab("Países", jPanel2);

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));
        jPanel3.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Nome:");

        jtxtNomeEstado.setBackground(new java.awt.Color(255, 255, 255));
        jtxtNomeEstado.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jtxtNomeEstado.setForeground(new java.awt.Color(0, 0, 0));
        jtxtNomeEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNomeEstadoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("País:");

        jcbPaísEstado.setBackground(new java.awt.Color(204, 204, 255));
        jcbPaísEstado.setForeground(new java.awt.Color(0, 0, 0));

        jbttSalvarEstados.setBackground(new java.awt.Color(0, 0, 0));
        jbttSalvarEstados.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jbttSalvarEstados.setForeground(new java.awt.Color(255, 255, 255));
        jbttSalvarEstados.setText("Salvar");
        jbttSalvarEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttSalvarEstadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxtNomeEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbPaísEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbttSalvarEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(280, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtxtNomeEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jcbPaísEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jbttSalvarEstados)
                .addGap(18, 18, 18))
        );

        jTabbedPane1.addTab("Estados", jPanel3);

        jPanel4.setBackground(new java.awt.Color(51, 153, 255));
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Nome:");

        jtxtNomeCapital.setBackground(new java.awt.Color(255, 255, 255));
        jtxtNomeCapital.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jtxtNomeCapital.setForeground(new java.awt.Color(0, 0, 0));
        jtxtNomeCapital.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNomeCapitalActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Tipo:");

        jcbTipoCapital.setBackground(new java.awt.Color(204, 204, 255));
        jcbTipoCapital.setForeground(new java.awt.Color(0, 0, 0));
        jcbTipoCapital.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Federal", "Estadual", " " }));

        jbttSalvarCapitais.setBackground(new java.awt.Color(0, 0, 0));
        jbttSalvarCapitais.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jbttSalvarCapitais.setForeground(new java.awt.Color(255, 255, 255));
        jbttSalvarCapitais.setText("Salvar");
        jbttSalvarCapitais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttSalvarCapitaisActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("País:");

        jcbPaísCapital.setBackground(new java.awt.Color(204, 204, 255));
        jcbPaísCapital.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(312, 312, 312)
                        .addComponent(jbttSalvarCapitais, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbPaísCapital, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtNomeCapital, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbTipoCapital, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(277, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jtxtNomeCapital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jcbPaísCapital, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jcbTipoCapital, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(47, 47, 47)
                .addComponent(jbttSalvarCapitais)
                .addGap(19, 19, 19))
        );

        jTabbedPane1.addTab("Capitais", jPanel4);

        jPanel5.setBackground(new java.awt.Color(0, 0, 204));

        jLabel1.setFont(new java.awt.Font("Sitka Heading", 1, 36)); // NOI18N
        jLabel1.setText("Painel do Administrador");

        jbttSair.setBackground(new java.awt.Color(255, 255, 255));
        jbttSair.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jbttSair.setForeground(new java.awt.Color(0, 0, 0));
        jbttSair.setText("Sair");
        jbttSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbttSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(238, 238, 238)
                .addComponent(jbttSair)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jbttSair))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void carregarContinentes() {
    ContinenteDAO dao = new ContinenteDAO();
    jcbContinentePaís.removeAllItems();

    for (Continente c : dao.buscarTodos()) {
        jcbContinentePaís.addItem(c);
    }
}

private void carregarPaises() {
    PaisDAO dao = new PaisDAO();

    jcbPaísEstado.removeAllItems();
    jcbPaísCapital.removeAllItems();

    for (Pais p : dao.buscarTodos()) {
        jcbPaísEstado.addItem(p);
        jcbPaísCapital.addItem(p);
    }
}


    private void jtxtNomeContinenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNomeContinenteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNomeContinenteActionPerformed

    private void jbttSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttSairActionPerformed
        new LoginForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jbttSairActionPerformed

    private void jtxtNomePaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNomePaisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNomePaisActionPerformed

    private void jtxtNomeEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNomeEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNomeEstadoActionPerformed

    private void jtxtNomeCapitalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNomeCapitalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNomeCapitalActionPerformed

    private void jbttSalvarCapitaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttSalvarCapitaisActionPerformed
        String nome = jtxtNomeCapital.getText();
Pais pais = (Pais) jcbPaísCapital.getSelectedItem();
TipoCapital tipo = TipoCapital.valueOf(
        jcbTipoCapital.getSelectedItem().toString()
);

Capital capital = new Capital(nome, pais, tipo);
CapitalDAO dao = new CapitalDAO();
dao.salvar(capital);

JOptionPane.showMessageDialog(this, "Capital salva com sucesso!");

    }//GEN-LAST:event_jbttSalvarCapitaisActionPerformed

    private void jbttSalvarEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttSalvarEstadosActionPerformed
        String nome = jtxtNomeEstado.getText().trim();

if (nome.isBlank()) {
    JOptionPane.showMessageDialog(this, "Informe o nome do estado");
    return;
}

Pais pais = (Pais) jcbPaísEstado.getSelectedItem();
Estado estado = new Estado(nome, pais);
new EstadoDAO().salvar(estado);
JOptionPane.showMessageDialog(this, "Estado salvo com sucesso!");
    }//GEN-LAST:event_jbttSalvarEstadosActionPerformed

    private void jbttSalvarPaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttSalvarPaisActionPerformed
        String nome = jtxtNomePais.getText().trim();

if (nome.isBlank()) {
    JOptionPane.showMessageDialog(this, "Informe o nome do país");
    return;
}

Continente continente =
    (Continente) jcbContinentePaís.getSelectedItem();

Pais pais = new Pais(nome, continente);
new PaisDAO().salvar(pais);
    
    JOptionPane.showMessageDialog(this, "País salvo com sucesso!");
    }//GEN-LAST:event_jbttSalvarPaisActionPerformed

    private void jbttSalvarContinenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbttSalvarContinenteActionPerformed
        String nome = jtxtNomeContinente.getText();

    if (nome.isBlank()) {
        JOptionPane.showMessageDialog(this, "Informe o nome do continente");
        return;
    }

    Continente continente = new Continente(nome);
    ContinenteDAO dao = new ContinenteDAO();
    dao.salvar(continente);

    JOptionPane.showMessageDialog(this, "Continente salvo com sucesso!");
    jtxtNomeContinente.setText("");
    }//GEN-LAST:event_jbttSalvarContinenteActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbttSair;
    private javax.swing.JButton jbttSalvarCapitais;
    private javax.swing.JButton jbttSalvarContinente;
    private javax.swing.JButton jbttSalvarEstados;
    private javax.swing.JButton jbttSalvarPais;
    private javax.swing.JComboBox<Continente> jcbContinentePaís;
    private javax.swing.JComboBox<Pais> jcbPaísCapital;
    private javax.swing.JComboBox<Pais> jcbPaísEstado;
    private javax.swing.JComboBox<String> jcbTipoCapital;
    private javax.swing.JTextField jtxtNomeCapital;
    private javax.swing.JTextField jtxtNomeContinente;
    private javax.swing.JTextField jtxtNomeEstado;
    private javax.swing.JTextField jtxtNomePais;
    // End of variables declaration//GEN-END:variables
}
