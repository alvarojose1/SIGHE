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
        consulta.setIdConsulta("1234");
    }
    
    
    @After
    public void tearDown() {
    }

    /**
     * Test of inserir method, of class ConsultaDAO.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        ConsultaDAO instance= null;
         instance = new ConsultaDAO();
        boolean expResult = true;
        boolean result = instance.inserir(consulta);
        assertEquals(expResult, result);
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
