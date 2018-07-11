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
		
		
		<div class="row   align-self-center" >
		<div class="col-sm-2" id="addcategoryrow2arrowdiv">
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
				<tr id="tablerow" onmouseover="func1(this)" onmouseout="func2(this)">
						<td id="tablecolumn">
							${categories[i-1]}
						</td>
				</tr>
			</c:forEach>
			</tbody>
			</table>
			</div>
		</div>
		
			<div class="col-sm-4" id="addcategoryrow2addcatdiv">
				<form action="adminaddnewcategory" method="post">
						<div class="form-group">
							<label for="categoryname" style="font-weight:bold; color : #620000">New Category Name</label>
					    	<input class="form-control" type="text" name="categoryname" id="categorynamename">
					    </div>
						<!-- <div class="form-group">
							<label for="username" style="font-weight:bold; color : #620000">Agent Email as Username</label>
					    	<input class="form-control" type="email" name="email" id="email">
					    </div>
					    <div class="form-group">
					    	<label for="password" style="font-weight:bold; color : #620000">Set Password:</label>
					    	<input class="form-control" type="password" name="password" id="password">
					    </div> -->
					    <button type="submit" class="btn btn-primary" id="submitbutton" value="login" >Submit</button>
				</form>
			</div>
		</div>
		
		<div class="row" id="footerdiv">
			<div class="col-sm-12" id="footercol12-1div">©NSDL | Site Map | Help Desk</div>
		</div>
	</div>
</body>


<script type="text/javascript" src="./JS/addcategory.js"></script>


</html>