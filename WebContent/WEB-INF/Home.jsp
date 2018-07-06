<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	jQuery library
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	Latest compiled JavaScript
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	jQuery library
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	Latest compiled JavaScript
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
	<link rel="stylesheet" href="./CSS/agstyle.css">
</head>
<body id="index">
	<div class="container" id="agbscontainer">
		<div class="row" id="agrow1div">
		<%-- 
			<div class="col-sm-offset-12 text-center" id="agrow1co6-1">Welcome ${username}</div>
			<div class="col-sm-offset-12 text-center" id="agrow1co6-2"><button>Hello</button></div> --%>
			<div class="col-sm-6 text-right" id="agrow1co6-1"><div id="welcome">Welcome ${username}</div></div>
			<div class="col-sm-6 text-right align-middle" id="agrow1co6-2"><div id="logoutbuttondiv"><a href="logout"><button class="button" id="logoutbutton"">Logout</button></a></div></div>			
		</div>
		<div class="row" id="emptyrow"></div>
		<div class="row" id="agrow2div">
			<div class="col-sm-3 text-center align-center" id="agrow2col6-1">
				<div id="sidenav">
					<div id="grhead">Grievances</div>
					<a href="newgrievance"><div id="grng">New Grievance</div></a>
					<div id="grag">All Grievances</div>
				</div>
			</div>
			<div class="col-sm-8 text-center" id="agrow2col6-2">
			<div id="tablediv" class="table table-responsive">
			<table class="tablemain">
			<thead>
			<tr id="tableheaderrow">
				<th id="tableheadercolumn">#</th>
				<th id="tableheadercolumn">Category</th>
				<th id="tableheadercolumn">Message</th>
				<th id="tableheadercolumn">Date</th>
				<th id="tableheadercolumn">Status</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="i" begin="1" end="${tableelems.size()}">
				<tr id="tablerow" onmouseover="func1(this)" onmouseout="func2(this)">
					<td id="tablecolumn" class="tablehyper"> ${i} </td>
					<c:forEach var="j" begin="1" end="${tableelems[i-1].size()-2}">
						<td id="tablecolumn">
							${tableelems[i-1][j]}
						</td>
					</c:forEach>
					<td id="tablecolumn" class="tablehyper"><a href="detailpage/" id="tablelink"><b>${tableelems[i-1][4]}</b></a></td>
				</tr>
			</c:forEach>
			</tbody>
			</table>
			</div>
			</div>
		</div>
		<div class="row" id="footerdiv">
			<div class="col-sm-12" id="footercol12-1div">©NSDL | Site Map | Help Desk</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="./JS/agscript.js"></script>
</html>