<%-- 
    Document   : index
    Created on : 01-mar-2016, 15:44:17
    Author     : josepplloo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

        <title>Concesionario</title>


    </head>
    <body>

        <div class="container">
            <h2>Concesionario</h2>

            <ul class="nav nav-tabs">
                <li><a data-toggle="tab" href="#home">Inicio</a></li>
                <li><a data-toggle="tab" href="#menu1">Carros</a></li>
                <li><a data-toggle="tab" href="#menu2">Clientes</a></li>
                <li><a data-toggle="tab" href="#menu3">Ventas</a></li>
            </ul>


            <div class="tab-content">   
                <div id="home" class="tab-pane fade <%=request.getAttribute("t1a")%>" >
                    <h3>Inicio</h3>
                    <p>Bienvenido a nuestro concesionario</p>
                </div>
                <div id="menu1" class="tab-pane fade <%=request.getAttribute("t2a")%>">

                    <h1>Car Information</h1>

                    <form action="./concesionarioServlet?cmd=carros" method="POST" enctype="multipart/form-data">
                        <table>
                            <tr>
                                <th>Matricula</th>
                                <th><input type="text" name="matricula" class="form-control" placeholder="matricula" value="${carro.matricula}"/> </th>
                            </tr>
                            <tr>
                                <th>Modelo</th>
                                <th> <input type="text" name="modelo" class="form-control" placeholder="modelo" value="${carro.modelo}"/></th>
                            </tr>
                            <tr>
                                <th>Fabricante</th>
                                <th><input type="text" name="fabricante" class="form-control" placeholder="fabricante" value="${carro.fabricante}"/> </th>
                            </tr>
                            <tr>
                                <th>Fecha</th>
                                <th> <input type="text" name="yearLevel" class="form-control" placeholder="fecha" value="${carro.fecha}"/></th>
                            </tr>
                            <tr>
                                <th>Cilindraje</th>
                                <th> <input type="text" name="cilindraje" class="form-control" placeholder="cilindraje" value="${carro.cilindraje}"/></th>
                            </tr>
                            <tr>
                                <th>Potencia</th>
                                <th> <input type="text" name="potencia" class="form-control" placeholder="potencia" value="${carro.potencia}"/></th>
                            </tr>
                            <tr>
                                <th>Precio</th>
                                <th> <input type="text" name="precio" class="form-control" placeholder="precio" value="${carro.precio}"/></th>
                            </tr>
                            <tr>
                                <th>Transmision</th>
                                <th> <input type="text" name="transmision" class="form-control" placeholder="transmision" value="${carro.transmision}"/></th>
                            </tr>
                            <tr>
                            <label class="control-label">Selecionar imagen</label>
                            <input id="input-2" name="imagen" type="file" class="file" multiple data-show-upload="false"
                                   data-caption="true">
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input type="submit" name="actioncarro" value="Agregar Carro"/>
                                    <input type="submit" name="actioncarro" value="Editar Carro"/>
                                    <input type="submit" name="actioncarro" value="Eliminar Carro"/>
                                    <input type="submit" name="actioncarro" value="Buscar Carro"/>
                                    <input type="submit" name="actioncarro" value="Ver Carros"/>

                                </td>
                            </tr>

                        </table>
                    </form>
                    <br>

                    <table border="1" class="table table-striped">

                        <th>Matricula</th>
                        <th>Modelo</th>
                        <th>Fabricante</th>
                        <th>Fecha</th>
                        <th>Cilindraje</th>
                        <th>Potencia</th>
                        <th>Precio</th>
                        <th>Transmision</th>

                        <c:forEach items="${getAllCarros}" var="car">
                            <tr>
                                <td>${car.matricula}</td>
                                <td>${car.modelo}</td>
                                <td>${car.fabricante}</td>
                                <td>${car.fecha}</td>
                                <td>${car.cilindraje}</td>
                                <td>${car.potencia}</td>
                                <td>${car.precio}</td>
                                <td>${car.transmision}</td>
                                <td><img src="http://localhost:8080/imagenes/${car.matricula}.jpg" alt="no encontrado "/></td>

                            </tr>
                        </c:forEach>



                    </table>
                </div><!-- cierro el contenedor de carros -->

                <div id="menu2" class="tab-pane fade <%=request.getAttribute("t3a")%>">

                    <h1>Client Information</h1>

                    <form action="./concesionarioServlet?cmd=clientes" method="POST">
                        <table>
                            <tr>
                                <th>Identificación</th>
                                <th><input type="text" name="id" class="form-control" placeholder="nombre" value="${cliente.id}"/> </th>
                            </tr>
                            <tr>
                                <th>Nombre</th>
                                <th><input type="text" name="nombre" class="form-control" placeholder="nombre" value="${cliente.nombre}"/> </th>
                            </tr>
                            <tr>
                                <th>Apellido</th>
                                <th> <input type="text" name="apellido" class="form-control" placeholder="apellido" value="${cliente.apellido}"/></th>
                            </tr>
                            <tr>
                                <th>Edad</th>
                                <th><input type="text" name="edad" class="form-control" placeholder="edad" value="${cliente.edad}"/> </th>
                            </tr>
                            <tr>
                                <th>Direccion</th>
                                <th> <input type="text" name="direccion" class="form-control" placeholder="direccion" value="${cliente.direccion}"/></th>
                            </tr>
                            <tr>
                                <th>Teléfono</th>
                                <th> <input type="text" name="telefono" class="form-control" placeholder="telefono" value="${cliente.telefono}"/></th>
                            </tr>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input type="submit" name="actioncliente" value="Agregar Cliente"/>
                                    <input type="submit" name="actioncliente" value="Editar Cliente"/>
                                    <input type="submit" name="actioncliente" value="Eliminar Cliente"/>
                                    <input type="submit" name="actioncliente" value="Buscar Cliente"/>
                                    <input type="submit" name="actioncliente" value="Ver Clientes"/>

                                </td>
                            </tr>

                        </table>
                    </form>
                    <br>

                    <table border="1" class="table table-striped">

                        <th>Identificación</th>
                        <th>Nombre</th>
                        <th>Apellido</th>
                        <th>Edad</th>
                        <th>Dirección</th>
                        <th>Teléfono</th>


                        <c:forEach items="${getAllClientes}" var="cli">
                            <tr>
                                <td>${cli.id}</td>
                                <td>${cli.nombre}</td>
                                <td>${cli.apellido}</td>
                                <td>${cli.edad}</td>
                                <td>${cli.direccion}</td>
                                <td>${cli.telefono}</td>

                            </tr>
                        </c:forEach>

                    </table>
                    </form>
                    <br>                  
                </div><!-- cierro el contenedor de cliente -->

                <div id="menu3" class="tab-pane fade <%=request.getAttribute("t4a")%>">

                    <h1>sell Information</h1>

                    <form action="./concesionarioServlet?cmd=ventas" method="POST">
                        <table>
                            <tr>
                                <th>Numero de la Venta</th>
                                <th><input type="text" name="ventaid" class="form-control" placeholder="ventaid" value="${venta.ventaid}"/> </th>
                            </tr>
                            <tr>
                                <th> Cliente</th>
                                <th><input type="text" name="clienteid" class="form-control" placeholder="clienteid" value="${venta.clienteid}" readonly="true"/> </th>
                            </tr>
                            <tr>
                                <th> Carro</th>
                                <th><input type="text" name="matriculaid" class="form-control" placeholder="matriculaid" value="${venta.matricula}" readonly="true"/> </th>
                            </tr>
                            <tr>
                                <th>Cliente</th>
                                <th>
                                    <select name="clientes">
                                        <c:forEach items="${clientes}" var="cliente">
                                            <option value="${cliente.id}">${cliente.id}</option>
                                        </c:forEach>
                                    </select>
                                </th>
                            </tr>
                            <tr>
                                <th>Carro</th>
                                <th>
                                    <select name="carros">
                                        <c:forEach items="${carros}" var="carros">
                                            <option value="${carros.matricula}">${carros.matricula}</option>
                                        </c:forEach>
                                    </select>
                                </th>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input type="submit" name="actionventa" value="Agregar Venta"/>
                                    <input type="submit" name="actionventa" value="Editar Venta"/>
                                    <input type="submit" name="actionventa" value="Eliminar Venta"/>
                                    <input type="submit" name="actionventa" value="Buscar Venta"/>
                                    <input type="submit" name="actionventa" value="Ver ventas"/>

                                </td>
                            </tr>

                        </table>
                    </form>
                    <br>

                    <table border="1" class="table table-striped">

                        <th>Número de la venta</th>
                        <th>Matricula</th>
                        <th>Cliente</th>


                        <c:forEach items="${getAllVentas}" var="venta">
                            <tr>
                                <td>${venta.ventaid}</td>
                                <td>${venta.matricula}</td>
                                <td>${venta.clienteid}</td>

                            </tr>
                        </c:forEach>

                    </table>
                    </form>
                </div>
            </div><!-- cierro el contenedor de pestañas -->
        </div><!-- cierro el contenedor general -->
    </body>
</html>

