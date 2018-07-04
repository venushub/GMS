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
	<link rel="stylesheet" href="./CSS/registration.css">
</head>
<body>
	<div class="container" id="ngbscontainer">
		<div class="row" id="ngrow1div">
			<div class="col-sm-6 text-right" id="agrow1co6-1"><div id="welcome">Welcome ${username}</div></div>
			<div class="col-sm-6 text-right align-middle" id="agrow1co6-2"><div id="logoutbuttondiv"><a href="index"><button class="button" id="logoutbutton">Home</button></a></div></div>	
		</div>
		<div class="row" id="emptyrow"></div>
		<div class="row" id="emptyrow"></div>
		<div class="row" id="emptyrow"></div>
		<div class="row" id="emptyrow"></div>
		<div class="row"><div class="col-sm-12 text-center" style="height:80px"><h2 style="color :#9f0000">Please enter your Registration credentials</h2></div></div>
		<div class="row" id="emptyrow"></div>
					<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					<form action="checklogin" method="post">
						<div class="form-group">
							<label for="username" style="font-weight:bold; color : #620000">Username:</label>
					    	<input class="form-control" type="text" name="username" id="username">
					    </div>
					    <div class="form-group">
					    	<label for="password" style="font-weight:bold; color : #620000">Password:</label>
					    	<input class="form-control" type="password" name="password" id="password">
					    </div>
					    <button type="submit" class="btn btn-primary" value="login" id="submitbutton">Submit</button>
					</form>
				</div>
				<div class="col-sm-4"></div>
			</div>
			<div class="row"><div class="col-sm-12 text-center" style="height:30px"></div></div>
			<div class="row"><div class="col-sm-12 text-center"><a href="registration">New Registration</a></div></div>
			<div class="row"><div class="col-sm-12 text-center" style="height:30px"></div></div>
			
			<div class="row">
				<div class="col-sm-12 text-center" ><p style="color:red">${error}</p></div>
		    </div>
		<div class="row" id="footerdiv">
			<div class="col-sm-12" id="footercol12-1div">©NSDL | Site Map | Help Desk</div>
		</div>
	</div>
</body>
<!-- <script type="text/javascript" src="./JS/ngscript.js"></script>
 -->
 <script type="text/javascript">
 document.getElementById("submitbutton").addEventListener("mouseover", changeme);
 document.getElementById("submitbutton").addEventListener("mouseout", rechangeme);

 function changeme(){
	 document.getElementById("submitbutton").style.backgroundColor = "#9f0000";
 }
 
 function rechangeme(){
	 document.getElementById("submitbutton").style.backgroundColor = "#620000";
 }
 
 </script>
 </html>