/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.sql;

import domain.reserva.Consulta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Wisley
 */
public class ConsultaDAO {
       private Connection conn;

    public ConsultaDAO () {
        this.conn = new Conexao().getConn();
    }

    public int inserir(Consulta consulta)  {
        String sql = "INSERT INTO consulta (matricula, medico, hora, data) VALUES (?, ?, ?, ?);";
        int idCons = 0;
        try {
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, consulta.getMatricula());
            stmt.setString(2, consulta.getMedico());
            stmt.setString(3, consulta.getHora());
            stmt.setString(4, consulta.getData());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            idCons = rs.getInt(1);

            rs.close();
            stmt.close();
           // conn.close();
            return idCons;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
     public Consulta pegarConsulta(int id){
        try {
            Consulta consulta = null;
            java.sql.PreparedStatement stmt = conn.prepareStatement("SELECT * FROM consulta WHERE idConsulta=" + id + ";");
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()){
               consulta = new Consulta();
               consulta.setMatricula(rs.getString("matricula"));
               consulta.setMedico(rs.getString("medico"));
               consulta.setHora(rs.getString("hora")); 
               consulta.setData(rs.getString("data"));
                
            }
            conn.close();
            return consulta;
        } catch (SQLException ei) {
           throw new RuntimeException (ei);
        }
    
    }
}

    
