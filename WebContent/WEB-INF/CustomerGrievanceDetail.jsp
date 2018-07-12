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
			<div class="col-sm-6 text-right align-middle" id="agrow1co6-2"><div id="logoutbuttondiv"><a href="login"><button class="button" id="logoutbutton">Logout</button></a></div></div>			
		</div>
		
		<div class="row" id="detailrow" >
			<div class="col-sm-4  d-flex flex-column align-self-center justify-content-end" id="sidedetails">
				
				<div>
				<svg width =65 height = 55>
				<a href="home">
            		<polygon id="backarrow" points="1,25 30,0 30,15 60,15 60,35 30,35 30,50" fill="#620000" stroke="#620000" stroke-width="2" />
        		</a>
        		</svg>
				</div>
				<div style="height:100px" id="khalidiv"></div>
				<div style="color : #e2b616"><b>Username</b></div>
				<div ><h3>${useremail}</h3></div>
				
				<div style="color : #e2b616"><b>Grievance Type</b></div>
				<div><h3>${grtype}</h3></div>
				
				<div style="color : #e2b616"><b>Created on</b></div>
				<div><h3>${timestamp}</h3></div>
				
				<div style="color : #e2b616"><b>Status</b></div>
				<div><h3>${userstatus}</h3></div>
			</div>
		<div class="col-sm-7 d-flex text-center flex-column" id="commentscol">
		<div style="margin:0px ;background-color : #620000 ; color : white">
			<h3>Comments</h3>
		</div>
		<div  class="table table-responsive" style="height : 100%  ;margin : 0px; " id="commentstable">
		<table>
		<thead></thead>
		<tbody>
		<c:forEach var="i" begin="1" end="${comments.size()}">
		<tr id="tbcommentrow">
			<td id="tbcommentcol">
				<div class="commentitem">
					<c:if test = "${comments[i-1][2] == 'customer'}" >
							<div id="commenthead" style="color : #e2b616; text-align : right"><b>${comments[i-1][1]}, ${comments[i-1][2]}, ${comments[i-1][4]}</b></div>
							<div id="commentbody" style="font-size : 20px;  text-align : right">
								${comments[i-1][3]}
							</div>
					 	</c:if>
					 
				<c:if test = "${comments[i-1][2] == 'agent'}">
							<div id="commenthead" style="color : #f9186f; "><b>${comments[i-1][1]}, ${comments[i-1][2]}, ${comments[i-1][4]}</b></div>
							<div id="commentbody" style="font-size : 20px; ">
								${comments[i-1][3]}
							</div>
					    </c:if>
					
				</div>
			</td>
		</tr>
		</c:forEach>
		</tbody>
		</table>
		</div>
	    <div id="sendcomment"> 
	    <!-- <div style="border-color : #620000 ; border-style:solid; margin: 0px; padding : 0px;"> -->
<!-- 		<div style="background-color : white; padding:0px; color : #620000 ; font-size : 20px;border-color : #620000 ; border-style:solid; float:left"><b>Make Comment</b></div>
 -->		<div style="border-color : white ; border-style:solid;float:right">
		<svg height="28px" width="30px" style="background-color: white" id="hidecommentdiv">
		
			<polygon id="commentclick" points="6,6 26,6 16,20" fill="#e2b616" stroke="#e2b616" stroke-width="1" />
			
		
		</svg>
<!-- 		<button id="hidebutton">hide</button>
 -->		</div>
		<!-- </div> -->
		<div id="commentformdiv">
		<form action="customerdetailaction" method="post">
						<!-- <div id="categorydiv" class="form-group">
					    	<label for="category" style="font-weight:bold; color : #620000">Category:</label>
					    	<select name="category" id="category" class="form-control">
								<option value="SUC">SUC</option>
								<option value="LF">LF</option>
							</select>
						</div>	 -->
						<input type="hidden" value="${useremail}" name="useremail">
						<input type="hidden" value="${grid}" name="grid">
						<div id="grievancenotediv" class="form-group">
					    	<textarea name="grievancecomment" rows="5" cols="20" id="grievancenote" class="form-control">
							</textarea>
						</div>
					    <button type="submit" class="btn btn-primary" value="login" id="submitbutton">Submit Comment</button>
		</form>
		</div>
		</div>
 		<div id="entermessage2" >
 			<svg height="100%" width="100%" style="background-color : white">
 			<g>
            	<polygon id="commentclick" points="6,34 615,34 615,4 6,4" fill="white" stroke="white" stroke-width="1" />
         		<text x="10" y="26" font-size="15px" fill="#620000" style="font-weight : bold; font-family: Verdana, Geneva, Tahoma, sans-serif">Enter Message</text>
            	<polygon id="commentclick" points="625,32 645,18 625,6" fill="#620000" stroke="#620000" stroke-width="2" />
             </g>
 			</svg>
 			<!-- <button id="hideshow">Enter message</button> -->
 		</div>	
		</div>
		</div>
		<div class="row" id="footerdiv">
			<div class="col-sm-12" id="footercol12-1div">©NSDL | Site Map | Help Desk</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="./JS/studentdetail.js"></script>
</html>