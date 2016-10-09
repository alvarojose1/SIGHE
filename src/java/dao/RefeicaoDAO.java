package banco;

import dao.ModelDAO;
import java.sql.Array;
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
public class RefeicaoDAO implements ModelDAO {
     private Connection conn;

    public RefeicaoDAO() {
        this.conn = new Banco().getConn();
    }

    public boolean inserir(Refeicao refeicao) throws SQLException {
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
            conn.close();
            return true;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }

    @Override
    public boolean inserir(Object object) {
        Refeicao refeicao =  (Refeicao) object;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(String matricula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Array getTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
 

