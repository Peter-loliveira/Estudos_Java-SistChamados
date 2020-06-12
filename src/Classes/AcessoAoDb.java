/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author peter
 */
public class AcessoAoDb {
    Connection conn;

    //    Metodo para CONECTAR ao banco
    public void conectar() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbchamados", "root", "");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não Conectado");
        }
    }

//    Metodo para DESCONECTAR ao banco
    public void Desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
