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
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link rel="stylesheet" href="./CSS/agstyle.css"> 
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
		
		<div class="row" id="detailrow" >
			<div class="col-sm-4  d-flex flex-column align-self-center justify-content-end" id="sidedetails">
				
				<div>
				<svg width =65 height = 55>
				<a href="adminusermgmt">
            		<polygon id="backarrow" points="1,25 30,0 30,15 60,15 60,35 30,35 30,50" fill="#620000" stroke="#620000" stroke-width="2" />
        		</a>
        		</svg>
				</div>
				<div style="height:100px" id="khalidiv"></div>
				<div ><b>Customer Username</b></div>
				<div ><h3>${useremail}</h3></div>
				
				<div ><b>Grievance Type</b></div>
				<div><h3>${grtype}</h3></div>
				
				<div ><b>Created on</b></div>
				<div><h3>${timestamp}</h3></div>
				
				<div ><b>Status</b></div>
				<div><h3>${agentstatus}</h3></div>
			</div>
		<div class="col-sm-7 d-flex text-center flex-column" id="commentscol">
		<div style="margin:0px ;background-color : #620000 ; color : white">
			<h3>Comments</h3>
		</div>
		<div  class="table table-responsive" style="height : 100%  ;margin : 0px; ">
		<table>
		<thead></thead>
		<tbody>
		<c:forEach var="i" begin="1" end="15">
		<tr id="tbcommentrow">
			<td id="tbcommentcol">
				<div class="commentitem">
					<div id="commenthead"><b>Customer</b></div>
					<div id="commentbody">
						${comments[0]}
					</div>
				</div>
			</td>
		</tr>
		</c:forEach>
		</tbody>
		</table>
		</div>
	    <div id="sendcomment"> 
		
		
		
		hello
			<!-- 	<form>
				<div>
					<label for="emtermessage"></label>
					<input type="text" name="comment" id="enter Message">
				</div>
				<div>
					<button type="submit" class="btn btn-primary" value="login" id="submitbutton">Submit</button>
				</div>
				</form> -->
		</div>
<!-- 				<button onclick="animdiv()" id="buttontoggle">Enter message</button>
 -->		
 <button id="hideshow">Enter message</button>
		</div>
		</div>
		<div class="row" id="footerdiv">
			<div class="col-sm-12" id="footercol12-1div">©NSDL | Site Map | Help Desk</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="./JS/agentdetail.js"></script>
</html>