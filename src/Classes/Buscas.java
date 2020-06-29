/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.DbDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author peter
 */
public class Buscas {

    DbDao Dao = new DbDao();
    
//    Connection Conn = Dao.getConn();

    public ResultSet PesquisaCliente(String NomeCliente) {
        try {
            Dao.conectar();
            Connection Conn = Dao.getConn();
            
            //Prepara SQL básico
            String sql = "select * from Clientes";
            PreparedStatement stmt = Conn.prepareStatement(sql);

            // Caso o NomeCliente inserido seja diferente de vazio
            if (!NomeCliente.equals("")) {
                sql = sql + " where Nome LIKE ? ";
                stmt = Conn.prepareStatement(sql);
                stmt.setString(1, NomeCliente + "%");
            }
            
            ResultSet ListaClientes = stmt.executeQuery();
//            stmt.close();
//            ResultSet Lista2 = ListaClientes;
            Dao.Desconectar();
            JOptionPane.showMessageDialog(null, ListaClientes);
            return ListaClientes;
//            return Lista2;
            
        } catch (SQLException e) {
        }
        return null;
    }
}
