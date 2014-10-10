<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Red social para alquiler de canchas de futbol</title>
<link href="styles/estilos.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript" src="js/validacionesJS.js"></script>
</head>

<body>
<div id="contenedorPrincipal">
  <div id="cabecera">
    <div id="logo"><a href="index-duenio.jsp"><img src="imagenes/logo.jpg" alt="Futbol Camp" width="167" height="120" border="0" /></a></div>
</div>
  <div id="barraSuperior">
    
  </div>
<div id="cuerpo">
    <h3>Registro de local</h3>
    <form name="registrarLocal" action="LocalServlet" method="post" onsubmit="return validarLocal();">
      <table width="100%" border="0" cellspacing="0" cellpadding="3">
        <tr>
          <td width="29%" align="right" valign="middle"><label for="desLoc">Nombre de local</label></td>
          <td width="71%">
          <input type="text" name="desLoc" id="desLoc" /></td>
        </tr>
        <tr>
          <td align="right" valign="middle"><label for="direccion">Dirección</label></td>
          <td>
          <input type="text" name="direccion" id="direccion" /></td>
        </tr>
        <tr>
          <td align="right" valign="middle"><label for="distrito">Distrito</label></td>
          <td><label for="distrito"></label>
            <select name="distrito" id="distrito">
			<option selected="selected" value="">Seleccionar</option>
			<option value="ANC">Anc&oacute;n</option>
            <option value="ATE">Ate</option>
            <option value="BAR">Barranco</option>
            <option value="BEL">Bellavista</option>
            <option value="BRE">Bre&ntilde;a</option>
            <option value="CAL">Callao</option>
            <option value="CAR">Carabayllo</option>
            <option value="CLE">Carmen de la Legua</option>
            <option value="CLI">Cercado de Lima</option>
            <option value="CHA">Chaclacayo</option>
            <option value="CHO">Chorrillos</option>
            <option value="CIE">Cieneguilla</option>
            <option value="COM">Comas</option>
            <option value="EAG">El Agustino</option>
            <option value="IND">Independencia </option>
            <option value="JEM">Jes&uacute;s Mar&iacute;a</option>
            <option value="LMO">La Molina</option>
            <option value="LPE">La Perla</option>
            <option value="LPU">La Punta</option>
            <option value="LVI">La Victoria</option>
            <option value="LIN">Lince</option>
            <option value="LOL">Los Olivos</option>
            <option value="LUI">Lurigancho</option>
            <option value="LUR">Lur&iacute;n</option>
            <option value="MMA">Magdalena del Mar</option>
            <option value="MIR">Miraflores</option>
            <option value="PAC">Pachacamac</option>
            <option value="PUC">Pucusana</option>
            <option value="PLI">Pueblo Libre</option>
            <option value="PPI">Puente Piedra</option>
            <option value="PHE">Punta Hermosa</option>
            <option value="PNE">Punta Negra</option>
            <option value="RIM">R&iacute;mac</option>
            <option value="SBA">San Bartolo</option>
            <option value="SBO">San Borja</option>
            <option value="SIS">San Isidro</option>
            <option value="SJL">San Juan de Lurigancho</option>
            <option value="SJM">San Juan de Miraflores</option>
            <option value="SLU">San Luis</option>
            <option value="SMP">San Mart&oacute;n de Porres</option>
            <option value="SMI">San Miguel</option>
            <option value="SAN">Santa Anita</option>
            <option value="SMM">Santa M. del Mar</option>
            <option value="SRO">Santa Rosa</option>
            <option value="SSU">Santiago de Surco</option>
            <option value="SUR">Surquillo</option>
            <option value="VEN">Ventanilla</option>
            <option value="VES">Villa El Salvador</option>
            <option value="VMT">Villa Mar&iacute;a del Triunfo</option>

          </select></td>
        </tr>
        <tr>
          <td align="right" valign="middle"><label for="dicGoogle">Dirección de Google</label></td>
          <td>
          <input type="text" name="dicGoogle" id="dicGoogle" /></td>
        </tr>
        <tr>
          <td align="right" valign="middle"><label for="telefonoFijo">Teléfono fijo</label></td>
          <td><input type="text" name="telefonoFijo" id="telefonoFijo" /></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><br />            <input type="submit" name="registrar" id="registrar" value="Regístra tu local" /></td>
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
