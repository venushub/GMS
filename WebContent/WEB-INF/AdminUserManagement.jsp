<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
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
	<link rel="stylesheet" href="./CSS/adminusermanagement.css">
</head>
<body id="index">
	<div class="container" id="agbscontainer">
		<div class="row" id="agrow1div">
		<%-- 
			<div class="col-sm-offset-12 text-center" id="agrow1co6-1">Welcome ${username}</div>
			<div class="col-sm-offset-12 text-center" id="agrow1co6-2"><button>Hello</button></div> --%>
			<div class="col-sm-6 text-right" id="agrow1co6-1"><div id="welcome">Welcome ${username}</div></div>
			<div class="col-sm-6 text-right align-middle" id="agrow1co6-2"><div id="logoutbuttondiv"><a href="logout"><button class="button" id="logoutbutton">Logout</button></a></div></div>			
		</div>
		<div class="row mt-2" ">
			<div class="col-sm-12">
				<svg width =65 height = 55>
				<a href="adminhome">
            		<polygon id="backarrow" points="1,25 30,0 30,15 60,15 60,35 30,35 30,50" fill="#620000" stroke="#620000" stroke-width="2" />
        		</a>
        		</svg>
			</div>
		</div>
		<div class="row text-center" id="agrow2div">
			<div class="col-sm-6 d-flex flex-column align-items-center align-self-center" id="customercol6-1">
				<div class="p-2"><h1 style="color: #9f0000"><b>Customer</b></h1></div>
				<div class="p-2">
					<svg width="150" height="150">
			            <g>
			                <circle cx="75" cy="75" r="70" stroke="#620000" stroke-width="4" fill="white" id="circ" />
			                <text x="33" y="85" font-size="40px" fill="#620000" id="tex" style="font-weight : bold; font-family: Verdana, Geneva, Tahoma, sans-serif">Add</text>
			            </g>
	        		</svg>
        		</div>
				<div class="p-2">
					<svg width="150" height="150">
			            <g>
			                <circle cx="75" cy="75" r="70" stroke="#620000" stroke-width="4" fill="white" id="circ1" />
			                <text x="20" y="85" font-size="40px" fill="#620000" id="tex1" style="font-weight : bold; font-family: Verdana, Geneva, Tahoma, sans-serif">Alter</text>
			            </g>
	        		</svg>
				</div>
			</div>
			<div class="col-sm-6 d-flex flex-column align-items-center align-self-center" id="agentcol6-2" >
				<div class="p-2" ><h1 style="color: #9f0000"><b>Agent</b></h1></div>
				<div class="p-2">
				<a href="adminaddagent">
					<svg width="150" height="150">
			            <g>
			                <circle cx="75" cy="75" r="70" stroke="#620000" stroke-width="4" fill="white" id="circ2" />
			                <text x="33" y="85" font-size="40px" fill="#620000" id="tex2" style="font-weight : bold; font-family: Verdana, Geneva, Tahoma, sans-serif">Add</text>
			            </g>
	        		</svg>
	        	</a>
				</div>
				<div class="p-2">
					<svg width="150" height="150">
			            <g>
			                <circle cx="75" cy="75" r="70" stroke="#620000" stroke-width="4" fill="white" id="circ3" />
			                <text x="20" y="85" font-size="40px" fill="#620000" id="tex3" style="font-weight : bold; font-family: Verdana, Geneva, Tahoma, sans-serif">Alter</text>
			            </g>
	        		</svg>
				</div>
			</div>
		</div>
		
		<div class="row" id="footerdiv">
			<div class="col-sm-12" id="footercol12-1div">©NSDL | Site Map | Help Desk</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="./JS/adminusermanagement.js"></script>
</html>