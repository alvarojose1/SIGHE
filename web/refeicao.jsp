<%-- 
    Document   : refeicao
    Created on : 02/02/2015, 20:04:49
    Author     : Wisley
--%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="javax.swing.text.Document"%>
<%@page import="banco.*"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" href="imagens/ico.png"/>
        <title> SIGHE - REFEI��O </title>
        <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
        <link rel="stylesheet" type="text/css" href="css/MasterPage.css"/>
        <link rel="stylesheet" type="text/css" href="css/Menu.css"/>
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <script src="js/script.js"></script>
    </head>
    <body>
    <center>
        <img src="imagens/newbanner.png" class="header"> 
        <%
            String idlogado = (String) session.getAttribute("idusuario");
            UsuarioDAO usuDAO = new UsuarioDAO();
            ResultSet usuLogado = null;
            if (idlogado == null) {
                response.sendRedirect("index.jsp");
            } else {
                usuLogado = usuDAO.pegarUsuario(idlogado);

                if (usuLogado.next()) {
        %>

        <div id='cssmenu'>
            <ul style="float: left;">
                <li> <a href=inicio.jsp>In�cio</a></li>
                <li><a href=usuarios.jsp> Usu�rios </a></li>
                <li><a href="horarios.jsp"> Hor�rios </a></li>
                <li><a href='logar.jsp?acao=sair'> Sair </a></li>
            </ul>
            <p style="padding-right: 20px; text-align: right;"><%=usuLogado.getString("nome")%> (<%=usuLogado.getString("tipo")%>)</p>
        </div>

        <div id='corpo'>   
            <h1> RESERVAR REFEI��O </h1>
            <%
                Date data = new Date(System.currentTimeMillis());
                SimpleDateFormat formatarDate = new SimpleDateFormat("u"); //nunmero do dia da semana
                //1 - segunda, 2 - ter�a, 3 - quarta 
                //4 - quinta, 5 - sexta, 6 - sabado, 7 domingo
                SimpleDateFormat formatarDateDia = new SimpleDateFormat("EEEEEE");

                if (Integer.parseInt(formatarDate.format(data)) == 6) {
            %>
            HOJE � S�BADO, SEM EXPEDIENTE!
            <%
            } else if (Integer.parseInt(formatarDate.format(data)) == 7) {
            %>  
            HOJE � DOMINGO, SEM EXPEDIENTE!
            <%
            } else {
                RefeicaoDAO refeicaoDAO = new RefeicaoDAO();
                int countAlmoco = refeicaoDAO.countPreenchido(data.toString(), "Almo�o");
                int countJanta = refeicaoDAO.countPreenchido(data.toString(), "Janta");
            %>
            <table>
                <tr>
                    <td><div style="font-size: 13pt; margin-left: 60px;"> Almo�o</div></td>
                    <td><div style="font-size: 13pt; margin-left: 60px;"> Janta</div></td>
                </tr>
                <tr> 
                    <td style="padding-left: 20px"><div style="text-align:left;"><div id="divSol">20</div><div style="font-size: 12pt; margin-left: 60px;">Vagas</div></div></td>
                    <td style="padding-left: 20px"><div style="text-align:left;"><div id="divSol">15</div><div style="font-size: 12pt; margin-left: 60px;">Vagas</div></div></td>
                </tr>
                <tr> 
                    <td style="padding-left: 20px"><div style="text-align:left;"><div id="divSol"> <%= countAlmoco%></div><div style="font-size: 12pt; margin-left: 60px;">Preenchidas</div></div></td>
                    <td style="padding-left: 20px"><div style="text-align:left;"><div id="divSol"><%= countJanta %></div><div style="font-size: 12pt; margin-left: 60px;">Preenchidas</div></div></td>
                </tr>
            </table>
            <br>
            <%
                String rv = request.getParameter("reservar");
                if (rv == null) {
            %> 
            <form action="refeicao.jsp" method="post">
                <fieldset>
                    <legend>Reserve uma refei��o para hoje (<%=formatarDateDia.format(data)%>)</legend>
                    <br>
                    <label> Tipo de refei��o: </label>
                    <input type="radio" name="tipo" value="Almo�o" checked/>Almo�o
                    <input type="radio" name="tipo" value="Janta"/>Janta                    
                    <br><br> 
                    <label> Justifivativa </label> <br>
                    <textarea name="justificativa" cols="50" rows="5" > </textarea>
                    <br><br>

                    <input type="submit" class="sub" name="reservar" value="Reservar">
                    <input type="reset" class="sub" value="Limpar">	                     
                    <br>
                </fieldset>
            </form>
            <%
            } else {
                if (request.getParameter("tipo").equals("Janta") && countJanta >= 15) {
            %>
            <fieldset class="login1">
                <p style="text-align: center; background-color: #ffcccc; width: 400px">AS VAGAS PARA A JANTA DE HOJE ACABARAM!<br/><br/>
                    <a class="ap" href="inicio.jsp">In�cio</a></p>
            </fieldset>
            <%
            } else if (request.getParameter("tipo").equals("Almo�o") && countAlmoco >= 20) {
            %>
            <fieldset class="login1">
                <p style="text-align: center; background-color: #ffcccc; width: 400px">AS VAGAS PARA O ALMO�O DE HOJE ACABARAM!<br/><br/>
                    <a class="ap" href="inicio.jsp">In�cio</a></p>
            </fieldset>
            <%
            } else {
                Refeicao refeicao = new Refeicao();
                refeicao.setMatricula(usuLogado.getString("matricula"));
                refeicao.setData(data);
                refeicao.setTipo(request.getParameter("tipo"));
                refeicao.setJustificativa(request.getParameter("justificativa"));

                refeicaoDAO.Inserir(refeicao);
            %>
            <fieldset class="login1">
                <p style="text-align: center; background-color: #ccffcc; width: 400px">RESERVA FEITA COM SUCESSO.<br/><br/>
                    <a class="ap" href="inicio.jsp">In�cio</a></p>
            </fieldset>
            <%
                        }
                    }
                }
            %>
        </div>
        <%
                }
            }
        %>
    </center>
    <div id="rodape">
        <p id="textoRodape">
            @ IFRN Campus Jo�o C�mara
            <!-- <img src="imagens/logoifrn.jpg" width="150"/> -->
        </p>
    </div>
</body>
</html>




