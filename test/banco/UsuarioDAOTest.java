/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Marina
 */
public class UsuarioDAOTest {
    
    private Usuario usuario;
    
    public UsuarioDAOTest() {
    
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("setUp UsuarioTestDAO");
        
        usuario = new Usuario();
        usuario.setMatricula("1234");
        usuario.setIdUsuario("5");
        
        
        try {
            Connection conn = new Banco().getConn();
            String sql = "DELETE FROM usuario WHERE matricula = 1234";
            java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();
            
            // inserir registro pra usar no testExcluir
            
        } catch (SQLException ex) {
            System.out.println("erro na exclusao");
            Logger.getLogger(UsuarioDAOTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of inserir method, of class UsuarioDAO.
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");
        
        UsuarioDAO instance = null;
        
        // Matricula nao existe
        instance = new UsuarioDAO();
        boolean expResult = true;
        boolean result = instance.inserir(usuario);
        assertEquals(expResult, result);
        
        //Matricula ja existe
        instance = new UsuarioDAO();
        expResult = false;
        result = instance.inserir(usuario);
        assertEquals(expResult, result);
    }

    /**
     * Test of Excluir method, of class UsuarioDAO.
     */
    @Test
    public void testExcluir() throws Exception {
        System.out.println("Excluir");
        String matricula = "1234";
        UsuarioDAO instance = new UsuarioDAO();
        instance.excluir(matricula);
        // TODO review the generated test code and remove the default call to fail.
        //anbusb
        
    }

    /**
     * Test of Editar method, of class UsuarioDAO.
     */
    @Test
    public void testEditar() throws Exception {
        System.out.println("Editar");
        String id = "";
        String nome = "";
        String curso = "";
        String funcao = "";
        String tel = "";
        String email = "";
        UsuarioDAO instance = new UsuarioDAO();

        Usuario u = new Usuario();
        u.setNome(nome);
        u.setCurso(curso);
        u.setFuncao(funcao);
        u.setTelefone(tel);
        u.setEmail(email);
        u.setIdUsuario(id);
        instance.editar(u);

        // TODO review the generated test code and remove the default call to fail.
      
    }

    /**
     * Test of pegarUsuario method, of class UsuarioDAO.
     */
    @Test
    public void testPegarUsuario() throws Exception {
        /*System.out.println("pegarUsuario"); 
        UsuarioDAO instance = new UsuarioDAO();
        instance.inserir(usuario);
        instance = new UsuarioDAO();
        Usuario result = instance.pegarUsuario(usuario.getIdUsuario());
        assertEquals(usuario, result);*/
        UsuarioDAO instance = new UsuarioDAO();
        instance.inserir(usuario);
        
        instance = new UsuarioDAO();
        Usuario result = instance.pegarUsuario(usuario.getIdUsuario());
        //assertEquals(usuario, result);
         assertNotNull(result);
        
        assertTrue(result.equals(usuario)); // TODO passando, mas nao deveria
     // assertTrue(result.getMatricula().equals(usuario.getMatricula()));
        assertTrue(result.getIdUsuario().equals(usuario.getIdUsuario()));        
    }
 
    @Test
    public void testPegarUsuarioPelaMatricula() throws Exception {
        UsuarioDAO instance = new UsuarioDAO();
        instance.inserir(usuario);
        
        instance = new UsuarioDAO();
        Usuario result = instance.pegarUsuarioPelaMatricula(usuario.getMatricula());
        assertNotNull(result);
        
        assertTrue(result.equals(usuario)); // TODO passando, mas nao deveria
        assertTrue(result.getMatricula().equals(usuario.getMatricula()));
        //assertTrue(result.getIdUsuario().equals(usuario.getIdUsuario()));        
    }
    
    /**
     * Test of selecionarAlunos method, of class UsuarioDAO.
     */
    @Test
    public void testSelecionarAlunos() throws Exception {
        System.out.println("selecionarAlunos");
        UsuarioDAO instance = new UsuarioDAO();
        ResultSet expResult = null;
        ResultSet result = instance.selecionarAlunos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of filtrarAlunos method, of class UsuarioDAO.
     */
    @Test
    public void testFiltrarAlunos() throws Exception {
        System.out.println("filtrarAlunos"); // tirar o resultset
        String filtro = "aluno";
        UsuarioDAO instance = new UsuarioDAO();
        ArrayList expResult = null;
        ArrayList result = (ArrayList) instance.filtrarAlunos(filtro);
        assertNotNull(result);
        /*
        p u bli c v oid t e s t L i s t a r L i s t ( ) {
    Li s t <Aluno> l i s t a = new A r r a yLi s t<Aluno >( );
    l i s t a = alunoDAO . l i s t a r ( ) ;
    f o r ( Aluno v a r i o s : l i s t a ) {
    System . out . p r i n t l n ( v a r i o s . g e t I d ( ) ) ;
    }
    a s s e r t T r u e ( l i s t a . s i z e ( ) >0 );
}

        */

       
    }

    /**
     * Test of selecionarProfessores method, of class UsuarioDAO.
     */
    @Test
    public void testSelecionarProfessores() throws Exception {
        System.out.println("selecionarProfessores");
        UsuarioDAO instance = new UsuarioDAO();
        ResultSet expResult = null;
        ResultSet result = instance.selecionarProfessores();
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of filtrarProfessores method, of class UsuarioDAO.
     */
    @Test
    public void testFiltrarProfessores() throws Exception {
        System.out.println("filtrarProfessores");
        String filtro = "";
        UsuarioDAO instance = new UsuarioDAO();
        ResultSet expResult = null;
        ResultSet result = instance.filtrarProfessores(filtro);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of selecionarFuncionarios method, of class UsuarioDAO.
     */
    @Test
    public void testSelecionarFuncionarios() throws Exception {
        System.out.println("selecionarFuncionarios");
        UsuarioDAO instance = new UsuarioDAO();
        ResultSet expResult = null;
        ResultSet result = instance.selecionarFuncionarios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of filtrarFuncionarios method, of class UsuarioDAO.
     */
    @Test
    public void testFiltrarFuncionarios() throws Exception {
        System.out.println("filtrarFuncionarios");
        String filtro = "";
        UsuarioDAO instance = new UsuarioDAO();
        ResultSet expResult = null;
        ResultSet result = instance.filtrarFuncionarios(filtro);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
