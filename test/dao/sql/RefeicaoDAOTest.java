/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.sql;

import domain.Usuario;
import domain.reserva.Refeicao;
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
public class RefeicaoDAOTest {
    private Usuario usuario;
    private Refeicao refeicao;
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
    System.out.println("setUp RefeicaoTestDAO");
        
        usuario = new Usuario();
        usuario.setMatricula("1234");
        refeicao = new Refeicao();
        refeicao.setIdRefeicao("1");
        refeicao.setMatricula("1234");
        refeicao.setJustificativa("fome");
        refeicao.setTipo("almoço");
         refeicao.setData("12-3-2014");
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of inserir method, of class RefeicaoDAO.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        RefeicaoDAO dao = null;
         dao = new RefeicaoDAO();
        boolean expResult = true;
        int result = dao.inserir(refeicao);
        assertEquals(expResult, result > 0);
        
        Refeicao r = dao.pegarRefeicao(result);
        assertEquals(refeicao.getMatricula(), r.getMatricula());
        assertEquals(refeicao.getTipo(), r.getTipo());
        assertEquals(refeicao.getJustificativa(), r.getJustificativa());
        assertEquals(refeicao.getData(), r.getData());
        
        
        
        // TODO review the generated test code and remove the default call to fail.
       
    }

    
    
}
