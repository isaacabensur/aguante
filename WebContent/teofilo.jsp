<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fulbito.model.Horario"%>
<%@page import="java.util.Collection"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Red social para alquiler de canchas de futbol</title>
<link href="styles/estilos.css" rel="stylesheet" type="text/css" />
<% 
	Collection<Horario> horarios = new ArrayList<Horario>();
    if(request.getAttribute("listaHorarios") != null) {
    	horarios = (ArrayList<Horario>)request.getAttribute("listaHorarios");
    	//System.out.println("canchas="+canchas.size()+" elementos");
	/*for(Iterator it = canchas.iterator(); it.hasNext();) {
		Cancha x = (Cancha)it.next();
		System.out.println("Nombre="+x.getNombre()+" Característica="+x.getCaracteristicas());
	}*/}
	%>
</head>

<body>
<div id="contenedorPrincipal">
  <div id="cabecera">
    <div id="logo"><a href="index.html"><img src="imagenes/logo.jpg" alt="Futbol Camp" width="167" height="120" border="0" /></a></div>
</div>
  <div id="barraSuperior">
    
  </div>
<div id="cuerpo">
    <h3>Detalle de cancha</h3>
<table width="100%" border="0" cellspacing="0" cellpadding="3">
      
       <tr>
    <th scope="col">Local</th>
    <th scope="col">Nombre de cancha</th>
    <th scope="col">Características</th>
    <th scope="col">Dias de atenci&oacute;n</th>
    <th scope="col">Horas de atenci&oacute;n</th>
    <th scope="col">Tarifa diurna<</th>
    <th scope="col">Tarifa nocturna</th>
    <th scope="col">Promoci&oacute;n especial</th>
	<th scope="col">Foto</th>
  </tr>
      <% 
	if(horarios.size() > 0) {
		for(Iterator it = horarios.iterator(); it.hasNext();) {
			Horario x = (Horario)it.next();
	%>
	<tr>
	<td><%=request.getAttribute("nomLocal")%></td>
	<td><%=request.getAttribute("nomCancha")%></td>
	<td><%=request.getAttribute("caracCancha")%></td>
	<td><%=x.getFecha()%></td>
	<td><%=x.getHoraInicio()%> - <%=x.getHoraFin()%></td>
	<td><%=request.getAttribute("tarifaDiurna")%></td>
	<td><%=request.getAttribute("tarifaNocturna")%></td>
	<td><%=request.getAttribute("promocion")%></td>
	<td><%=request.getAttribute("foto")%></td>
	</tr>
	<%}} else {%>
	<tr>
	<td colspan="9">No se ha encontrado registros</td>
	</tr>
	<% }%>
        <!-- td width="29%" align="right" valign="middle"><label for="local">Local</label></td>
        <td width="71%">Leyendas Peruanas</td>
      </tr>
      <tr>
        <td width="29%" align="right" valign="middle"><label for="nombre">Nombre de cancha</label></td>
        <td width="71%">Teófilo &quot;Nene&quot; Cubillas</td>
      </tr>
      <tr>
        <td align="right" valign="middle"><label for="caracteristicas">Características</label></td>
        <td>Pasto sintÃ©tico, futbol 6</td>
      </tr>
      <tr>
        <td align="right" valign="middle"><label for="diasAtencion">Dias de atenci&oacute;n</label></td>
        <td>Lunes a Viernes</td>
      </tr>
      <tr>
        <td align="right" valign="middle"><label for="horasAtencion">Horas de atenci&oacute;n</label></td>
        <td>10:00 a 23:00</td>
      </tr>
      <tr>
        <td align="right" valign="middle"><label for="tarifaDiurna">Tarifa diurna</label></td>
        <td>80</td>
      </tr>
      <tr>
        <td align="right" valign="middle"><label for="tarifaNocturna">Tarifa nocturna</label></td>
        <td>100</td>
      </tr>
      <tr>
        <td align="right" valign="middle"> <label for="promo">Promoci&oacute;n especial</label></td>
        <td>Los miÃ©rcoles de 5 p.m. a 7 p.m. juega 02 horas paga solo una</td>
      </tr>
      <tr>
        <td align="right" valign="top"><label for="foto">Foto</label></td>
        <td><img src="imagenes/cancha_sample.jpg" width="400" height="271" /></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr -->
  </table>
  
    <form action="" method="get">
      <table width="100%" border="0" cellspacing="0" cellpadding="3">
        <tr>
          <td width="29%" align="right" valign="middle"><label for="descLoc">CalificaciÃ³n</label></td>
          <td width="71%"><table width="200" class="comentario">
            <tr>
              <td>
                <input type="radio" name="calificacion" value="1" id="calificacion_1" />
              <label>  1</label></td>
              <td><input type="radio" name="calificacion" value="2" id="calificacion_2" />
<label>  2</label></td>
              <td><input name="calificacion" type="radio" id="calificacion_3" value="3" checked="checked"/>
<label>  3</label></td>
              <td><input type="radio" name="calificacion" value="4" id="calificacion_4" />
<label>4</label></td>
              <td><input type="radio" name="calificacion" value="5" id="calificacion_5" />
<label>5</label></td>
            </tr>
          </table></td>
        </tr>
        <tr>
          <td align="right" valign="top"><label for="comentario">Comentario</label></td>
          <td>
          <textarea name="comentario" id="comentario" cols="45" rows="5"></textarea></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><input type="submit" name="registrar" id="registrar" value="Comentar" /></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
      </table>
    
    
    
  </form>
  </div></div><div id="piecera">Futbol Camp tiene todos los derechos Â® reservados  </div>
</body>
</html>
