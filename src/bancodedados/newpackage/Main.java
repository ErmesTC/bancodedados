
package bancodedados.newpackage;


public class Main extends javax.swing.JFrame {

    private listaFilial listaf;
    private listaCliente listac;
    private listaFuncionario listafunc;
    
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtoncliente = new javax.swing.JButton();
        jButtonfilial = new javax.swing.JButton();
        jButtonfuncioonario = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Cadastro");

        jButtoncliente.setText("cliente");
        jButtoncliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonclienteActionPerformed(evt);
            }
        });

        jButtonfilial.setText("filial");
        jButtonfilial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonfilialActionPerformed(evt);
            }
        });

        jButtonfuncioonario.setText("funcionario");
        jButtonfuncioonario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonfuncioonarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtoncliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonfilial)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85)
                .addComponent(jButtonfuncioonario)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtoncliente)
                    .addComponent(jButtonfilial)
                    .addComponent(jButtonfuncioonario))
                .addGap(0, 235, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonclienteActionPerformed
        listac = new listaCliente();
        listac.setVisible(true);
    }//GEN-LAST:event_jButtonclienteActionPerformed

    private void jButtonfilialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonfilialActionPerformed
        listaf = new listaFilial();
        listaf.setVisible(true);
    }//GEN-LAST:event_jButtonfilialActionPerformed

    private void jButtonfuncioonarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonfuncioonarioActionPerformed
        listafunc = new listaFuncionario();
        listafunc.setVisible(true);
    }//GEN-LAST:event_jButtonfuncioonarioActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtoncliente;
    private javax.swing.JButton jButtonfilial;
    private javax.swing.JButton jButtonfuncioonario;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
