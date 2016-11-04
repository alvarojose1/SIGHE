/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.sql;

import domain.Usuario;
import domain.reserva.Ginasio;
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
public class GinasioDAOTest {
    private Usuario usuario;
    private Ginasio ginasio;
    
    public GinasioDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("setUp GinasioTestDAO");
        
        usuario = new Usuario();
        usuario.setMatricula("1234");
        ginasio = new Ginasio();
        ginasio.setIdGinasio("1234");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of inserir method, of class GinasioDAO.
     */
    @Test
    public void testInserir() {
        System.out.println("inserir");
        //String ginasio = "1234";
        GinasioDAO instance = null;
        instance = new GinasioDAO();
        boolean expResult = false;
        boolean result = instance.inserir(ginasio);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
