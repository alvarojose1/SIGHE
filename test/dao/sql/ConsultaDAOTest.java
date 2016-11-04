/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.sql;

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
        Consulta consulta = null;
        ConsultaDAO instance = new ConsultaDAO();
        boolean expResult = false;
        boolean result = instance.inserir(consulta);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
