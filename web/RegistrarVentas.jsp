<%@page import="com.project.ememusic.entidad.Ventas"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.project.ememusic.persistencia.DaoArtista"%>
<%@page import="com.project.ememusic.entidad.Usuarios"%>
<%@page import="com.project.ememusic.persistencia.DaoEmpresa"%>
<%@page import="java.sql.ResultSet"%>
<%@page import= "java.util.*" session="true"%>

<!DOCTYPE html>
<%  List<Ventas> listaVentas = request.getAttribute("lista")
            != null ? (List<Ventas>) request.getAttribute("lista") : null;%>

<%
    String id_usu = "";
    String perfil = "";
    String nombre = "";
    Usuarios tec = new Usuarios();
    if (session.getAttribute("usuario") != null) {
        tec = (Usuarios) session.getAttribute("usuario");
        id_usu = tec.getIdUsuario();
        nombre = (String) (tec.getNombre());
        perfil = tec.getPerfil();
    }
    Date fecha = new Date();
    SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
    String fechaActual = format.format(fecha);
    DaoEmpresa daoEmpre = new DaoEmpresa();
    ResultSet empre = daoEmpre.idEmpresa();
    DaoArtista daoArtis = new DaoArtista();
    ResultSet artis = daoArtis.idArtista();
    String mensaje = request.getAttribute("mensaje") != null
            ? (String) request.getAttribute("mensaje") : null;
%>

<script>
    function soloLetras(e) {
        key = e.keyCode || e.which;
        tecla = String.fromCharCode(key).toString();
        letras = " áéíóúabcdefghijklmnñopqrstuvwxyzÁÉÍÓÚABCDEFGHIJKLMNÑOPQRSTUVWXYZ";//Se define todo el abecedario que se quiere que se muestre.
        especiales = [8, 37, 39, 46, 6]; //Es la validación del KeyCodes, que teclas recibe el campo de texto.

        tecla_especial = false
        for (var i in especiales) {
            if (key == especiales[i]) {
                tecla_especial = true;
                break;
            }
        }

        if (letras.indexOf(tecla) == -1 && !tecla_especial) {
            alert('Tecla no aceptada');
            return false;
        }
    }

    function soloNumeros(e) {
        key = e.keyCode || e.which;
        tecla = String.fromCharCode(key).toString();
        letras = "0123456789";//Se define todo el abecedario que se quiere que se muestre.
        especiales = [8, 37, 39, 46, 6]; //Es la validación del KeyCodes, que teclas recibe el campo de texto.

        tecla_especial = false
        for (var i in especiales) {
            if (key == especiales[i]) {
                tecla_especial = true;
                break;
            }
        }

        if (letras.indexOf(tecla) == -1 && !tecla_especial) {
            alert('Tecla no aceptada');
            return false;
        }
    }

</script>

<html lang="es">
    <head>
        <title>EME MUSIC</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="RanGO Project">
        <meta name="viewport" content="width=device-width, initial-scale=1">
       <link rel="stylesheet" type="text/css" href="styles/Caja.css">
        <link rel="stylesheet" type="text/css" href="styles/btn.css">
        <link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
        <link href="plugins/fontawesome-free-5.0.1/css/fontawesome-all.css" rel="stylesheet" type="text/css">

        <link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
        <link href="plugins/fontawesome-free-5.0.1/css/fontawesome-all.css" rel="stylesheet" type="text/css">
        <link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="styles/contact_styles.css">
        <link rel="stylesheet" type="text/css" href="styles/contact_responsive.css">
        <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.carousel.css">
        <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
        <link rel="stylesheet" type="text/css" href="plugins/OwlCarousel2-2.2.1/animate.css">
        <link rel="stylesheet" type="text/css" href="plugins/slick-1.8.0/slick.css">
        <link rel="stylesheet" type="text/css" href="styles/about_styles.css">
        <link rel="stylesheet" type="text/css" href="styles/about_responsive.css">
        <link rel="stylesheet" type="text/css" href="styles/EstilosNav.css">
        <link href="css/EstiloNav.css"  media="screen" rel="stylesheet" type="text/css">
    </head>

    <body>

        <div class="super_container">

            <!-- Header -->

            <header class="header d-flex flex-row justify-content-end align-items-center trans_200">

                <!-- Logo -->
                <div class="logo mr-auto">
                    <a href="#">EME<spa>MUSIC</spa></a>
                </div>

               <%if (perfil.equals("Administrador")) {%> 
                <jsp:include page="Smenu.jsp" flush="false"></jsp:include>
                <%} else {%>
                <jsp:include page="Smenu_1.jsp" flush="false"></jsp:include>
                
                <%}%>
                <!-- Search -->
                <div class="search">
                    <div class="search_content d-flex flex-column align-items-center justify-content-center">
                        <h4 style="text-height: right">Usuario:    <%=nombre%></h4>
                        <a href="index.jsp">Cerrar sesión</a>
                        <div class="search_button d-flex flex-column align-items-center justify-content-center">
                            <svg version="1.1" id="Layer_1" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"
                                 width="18px" height="18px" viewBox="0 0 100 100" enable-background="new 0 0 100 100" xml:space="preserve">


                            </svg>
                        </div>

                        <form id="search_form" class="search_form bez_1">
                            <input type="search" class="search_input bez_1">
                        </form>

                    </div>
                </div>
                </nav>

                <!-- Hamburger -->
                <div class="hamburger_container bez_1">
                    <i class="fas fa-bars trans_200"></i>
                </div>

            </header>

            <!-- Menu -->

            <div class="menu_container">
                <div class="menu menu_mm text-right">
                    <div class="menu_close"><i class="far fa-times-circle trans_200"></i></div>
                    <ul class="menu_mm">
                        <li class="menu_mm"><a href="index.jsp">Home</a></li>
                        <li class="menu_mm active"><a href="Artista.jsp">Registro de Artistas</a></li>
                        <li class="menu_mm"><a href="Empresa.jsp">Registro de Emresas</a></li>
                        <li class="menu_mm"><a href="RegistrarVentas.jsp">Registro Ventas</a></li>
                        <li class="menu_mm"><a href="Informes.jsp">Informes</a></li>
                        <li class="menu_mm"><a href="Administracion.jsp">Administración</a></li>
                    </ul>
                </div>
            </div>

            <!-- Home -->
            <div class="home">
                <div class="home_background_container prlx_parent">
                    <div class="home_background prlx" style="background-image:url(images/home_background.jpg)"></div>
                </div>

                <div class="home_title">
                  
                    <div class="next_section_scroll">
                        
                        <h1>Registro de Ventas </h1>
                      </div>
                    <div><center>  <h2><%=mensaje != null ? mensaje : ""%></h2></center></div>

                </div>


            </div>
                    <br>
                    <br>
                    
               <form name="Ventas" method="Post" id="Ventas"
                  action="./MaestroVentas" autocomplete="off" class="bod">    
                <div class="content-box-gray">
                    <div class="col-lg-8">

                        <!-- Reply -->

                        <div class="Reply">


                            <div class="reply_form">

                                <!-- Reply Form -->


                                <div>
                                    <center>
                                        <select id="company " name="cboempresa" class="input_field reply_form_name" type="select" placeholder="Empresa *" 
                                                title="Seleccione la empresa" >
                                            <option value="0" disabled selected="true">Seleccione la empresa</option>
                                            <%while (empre.next()) {%>
                                            <option value="<%= empre.getString(1)%>"><%=empre.getString(2)%></option>      
                                            <% }%></select>

                                        <select id="company " name="cboartista" class="input_field reply_form_label" type="select" placeholder="Artista *" 
                                                title="Seleccione el Artista" >
                                            <option value="0" disabled selected="true">Seleccione</option>
                                            <%while (artis.next()) {%>
                                            <option value="<%= artis.getString(1)%>"><%=artis.getString(2)%></option>      
                                            <% }%></select>

                                        <input id="stageName" name="txtreproduccion" value="" onkeyup = "this.value = this.value.toUpperCase()
                                               "class="input_field reply_form_name"  onkeypress="return soloNumeros(event)" type="text" placeholder="Cantidad de reproducciones *"  data-error="">

                                        <input name="txtfecharegistro" type="text" readonly="readonly" class="input_field reply_form_label" 
                                               value="<%=fechaActual%>"
                                               maxlength="15" tabindex="2">

                                    </center> 
                                </div>
                                <br>

                                <div class="Reply">
                                    <button id="save" type="submit" class="btn bg-info" name="action" value="Guardar">Guardar</button>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
               <br>
               <br>
                 
               <%if (listaVentas != null) {%>
                <div class="content-box-purple">
                    <div class="container">
                        <div class="row">

                            <div class="col-lg-8">
                                <div class="table container">
                                    
                                    <%if (listaVentas != null) {%>
                                    <table border="0" id="tabla" class="table">
                                        <tbody class="table-responsive">
                                            <tr class="active" >
                                                <th>Nombre Artistico</th>
                                                <th>Nombre Empresa</th>
                                                <th>Cantidad Reproducciones</th>
                                            </tr> 
                                            <%for (Ventas infor : listaVentas) {%>
                                            <tr>
                                                <td><%=infor.getIdArtista()%></td>
                                                <td><%=infor.getIdEmpresa()%></td>
                                                <td><%=infor.getReproduccion()%></td>
                                            </tr>
                                            <%}%>
                                        </tbody>
                                    </table>
                                    <%}%>
                                    
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%}%>
                 <br>
                <br>
            </form>
            
            <script src="js/jquery-3.2.1.min.js"></script>
            <script src="styles/bootstrap4/popper.js"></script>
            <script src="styles/bootstrap4/bootstrap.min.js"></script>
            <script src="plugins/greensock/TweenMax.min.js"></script>
            <script src="plugins/greensock/TimelineMax.min.js"></script>
            <script src="plugins/scrollmagic/ScrollMagic.min.js"></script>
            <script src="plugins/greensock/animation.gsap.min.js"></script>
            <script src="plugins/greensock/ScrollToPlugin.min.js"></script>
            <script src="plugins/slick-1.8.0/slick.js"></script>
            <script src="plugins/OwlCarousel2-2.2.1/owl.carousel.js"></script>
            <script src="plugins/scrollTo/jquery.scrollTo.min.js"></script>
            <script src="plugins/easing/easing.js"></script>
            <script src="js/about_custom.js"></script>
    </body>

</html>