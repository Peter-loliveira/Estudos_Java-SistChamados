/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Classes.DbDao;

//import Formularios.Login;
import javax.swing.JOptionPane;

/**
 *
 * @author peter
 */
public class TelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        menuSistema = new javax.swing.JMenu();
        imCadastros = new javax.swing.JMenu();
        imClientes = new javax.swing.JMenuItem();
        imCChamados = new javax.swing.JMenuItem();
        imSair = new javax.swing.JMenuItem();
        MenuAdm = new javax.swing.JMenu();
        imUsuarios = new javax.swing.JMenuItem();
        MenuAjuda = new javax.swing.JMenu();
        imSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Chamados - Usuário: Nivel:");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        menuSistema.setText("Sistema");

        imCadastros.setText("Cadastros");
        imCadastros.setEnabled(false);

        imClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, 0));
        imClientes.setText("Clientes");
        imClientes.setEnabled(false);
        imClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imClientesActionPerformed(evt);
            }
        });
        imCadastros.add(imClientes);

        imCChamados.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, 0));
        imCChamados.setText("Chamados");
        imCChamados.setEnabled(false);
        imCChamados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imCChamadosActionPerformed(evt);
            }
        });
        imCadastros.add(imCChamados);

        menuSistema.add(imCadastros);

        imSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        imSair.setText("Sair");
        imSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imSairActionPerformed(evt);
            }
        });
        menuSistema.add(imSair);

        jMenuBar1.add(menuSistema);

        MenuAdm.setText("Administrativo");
        MenuAdm.setEnabled(false);

        imUsuarios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, 0));
        imUsuarios.setText("Usuários do Sistema");
        imUsuarios.setEnabled(false);
        imUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imUsuariosActionPerformed(evt);
            }
        });
        MenuAdm.add(imUsuarios);

        jMenuBar1.add(MenuAdm);

        MenuAjuda.setText("Ajuda");

        imSobre.setText("Sobre o Sistema");
        MenuAjuda.add(imSobre);

        jMenuBar1.add(MenuAjuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1349, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 646, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void imUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imUsuariosActionPerformed
        NovoUsuario CadastroUsuarios = new NovoUsuario();
        CadastroUsuarios.setVisible(true);
    }//GEN-LAST:event_imUsuariosActionPerformed

    DbDao Dao = new DbDao();
//    Logar Login = new Logar(new javax.swing.JFrame(), true);
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String DadosLogados[] = new String[2];
        DadosLogados = Dao.DadosUsuarioLogado();
        String TituloTela = null;
                
        switch (DadosLogados[1]) {
            case "1":
                MenuAdm.setEnabled(true);
                imUsuarios.setEnabled(true);
                menuSistema.setEnabled(true);
                imCadastros.setEnabled(true);
                imClientes.setEnabled(true);
                imCChamados.setEnabled(true);
                TituloTela = "Sistema de Chamados - Usuário: " + DadosLogados[0] + ". Nivel: ADMINISTRADOR ";
                break;
            case "2":
                MenuAdm.setEnabled(false);
                imUsuarios.setEnabled(false);
                menuSistema.setEnabled(true);
                imCadastros.setEnabled(true);
                imClientes.setEnabled(true);
                imCChamados.setEnabled(true);
                TituloTela = "Sistema de Chamados - Usuário: " + DadosLogados[0] + ". Nivel: GERENTE ";
                break;
            case "3":
                MenuAdm.setEnabled(false);
                imUsuarios.setEnabled(false);
                menuSistema.setEnabled(true);
                imCadastros.setEnabled(true);
                imClientes.setEnabled(false);
                imCChamados.setEnabled(true);
                TituloTela = "Sistema de Chamados - Usuário: " + DadosLogados[0] + ". Nivel: TÉCNICO ";
                break;
            default:
                break;
        }
        this.setTitle(TituloTela);
    }//GEN-LAST:event_formWindowOpened

    private void imClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imClientesActionPerformed
        // TODO add your handling code here:
        NovoUsuario CadastroUsuarios = new NovoUsuario();
        CadastroUsuarios.setVisible(true);

    }//GEN-LAST:event_imClientesActionPerformed

    private void imSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_imSairActionPerformed

    private void imCChamadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imCChamadosActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_imCChamadosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenuAdm;
    private javax.swing.JMenu MenuAjuda;
    private javax.swing.JMenuItem imCChamados;
    private javax.swing.JMenu imCadastros;
    private javax.swing.JMenuItem imClientes;
    private javax.swing.JMenuItem imSair;
    private javax.swing.JMenuItem imSobre;
    private javax.swing.JMenuItem imUsuarios;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuSistema;
    // End of variables declaration//GEN-END:variables
}
