<%@page import="java.sql.*" %>
<%@page import="Utilitarios.ConexionBD" %>

<%
try {//Probar el código
    //Guardar los datos en la BD
    //a. Conexion a la BD
    Connection cn = ConexionBD.retornaConexion();
    //b. Leer los datos de la web
    String ape = request.getParameter("apellido");
    String nom = request.getParameter("nombres");
    String gen = request.getParameter("genero");
    String ocu = request.getParameter("ocupacion");
    String cv = request.getParameter("cv");
    int edad =Integer.parseInt(request.getParameter("edad"));
    //c. Preparar consulta para Insert
    String sql = "insert into usuario values(null,?,?,?,?,?,?)";
    PreparedStatement pst = cn.prepareStatement(sql);
        pst.setString(1, ape);
        pst.setString(2, nom);
        pst.setString(3, gen);
        pst.setString(4, ocu);
        pst.setString(5, cv);
        pst.setInt(6, edad);
    //d. Ejecutar instruccion
    pst.executeUpdate();
    //e. Redirección a la web principal
    response.sendRedirect("index.jsp");
    pst.close(); cn.close();
    } catch (Exception e) {
    }
%>
