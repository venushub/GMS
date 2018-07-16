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
<!-- 	<link rel="stylesheet" href="./CSS/adminusermanagement.css">
 -->
 	<link rel="stylesheet" href="./CSS/adminmapc2a.css">
 
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
			<div class="row" id="khalidiv" style="height:5%"></div>
		<div class="row text-center" id="agrow2div">
		
			<div class="col-sm-2">
					<svg width =65 height = 55>
					<a href="admindatamgmt">
	            		<polygon id="backarrow" points="1,25 30,0 30,15 60,15 60,35 30,35 30,50" fill="#620000" stroke="#620000" stroke-width="2" />
	        		</a>
	        		</svg>
			</div>
		
		<div class="col-sm-4"  id="addcategoryrow2catlistdiv">
			<div id="tablediv" class="table table-responsive">
			<table class="tablemain">
			<thead>
			<tr id="tableheaderrow">
				<th id="tableheadercolumn">Existing Categories</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var="i" begin="1" end="${categories.size()}">
				
				<c:if test="${categories[i-1] ne selected_cat}">
					<tr id="tablerow" onmouseover="func1(this)" onmouseout="func2(this)">
							<td id="tablecolumn" class="tablehyper">
							<a href="getowners?cat_name=${categories[i-1]}" id="tablelink"><b>	${categories[i-1]} </b></a>
							</td>
					</tr>
				</c:if>
				<c:if test="${categories[i-1] == selected_cat}">
					<tr id="tablerow" >
							<td id="tablecolumn" class="tablehyper" style="background-color: #400101;">
							<a href="getowners?cat_name=${categories[i-1]}" id="tablelink"><b>	${categories[i-1]} </b></a>
							</td>
					</tr>
				</c:if>
				
				
			</c:forEach>
			</tbody>
			</table>
			</div>
		</div>
		<div class="col-sm-4 d-flex flex-column" id="mapc2adiv" >
<!-- 		<div id="ownerstablediv" style="width:100px; padding:0px; margin:0px; border:0px">

 -->
 		<div id="tablediv" class="table table-responsive">
 		<table class="tablemain">
			<thead>
				<tr id="tableheaderrow">
					<th id="tableheadercolumn">Owners</th>
					<th id="tableheadercolumn">Delete</th>
 				</tr>
			</thead>
				<tbody id="agentaddtbody">
				<c:forEach var="i" begin="1" end="${owners.size()}">
					<tr id="tablerow" onmouseover="func1(this)" onmouseout="func2(this)">
							<td id="tablecolumn">
								${owners[i-1]}
							</td>
							<td id="deletebuttontd"><form action="deletemapc2a" method="post"><input type="hidden" value="${selected_cat}" name="selected_cat"><input type="hidden" value="${owners[i-1]}" name="agent_to_delete"><button id="deletebutton"><b style="color: #C70039">Delete</b></button></form></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			</div>
			
		<div id="addmapc2a" >
		
 	<!-- 	<div id="closeaddmapc2adiv" style="text-align : right; margin-bottom: 10px; margin-right:10px;color : #620010">
	 		<svg height="28px" width="30px" style="background-color: white" id="hidecloseaddmapc2adiv">
				<polygon id="commentclick" points="6,6 26,6 16,20" fill="#e2b616" stroke="#e2b616" stroke-width="1" />
			</svg>
 		</div>
  -->
 		<div style="margin-top: 10px;">	
		<form action="addmapc2a" method="post">
			<div class="form-group" style="width:80%; margin-left : 30px;">
				<input type="text"	 name="agent_name" class="form-control">
				<input type="hidden" value="${selected_cat}" name="selected_cat">
			</div>
		<button type="submit" class="btn btn-primary" value="login" id="submitbutton">Add</button>
		</form>
		<div style="color:red; margin-top:10px;">
		${error}
		</div>
		</div>	
		</div>
<!-- 		</div>	
 -->				
			
		</div>
		</div>
		
		<div class="row" id="footerdiv">
			<div class="col-sm-12" id="footercol12-1div">©NSDL | Site Map | Help Desk</div>
		</div>
	</div>
</body>
<!-- <script type="text/javascript" src="./JS/adminusermanagement.js"></script>
 -->
 	<script type="text/javascript" src="./JS/mapc2a.js"></script>
 	


</html>