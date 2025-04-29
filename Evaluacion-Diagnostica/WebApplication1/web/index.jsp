<%@page import="java.sql.*" %>
<%@page import="Utilitarios.ConexionBD" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <button onclick="abrirModal()">Añadir nuevo usuario</button>
        <dialog id="modal">
            <form action="añadirUsuario.jsp">
                <label>Apellidos : </label> <br>
                <input name="apellido"><br>
                <label>Nombres : </label> <br>
                <input name="nombres"><br>
                <label>Genero : </label><br>
                <div>
                    <label>Masculino : </label>
                    <input name="genero" type="radio" value="masculino">
                    <label>Femenino :</label>
                    <input name="genero" type="radio" value="femenino">
                </div>
                <label>Ocupación</label><br>
                <select name="ocupacion">
                    <option></option>
                    <option>Ingeniero</option>
                    <option>Profesor</option>
                </select><br>
                <label>CV</label><br>
                <textarea name="cv"></textarea><br>
                <label>Edad</label><br>
                <input name="edad"><br>
                <input type="submit">
            </form>
            <button onclick="cerrarModal()">Cerrar</button>
        </dialog>
        <table border="1">
            <thead>
                <th>Apellido</th>
                <th>Nombre</th>
                <th>Genero</th>
                <th>Ocupación</th>
                <th>CV</th>
                <th>Edad</th>
            </thead>
            <tbody>
                <%
                            try {//Codigo a analizar
                               //Mostrar la lista de Productos
                               Connection  conexion = ConexionBD.retornaConexion();
                               PreparedStatement pst = conexion.prepareStatement("select * from usuario");
                               ResultSet rs  = pst.executeQuery();
                               while(rs.next()){
                                  out.print("</tr>");
                                  out.print("<td hidden>"+rs.getInt("idUsuario") + "</td>");
                                  out.print("<td>"+rs.getString("apellido") + "</td>");
                                  out.print("<td>"+rs.getString("nombre") + "</td>");
                                  out.print("<td>"+rs.getString("genero") + "</td>");
                                  out.print("<td>"+rs.getString("ocupacion") + "</td>");
                                  out.print("<td>"+rs.getString("CV") + "</td>");
                                  out.print("<td>"+rs.getInt("edad") + "</td>");
                               }
                            } catch (Exception e) {//Encontrar el error
                                System.out.println(e.getMessage());
                          }
                      %>
            </tbody>
        </table>
    <script>
        function abrirModal(){
            document.getElementById("modal").style.display = "block"
        }
        function cerrarModal(){
            document.getElementById("modal").style.display = "none"
        }
    </script>
    </body>
</html>
