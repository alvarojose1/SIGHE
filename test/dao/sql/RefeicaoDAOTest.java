/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.sql;

import domain.reserva.Refeicao;
import java.sql.Array;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Eriberto
 */
public class RefeicaoDAOTest {
    
    public RefeicaoDAOTest() {
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
     * Test of inserir method, of class RefeicaoDAO.
     */
    @Test
    public void testInserir_Refeicao() throws Exception {
        System.out.println("inserir");
        Refeicao refeicao = null;
        RefeicaoDAO instance = new RefeicaoDAO();
        boolean expResult = false;
        boolean result = instance.inserir(refeicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of inserir method, of class RefeicaoDAO.
     */
    @Test
    public void testInserir_Object() {
        System.out.println("inserir");
        Object object = null;
        RefeicaoDAO instance = new RefeicaoDAO();
        boolean expResult = false;
        boolean result = instance.inserir(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of excluir method, of class RefeicaoDAO.
     */
    @Test
    public void testExcluir() {
        System.out.println("excluir");
        String matricula = "";
        RefeicaoDAO instance = new RefeicaoDAO();
        boolean expResult = false;
        boolean result = instance.excluir(matricula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of editar method, of class RefeicaoDAO.
     */
    @Test
    public void testEditar() {
        System.out.println("editar");
        Object object = null;
        RefeicaoDAO instance = new RefeicaoDAO();
        boolean expResult = false;
        boolean result = instance.editar(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTodos method, of class RefeicaoDAO.
     */
    @Test
    public void testGetTodos() {
        System.out.println("getTodos");
        RefeicaoDAO instance = new RefeicaoDAO();
        Array expResult = null;
        Array result = instance.getTodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
