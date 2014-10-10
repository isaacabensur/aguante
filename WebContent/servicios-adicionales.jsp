<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="fulbito.model.Persona"%>
<%@page import="fulbito.model.Local"%>
<%@page import="java.util.Collection"%>
<%@page import="fulbito.business.InsertarLocal"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Red social para alquiler de canchas de futbol</title>
<link href="styles/estilos.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/validacionesJS.js"></script>
<% 
Persona vo = (Persona)session.getAttribute("USUARIO_ACTUAL");
int codPersona = vo.getCodPer();
InsertarLocal neg = new InsertarLocal();
Collection<Local> listaLocales=neg.buscarPorPersona(codPersona);
request.setAttribute("listaLocales",listaLocales);
%>
</head>

<body>
<div id="contenedorPrincipal">
  <div id="cabecera">
    <div id="logo"><a href="index-duenio.jsp"><img src="imagenes/logo.jpg" alt="Futbol Camp" width="167" height="120" border="0" /></a></div>
</div>
  <div id="barraSuperior">
    
  </div>
<div id="cuerpo">
    <h3>Registrar servicios adicionales para el local</h3>
    
    <form name="registrarServiciosAdicionales" action="ServAdicionalServlet" method="post" onsubmit="return validarServiciosAdicionales();">
      <table width="100%" border="0" cellspacing="0" cellpadding="3">
      
      <tr>
          <td width="29%" align="right" valign="middle"><label for="tipo">Tipo de servicio</label></td>
          <td width="71%">
            
            <select name="tipo" id="tipo">
              <option selected="selected" value="">Seleccionar</option>
              <option>Camisetas</option>
              <option>Árbitros</option>
              <option>Servicio de fotografía</option>
            
</select></td>
        </tr>
        <tr>
          <td width="29%" align="right" valign="middle"><label for="descripcion">Descripción</label></td>
          <td width="71%">
          <input type="text" name="descripcion" id="descripcion" /></td>
        </tr>
        <tr>
          <td align="right" valign="middle"><label for="tarifa">Tarifa</label></td>
          <td>
          <input type="text" name="tarifa" id="tarifa" /></td>
        </tr>
        <tr>
          <td align="right" valign="middle"><label for="local">Local</label></td>
          <td>
            
              <select name="local" id="local">
            <option value="" selected="selected">Seleccionar</option>
            <% 
            Collection<Local> locales = (ArrayList<Local>)request.getAttribute("listaLocales");
            for(Local x: locales) {
            %>
            <option value="<%=x.getCodLoc()%>"><%=x.getDesLoc()%></option>
            <%}%>
</select></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><br />            <input type="submit" name="registrar" id="registrar" value="Regístra el servicio" /></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
      </table>
    
    
    
    </form>
</div></div><div id="piecera">Futbol Camp tiene todos los derechos &reg; reservados  </div>
<%if(request.getAttribute("MENSAJE") != null) {%>
	<script type="text/javascript" language="javascript">alert("<%=request.getAttribute("MENSAJE")%>");	</script>
<%}%>
</body>
</html>

