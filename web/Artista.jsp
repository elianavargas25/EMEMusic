<%@page import="com.project.ememusic.entidad.Artistas"%>
<%@page import="com.project.ememusic.entidad.Usuarios"%>
<%@page import="com.project.ememusic.persistencia.DaoEmpresa"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="com.project.ememusic.persistencia.DaoTipoDocumento"%>
<%@page import= "java.util.*" session="true"%>

<!DOCTYPE html>
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
    DaoTipoDocumento daoTDocu = new DaoTipoDocumento();
    ResultSet tdocu = daoTDocu.tipoDoc();
    DaoEmpresa daoEmpre = new DaoEmpresa();
    ResultSet empre = daoEmpre.idEmpresa();
    String idArtista;
    String TipoDocumento = request.getParameter("cbotipodocumento");
    String NroDocumento = request.getParameter("txtnumdocumento");
    String PrimerNombre = request.getParameter("txtprimernombre");
    String SegundoNombre = request.getParameter("txtsegundonombre");
    String PrimerApellido = request.getParameter("txtprimerapellido");
    String SegundoApellido = request.getParameter("txtsegundopellido");
    String NombreArtistico = request.getParameter("txtnombreartistico");
    String Empresa = request.getParameter("cboempresa");
    String Estado = request.getParameter("optionStateS");//validar

    Artistas artista = request.getAttribute("datos") != null
            ? (Artistas) request.getAttribute("datos") : null;

    if (artista != null) {
        idArtista = artista.getIdArtista();
        TipoDocumento = artista.getTipoDocumento();
        NroDocumento = artista.getNroDocumento();
        PrimerNombre = artista.getPrimerNombre();
        SegundoNombre = artista.getSegundoNombre();
        PrimerApellido = artista.getPrimerApellido();
        SegundoApellido = artista.getSegundoApellido();
        NombreArtistico = artista.getNombreArtistico();
        Empresa = artista.getEmpresa();
        Estado = artista.getEstado();
    }
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
    </head>

    <body>

        <div class="super_container">

            <!-- Header -->

            <header class="header d-flex flex-row justify-content-end align-items-center trans_200">

                <!-- Logo -->
                <div class="logo mr-auto">
                    <a href="#">EME<span>MUSIC</span></a>
                </div>

                <!-- Navigation -->
                <%if (perfil.equals("Administrador")) {%> 
                <nav class="main_nav justify-self-end text-right">
                    <ul>
                        <li class="menu_mm active"><a href="Artista.jsp">Registro de Artistas</a></li>
                        <li class="menu_mm"><a href="Empresa.jsp">Registro de Empresas</a></li>
                        <li class="menu_mm"><a href="RegistrarVentas.jsp">Cargar Ventas</a></li>
                        <li class="menu_mm"><a href="Informes.jsp">Informes</a></li>
                        <li class="menu_mm"><a href="Administracion.jsp">Administración</a></li>
                        <h4 style="text-align: right">Usuario:    <%=nombre%></h4>
                        <a href="index.jsp">Cerrar sesión</a>
                    </ul>   
                </nav>
                <%} else {%>
                <nav class="main_nav justify-self-end text-right">
                    <ul>
                        <li class="menu_mm active"><a href="Artista.jsp">Registro de Artistas</a></li>
                        <li class="menu_mm"><a href="Empresa.jsp">Registro de Empresas</a></li>
                        <li class="menu_mm"><a href="RegistrarVentas.jsp">Cargar Ventas</a></li>
                        <li class="menu_mm"><a href="Informes.jsp">Informes</a></li>
                        <h4 style="text-align: right">Usuario:    <%=nombre%></h4>
                        <a href="index.jsp">Cerrar sesión</a>

                    </ul>   
                </nav>

                <%}%>

                <!-- Search -->
                <div class="search">
                    <div class="search_content d-flex flex-column align-items-center justify-content-center">
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
                        <li class="menu_mm"><a href="RegistrarVentas.jsp">Cargar Ventas</a></li>
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
                    <h2>Registro de Artistas</h2>
                    <center>  <h4><%=mensaje != null ? mensaje : ""%></h4><br> </center>
                    <div class="next_section_scroll">
                        <div class="next_section nav_links" data-scroll-to=".icon_boxes">
                            <i class="fas fa-chevron-down trans_200"></i>
                            <i class="fas fa-chevron-down trans_200"></i>
                        </div>
                    </div>
                </div>

            </div>


            <br>

            <center>  <h4><%=mensaje != null ? mensaje : ""%></h4><br> </center>

            <div class="row contact_row">
                <div class="content-box-gray">
                    <div class="col-lg-8">

                        <!-- Reply -->

                        <div class="Reply">


                            <div class="reply_form">

                                <!-- Reply Form -->
                                <form name="Artista" method="Post" id="Artista"
                                      action="./MaestroArtista" autocomplete="off" class="bod">
                                   
                                    <div>
                                        <center>
                                            <select id="cboDocument" name="cbotipodocumento" value="<%=TipoDocumento != null ? TipoDocumento : ""%>" class="input_field reply_form_email" type="select"  required="required" 
                                                    title="Seleccione el tipo de documento">
                                                <option value="0" disabled selected="true">Seleccione</option>
                                                <%while (tdocu.next()) {%>
                                                <option value="<%= tdocu.getString(1)%>"><%=tdocu.getString(2)%></option>      
                                                <% }%></select>
                                                <input id="nroDocument" name="txtnumdocumento" value="<%=NroDocumento != null ? NroDocumento : "" %>" class="input_field reply_form_name" type="text" placeholder="Número de Documento *"   maxlength="15" min="3" required="required" data-error="Name is required.">
                                            <br>
                                            <input id="firstName"  name="txtprimernombre" value="<%=PrimerNombre != null ? PrimerNombre : ""%>" onkeyup = "this.value = this.value.toUpperCase()" class="input_field reply_form_email" type="text" placeholder="Primer Nombre *"  required="required" data-error="Valid Primer Nombre is required." onkeypress="return soloLetras()(event)" maxlength="15" min="3">
                                            <input id="secondName" name="txtsegundonombre" value="<%=SegundoNombre != null ? SegundoNombre : ""%>"onkeyup = "this.value = this.value.toUpperCase()"class="input_field reply_form_name"  maxlength="15" min="3" type="text" placeholder="Segundo Nombre" onkeypress="return soloLetras(event)"><br>
                                            <input id="firstLastname" name="txtprimerapellido" value="<%=PrimerApellido != null ? PrimerApellido : ""%>" onkeyup = "this.value = this.value.toUpperCase()" class="input_field reply_form_email" onkeypress="return soloLetras(event)" maxlength="15" min="3" type="text" placeholder="Primer Apellido *" required="required" data-error="Valid Primer Apellido is required.">
                                            <input id="secondLastname" name="txtsegundopellido" value="<%=SegundoApellido != null ? SegundoApellido : ""%>" onkeyup = "this.value = this.value.toUpperCase()"class="input_field reply_form_name" onkeypress="return soloLetras(event)" maxlength="15" min="3" type="text" placeholder="Segundo Apellido" data-error="Name is required."><br>
                                            <input id="stageName" name="txtnombreartistico" value="<%=NombreArtistico != null ? NombreArtistico : ""%>" onkeyup = "this.value = this.value.toUpperCase()"class="input_field reply_form_email" type="text" placeholder="Nombre Artistico *" required="required" data-error="Valid Nombre Artistico is required.">
                                            <select id="company " name="cboempresa" value="<%=Empresa != null ? Empresa : ""%>"class="input_field reply_form_name" type="select" placeholder="Empresa *" 
                                            <input id="stageName" name="txtnombreartistico" value="<%=NombreArtistico != null ? NombreArtistico : ""%>" onkeyup = "this.value = this.value.toUpperCase()"class="input_field reply_form_email" type="text" placeholder="Nombre Artistico *" required="required" data-error="Valid Nombre Artistico is required.">
                                            <select id="company " name="cboempresa" value="<%=Empresa != null ? Empresa : ""%>"class="input_field reply_form_name" type="select" placeholder="Empresa *" 
                                                    title="Seleccione el tipo de documento">
                                                <option value="0" disabled selected="true">Seleccione</option>
                                                <%while (empre.next()) {%>
                                                <option value="<%= empre.getString(1)%>"><%=empre.getString(2)%></option>      
                                                <% }%></select>
                                        </center>
                                        <div class="reply_form_email" value="<%=Estado != null ? Estado : ""%>" name="optestado" aria-hidden="true">Activo</div>
                                        <label class="reply_form_email radio-inline"><input type="radio" name="optionStateS" value="S">Si</label>
                                        <label class="reply_form_email radio-inline"><input type="radio" name="optionStateS" value="N">No</label>

                                    </div>

                                    <div class="Reply">
                                        <button id="save" type="submit" class="btn bg-info" name="action" value="Guardar">Guardar</button>
                                        <%if (perfil.equals("Administrador")) {%> 
                                        <button id="edit" type="submit" class="btn bg-info"  name="action" value="modificar">Modificar</button>
                                        <%}%>
                                        <button id="search" type="submit" class="btn bg-info" name="action" value="Buscar">Buscar</a></button>
                                        <button id="exit" type="submit" class="btn bg-info" name="action" value="Cancelar">Cancelar</a></button>


                                    </div>

                                </form>


                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <br>








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