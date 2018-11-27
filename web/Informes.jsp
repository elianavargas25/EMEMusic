<%@page import="com.project.ememusic.entidad.InfoInformes"%>
<%@page import="com.project.ememusic.entidad.Usuarios"%>
<%@page import= "java.util.*" session="true"%>

<!DOCTYPE html>
<%  List<InfoInformes> listaInforme = request.getAttribute("lista")
            != null ? (List<InfoInformes>) request.getAttribute("lista") : null;%>
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
    int filtro = 0;
    if (request.getParameter("Filtro") != null) {
        filtro = Integer.parseInt(request.getParameter("Filtro"));
    }

    String mensaje = request.getAttribute("mensaje") != null
            ? (String) request.getAttribute("mensaje") : null;
%>
<html lang="en">
    <head>
        <title>EME MUSIC - Informes</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="description" content="RanGO Project">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="styles/bootstrap4/bootstrap.min.css">
        <link href="plugins/fontawesome-free-5.0.1/css/fontawesome-all.css" rel="stylesheet" type="text/css">
        <link href="plugins/colorbox/colorbox.css" rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css" href="styles/Caja.css">
        <link rel="stylesheet" type="text/css" href="styles/blog_styles.css">
        <link rel="stylesheet" type="text/css" href="styles/blog_responsive.css">
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
                        <li class="menu_mm"><a href="RegistrarVentas.jsp">Registrar Ventas</a></li>
                        <li class="menu_mm"><a href="Informes.jsp">Informes</a></li>
                        <li class="menu_mm">Administración
                            <ul>
                                <li class="menu_mm"><a href="Parametros.jsp">Parámetros</a></li>
                                <li class="menu_mm"><a href="Usuarios.jsp">Usuarios</a></li>
                                <li class="menu_mm"><a href="Auditoria.jsp">Log Auditoria</a></li>
                            </ul>
                        </li>
                        <h4 style="text-align: right">Usuario:    <%=nombre%></h4>
                        <a href="index.jsp">Cerrar sesión</a>
                    </ul>   
                </nav>
                <%} else {%>
                <nav class="main_nav justify-self-end text-right">
                    <ul>
                        <li class="menu_mm active"><a href="Artista.jsp">Registro de Artistas</a></li>
                        <li class="menu_mm"><a href="Empresa.jsp">Registro de Empresas</a></li>
                        <li class="menu_mm"><a href="RegistrarVentas.jsp">Registrar Ventas</a></li>
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
                            <g>
                            <g>
                            <path class="search_path" fill="#FFFFFF" d="M89.354,10.609c-14.144-14.146-37.157-14.146-51.301,0c-6.852,6.853-10.625,15.964-10.625,25.655
                                  c0,8.829,3.132,17.174,8.87,23.771l-4.32,4.321l-4.402-4.403c-0.482-0.482-1.137-0.754-1.819-0.754s-1.337,0.271-1.819,0.754
                                  L3.31,80.584c-2.148,2.147-3.331,5.004-3.331,8.042s1.183,5.895,3.331,8.042C5.457,98.817,8.313,100,11.35,100
                                  c3.038,0,5.894-1.184,8.041-3.331l20.627-20.631c0.482-0.482,0.753-1.137,0.753-1.819s-0.271-1.337-0.753-1.819l-4.403-4.403
                                  l4.322-4.322c6.795,5.902,15.28,8.855,23.766,8.855c9.289,0,18.579-3.537,25.65-10.61c6.852-6.853,10.625-15.963,10.625-25.654
                                  C99.979,26.573,96.205,17.462,89.354,10.609z M15.753,93.029c-1.176,1.177-2.739,1.824-4.403,1.824
                                  c-1.663,0-3.227-0.648-4.403-1.824c-1.176-1.176-1.823-2.74-1.823-4.403s0.647-3.228,1.824-4.403L18.458,72.71l8.805,8.807
                                  L15.753,93.029z M30.902,77.878l-8.805-8.807l3.659-3.66l8.806,8.808L30.902,77.878z M85.715,58.28
                                  c-12.137,12.14-31.886,12.14-44.023,0c-5.88-5.881-9.118-13.699-9.118-22.016c0-8.316,3.238-16.135,9.118-22.016
                                  c6.069-6.069,14.041-9.104,22.012-9.104c7.972,0,15.943,3.035,22.013,9.104c5.88,5.881,9.117,13.699,9.117,22.016
                                  S91.596,52.399,85.715,58.28z"></path>
                            </g>
                            </g>
                            <g>
                            <g>
                            <path class="search_path" fill="#FFFFFF" d="M81.47,18.495c-9.797-9.798-25.736-9.798-35.533,0c-9.796,9.798-9.796,25.741,0,35.539
                                  c4.898,4.898,11.333,7.349,17.766,7.349c6.435,0,12.868-2.45,17.767-7.349l0,0C91.266,44.235,91.266,28.293,81.47,18.495z
                                  M77.831,50.395c-7.79,7.791-20.466,7.791-28.256,0c-7.79-7.792-7.79-20.469,0-28.261c3.896-3.896,9.011-5.843,14.128-5.843
                                  c5.116,0,10.233,1.948,14.128,5.843C85.621,29.925,85.621,42.603,77.831,50.395z"></path>
                            </g>
                            </g>
                            <g>
                            <g>
                            <path class="search_path" fill="#FFFFFF" d="M73.283,26.683c-5.282-5.283-13.877-5.283-19.16,0c-1.004,1.005-1.004,2.634,0,3.639
                                  c1.005,1.005,2.634,1.005,3.639,0c3.276-3.276,8.607-3.276,11.884,0c0.502,0.503,1.16,0.754,1.818,0.754
                                  c0.659,0,1.317-0.251,1.819-0.754C74.288,29.317,74.288,27.688,73.283,26.683z"></path>
                            </g>
                            </g>
                            </svg>
                        </div>

                        <form id="search_form" class="search_form bez_1">
                            <input type="search" class="search_input bez_1">
                        </form>

                    </div>
                </div>

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
                        <li class="menu_mm"><a href="RegistrarVentas.jsp">Registrar Ventas</a></li>
                        <li class="menu_mm"><a href="Informes.jsp">Informes</a></li>
                        <li class="menu_mm"><a href="Administracion.jsp">Administración</a></li>
                    </ul>
                </div>
            </div>

            <!-- Home -->

            <div class="home">
                <div class="home_background_container prlx_parent">
                    <div class="home_background prlx" style="background-image:url(images/blog_background.jpg)"></div>
                </div>

                <div class="home_title">
                    <h2>Informes</h2>
                    <center>  <h4><%=mensaje != null ? mensaje : ""%></h4><br> </center>
                    <div class="next_section_scroll">
                        <div class="next_section nav_links" data-scroll-to=".blog">
                            <i class="fas fa-chevron-down trans_200"></i>
                            <i class="fas fa-chevron-down trans_200"></i>
                        </div>
                    </div>
                </div>

            </div>

            <!-- Blog -->
            <form name="Informes" method="Post" id="Informes"
                  action="./MaestroInformes" autocomplete="off" class="bod">

                <div class="blog">
                    <div class="content-box-green">
                        <br>
                        <div class="container">
                            <div class="row">

                                <div class="col-lg-8">

                                    <div class="blog_container">
                                        <div class="sidebar">

                                            <div class="sidebar_search_container">

                                                <!-- Sidebar Search -->
                                                <div>
                                                    <select id="Filtro" name="Filtro" type="text" class="sidebar_search_input" align="Center">
                                                        <option value="0" >Seleccione</option>
                                                        <option value="1" >Dinero ganado por artista</option>
                                                        <option value="2" >Artistas con premio</option>
                                                        <option value="3" >Ventas por empresa</option>
                                                    </select>
                                                    <br>
                                                    <label><b>Fecha Desde</b></label>
                                                    <input id="dateFrom" name="txtDateFrom"   type="date" class="search_input date">
                                                    <br>
                                                    <label><b>Fecha Hasta</b></label>
                                                    <input id="dateTo" name="txtDateTo" type="date" class="search_input date">
                                                </div>
                                                <div>
                                                    <br>
                                                    <button id="search" type="submit" class="btn bg-info" name="action" value="Buscar">Buscar</a></button>
                                                    <button id="exit" type="submit" class="btn bg-info" name="action" value="Cancelar">Cancelar</a></button>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <br>
                <%if (listaInforme != null) {%>
                <div class="content-box-purple">
                    <div class="container">
                        <div class="row">

                            <div class="col-lg-8">
                                <div class="table container">
                                    <%if (filtro == 1) {%>
                                    <%if (listaInforme != null) {%>
                                    <table border="0" id="tabla" class="table">
                                        <tbody class="table-responsive">
                                            <tr class="active" >
                                                <th>Nombre Artistico</th>
                                                <th>Nombre Empresa</th>
                                                <th>Cantidad Reproducciones</th>
                                                <th>total ganado</th>
                                            </tr> 
                                            <%for (InfoInformes infor : listaInforme) {%>
                                            <tr>
                                                <td><%=infor.getArtista().getNombreArtistico()%></td>
                                                <td><%=infor.getEmpresa().getNombre()%></td>
                                                <td><%=infor.getVenta().getReproduccion()%></td>
                                                <td><%=infor.getVenta().getTotalGanado()%></td>

                                            </tr>
                                            <%}%>
                                        </tbody>
                                    </table>
                                    <%}%>
                                    <%}%>
                                    <%if (filtro == 2) {%>
                                    <%if (listaInforme != null) {%>
                                    <table border="0" id="tabla" class="table">
                                        <tbody class="table-responsive">
                                            <tr class="active" >
                                                <th>Nombre Artistico</th>
                                                <th>Nombre Empresa</th>
                                                <th>Cantidad Reproducciones</th>
                                                <th>total ganado</th>
                                            </tr> 
                                            <%for (InfoInformes infor : listaInforme) {%>
                                            <tr>
                                                <td><%=infor.getArtista().getNombreArtistico()%></td>
                                                <td><%=infor.getEmpresa().getNombre()%></td>
                                                <td><%=infor.getVenta().getReproduccion()%></td>
                                                <td><%=infor.getVenta().getTotalGanado()%></td>

                                            </tr>
                                            <%}%>
                                        </tbody>
                                    </table>
                                    <%}%>
                                    <%}%>
                                    <%if (filtro == 3) {%>
                                    <%if (listaInforme != null) {%>
                                    <table border="0" id="tabla" class="table">
                                        <tbody class="table-responsive">
                                            <tr class="active" >
                                                <th>Nombre Empresa</th>
                                                <th>Cantidad Reproducciones</th>
                                                <th>total ganado</th>
                                            </tr> 
                                            <%for (InfoInformes infor : listaInforme) {%>
                                            <tr>
                                                <td><%=infor.getEmpresa().getNombre()%></td>
                                                <td><%=infor.getVenta().getReproduccion()%></td>
                                                <td><%=infor.getVenta().getTotalGanado()%></td>

                                            </tr>
                                            <%}%>
                                        </tbody>
                                    </table>
                                    <%}%>
                                    <%}%>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                                <%}%>
            </form>
        </div>	
        <br>
    </div>

    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="styles/bootstrap4/popper.js"></script>
    <script src="styles/bootstrap4/bootstrap.min.js"></script>
    <script src="plugins/greensock/TweenMax.min.js"></script>
    <script src="plugins/greensock/TimelineMax.min.js"></script>
    <script src="plugins/scrollmagic/ScrollMagic.min.js"></script>
    <script src="plugins/greensock/animation.gsap.min.js"></script>
    <script src="plugins/greensock/ScrollToPlugin.min.js"></script>
    <script src="plugins/colorbox/jquery.colorbox-min.js"></script>
    <script src="plugins/scrollTo/jquery.scrollTo.min.js"></script>
    <script src="plugins/easing/easing.js"></script>
    <script src="plugins/masonry/masonry.js"></script>
    <script src="js/blog_custom.js"></script>
</body>

</html>