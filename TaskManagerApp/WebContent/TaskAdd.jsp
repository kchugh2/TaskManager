
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
	integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="/Navbar.jsp" />

	<div class="container">
		<div style="background-color: blue light">

			<form action="TaskAddServlet" method="POST">
				<br> <br>
				<div class="form-group">
					<label for="duedate" style="color: #141452"></label> <input
						path="myDate" type="date" class="form-control" name="duedate"
						placeholder="Due Date">
				</div>
				<div class="form-group">
					<label for="priority">Priority</label> <select class="form-control"
						name="priority">
						<option value="low">LOW</option>
						<option value="none">NONE</option>
						<option value="high">HIGH</option>
					</select>
				</div>
				<br> <br> <label for="description">Description</label>
				<textarea class="form-control" rows="3" name="description"
					placeholder="Description"></textarea>
				<div align="center">
				<br><br>
					<button type="Submit" class="btn btn-primary btn-sm">Submit
						task</button>
				</div>
			</form>
		</div>
	</div>
	<jsp:include page="/Footer.jsp" />

</body>
</html>
