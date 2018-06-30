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
	<link rel="stylesheet" href="./CSS/ngstyle.css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="container" id="ngbscontainer">
		<div class="row" id="ngrow1div">
			<div class="col-sm-6 text-right" id="agrow1co6-1"><div id="welcome">Welcome ${username}</div></div>
			<div class="col-sm-6 text-right align-middle" id="agrow1co6-2"><div id="logoutbuttondiv"><button class="button" id="logoutbutton">Logout</button></div></div>	
		</div>
		<div class="row" id="emptyrow"></div>
		<div class="row" id="ngrow2div">
			<div class="col-sm-6 text-center" id="ngrow2col6-1">
				<div id="sidenav">
					<div id="grhead">Grievances</div>
					<div id="grng">New Grievance</div>
					<div id="grag"><a href="home">All Grievances</a></div>
				</div>
			</div>
			<div class="col-sm-6 text-center" id="ngrow2col6-2">
				<!-- <div id="formheading"><h3>Please Fill in Grievance details</h3></div> -->
				<div id="formdiv">
					<form action="createnewgrievance" method="post">
						<!-- <div id="formrowdiv1" style="float:left">
							<div id="intendedtodiv" class="form-group" style="float:left">
								<label for="intendedto">Intended to:</label>
						    	<select name="intendedto" id="intendedto" class="form-control">
									<option value="CCA">CCA</option>
									<option value="DoT">DoT</option>
								</select>
							</div>
							<div id="typediv" class="form-group" style="float:left">
					    	<label for="type">Type:</label>
					    	<select name="type" id="type" class="form-control">
								<option value="For Action">For Action</option>
								<option value="For Information">For Information</option>
							</select>
							</div>
					    </div> -->
					    <div id="formrowdiv2" style="float:left; clear:left">
							<div id="categorydiv" class="form-group" style="float:left">
						    	<label for="category">Category:</label>
						    	<select name="category" id="category" class="form-control">
									<option value="SUC">SUC</option>
									<option value="LF">LF</option>
								</select>
							</div>
							<!-- <div id="yeardiv" class="form-group" style="float:left">
						    	<label for="year">Year:</label>
						    	<select name="year" id="year" class="form-control">
									<option value="2012">2012</option>
									<option value="2013">2013</option>
									<option value="2014">2014</option>
									<option value="2015">2015</option>
								</select>
							</div> -->
					    </div>
					    <div id="formrowdiv3" style="float:left; clear:left">
							<div id="grievancenotediv" class="form-group" style="float:left">
						    	<label for="grievancenote">Grievance Note:</label>
						    	<textarea name="grievancenote" rows="10" cols="30" id="grievancenote" class="form-control">
								</textarea>
							</div>
					    </div>
					    <div id="formrowdiv4" style="float:left; clear:left">
							<div id="submitbuttondiv" class="form-group" style="float:left">
					    	<button type="submit" class="btn btn-primary" value="login" id="submitbutton" >Submit</button>
					    	</div>
					    </div>
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