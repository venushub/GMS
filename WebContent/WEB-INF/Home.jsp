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
	<link rel="stylesheet" href="./CSS/agstyle.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body id="index">
	<div class="container" id="agbscontainer">
		<div class="row" id="agrow1div">
		<%-- 
			<div class="col-sm-offset-12 text-center" id="agrow1co6-1">Welcome ${username}</div>
			<div class="col-sm-offset-12 text-center" id="agrow1co6-2"><button>Hello</button></div> --%>
			<div class="col-sm-6 text-right" id="agrow1co6-1"><div id="welcome">Welcome ${username}</div></div>
			<div class="col-sm-6 text-right align-middle" id="agrow1co6-2"><div id="logoutbuttondiv"><a href="login"><button class="button" id="logoutbutton" onclick="logoutbutton()">Logout</button></a></div></div>			
		</div>
		<div class="row" id="emptyrow"></div>
		<div class="row" id="agrow2div">
			<div class="col-sm-6 text-center align-center" id="agrow2col6-1">
				<div id="sidenav">
					<div id="grhead">Grievances</div>
					<a href="newgrievance"><div id="grng">New Grievance</div></a>
					<div id="grag">All Grievances</div>
				</div>
			</div>
			<div class="col-sm-6 text-center" id="agrow2col6-2">
			<table id="tablemain" class="table-responsive-sm">
			<tr id="tableheaderrow">
				<th id="tableheadercolumn">One</th>
				<th id="tableheadercolumn">Two</th>
				<th id="tableheadercolumn">Three</th>
				<th id="tableheadercolumn">Four</th>
			</tr>
			<c:forEach var="i" begin="0" end="${tableelems.size()}">
				<tr id="tablerow" onmouseover="func1(this)" onmouseout="func2(this)">
					<c:forEach var="j" begin="0" end="${tableelems[i].size()}">
						<td id="tablecolumn">
							${tableelems[i][j]}
						</td>
					</c:forEach>
				</tr>
			</c:forEach>
			</table>
			</div>
		</div>
		<div class="row" id="footerdiv">
			<div class="col-sm-12" id="footercol12-1div">©NSDL | Site Map | Help Desk</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="./JS/agscript.js"></script>
</html>