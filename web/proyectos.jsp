<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Administrador de Proyectos</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs/dt-1.10.12/datatables.min.css"/>
    <link rel="stylesheet" href="stylesheets/styles.css">
  </head>

  <body>
    <nav class="navbar navbar-inverse navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">AdmProyectos</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li><a href="home">Usuarios</a></li>
            <li class="active"><a href="proyectos">Proyectos</a></li>
            <li><a href="#">Dashboard</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#about"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a></li>
            <li><a href="index.jsp">Logout</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    <div class="container usuarios">
      <h2>Registro de Proyectos</h2>
      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalProyectos">Agregar Proyecto</button>
      <table id="tablaProyectos" class="table table-bordered table-striped">
        <thead>
          <tr>
            <th>#</th>
            <th>Nombre</th>
            <th>Descripci&oacute;n</th>
            <th>Encargado</th>
            <th>Editar</th>
            <th>Eliminar</th>
          </tr>
        </thead>
        <tbody>
        <% int index = 0;%>
        <c:forEach items="${proyectos}" var="proy">
            <tr>
                <th scope="row"><% out.print(++index); %></th>
                <td>${proy.nombre}</td>
                <td>${proy.descripcion}</td>
                <c:forEach items="${usuarios}" var="usuario">
                <c:if test="${proy.id_usuario == usuario.id}">
                <td>${usuario.nombre}</td>
                </c:if>
                </c:forEach>
                <td><a href="editp?id=${proy.id}"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
                <td><a href="deletep?id=${proy.id}"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
            </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="modalProyectos" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <form id="crearProyectoForm">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
              <h4 class="modal-title">Ingresar Proyecto</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                    <label class="control-label" for="proyNombre">Nombre del Proyecto: </label>
                  <input type="text" class="form-control" id="proyNombre" name="proyNombre" placeholder="Nombre">
                </div>
                <div class="form-group">
                    <label class="control-label" for="proyDescripcion">Descripción: </label>
                  <input type="text" class="form-control" id="proyDescripcion" name="proyDescripcion" placeholder="Descripción">
                </div>
                <div class="form-group">
                    <label class="control-label" for="selectUser">Encargado: </label>
                  <select class="form-control" id="selectUser" name="selectUser">
                    <c:forEach items="${usuarios}" var="usuario">
                        <option value="${usuario.id}">${usuario.nombre}</option>
                    </c:forEach>
                  </select>
                </div>
                <div id="errorProy" class="alert alert-danger collapse" role="alert"></div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
              <button type="submit" class="btn btn-primary">Ingresar</button>
            </div>
          </form>
        </div>
      </div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/v/bs/dt-1.10.12/datatables.min.js"></script>
    <script>
        $(document).ready(function() {
            var tablaProyectos = $('#tablaProyectos').DataTable({
                "language": {
                    url: 'i18n/dt-spanish.json'
                },
                "aoColumnDefs": [
                    { 'bSortable': false, 'aTargets': [ 4, 5 ] }
                 ]
            });
            $("#crearProyectoForm").submit(function(e){
                e.preventDefault();
                var url = "createProy";
                $.ajax({
                   type: "POST",
                   url: url,
                   data: $("#crearProyectoForm").serialize(), //envia todos los campos del formulario
                   success: function(data){
                       if (data.error){
                           $("#errorProy").show();
                           $("#errorProy").text(data.errormsg);
                           $('#modalProyectos').modal('show');
                       }else{
                            tablaProyectos.draw();
                            var proyecto = $.parseJSON(data.proyecto);
                            var usuario = $.parseJSON(data.usuario);
                            var nuevoProyecto = $("<tr>").append($("<th scope='row'>").text(data.lastnum))
                                .append($("<td>").text(proyecto.nombre))
                                .append($("<td>").text(proyecto.descripcion))
                                .append($("<td>").text(usuario.nombre))
                                .append($("<td><a href='editp?id="+data.id+"'><span class='glyphicon glyphicon-edit' aria-hidden='true'></span></a></td>"))
                                .append($("<td><a href='deletep?id="+data.id+"'><span class='glyphicon glyphicon-remove' aria-hidden='true'></span></a></td>"));
                            tablaProyectos.row.add(nuevoProyecto).draw();
                            $('#modalProyectos').modal('hide');
                       }
                   }
                });
            });
        });
        
    </script>
  </body>
</html>
