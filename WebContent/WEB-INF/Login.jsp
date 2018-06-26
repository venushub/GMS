<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Insert title here</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		
	</head>
	<body>
		<div class="container">
			<div class="row"><div class="col-sm-12 text-center" style="height:80px"><h2>Please enter your login credentials</h2></div></div>
			<div class="row">
				<div class="col-sm-4"></div>
				<div class="col-sm-4">
					<form action="checklogin" method="post">
						<div class="form-group">
							<label for="username">Username:</label>
					    	<input class="form-control" type="text" name="username" id="username">
					    </div>
					    <div class="form-group">
					    	<label for="password">Password:</label>
					    	<input class="form-control" type="password" name="password" id="password">
					    </div>
					    <button type="submit" class="btn btn-primary" value="login" >Submit</button>
					</form>
				</div>
				<div class="col-sm-4"></div>
			</div>
			<div class="row"><div class="col-sm-12 text-center" style="height:30px"></div></div>
			<div class="row">
				<div class="col-sm-12 text-center" ><p style="color:red">${error}</p></div>
		</div>
		</div>
	</body>
</html>