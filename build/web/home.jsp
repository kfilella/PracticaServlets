<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <li class="active"><a href="#">Usuarios</a></li>
            <li><a href="#">Proyectos</a></li>
            <li><a href="#">Dashboard</a></li>
          </ul>
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#about"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a></li>
            <li><a href="#">Logout</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    <div class="container usuarios">
      <h2>Registro de Usuarios</h2>
      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#modalUsuarios">Agregar Usuario</button>
      <table id="tablaUsuarios" class="table table-bordered table-striped">
        <thead>
          <tr>
            <th>#</th>
            <th>Nombre</th>
            <th>Email</th>
            <th>Rol</th>
            <th>Editar</th>
            <th>Eliminar</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">1</th>
            <td>Juan Perez</td>
            <td>jperez@example.com</td>
            <td>Desarrollador</td>
            <td><a href="#"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
            <td><a href="#"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
          </tr>
          <tr>
            <th scope="row">2</th>
            <td>Rodrigo Castro</td>
            <td>rcastro@example.com</td>
            <td>Diseñador</td>
            <td><a href="#"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
            <td><a href="#"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
          </tr>
          <tr>
            <th scope="row">3</th>
            <td>Jose Sanchez</td>
            <td>jsanchez@example.com</td>
            <td>Administrador</td>
            <td><a href="#"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
            <td><a href="#"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a></td>
          </tr>
        </tbody>
      </table>
    </div>

    <!-- Modal -->
    <div class="modal fade" id="modalUsuarios" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <form>
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
              <h4 class="modal-title">Ingresar Usuario</h4>
            </div>
            <div class="modal-body">
                <div class="form-group">
                  <input type="text" class="form-control" id="inputNombre" name="inputNombre" placeholder="Nombre">
                </div>
                <div class="form-group">
                  <input type="email" class="form-control" id="inputApellido" name="inputEmail" placeholder="Email">
                </div>
                <div class="form-group">
                  <select class="form-control" id="selectRol" name="selectRol">
                    <option value="1">Desarrollador</option>
                    <option value="2">Diseñador</option>
                    <option value="3">Administrador</option>
                  </select>
                </div>
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
            $('#tablaUsuarios').DataTable({
                "language": {
                    url: 'i18n/dt-spanish.json'
                },
                "aoColumnDefs": [
                    { 'bSortable': false, 'aTargets': [ 4, 5 ] }
                 ]
            });
            
        });
    </script>
  </body>
</html>
