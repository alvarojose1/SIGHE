/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.sql;

import domain.reserva.Laboratorio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Wisley
 */
public class LaboratorioDAO {
    
    private Connection conn;

    public LaboratorioDAO () {
        this.conn = new Conexao().getConn();
    }

    public int inserir(Laboratorio laboratorio) throws SQLException {
        String sql = "INSERT INTO laboratorio (matriculaAluno, matriculaProfessor, laboratorio, aprovacao, horario, data, turno) VALUES (?, ?, ?, ?, ?, ?, ?);";
        int idLaboratorio = 0;
        try {
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, laboratorio.getMatriculaAluno());
            stmt.setString(2, laboratorio.getMatriculaProfessor());
            stmt.setString(3, laboratorio.getLaboratorio());
            stmt.setString(4, laboratorio.getAprovacao());
            stmt.setString(5, laboratorio.getHorario());
            stmt.setString(6, laboratorio.getData());
            stmt.setString(7, laboratorio.getTurno());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            idLaboratorio = rs.getInt(1);

            rs.close();
            stmt.close();
            //conn.close();
            return idLaboratorio;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
    public Laboratorio pegarLaboratorio(int id){
        try {
            Laboratorio laboratorio = null;
            java.sql.PreparedStatement stmt = conn.prepareStatement("SELECT * FROM laboratorio WHERE idLaboratorio=" + id + ";");
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()){
               laboratorio = new Laboratorio();
               laboratorio.setMatriculaAluno(rs.getString("matriculaAluno"));
               laboratorio.setMatriculaProfessor(rs.getString("matriculaProfessor"));
               laboratorio.setLaboratorio(rs.getString("laboratorio"));
               laboratorio.setAprovacao(rs.getString("aprovacao"));
               laboratorio.setHorario(rs.getString("horario")); 
               laboratorio.setData(rs.getString("data"));
               laboratorio.setTurno(rs.getString("turno"));
               
            }
            conn.close();
            return laboratorio;
        } catch (SQLException ei) {
           throw new RuntimeException (ei);
        }
    
    }
}

    

