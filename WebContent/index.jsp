<%@ page import ="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>TODO list</h1>
	<form method="post" action="todolist">
		<input type="text" name="task" placeholder="Nueva tarea" />
		<input type="submit" value="Agregar" />
	</form>
	
		<%
			List tasks =(List) request.getAttribute("tasks");
			Iterator it = tasks.iterator();
			out.println("<br>");
			while(it.hasNext()){
				out.println("<button>Subir</button><button>Bajar</button><button>Eliminar</button>");
				out.println(" "+it.next()+"<br>");
			}
		%>
	
	<br>
</body>
</html>