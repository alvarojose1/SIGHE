/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.sql;

import domain.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Wisley
 */
public class UsuarioDAO {

    private Connection conn;

    public UsuarioDAO() {
        this.conn = new Conexao().getConn();
    }

    private void inserirAux(Usuario usuario) throws SQLException{
        String sql = "INSERT INTO usuario (tipo, senha, nome, matricula, " + 
                                            "dataNasc, email, telefone, cpf, " + 
                                            "sexo, curso, funcao) "
                                    + "VALUES (?, ?, ?, ?, " + 
                                                "?, ?, ?, ?, " + 
                                                "?, ?, ?);";
        java.sql.PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, usuario.getTipo());
        stmt.setString(2, usuario.getSenha());
        stmt.setString(3, usuario.getNome());
        stmt.setString(4, usuario.getMatricula());
        stmt.setString(5, usuario.getDataNasc());
        stmt.setString(6, usuario.getEmail());
        stmt.setString(7, usuario.getTelefone());
        stmt.setString(8, usuario.getCpf());
        stmt.setString(9, usuario.getSexo());
        stmt.setString(10, usuario.getCurso());
        stmt.setString(11, usuario.getFuncao());
        stmt.execute();                            
        ResultSet rs = stmt.getGeneratedKeys();
        rs.next();
        rs.close();
        stmt.close();
        conn.close();
    }
   
    public boolean inserir(Usuario usuario) {
        try {
            java.sql.PreparedStatement stmt1 = conn.prepareStatement("SELECT 1 FROM usuario WHERE matricula=" 
                    + usuario.getMatricula() + ";");
            ResultSet rs1 = stmt1.executeQuery();
            if (rs1.next()) {
                return false;
            } else {
                inserirAux(usuario);
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Exceção de banco de dados:", e);
        }catch(Exception e){
            throw new RuntimeException("Exceção inesperada:", e);
        }
    }

    public boolean excluir(String matricula) {
        try {
            java.sql.PreparedStatement stmt = conn.prepareStatement("DELETE FROM usuario WHERE Matricula = " + matricula + ";");
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return true;
    }

    public boolean editar(Usuario usuario) {
        try {
        String sql = "UPDATE usuario SET nome = ?, curso = ?, funcao = ?, telefone = ?, email = ?" 
                      +" WHERE idUsuario = ?;";
        java.sql.PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        
        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getCurso());
        stmt.setString(3, usuario.getFuncao());
        stmt.setString(4, usuario.getTelefone());
        stmt.setString(5, usuario.getEmail());
        stmt.setString(6, usuario.getIdUsuario());
        stmt.execute();                            
        stmt.close();
        
    } catch (SQLException ed){
        throw new RuntimeException (ed);
    }
        return true;
    }


    public Usuario pegarUsuario(String id) {    
        try {
            Usuario usuario = null;
            java.sql.PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuario WHERE idUsuario=" + id + ";");
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()){
               usuario = new Usuario();
               usuario.setMatricula(rs.getString("matricula"));
               usuario.setIdUsuario(rs.getString("idUsuario"));
               usuario.setNome(rs.getString("nome"));
               usuario.setSenha(rs.getString("senha"));
               usuario.setTipo(rs.getString("tipo"));
               usuario.setDataNasc(rs.getString("dataNasc"));
               usuario.setCpf(rs.getString("cpf"));
               usuario.setCurso(rs.getString("curso"));
               usuario.setFuncao(rs.getString("funcao"));
               usuario.setSexo(rs.getString("sexo"));
               usuario.setTelefone(rs.getString("telefone"));
               usuario.setEmail(rs.getString("email"));
            }
            
            return usuario;
        } catch (SQLException ei) {
           throw new RuntimeException (ei);
        }
    }

    public Usuario pegarUsuarioPelaMatricula(String matricula){
        try {
            Usuario usuario = null;
            java.sql.PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuario WHERE Matricula=" + matricula + ";");
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()){
               usuario = new Usuario();
               usuario.setMatricula(rs.getString("matricula"));
               usuario.setIdUsuario(rs.getString("idUsuario"));
               usuario.setNome(rs.getString("nome"));
               usuario.setSenha(rs.getString("senha"));
               usuario.setTipo(rs.getString("tipo"));
               usuario.setDataNasc(rs.getString("dataNasc"));
               usuario.setCpf(rs.getString("cpf"));
               usuario.setCurso(rs.getString("curso"));
               usuario.setFuncao(rs.getString("funcao"));
               usuario.setSexo(rs.getString("sexo"));
               usuario.setTelefone(rs.getString("telefone"));
               usuario.setEmail(rs.getString("email"));
               
               //arrayUsuario.add(usuario);
            }
            
            return usuario;
        } catch (SQLException ex) {
           throw new RuntimeException (ex);
        }
    }
    
    public ResultSet selecionarAlunos() throws SQLException {
        java.sql.PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuario WHERE tipo = 'Aluno';");
        ResultSet rs = stmt.executeQuery();
        return rs;
    }

    public ArrayList<Usuario> filtrarAlunos(String filtro){
   /*     java.sql.PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuario WHERE tipo = 'Aluno'"
                + " AND nome LIKE '%" + filtro + "%' OR matricula LIKE '%" + filtro + "%' OR curso LIKE '%" + filtro + "%';");
        ResultSet rs = stmt.executeQuery();
        return rs;
    }*/
     try {
            //Usuario usuario = null;
            java.sql.PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuario WHERE tipo = 'Aluno'"
                + " AND nome LIKE '%" + filtro + "%' OR matricula LIKE '%" + filtro + "%' OR curso LIKE '%" + filtro + "%';");
            ResultSet rs = stmt.executeQuery();
            ArrayList<Usuario> a = new ArrayList<>();
            if (rs.next()){
               Usuario usuario = new Usuario();
               usuario.setTipo(rs.getString("tipo"));
               usuario.setNome(rs.getString("nome"));
               usuario.setMatricula(rs.getString("matricula"));
               usuario.setCurso(rs.getString("curso"));
              // usuario.setIdUsuario(rs.getString("idUsuario"));
             // usuario.setFuncao(rs.getString("funcao"));
              a.add(usuario);

              }          
            return a;
     
        } catch (SQLException ei) {
           throw new RuntimeException (ei);
        }
    }
    
    public ResultSet selecionarProfessores() throws SQLException {
        java.sql.PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuario WHERE tipo = 'Professor';");
        ResultSet rs = stmt.executeQuery();
        return rs;
    }

    public ArrayList<Usuario> filtrarProfessores(String filtro){
   /*     java.sql.PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuario WHERE tipo = 'Aluno'"
                + " AND nome LIKE '%" + filtro + "%' OR matricula LIKE '%" + filtro + "%' OR curso LIKE '%" + filtro + "%';");
        ResultSet rs = stmt.executeQuery();
        return rs;
    }*/
     try {
            //Usuario usuario = null;
            java.sql.PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuario WHERE tipo = 'Professor'"
                + " AND nome LIKE '%" + filtro + "%' OR matricula LIKE '%" + filtro + "%' OR curso LIKE '%" + filtro + "%';");
            ResultSet rs = stmt.executeQuery();
            ArrayList<Usuario> a = new ArrayList<>();
            if (rs.next()){
               Usuario usuario = new Usuario();
               usuario.setTipo(rs.getString("tipo"));
               usuario.setNome(rs.getString("nome"));
               usuario.setMatricula(rs.getString("matricula"));
               usuario.setCurso(rs.getString("curso"));
              // usuario.setIdUsuario(rs.getString("idUsuario"));
             // usuario.setFuncao(rs.getString("funcao"));
              a.add(usuario);

              }          
            return a;
     
        } catch (SQLException ei) {
           throw new RuntimeException (ei);
        }
    }

    public ResultSet selecionarFuncionarios() throws SQLException {
        java.sql.PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuario WHERE tipo = 'Funcionário';");
        ResultSet rs = stmt.executeQuery();
        return rs;
    }

    public ArrayList<Usuario> filtrarFuncionarios(String filtro){
   /*     java.sql.PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuario WHERE tipo = 'Aluno'"
                + " AND nome LIKE '%" + filtro + "%' OR matricula LIKE '%" + filtro + "%' OR curso LIKE '%" + filtro + "%';");
        ResultSet rs = stmt.executeQuery();
        return rs;
    }*/
     try {
            //Usuario usuario = null;
            java.sql.PreparedStatement stmt = conn.prepareStatement("SELECT * FROM usuario WHERE tipo = 'Funcionario'"
                + " AND nome LIKE '%" + filtro + "%' OR matricula LIKE '%" + filtro + "%' OR funcao LIKE '%" + filtro + "%';");
            ResultSet rs = stmt.executeQuery();
            ArrayList<Usuario> a = new ArrayList<>();
            if (rs.next()){
               Usuario usuario = new Usuario();
               usuario.setTipo(rs.getString("tipo"));
               usuario.setNome(rs.getString("nome"));
               usuario.setMatricula(rs.getString("matricula"));
               //usuario.setCurso(rs.getString("curso"));
              // usuario.setIdUsuario(rs.getString("idUsuario"));
               usuario.setFuncao(rs.getString("funcao"));
              a.add(usuario);

              }          
            return a;
     
        } catch (SQLException ei) {
           throw new RuntimeException (ei);
        }
    }}
