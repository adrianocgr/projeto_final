<%@page import="com.fabricadeprogramador.persistencia.dao.AlunoDAO"%>
<%@page import="com.fabricadeprogramador.persistencia.entidade.Aluno"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		List<Aluno> lista = (List) request.getAttribute("lista");
		AlunoDAO mediaDao = new AlunoDAO();
	%>
<form method="post" action="aluno.do"">
	
		<table style="border: 1px solid black;">
		<thead>
			<tr>
				<td style="border: 1px solid black;">ID</td>
				<td style="border: 1px solid black;">NOME</td>
				<td style="border: 1px solid black;">NOTA</td>			
			</tr>
		</thead>
		<tobody> 
			<% for(Aluno a : lista){ %>
				<tr style="border: 1px solid black;">
					<td style="border: 1px solid black;"><%= a.getId() %></td>
					<td style="border: 1px solid black;"><%= a.getNome() %></td>
					<td style="border: 1px solid black;"><%= a.getNota() %></td>
				</tr>
			<% } %>
		</tobody>
	</table>
	<br>
	<table>
			<thead>
		<tobody>
			<tr style="border: 1px solid black;"><td style="border: 1px solid black;"> Media: <%= mediaDao.media()%></td></tr>
		</tobody>
		</thead>
	</table>
		<input type="submit" value="Excluir">
	</form>
</body>
</html>