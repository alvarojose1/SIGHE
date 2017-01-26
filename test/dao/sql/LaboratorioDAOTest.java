/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.sql;

import domain.Usuario;
import domain.reserva.Laboratorio;
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
public class LaboratorioDAOTest {
    private Usuario usuario;
    private Laboratorio laboratorio;
    public LaboratorioDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    System.out.println("setUp LaboratorioTestDAO");
        
        usuario = new Usuario();
        usuario.setMatricula("1234");
        laboratorio = new Laboratorio();
        laboratorio.setIdLaboratorio("1234");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of inserir method, of class LaboratorioDAO.
     */
    @Test
    public void testInserir() throws Exception {
        System.out.println("inserir");
        LaboratorioDAO  dao = null;
        dao = new LaboratorioDAO();
        boolean expResult = true;
        int result = dao.inserir(laboratorio);
        assertEquals(expResult, result > 0);
        
        Laboratorio l = dao.pegarLaboratorio(result);
         assertEquals(laboratorio.getMatriculaAluno(), l.getMatriculaAluno());
         assertEquals(laboratorio.getMatriculaProfessor(), l.getMatriculaProfessor());
         assertEquals(laboratorio.getLaboratorio(), l.getLaboratorio());
         assertEquals(laboratorio.getAprovacao(), l.getAprovacao());
         assertEquals(laboratorio.getHorario(), l.getHorario());
         assertEquals(laboratorio.getData(), l.getData());
         assertEquals(laboratorio.getTurno(), l.getTurno());
         
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
