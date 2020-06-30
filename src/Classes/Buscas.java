/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import Classes.DbDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author peter / Carla
 */
public class Buscas {

    DbDao Dao = new DbDao();
    
    ResultSet ResultadoClientes;
    ResultSet ResultadoChamado;
    ResultSet ResultadoStatos;
    
    public ResultSet GetResultadoCliente(){
        return ResultadoClientes;
    }
    
    public ResultSet GetResultadoStatus(){
        return ResultadoStatos;
    }
    
    
//    Connection Conn = Dao.getConn();

    public void PesquisaCliente(String NomeCliente) {
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
            
            ResultadoClientes =  stmt.executeQuery();
            Dao.Desconectar();
            
        } catch (SQLException e) {
        }
    }
    
    public void PesquisaChamado(String OS){
        Dao.conectar();
        
        String Sql = "Select * from Chamados where ID = " + OS;
        
        Dao.Desconectar();
        
    }
    
    public void PesquisaStatus(){
        Dao.conectar();
        Connection Conn = Dao.getConn();
        String Sql = "SELECT situacao FROM STATUS";
        try {
            PreparedStatement stmt = Conn.prepareStatement(Sql); 
            ResultadoStatos = stmt.executeQuery();            
        } catch (SQLException ex) {
            Logger.getLogger(Buscas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Dao.Desconectar();
    }
}
