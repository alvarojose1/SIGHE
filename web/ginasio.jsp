<%-- 
    Document   : ginasio
    Created on : 02/02/2015, 20:04:49
    Author     : Wisley
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Date"%>
<%@page import="dao.sql.*"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="shortcut icon" href="imagens/ico.png"/>
        <title> SIGHE - GIN�SIO </title>
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
            <h1> RESERVAR GIN�SIO </h1>
            <%
                String rv = request.getParameter("reservar");
                if (rv == null) {
            %>
            <form action="ginasio.jsp" method="post">
                <fieldset class="login">

                    <legend> Preencha o formul�rio abaixo</legend>
                    <br>
                    <label>Data: </label>
                    <input type="date" name="data" id="data" required="">
                    <br><br>
                    <script type="text/javascript" src="js/jquery-1.2.6.pack.js">
                    </script>

                    <script type="text/javascript" src="js/jquery.maskedinput-1.1.4.pack.js"/>
                    </script>

                    <script type="text/javascript">$(document).ready(function () {
                            $("#hora").mask("99h99");
                        });
                    </script>
                    <script type="text/javascript">$(document).ready(function () {
                            $("#hora1").mask("99h99");
                        });
                    </script>

                    <label> Hor�rio das: </label> 
                    <input id="hora" type="text" name="horario1" size="5" required/> 
                    <label> �s: </label>
                    <input id="hora1" type="text" name="horario2"  size="5" required/> *M�x. de 1h!
                    <br><br>

                    <label> Pr�tica esportiva: </label>
                    <select name="tipoEsporte" required/>
                    <option>Futsal</option>
                    <option>Handball</option>
                    <option>V�lei</option>
                    <option>Basquete</option>
                    </select>
                    <br><br>
                    <label> Quantidade de bolas: </label>
                    <input type="number" name="qtdBolas" min="1" max="2" required/> *M�x. 2!
                    <br><br>
                    <input type="submit" class="sub" name="reservar" value="Reservar">
                    <input type="reset" class="sub" value="Limpar">
                    <br>
                </fieldset>
            </form>
            <%} else {
                // Embora o nomes aqui sejam "ginasio", isto refere-se a reservas do ginasio,
                // e n�o o gin�sio em si.
                Ginasio ginasio = new Ginasio();

                ginasio.setMatricula(usuLogado.getString("matricula"));
                ginasio.setTipoEsporte(request.getParameter("tipoEsporte"));
                ginasio.setQtdBolas(request.getParameter("qtdBolas"));
                ginasio.setData(request.getParameter("data"));
                ginasio.setHorario(request.getParameter("horario1") + " �s " + request.getParameter("horario2"));

                GinasioDAO ginasioDAO = new GinasioDAO();

                ginasioDAO.inserir(ginasio);
            %>
            <fieldset class="login1">
                <p style="text-align: center">RESERVA FEITA COM SUCESSO. <br/><br/>
                    <a class="ap" href="inicio.jsp">In�cio</a></p>
            </fieldset>
            <%}%>
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