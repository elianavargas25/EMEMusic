
<%HttpSession sesionOk = request.getSession();
    sesionOk.invalidate(); %>
<%
    /*vamos a entregar la respuesta del servlet en la pagina JSP
   * página JSP
     */
    String mensajeError = (String) request.getAttribute("mensajeError");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="styles/loguin.css">
<form name="Ingreso" accept-charset="UTF-8"
      autocomplete="off" method="post"
      action="./ValidacionServlet" >
    <div class="home_background_container prlx_parent">
        <div class="home_background prlx" style="background-image:url(images/slider_background.jpg)"></div>
    </div>
    <h1><%=mensajeError == null ? "" : mensajeError%></h1>
    <h1>Ingresar al Sistema</h1>
    <div class="inset">
        <p>
            <label for="Username">Usuario</label>
            <input type="text" id="Username" name="Usuario" required="required" maxlength="8">
        </p>
        <p>
            <label for="password">Password</label>
            <input type="Password" id="Password" name="Clave" required="required" maxlength="8">
        </p>

    </div>
    <p class="p-container">
        <button id="login" type="submit" class="btn bg-info"
                value="Ingresar" name="action" tabindex="3"  >Login</button>
    </p>
</form>