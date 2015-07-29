<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>cadastro nota</title>
</head>
<body>

	<form action="aluno.do" method="post">
		<label for="inpNome">Nome:</label> <input id="inpNome" type="text" name="nome"/><br>
		<label for="inpNota">Nota:</label> <input id="inpNota" type="text" name="nota"/><br>
		<input type="submit" value="salvar"/>
	</form>
</body>
</html>