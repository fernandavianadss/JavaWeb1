<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="modelo.dominio.Aluno"%>
<%@page import="java.util.List"%>
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
<script type="text/javascript">
	function confirmar(matricula, nome) {
		if (confirm('Deseja realmente excluir o Aluno: ' + nome + '?')) {
			// modelo DOM
			window.location = 'excluir?matricula=' + matricula;
		}
	}
</script>

<%
	//    TYPE CAST  /  CASTING
	List<Aluno> lista = (List<Aluno>) request.getAttribute("lista");
%>

<body>
	<!-- Static navbar -->
	<nav class="navbar navbar-default navbar-static-top navbar-sistema">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand"> <img id="logo"
					src="img/logosistema.png" alt="Logo da escola prime">
				</a>
			</div>
			<!--/fim navbar-header-->

			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
				</ul>
			</div>
			<!--/fim nav-collapse -->
		</div>
		<!--/fim container -->
	</nav>
	<!--/fim nav -->

	<div class="container">
		<a class="btn btn-primary pull-right" href="abrirInclusao">Novo
			aluno</a>
	</div>
	<!--/fim container-->
	<br>


	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading">Alunos</div>
			<table class="table">
				<thead>
					<tr>
						<th>Ação</th>
						<th>Matricula</th>
						<th>Nome</th>
						<th>CPF</th>
						<th>Data de Nascimento</th>
						<th>Série</th>
						<th>Turno</th>
						<th>Endereço</th>
					</tr>
				</thead>
				<c:forEach var="aluno" items="${lista}">
						<tr>
							<td><a class="btn btn-info btn-xs" href="alterar?matricula=${aluno.matricula}">Alterar</a>
								<a class="btn btn-danger btn-xs"
								href="javascript:confirmar('${aluno.matricula}', '${aluno.nome}')">Excluir</a>
							</td>
							<td>${aluno.matricula}</td>
							<td>${aluno.nome}</td>
							<td>${aluno.cpf}</td>
							<td>${aluno.dataNascimento}</td>
							<td>${aluno.serie}</td>
							<td>${aluno.turno.nome}</td>
							<td>${aluno.endereco}</td>
						</tr>
				</c:forEach>
			</table>
		</div>
		<!--/fim panel panel-default -->
	</div>
	<!--/fim container -->

	<!-- Core JS -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>

</body>
</html>