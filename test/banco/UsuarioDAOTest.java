/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import com.mysql.jdbc.Connection;
import dao.sql.Conexao;
import dao.sql.UsuarioDAO;
import domain.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Marina
 */
public class UsuarioDAOTest {
    
    private Usuario usuario;
    private Usuario usuario1;
    private Usuario usuario2;
    private Usuario usuario3;
    private Usuario usuario4;
    private Object set;
    
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
        
       
        usuario1 = new Usuario();
        usuario1.setTipo("Aluno");
        usuario1.setSenha("000");
        usuario1.setNome("Edson");
        usuario1.setMatricula("342545645");
        usuario1.setDataNasc("2015-04-15");
        usuario1.setEmail("wisley@gmail.com");
        usuario1.setTelefone("(44) 4444-4444");
        usuario1.setCpf("444.444.444-44");
        usuario1.setSexo("Feminino");
        usuario1.setCurso("Energias Renováveis");
        usuario1.setFuncao("-");
        
        usuario2 = new Usuario();
        usuario2.setTipo("Funcionário");
        usuario2.setSenha("1");
        usuario2.setNome("Lúcia");
        usuario2.setMatricula("00003");
        usuario2.setDataNasc("1986-01-13");
        usuario2.setEmail("p@gmail.com");
        usuario2.setTelefone("(55) 5555-5555");
        usuario2.setCpf("000.000.000-00");       
        usuario2.setSexo("Masculino");
        usuario2.setCurso("-");
        usuario2.setFuncao("Gerente de Ginásio");
        
        usuario3 = new Usuario();
        usuario3.setTipo("Professor");
        usuario3.setSenha("000");
        usuario3.setNome("João");
        usuario3.setMatricula("3335");
        usuario3.setDataNasc("2015-04-13");
        usuario3.setEmail("joao@gmail.com");
        usuario3.setTelefone("(09) 0909-0909");
        usuario3.setCpf("988.888.888-88");
        usuario3.setSexo("Masculino");
        usuario3.setCurso("Física");
        usuario3.setFuncao("-");

        UsuarioDAO dao = new UsuarioDAO();
        
        //dao.inserir(usuario1);
        
        
        try {
            Connection conn = new Conexao().getConn();
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
        System.out.println(expResult);
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
    public void testExcluir() {
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
    public void testEditar() {
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
    public void testPegarUsuario(){
        
    
        UsuarioDAO instance = new UsuarioDAO();
        instance.inserir(usuario1);
        
        Usuario a = instance.pegarUsuarioPelaMatricula(usuario1.getMatricula());
        assertTrue(usuario1.equals(a));
        
        instance = new UsuarioDAO();
        Usuario result = instance.pegarUsuario(a.getIdUsuario());
         assertNotNull(result);
         assertTrue(result.equals(a));
         assertTrue(result.getIdUsuario().equals(a.getIdUsuario()));        
    }
 
    @Test
    public void testPegarUsuarioPelaMatricula() {
        UsuarioDAO instance = new UsuarioDAO();
        instance.inserir(usuario1);
        
        instance = new UsuarioDAO();
        Usuario result = instance.pegarUsuarioPelaMatricula(usuario1.getMatricula());
        assertNotNull(result);
        
        assertTrue(result.equals(usuario1));       
    }
    
    /**
     * Test of selecionarAlunos method, of class UsuarioDAO.
     */
    @Test
    public void testSelecionarAlunos() {
        //verificar quantidade. Tem três usuarios do tipo funcionario no banco
         //fazer um laço (for), fazer um break se o id do funcionario for 9 e comparar os atributos dele.
        
        UsuarioDAO dao = new UsuarioDAO();
         
           ArrayList<Usuario> lista = dao.selecionarAlunos();
            
           int expResult = 4;
           int result = lista.size();
           assertEquals(expResult, result);
         
           Usuario a = null;
           
           int i;
           for (i=0; i < lista.size(); i++){
                a = lista.get(i);
                if (a.getMatricula().equals(usuario1.getMatricula())) {
                    assertEquals(usuario1.getMatricula(), a.getMatricula());
                    assertEquals(usuario1.getNome(), a.getNome());
                    assertEquals(usuario1.getCurso(), a.getCurso());
                    assertEquals(usuario1.getTelefone(), a.getTelefone());
                    assertEquals(usuario1.getSexo(), a.getSexo());
                    assertEquals(usuario1.getCpf(), a.getCpf());
                    assertEquals(usuario1.getDataNasc(), a.getDataNasc());
                    assertEquals(usuario1.getEmail(), a.getEmail());
                    assertEquals(usuario1.getFuncao(), a.getFuncao());
                    assertEquals(usuario1.getSenha(), a.getSenha());
                    assertEquals(usuario1.getTipo(), a.getTipo());
                    break;
                }
           }
           
           // validar f situacao de não ter retornado o Aluno X
           assertNotEquals(i, lista.size());
    }
    @Test
   
        public void testFiltrarAlunos(){
           
            UsuarioDAO dao = new UsuarioDAO();
           
           // Esse primeirpo trecho do metodo testa apenas f quantidade do retorno 
            
           // No BANCO existem três usuarios que contém "marina" no nome, onde 2 sao alunos e 1 professor
           String filtro = "Marina";
           ArrayList<Usuario> lista = dao.filtrarAlunos(filtro);
            
           int expResult = 2;
           int result = lista.size();
           assertEquals(expResult, result);
           
           // No banco exitem "3" usuario que contem "informatica" no nome do curso
           filtro = "Informática";
           lista = dao.filtrarAlunos(filtro);
            
           expResult = 3;
           result = lista.size();
           assertEquals(expResult, result);        

           // Esse segundo trecho, faz f pesquisa por um filtro que irá retornar
           // apenas um registro. E testará os atributos
           filtro = "342545645";
           lista = dao.filtrarAlunos(filtro);
            
           expResult = 1;
           result = lista.size();
           assertEquals(expResult, result);
           
            for (Usuario b : lista) {
              assertEquals(usuario1.getMatricula(), b.getMatricula());
              assertEquals(usuario1.getNome(), b.getNome());
              assertEquals(usuario1.getCurso(), b.getCurso());
              assertEquals(usuario1.getTelefone(), b.getTelefone());
              assertEquals(usuario1.getSexo(), b.getSexo());
              assertEquals(usuario1.getCpf(), b.getCpf());
              assertEquals(usuario1.getDataNasc(), b.getDataNasc());
              assertEquals(usuario1.getEmail(), b.getEmail());
              assertEquals(usuario1.getFuncao(), b.getFuncao());
              assertEquals(usuario1.getSenha(), b.getSenha());
              assertEquals(usuario1.getTipo(), b.getTipo());
            }   
           
        }     
            

    /**
     * Test of selecionarProfessores method, of class UsuarioDAO.
     */
    @Test
    public void testSelecionarProfessores() {
       //verificar quantidade. Tem três usuarios do tipo funcionario no banco
         //fazer um laço (for), fazer um break se o id do funcionario for 9 e comparar os atributos dele.
        
        UsuarioDAO dao = new UsuarioDAO();
         
           ArrayList<Usuario> lista = dao.selecionarProfessores();
            
           int expResult = 3;
           int result = lista.size();
           assertEquals(expResult, result);
         
           Usuario c = null;
           
           int i;
           for (i=0; i < lista.size(); i++){
                c = lista.get(i);
                if (c.getMatricula().equals(usuario3.getMatricula())) {
                    assertEquals(usuario3.getMatricula(), c.getMatricula());
                    assertEquals(usuario3.getNome(), c.getNome());
                    assertEquals(usuario3.getCurso(), c.getCurso());
                    assertEquals(usuario3.getTelefone(), c.getTelefone());
                    assertEquals(usuario3.getSexo(), c.getSexo());
                    assertEquals(usuario3.getCpf(), c.getCpf());
                    assertEquals(usuario3.getDataNasc(), c.getDataNasc());
                    assertEquals(usuario3.getEmail(), c.getEmail());
                    assertEquals(usuario3.getFuncao(), c.getFuncao());
                    assertEquals(usuario3.getSenha(), c.getSenha());
                    assertEquals(usuario3.getTipo(), c.getTipo());
                    break;
                }
           }
           
           // validar f situacao de não ter retornado o Professor X
           assertNotEquals(i, lista.size());
    }

    /**
     * Test of filtrarProfessores method, of class UsuarioDAO.
     */
    @Test
    public void testFiltrarProfessores() {
              UsuarioDAO dao = new UsuarioDAO();
           
           // Esse primeirpo trecho do metodo testa apenas f quantidade do retorno 
            
           // No BANCO existem três usuarios que contém "joão" no nome, onde 2 sao professores e 1 aluno
           String filtro = "João";
           ArrayList<Usuario> lista = dao.filtrarProfessores(filtro);
            
           int expResult = 2;
           int result = lista.size();
           assertEquals(expResult, result);
           
           // No banco exitem "1" usuario que contem "informatica" no nome do curso
           filtro = "Física";
           lista = dao.filtrarProfessores(filtro);
            
           expResult = 2;
           result = lista.size();
           assertEquals(expResult, result);        

           // Esse segundo trecho, faz f pesquisa por um filtro que irá retornar
           // apenas um registro. E testará os atributos
           filtro = "3335";
           lista = dao.filtrarProfessores(filtro);
            
           expResult = 1;
           result = lista.size();
           assertEquals(expResult, result);
           
            for (Usuario d : lista) {
              assertEquals(usuario3.getMatricula(), d.getMatricula());
              assertEquals(usuario3.getNome(), d.getNome());
              assertEquals(usuario3.getCurso(), d.getCurso());
              assertEquals(usuario3.getTelefone(), d.getTelefone());
              assertEquals(usuario3.getSexo(), d.getSexo());
              assertEquals(usuario3.getCpf(), d.getCpf());
              assertEquals(usuario3.getDataNasc(), d.getDataNasc());
              assertEquals(usuario3.getEmail(), d.getEmail());
              assertEquals(usuario3.getFuncao(), d.getFuncao());
              assertEquals(usuario3.getSenha(), d.getSenha());
              assertEquals(usuario3.getTipo(), d.getTipo());
            }   
           
        }     

    /**
     * Test of selecionarFuncionarios method, of class UsuarioDAO.
     */
    @Test
    public void testSelecionarFuncionarios()  {
         //verificar quantidade. Tem três usuarios do tipo funcionario no banco
         //fazer um laço (for), fazer um break se o id do funcionario for 9 e comparar os atributos dele.
        
        UsuarioDAO dao = new UsuarioDAO();
         
           ArrayList<Usuario> lista = dao.selecionarFuncionarios();
            
           int expResult = 3;
           int result = lista.size();
           assertEquals(expResult, result);
         
           Usuario e = null;
           
           int i;
           for (i=0; i < lista.size(); i++){
                e = lista.get(i);
                if (e.getMatricula().equals(usuario2.getMatricula())) {
                    assertEquals(usuario2.getMatricula(), e.getMatricula());
                    assertEquals(usuario2.getNome(), e.getNome());
                    assertEquals(usuario2.getCurso(), e.getCurso());
                    assertEquals(usuario2.getTelefone(), e.getTelefone());
                    assertEquals(usuario2.getSexo(), e.getSexo());
                    assertEquals(usuario2.getCpf(), e.getCpf());
                    assertEquals(usuario2.getDataNasc(), e.getDataNasc());
                    assertEquals(usuario2.getEmail(), e.getEmail());
                    assertEquals(usuario2.getFuncao(), e.getFuncao());
                    assertEquals(usuario2.getSenha(), e.getSenha());
                    assertEquals(usuario2.getTipo(), e.getTipo());
                    break;
                }
           }
           
           // validar f situacao de não ter retornado o funcionario X
           assertNotEquals(i, lista.size());
    }
    


    /**
     * Test of filtrarFuncionarios method, of class UsuarioDAO.
     */
    @Test
    public void testFiltrarFuncionarios() {
      
              UsuarioDAO dao = new UsuarioDAO();
           
           // Esse primeirpo trecho do metodo testa apenas f quantidade do retorno 
            
           // No BANCO existem 1 usuario que contém "Lucia" no nome
           String filtro = "Lúcia";
           ArrayList<Usuario> lista = dao.filtrarFuncionarios(filtro);
            
           int expResult = 1;
           int result = lista.size();
           assertEquals(expResult, result);
           
           // No banco exitem "3" usuario que contem "-" no nome do curso
           filtro = "-";
           lista = dao.filtrarFuncionarios(filtro);
            
           expResult = 3;
           result = lista.size();
           assertEquals(expResult, result);        

           // Esse segundo trecho, faz f pesquisa por um filtro que irá retornar
           // apenas um registro. E testará os atributos
           filtro = "00003";
           lista = dao.filtrarFuncionarios(filtro);
            
           expResult = 1;
           result = lista.size();
           assertEquals(expResult, result);
           
            for (Usuario f : lista) {
              assertEquals(usuario2.getMatricula(), f.getMatricula());
              assertEquals(usuario2.getNome(), f.getNome());
              assertEquals(usuario2.getCurso(), f.getCurso());
              assertEquals(usuario2.getTelefone(), f.getTelefone());
              assertEquals(usuario2.getSexo(), f.getSexo());
              assertEquals(usuario2.getCpf(), f.getCpf());
              assertEquals(usuario2.getDataNasc(), f.getDataNasc());
              assertEquals(usuario2.getEmail(), f.getEmail());
              assertEquals(usuario2.getFuncao(), f.getFuncao());
              assertEquals(usuario2.getSenha(), f.getSenha());
              assertEquals(usuario2.getTipo(), f.getTipo());
            }   
           
        }     
  

    
    }
 