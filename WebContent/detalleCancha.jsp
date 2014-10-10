<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@page import="fulbito.business.SeguridadNegocioCancha"%>
<%@page import="java.util.*" %>
<%@page import="fulbito.model.Local"%>
<%@page import="fulbito.model.Cancha"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Red social para alquiler de canchas de futbol</title>
<link href="styles/estilos.css" rel="stylesheet" type="text/css" />
<% 
	int numCancha = Integer.parseInt(request.getParameter("numCancha"));
	SeguridadNegocioCancha negocio = new SeguridadNegocioCancha();
	Collection<Cancha> canchas = new ArrayList<Cancha>();
	Cancha obj = new Cancha(); 
	for(Cancha x: canchas) {
	 
	if(x.getNumCan()==numCancha){
	 obj=x;
	 }
	 
	 }
	   	
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
        <td width="29%" align="right" valign="middle"><label for="local">Local</label></td>
        <td width="71%">Leyendas Peruanas</td>
      </tr>
      <tr>
        <td width="29%" align="right" valign="middle"><label for="nombre">Nombre de cancha</label></td>
        <td width="71%"><%=obj.getNombre()%></td>
      </tr>
      <tr>
        <td align="right" valign="middle"><label for="caracteristicas">Caracter�sticas</label></td>
        <td>Pasto sintético, futbol 6</td>
      </tr>
      <tr>
        <td align="right" valign="middle"><label for="diasAtencion">Dias de atenci�n</label></td>
        <td>Lunes a Viernes</td>
      </tr>
      <tr>
        <td align="right" valign="middle"><label for="horasAtencion">Horas de atención</label></td>
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
        <td align="right" valign="middle"> <label for="promo">Promoción especial</label></td>
        <td>Los miércoles de 5 p.m. a 7 p.m. juega 02 horas paga solo una</td>
      </tr>
      <tr>
        <td align="right" valign="top"><label for="foto">Foto</label></td>
        <td><img src="imagenes/cancha_sample.jpg" width="400" height="271" /></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td>&nbsp;</td>
      </tr>
  </table>
  
    <form action="" method="get">
      <table width="100%" border="0" cellspacing="0" cellpadding="3">
        <tr>
          <td width="29%" align="right" valign="middle"><label for="descLoc">Calificación</label></td>
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
  </div></div><div id="piecera">Futbol Camp tiene todos los derechos ® reservados  </div>
</body>
</html>