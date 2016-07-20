<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Administrador de Proyectos</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <link rel="stylesheet" href="stylesheets/styles.css">
  </head>

  <body>
      <div id="errorLogin" class="alert alert-danger collapse" role="alert"></div>
	<div class="container login-form">
		<h2 class="login-title">- Ingreso al Sistema -</h2>
		<div class="panel panel-default">
			<div class="panel-body">
				<form id="loginForm">
					<div class="input-group login-userinput">
						<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
						<input name="usuario" type="text" class="form-control" placeholder="Usuario">
					</div>
					<div class="input-group">
						<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
						<input name="password" type="password" class="form-control" placeholder="Contraseña">
						<span id="showPassword" class="input-group-btn">
	            			<button class="btn btn-default reveal" type="button"><i class="glyphicon glyphicon-eye-open"></i></button>
	          			</span>  
					</div>
					<button class="btn btn-primary btn-block login-button" type="submit"><i class="fa fa-sign-in"></i> Login</button>
					<div class="checkbox login-options">
						<label><input type="checkbox"/> Recordarme</label>
						<a href="#" class="login-forgot">Olvido su contraseña?</a>
					</div>		
				</form>			
			</div>
		</div>
	</div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="javascripts/script.js"></script>
    <script>
        $(document).ready(function(){
            $("#loginForm").submit(function(e){
                e.preventDefault();
                
                var url = "LoginServlet";
                $.ajax({
                   type: "POST",
                   url: url,
                   data: $("#loginForm").serialize(), //envia todos los campos del formulario
                   success: function(data){
                       //console.log(data);
                       if (data.error){
                           $("#errorLogin").show();
                           $("#errorLogin").text(data.errormsg)
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
