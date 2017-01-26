package dao.sql;

import domain.reserva.Refeicao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Wisley
 */
public class RefeicaoDAO {
     private Connection conn;

    public RefeicaoDAO() {
        this.conn = new Conexao().getConn();
    }

    public int inserir(Refeicao refeicao) throws SQLException {
        String sql = "INSERT INTO refeicao (matricula, tipo, justificativa, data) VALUES (?, ?, ?, ?);";
        int idRefeicao = 0;
        try {
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, refeicao.getMatricula());
            stmt.setString(2, refeicao.getTipo());
            stmt.setString(3, refeicao.getJustificativa());
            stmt.setString(4, refeicao.getData());
            
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            
            idRefeicao = rs.getInt(1);

            rs.close();
            stmt.close();
           // conn.close();
            return idRefeicao;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    public Refeicao pegarRefeicao(int id){
        try {
            Refeicao refeicao = null;
            java.sql.PreparedStatement stmt = conn.prepareStatement("SELECT * FROM refeicao WHERE idRefeicao=" + id + ";");
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()){
               refeicao = new Refeicao();
               refeicao.setMatricula(rs.getString("matricula"));
               refeicao.setTipo(rs.getString("tipo"));
               refeicao.setJustificativa(rs.getString("justificativa"));
               refeicao.setData(rs.getString("data"));               
               
            }
            conn.close();
            return refeicao;
        } catch (SQLException ei) {
           throw new RuntimeException (ei);
        }
    
    }
    
}
 

