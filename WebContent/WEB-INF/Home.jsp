<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="./CSS/singlestyle.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="container" id="bscontainer">
		<div class="row" id="row1div">
			<div class="col-sm-12 text-center">Welcome ${username}</div>
		</div>
		<div class="row" id="row2div">
			<div class="col-sm-6 text-center" id="row2col6-1">
				<div id="sidenav">
					<div id="grhead">Grievances</div>
					<div id="grng" onmouseover="func1(this)" onmouseout="func2(this)">New Grievance</div>
					<div id="gral">All Grievances</div>

				</div>
			</div>
			<div class="col-sm-6 text-center" id="row2col6-2">
			<table>
			<c:forEach var="j" begin="0" end="8">
			<tr>
				${tableelems} }
			</tr>
			</c:forEach>
			</table>
			</div>
			
		</div>
		
	</div>
</body>
<script type="text/javascript" src="./JS/homescript.js"></script>
</html>