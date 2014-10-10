<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="fulbito.model.Horario"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fulbito.model.Cancha"%>
<%@page import="java.util.Collection"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Red social para alquiler de canchas de futbol</title>
<link href="styles/estilos.css" rel="stylesheet" type="text/css" />
<% 
	Collection<Cancha> canchas = new ArrayList<Cancha>();
    if(request.getAttribute("listaCanchas") != null) {
    	canchas = (ArrayList<Cancha>)request.getAttribute("listaCanchas");
    	//System.out.println("canchas="+canchas.size()+" elementos");
	/*for(Iterator it = canchas.iterator(); it.hasNext();) {
		Cancha x = (Cancha)it.next();
		System.out.println("Nombre="+x.getNombre()+" Característica="+x.getCaracteristicas());
	}*/}
	%>
 <script>
 
 	/*function loopSelected() {
		//var diasAtencionObj = document.getElementById('diasAtencion');
		//var horasAtencionObj = document.getElementById('horasAtencion');
		var diasAtencionArray = new Array();
		var horasAtencionArray = new Array();
		var diasAtencionObj = document.getElementById('diasAtencion');
		var horasAtencionObj = document.getElementById('horasAtencion');
		var count1 = 0;
		var count2 = 0;
		for (var i=0; i<diasAtencionObj.options.length; i++) {
			if (diasAtencionObj.options[i].selected) {
				diasAtencionArray[count1] = diasAtencionObj.options[i].value;
				count1++;
			}
		}
		for (var i=0; i<horasAtencionObj.options.length; i++) {
			if (horasAtencionObj.options[i].selected) {
				horasAtencionArray[count2] = horasAtencionObj.options[i].value;
				count2++;
			}
		}
		alert(diasAtencionArray+" "+horasAtencionArray)
		//txtSelectedValuesObj.value = selectedArray;
	}*/
	function validar(){
		//loopSelected();
		if (document.f1.distrito.value == ""){
			alert("Ingresa el distrito");
			document.f1.distrito.focus();
    		   
			return false;
		}	

		if (document.f1.diasAtencion.value == ""){
           
			alert("Elige los días de atención");
			document.f1.diasAtencion.focus();
    		   
		    return false;
		}
		 
		if (document.f1.horasAtencion.value == ""){
           
			alert("Elige las horas de atención");
			document.f1.horasAtencion.focus();
    		   
			return false;
		}
			 		 
		
		return true;
         
         
	}
	
	function doOnload(){
		var dis = "";
		var dias = "";
		var horas = "";
		if("<%=request.getAttribute("distrito")%>" != "null") dis = "<%=request.getAttribute("distrito")%>";
		if("<%=request.getAttribute("diasAtencion")%>" != "null") dias = "<%=request.getAttribute("diasAtencion")%>";
		if("<%=request.getAttribute("horasAtencion")%>" != "null") horas = "<%=request.getAttribute("horasAtencion")%>";
		document.f1.distrito.value  = dis;
		document.f1.diasAtencion.value = dias;
		document.f1.horasAtencion.value = horas;
	}
	
    </script>

</head>

<body onload="doOnload();">
<div id="contenedorPrincipal">
  <div id="cabecera">
    <div id="logo"><a href="index.html"><img src="imagenes/logo.jpg" alt="Futbol Camp" width="167" height="120" border="0" /></a></div>
</div>
  <div id="barraSuperior">
    
  </div>
<div id="cuerpo">
    <h3>Alquiler de cancha</h3>
    
    <form name="f1" action="BuscarCanchaServlet" method="post" onsubmit="return validar();">
      <table width="100%" border="0" cellspacing="0" cellpadding="3">
        <tr>
          <td width="29%" align="right" valign="middle"><label for="distrito">Distrito</label></td>
          <td width="71%"><select name="distrito" id="distrito">
            <option value="" selected="selected">Seleccionar</option>
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
          <td align="right" valign="middle"><label for="fecha">D&iacute;a de atenci&oacute;n</label></td>
          <td><select name="diasAtencion" id="diasAtencion">
            <option value="" selected="selected" value="">D&iacute;as</option>
            <option value="LUN" >Lunes</option>
            <option value="MAR" >Martes</option>
            <option value="MIE" >Miercoles</option>
            <option value="JUE" >Jueves</option>
            <option value="VIE" >Viernes</option>
            <option value="SAB" >Sabado</option>
            <option value="DOM" >Domingo</option>
          </select>
		</td>
        </tr>
        <tr>
          <td align="right" valign="middle"><label for="horasAtencion">Horas de atenci&oacute;n</label></td>
          <td>
            <select name="horasAtencion" id="horasAtencion">
				<option value="" selected="selected" value="">Seleccionar</option>
				<option value="06000700">06:00-07:00</option>
				<option value="07000800">07:00-08:00</option>
				<option value="08000900">08:00-09:00</option>
				<option value="09001000">09:00-10:00</option>
				<option value="10001100">10:00-11:00</option>
				<option value="11001200">11:00-12:00</option>
				<option value="12001300">12:00-13:00</option>
				<option value="13001400">13:00-14:00</option>
				<option value="14001500">14:00-15:00</option>
				<option value="15001600">15:00-16:00</option>
				<option value="16001700">16:00-17:00</option>
				<option value="17001800">17:00-18:00</option>
				<option value="18001900">18:00-19:00</option>
				<option value="19002000">19:00-20:00</option>
				<option value="20002100">20:00-21:00</option>
				<option value="21002200">21:00-22:00</option>
				<option value="22002300">22:00-23:00</option>
          </select></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><br/>            <input type="submit" name="buscar" id="buscar" value="Buscar cancha" /></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
      </table>
    
    
    
    </form>
    
    <table border="0" cellspacing="0" cellpadding="0" class="resultadosTabla">
    <tr>
    <th scope="col">Nombre de la cancha</th>
    <th scope="col">Caracter&iacute;sticas</th>
    <th scope="col">Dias de atenci&oacute;n</th>
    <th scope="col">Horas de atenci&oacute;n</th>
    <th scope="col">Tarifa Diurna</th>
    <th scope="col">Tarifa Nocturna</th>
    <th scope="col">Local</th>
    <th scope="col">Distrito</th>
    <th scope="col">Disponibilidad</th>

  </tr>
    <% 
	if(canchas.size() > 0) {
		for(Iterator it = canchas.iterator(); it.hasNext();) {
			Cancha x = (Cancha)it.next();
			//System.out.println("Nombre="+x.getNombre()+" Característica="+x.getCaracteristicas());
			Collection<Horario> horarios= new ArrayList<Horario>();
			horarios = x.getHorarios();
	%>
	<tr>
	<td><a href="<%=request.getContextPath() %>/AlquilarServlet?numCancha=<%=x.getNumCan()%>&diasAtencion=<%=request.getAttribute("diasAtencion")%>&horasAtencion=<%=request.getAttribute("horasAtencion")%>&nomCan=<%=x.getNombre()%>&caracCan=<%=x.getCaracteristicas()%>&tarifaDiurna=<%=x.getTarifaDiurna()%>&tarifaNocturna=<%=x.getTarifaNocturna()%>&nomLocal=<%=x.getoLocal().getDesLoc()%>&promocion=<%=x.getPromo()%>&foto=<%=x.getFoto()%>"><%=x.getNombre()%></a></td>
	<td><%=x.getCaracteristicas()%></td>
	<td><%=x.getDiasAtencion()%></td>
	<td><%=x.getHorasAtencion()%></td>
	<td><%=x.getTarifaDiurna()%></td>
	<td><%=x.getTarifaNocturna()%></td>
	<td><%=x.getoLocal().getCodLoc()%></td>
	<td><%=x.getoLocal().getDistrito()%></td>
	<%if(horarios.size() > 0) {%>
	<td style="color:#FF0000;">NO DISPONIBLE</td>
	<%} else {%>
	<td style="color:#0000FF;">DISPONIBLE</td>
	<%}%>
	</tr>
	<%}} else {%>
	<tr>
	<td colspan="9">No se ha encontrado registros</td>
	</tr>
	<% }%>
  <!-- tr>
    <td><a href="teofilo.html">Te&oacute;filo &quot;Nene&quot; Cubillas</a></td>
    <td>Pasto sint&eacute;tico, futbol 6</td>
    <td>31/02/12</td>
    <td>07:00 a 08:00</td>
    <td>60</td>
    <td>Leyendas peruanas</td>
    <td>San Miguel</td>
    <td><input type="submit" name="Alquilar" id="Alquilar" value="Alquilar"  /></td>
  </tr>
  <tr>
    <td><a href="#">C&eacute;sar Cueto</a></td>
    <td>Pasto natural, f&uacute;tbol 7</td>
    <td>31/02/12</td>
    <td>18:00 a 19:00</td>
    <td>90</td>
    <td>Leyendas peruanas</td>
    <td>San Miguel</td>
    <td><input type="submit" name="Alquilar" id="Alquilar2" value="Alquilar" disabled="disabled"/></td>
  </tr -->
  </table>

</div></div><div id="piecera">Futbol Camp tiene todos los derechos &reg; reservados </div>
</body>
</html>