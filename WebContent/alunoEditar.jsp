<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="modelo.dominio.Turno"%>
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


<body>
	<jsp:useBean id="aluno" scope="request" class="modelo.dominio.Aluno"></jsp:useBean>

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
			<!--/fim navbar-header -->
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
				</ul>
			</div>
			<!--/fim navbar-collapse -->
		</div>
		<!--/fim container -->
	</nav>
	<!--/fim nav -->

	<%
		List<Turno> listaTurno = (List<Turno>) request.getAttribute("listaTurno");

		List<String> falhas = (List<String>) request.getAttribute("falhas");
		if (falhas != null) {
			out.print("<ul class=\"list-group listas\">");
			for (String falha : falhas)
				out.print("<li class=\"alert alert-danger alerts\">" + falha + "</li>");

			out.print("</ul>");
		}
	%>


	<!-- Formulário de Cadastro -->

	<div class="container">
		<form action="salvarAluno" method="post">
			<fieldset>
				<legend>Dados do Aluno</legend>
				<div class="row">
					<div class="col-md-2 col-sm-2 form-group">
						<label for="matricula" class="control-label">Matrícula:</label> <input
							type="text" readonly="readonly" class="form-control" name="matricula" value="${aluno.matricula}">
					</div>
				</div>


				<div class="row">
					<div class="col-md-8 col-sm-8 form-group">
						<label for="nome" class="control-label">Nome:</label> <input
							type="text" class="form-control" value="${aluno.nome}"
							name="nome" id="nome" required>
					</div>
					<!-- fim col-md-8 -->
				</div>
				<!-- fim da row -->

				<div class="row">
					<div class="col-md-2 col-sm-2 form-group">
						<label for="cpf" class="control-label">CPF:</label> <input
							type="text" class="form-control" value="${aluno.cpf}" name="cpf"
							id="cpf" onkeyup="cpfCheck(this)"
							onkeydown="fMasc( this, mcpf )" required><span
							id="cpfResponse"></span>
					</div>
					<!-- fim col-md-2 -->

					<div class="col-md-2 col-sm-2 form-group">
						<label for="dataNascimento" class="control-label">Data de
							Nascimento:</label> <input type="text" class="form-control"
							value="${aluno.dataNascimento}" name="dataNascimento"
							id="dataNascimento" onkeyup="mascara(this, mdata)" required>
					</div>
					<!-- fim col-md-2 -->

					<div class="col-md-2 col-sm-2 form-group">
						<label for="serie" class="control-label">Série ª:</label> <input
							type="text" class="form-control" value="${aluno.serie}"
							name="serie" id="serie" required>
					</div>
					<!-- fim col-md-2 -->

					<div class="col-md-2 col-sm-2 form-group">
						<label for="turno">Turno:</label> <select class="form-control"
							name="turno" id="turno">
							<option value="">Selecione...</option>

							<c:forEach var="turno" items="${listaTurno}">
								<c:set var="selecao" value="" />
								<c:if test="${turno.equals(aluno.turno)}">
									<c:set var="selecao" value="selected='selected'" />
								</c:if>
								<option ${selecao} value="${turno.id}">${turno.nome}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<!-- fim da row -->

				<div class="row">
					<div class="col-md-8 col-sm-8 form-group">
						<label for="endereco" class="control-label">Endereço:</label> <input
							type="text" class="form-control" value="${aluno.endereco}"
							name="endereco" id="endereco" required>
					</div>
					<!-- fim col-md-8 -->
				</div>
				<!-- fim da row -->

			</fieldset>
			<!-- fim do fieldset -->


			<div class="form-group">
				<button type="submit" class="btn btn-primary" name="btnSalvar"
					value="Salvar">Salvar</button>
				<button type="button" class="btn btn-danger" value="Cancelar"
					onclick="window.location = 'listarAlunos'">Cancelar</button>
			</div>
			<!--/fim form-group -->
		</form>
		<!--/fim form -->
	</div>
	<!--/fim container -->


	<!-- Core JS -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/validacao.js"></script>

</body>
</html>
