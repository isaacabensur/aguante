<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Red social para alquiler de canchas de futbol</title>
<link href="styles/estilos.css" rel="stylesheet" type="text/css" />

 <script>
       function validar(){
        
		 
		 
		  if (document.f1.distrito.value == ""){
           
				alert("Ingresa el distrito");
          		document.f1.distrito.focus();
    		   
		    return false;
         }	

		  if (document.f1.diasAtencion.value == ""){
           
				alert("Ingresa tus nombres");
          		document.f1.nombres.focus();
    		   
		    return false;
         }
		 
		 if (document.f1.paterno.value == ""){
           
				alert("Ingresa tu apellido paterno");
          		document.f1.paterno.focus();
    		   
		    return false;
         }
			 		 

         return true;
       }
    </script>

</head>

<body>
<div id="contenedorPrincipal">
  <div id="cabecera">
    <div id="logo"><a href="index.html"><img src="imagenes/logo.jpg" alt="Futbol Camp" width="167" height="120" border="0" /></a></div>
</div>
  <div id="barraSuperior">
    
  </div>
<div id="cuerpo">
    <h3>Mis alquileres</h3>
    
    <form action="" method="get">
      <table width="100%" border="0" cellspacing="0" cellpadding="3">
        <tr>
          <td width="29%" align="right" valign="middle"><label for="distrito">Local</label></td>
          <td width="71%"><select name="distrito" id="distrito">
            <option selected="selected">Seleccionar</option>
           
          </select></td>
        </tr>
        <tr>
          <td align="right" valign="middle"><label for="diasAtencion">Fecha de inicio</label></td>
          <td>
            <select name="diasAtencion" id="diasAtencion">
              <option selected="selected">Seleccionar</option>
              <option value="l-v">Lunes a Viernes</option>
              <option value="l-s">Lunes a Sábado</option>
              <option value="l-d">Lunes a Domingo</option>
          </select></td>
        </tr>
        <tr>
          <td align="right" valign="middle"><label for="horasAtencion">Fecha de fin</label></td>
          <td>
            <select name="horasAtencion" id="horasAtencion">
              <option selected="selected">Seleccionar</option>
              <option value="06:00-17:00">06:00 a 17:00</option>
              <option value="08:00-19:00">08:00 a 19:00</option>
              <option value="09:00-20:00">09:00 a 20:00</option>
              <option value="09:00-22:00">09:00 a 22:00</option>
              <option value="10:00-23:00">10:00 a 23:00</option>
          </select></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><br />            <input type="submit" name="buscar" id="buscar" value="Buscar alquileres" /></td>
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
    <th scope="col">Características</th>
    <th scope="col">Dias de atención</th>
    <th scope="col">Horas de atención</th>
    <th scope="col">Tarifa</th>
    <th scope="col">Local</th>
    <th scope="col">Distrito</th>
    <th scope="col">Disponibilidad</th>

  </tr>
  <tr>
    <td><a href="teofilo.html">Teófilo &quot;Nene&quot; Cubillas</a></td>
    <td>Pasto sintético, futbol 6</td>
    <td>Lunes a Viernes</td>
    <td>10:00 a 23:00</td>
    <td>80</td>
    <td>Leyendas peruanas</td>
    <td>San Miguel</td>
    <td>Si</td>
  </tr>
  <tr>
    <td>César Cueto</td>
    <td>Pasto natural, fútbol 7</td>
    <td>Lunes a Sábado</td>
    <td>09:00 a 20:00</td>
    <td>90</td>
    <td>Leyendas peruanas</td>
    <td>San Miguel</td>
    <td>No</td>
  </tr>
  </table>

</div></div><div id="piecera">Futbol Camp tiene todos los derechos ® reservados  </div>
</body>
</html>