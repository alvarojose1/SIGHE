/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.sql;

import domain.Usuario;
import domain.reserva.Consulta;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Eriberto
 */
public class ConsultaDAOTest {
    private Usuario usuario;
    private Consulta consulta;
    public ConsultaDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
     System.out.println("setUp ConsultaTestDAO");
        
        usuario = new Usuario();
        usuario.setMatricula("1234");
        consulta = new Consulta();
        consulta.setIdConsulta("6");
        consulta.setMatricula("123564");
        consulta.setMedico("medico");
        consulta.setHora("12:56");
        consulta.setData("1-2-2034");
    
    }
    
    
    @After
    public void tearDown() {
    }

    /**
     * Test of inserir method, of class ConsultaDAO.
     */
    @Test
    public void testInserirEPegarConsulta(){
        System.out.println("inserir");
        ConsultaDAO dao= null;
         dao = new ConsultaDAO();
        boolean expResult = true;
        int result = dao.inserir(consulta);
        assertEquals(expResult, result > 0);
        
        Consulta c = dao.pegarConsulta(result);
         assertEquals(consulta.getMatricula(), c.getMatricula());
         assertEquals(consulta.getMedico(), c.getMedico());
         assertEquals(consulta.getHora(), c.getHora());
         assertEquals(consulta.getData(), c.getData());
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
/**
 *  String idlogado = (String) session.getAttribute("idusuario");
            UsuarioDAO usuDAO = new UsuarioDAO();
            ResultSet usuLogado = null;
            if (idlogado == null) {
                response.sendRedirect("index.jsp");
            } else {
                usuLogado = usuDAO.pegarUsuario(idlogado);

                if (usuLogado.next()) {

String rv = request.getParameter("reservar");
                if (rv == null) {
                } else {
                Consulta consulta = new Consulta();

                consulta.setMatricula(usuLogado.getString("matricula"));
                consulta.setMedico(request.getParameter("medico"));
                consulta.setHora(request.getParameter("hora"));
                consulta.setData(request.getParameter("data"));

                ConsultaDAO consultaDAO = new ConsultaDAO();

                consultaDAO.Inserir(consulta);
                */
