<%@ taglib tagdir="/WEB-INF/tags" prefix="u"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Gerenciador de Espaços</title>

<link href="/geu/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="/geu/bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
<link href="/geu//css/app.css" rel="stylesheet">


</head>

<body>
	<c:import url="topo.jsp"></c:import>
	<div class="container">

		<div class="page-header">
			<h1>Inserir Espaços</h1>
		</div>

		<form action="reservas" method="post">
			Titulo: <input name="titulo" type="text" required><br>
			Descricao: <input name="descricao" type="text" required><br>
			Justificativa: <input name="justificativa" type="text" required><br>
			Solicitante: <input name="solicitante" type="text" required><br>
			Data: <input name="data" type="date" required><br> Hora
			Hora Inicio: <input name="horaInicio" type="time" required><br>
			Hora Fim: <input name="horaFim" type="time" required><br>
			Espaco: <select name="espaco">
				<option value="" selected>Selecione</option>
				<c:forEach var="espaco" items="${listaEspaco}">
					<option value="${espaco.id}">${espaco.identificacao}</option>
				</c:forEach>
			</select> <br>
			<button type="submit">Salvar</button>
		</form>


	</div>

	<c:import url="rodape.jsp"></c:import>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

	<script src="/geu/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>