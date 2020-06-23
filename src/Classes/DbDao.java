package Classes;

import Formularios.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DbDao {

    Connection conn;

    public Connection getConn() {
        return conn;
    }

// <editor-fold defaultstate="collapsed" desc="Métodos para conectar e desconectar ao banco">
    public void conectar() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbchamados", "root", "");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Serviço temporariamente indisponivel!");
        }
    }

    public void Desconectar() {
        try {
            conn.close();
        } catch (SQLException ex) {
//            Logger.getLogger(DbDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("TESTE");
        }
    }
// </editor-fold> 

// <editor-fold defaultstate="collapsed" desc="Métodos CREATE">
//############################# CREATES ###################################
    public void CreateStatus(String Status, String Desc) throws SQLException {
//        Conecta ao Banco
        conectar();

//Tenta gravar no Banco
        try {
            String sql;
            sql = "insert into status "
                    + "(Situacao, Descricao) "
                    + "values (?,?)";
            PreparedStatement st;
            st = conn.prepareStatement(sql);
            st.setString(1, Status);
            st.setString(2, Desc);
            st.execute();
        } catch (Exception e) {
            System.out.println("CLASSE " + e);
        }

//        Desconecta do Banco        
        Desconectar();
    }

    public void CreateUsers(String Nome, int Nivel, String Senha) throws SQLException {
//Conecta ao Banco
        conectar();

//Tenta gravar no Banco
        try {
            String sql;
            sql = "insert into users "
                    + "(Nome, Nivel, Senha) "
                    + "values (?,?,?)";
            PreparedStatement st;
            st = conn.prepareStatement(sql);
            st.setString(1, Nome);
            st.setInt(2, Nivel);
            st.setString(3, Senha);
            st.execute();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com Sucesso!");
        } catch (Exception e) {
            System.out.println(e);
        }

//Desconecta do Banco        
        Desconectar();
    }

    public void CreateAtendimentos(int CodChamado, String Descricao, String DataAtendimento) throws SQLException {
//Conecta ao Banco
        conectar();

//Tenta gravar no Banco
        try {
            String sql;
            sql = "insert into atendimentos "
                    + "(CodChamado, Descricao,DataAtendimento ) "
                    + "values (?,?,?)";
            PreparedStatement st;
            st = conn.prepareStatement(sql);
            st.setInt(1, CodChamado);
            st.setString(2, Descricao);
            st.setString(3, DataAtendimento);
            st.execute();
        } catch (Exception e) {
            System.out.println("CLASSE " + e);
        }

//Desconecta do Banco        
        Desconectar();
    }

    public void CreateChamados(int CodCliente, int CodEquip, int Status, String DataAbertura, String DataFechamento, String Defeito) throws SQLException {
//Conecta ao Banco
        conectar();

//Tenta gravar no Banco
        try {
            String sql;
            sql = "insert into chamados "
                    + "(CodCliente, CodEquip, Status, DataAbertura, DataFechamento, Defeito) values "
                    + "(?,?,?,?,?,?)";
            PreparedStatement st;
            st = conn.prepareStatement(sql);
            st.setInt(1, CodCliente);
            st.setInt(2, CodEquip);
            st.setInt(3, Status);
            st.setString(4, DataAbertura);
            st.setString(5, DataFechamento);
            st.setString(6, Defeito);
            st.execute();
        } catch (Exception e) {
            System.out.println("CLASSE " + e);
        }

//Desconecta do Banco        
        Desconectar();
    }

    public void CreateClientes(String Nome, String DataNasc, String Cel, String Endereco, String Genero) throws SQLException {
//Conecta ao Banco
        conectar();

//Tenta gravar no Banco
        try {
            String sql;
            sql = "insert into clientes "
                    + "(Nome, DataNasc, Cel, Endereco, Genero) values "
                    + "(?,?,?,?,?)";
            PreparedStatement st;
            st = conn.prepareStatement(sql);
            st.setString(1, Nome);
            st.setString(2, DataNasc);
            st.setString(3, Cel);
            st.setString(4, Endereco);
            st.setString(5, Genero);
            st.execute();
        } catch (Exception e) {
            System.out.println("CLASSE " + e);
        }

//Desconecta do Banco        
        Desconectar();
    }

    public void CreateEquipamentos(int ClienteID, String TipoEquip, String Serial, String Marca) throws SQLException {
//Conecta ao Banco
        conectar();

//Tenta gravar no Banco
        try {
            String sql;
            sql = "insert into equipamentos "
                    + "(ClienteID, TipoEquip, Serial, Marca) values "
                    + "(?,?,?,?)";
            PreparedStatement st;
            st = conn.prepareStatement(sql);
            st.setInt(1, ClienteID);
            st.setString(2, TipoEquip);
            st.setString(3, Serial);
            st.setString(4, Marca);
            st.execute();
        } catch (Exception e) {
            System.out.println("CLASSE " + e);
        }

//Desconecta do Banco        
        Desconectar();
    }

    public void CreateNiveisAcesso(String Nivel) throws SQLException {
//Conecta ao Banco
        conectar();

//Tenta gravar no Banco
        try {
            String sql;
            sql = "insert into niveisacesso "
                    + "(Nivel) values "
                    + "(?)";
            PreparedStatement st;
            st = conn.prepareStatement(sql);
            st.setString(1, Nivel);
            st.execute();
        } catch (Exception e) {
            System.out.println("CLASSE " + e);
        }

//Desconecta do Banco        
        Desconectar();

    }

    public void CreateTiposEquip(String Tipos) throws SQLException {
//Conecta ao Banco
        conectar();

//Tenta gravar no Banco
        try {
            String sql;
            sql = "insert into tiposequip "
                    + "(CAMPOS, CAMPOS) values "
                    + "(?)";
            PreparedStatement st;
            st = conn.prepareStatement(sql);
            st.setString(1, Tipos);
            st.execute();
        } catch (Exception e) {
            System.out.println("CLASSE " + e);
        }

//Desconecta do Banco        
        Desconectar();
    }

// </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="Métodos UPDATE">
    public void GravaUsuarioLogado(String Nivel, String Nome) {
        conectar();
        String sql;
        
        sql = "UPDATE usuariologado SET Nivel =" + Nivel + ", Nome = \"" + Nome + "\"";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            // Precisei mudar para Int em vez de ResultSet para fancionar.
            // Nao sei o porque.......
            stmt.execute(sql);

            Desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void UpdateCliente(String Nome, String DataNasc, String Cel, String Endereco, String Genero, String ID ) {
        conectar();
        String sql;
        
        sql = "UPDATE clientes "
                + "SET "
                + "Nome = \"" + Nome + "\"" 
                + ", DataNasc = \"" + DataNasc + "\"" 
                + ", Cel = \"" + Cel + "\"" 
                + ", Endereco = \"" + Endereco + "\"" 
                + ", Genero = \"" + Genero +"\""
                + " WHERE ID = " + ID;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.execute();
            Desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
// </editor-fold> 

// <editor-fold defaultstate="collapsed" desc="Métodos EXTRAS no Banco">
//############################# UPDATES ###################################
    public int checaTabelaVazia() {
        try {
            conectar();
            String sql = "SELECT COUNT(ID) FROM users;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            int rows = Integer.parseInt(rs.getString(1));
            Desconectar();
            return rows;
        } catch (SQLException e) {
        }
        return -1;
    }

    public String[] DadosUsuarioLogado() {
        try {
            conectar();
            String sql = "SELECT Nivel, Nome FROM usuariologado;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            String Dados[] = new String[2];
            Dados[0] = rs.getString("Nome");
            Dados[1] = rs.getString("Nivel");
            Desconectar();
            return Dados;
        } catch (SQLException e) {
            return null;
        }
    }

// </editor-fold>     

}
