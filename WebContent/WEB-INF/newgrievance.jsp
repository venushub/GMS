<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Insert title here</title>
<!-- 	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	jQuery library
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	Latest compiled JavaScript
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
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
	<link rel="stylesheet" href="./CSS/ngstyle.css">
</head>
<body>
	<div class="container" id="ngbscontainer">
		<div class="row" id="ngrow1div">
			<div class="col-sm-6 text-right" id="agrow1co6-1"><div id="welcome">Welcome ${username}</div></div>
			<div class="col-sm-6 text-right align-middle" id="agrow1co6-2"><div id="logoutbuttondiv"><a href="logout"><button class="button" id="logoutbutton">Logout</button></a></div></div>	
		</div>
		<div class="row" id="emptyrow"></div>
		<div class="row" id="ngrow2div">
			<div class="col-sm-3 text-center" id="ngrow2col6-1">
				<div id="sidenav">
					<div id="grhead">Grievances</div>
					<div id="grng">New Grievance</div>
					<a href="home"><div id="grag">All Grievances</div></a>
				</div>
			</div>
			<div class="col-sm-1"></div>
			<div class=" col-sm-6 " id="ngrow2col6-2">
				<!-- <div id="formheading"><h3>Please Fill in Grievance details</h3></div> -->
				<div id="formdiv">
					<form action="createnewgrievance" method="post">
						<div id="categorydiv" class="form-group">
					    	<label for="category" style="font-weight:bold; color : #620000">Category:</label>
					    	<select name="category" id="category" class="form-control">
					    		<c:forEach var="i" begin="1" end="${categories.size()}">
									<option value="${categories[i-1]}">${categories[i-1]}</option>
								</c:forEach>
						<!-- 		<option value="SUC">SUC</option>
								<option value="LF">LF</option> -->
							</select>
						</div>	
						<div id="grievancenotediv" class="form-group">
					    	<label for="grievancenote" style="font-weight:bold; color : #620000">Grievance Note:</label>
					    	<textarea name="grievancenote" rows="10" cols="30" id="grievancenote" class="form-control">
							</textarea>
						</div>
					    <button type="submit" class="btn btn-primary" value="login" id="submitbutton">Submit</button>
					</form>
				</div>
			</div>
		</div>
		<div class="row" id="footerdiv">
			<div class="col-sm-12" id="footercol12-1div">©NSDL | Site Map | Help Desk</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="./JS/ngscript.js"></script>	
</html>