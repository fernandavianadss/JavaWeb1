<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <title>Sistema escolar prime</title>
	
	<!-- Css -->
    <link href="css/style.css" rel="stylesheet">
    
    <!-- Bootstrap CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    
  </head>

  <body>   
    <!-- Static navbar -->
      <nav class="navbar navbar-default navbar-static-top">
        <div class="container">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand">
        		<img id="logo" src="img/logosistema.png" alt="Logo da escola prime"/>
      		</a>
         </div><!-- navbar-header -->
          <div id="navbar" class="navbar-collapse collapse">
            
          </div> <!--/fim navbar-collapse -->
        </div> <!--/fim container -->
      </nav> <!--/fim nav -->
      
      <!-- Card de cadastro -->

    <div class="container">
    	<div class="row">
  			<div class="col-md-3 col-xs-6">
    			<div class="thumbnail">
     				 <img src="img/user.png" alt="avatar"/>
     					 <div class="caption">
        					<h3 class="title">Controle de Alunos</h3>
        						<p><a href="listarAlunos" class="btn btn-primary" role="button">Novo Aluno</a></p>
      					</div> <!-- caption -->
    			</div> <!-- fim thumbnail -->
    		</div> <!-- fim col-md-3 -->
		</div> <!-- fim row -->
	</div> <!-- fim container -->


    <!-- Core JS
    ================================================== -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

  </body>
</html>
    