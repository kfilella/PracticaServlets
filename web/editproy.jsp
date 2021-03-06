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
            <li class="active"><a href="home">Usuarios</a></li>
            <li><a href="proyectos">Proyectos</a></li>
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
    <c:forEach items="${proyectos}" var="proy">
        <div class="page-header text-center">
	  <h2>Editar Proyecto - ${proy.nombre}</h2>
          <div id="editError" class="alert alert-danger collapse" role="alert"></div>
	</div>
        <div class="row-md-12">
          <form class="form-horizontal" role="form" id="editProyectoForm">
                <input type="hidden" id="proyID" name="proyID" value="${proy.id}">
                <div class="form-group">
                  <label class="control-label col-sm-2" for="proyNombre">Nombre: </label> 
                  <div class="col-md-8">
                    <input type="text" class="form-control" id="proyNombre" name="proyNombre" value="${proy.nombre}">
                  </div>
                </div>
                <div class="form-group">
                  <label class="control-label col-sm-2" for="proyDescripcion">Descripción: </label>
                  <div class="col-md-8">
                    <input type="text" class="form-control" id="proyDescripcion" name="proyDescripcion" value="${proy.descripcion}">
                  </div>
                </div>
                <div class="form-group">
                  <label class="control-label col-sm-2" for="proyUser">Encargado: </label>
                  <div class="col-md-8">
                    <select class="form-control" id="proyUser" name="proyUser">
                      <c:forEach items="${usuarios}" var="usuario">
                        <c:if test="${proy.id_usuario == usuario.id}">
                            <option value="${usuario.id}" selected="selected">${usuario.nombre}</option> 
                        </c:if>
                        <c:if test="${proy.id_usuario != usuario.id}">
                          <option value="${usuario.id}">${usuario.nombre}</option>
                        </c:if>
                      </c:forEach>
                    </select>
                  </div>
                </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <a href="proyectos" class="btn btn-default" role="button">Cancelar</a>
                    <button type="submit" class="btn btn-primary">Guardar</button>
                </div>
            </div>
          </form>
        </div>
    </c:forEach>
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/v/bs/dt-1.10.12/datatables.min.js"></script>
    <script>
        $(document).ready(function() {
            $("#editProyectoForm").submit(function(e){
                e.preventDefault();
                var url = "editproy";
                $.ajax({
                   type: "POST",
                   url: url,
                   data: $("#editProyectoForm").serialize(), //envia todos los campos del formulario
                   success: function(data){
                       if (data.error){
                           $("#editError").show();
                           $("#editError").text(data.errormsg);
                       }else{
                           window.location = data.url;
                       }
                   }
                });
            });
        });
        
    </script>
  </body>
</html>
