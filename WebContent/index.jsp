<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Red social para alquiler de canchas de futbol</title>
<link href="styles/estilos.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div id="contenedorPrincipal">
  <div id="cabecera">
    <div id="logo"><a href="#"><img src="imagenes/logo.jpg" alt="Futbol Camp" width="167" height="120" border="0" /></a></div>
</div>
  <div id="barraSuperior">
    
  </div>
<div id="login">
  <form action="LoginServlet" method="post">
    <table width="390px" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td><label for="correo">Direcci&oacute;n de correo electr&oacute;nico</label></td>
        <td><label for="password">Contrase&ntilde;a</label></td>
        <td>&nbsp;</td>
        </tr>
      <tr>
        <td>
          <input type="text" name="correo" id="correo" /></td>
        <td><input name="password" type="password"  /></td>
        <td><input name="Entrar" type="submit" value="Entrar" id="Entrar"/></td>
        </tr>
      <tr>
        <td><label>Si no tienes una cuenta <a href="registro.jsp">¡Regístrate!</a></label></td>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
        </tr>
  </table>
    
    
    </form>
  
</div>
  
</div><div id="piecera">Futbol Camp tiene todos los derechos  reservados &reg; </div>
<%if(request.getAttribute("MENSAJE") != null) {%>
	<script type="text/javascript" language="javascript">alert("<%=request.getAttribute("MENSAJE")%>");	</script>
<%}%>
</body>
</html>
