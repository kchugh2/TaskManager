
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

	<div class="container" style="background-color: white">
		<div class="container" style="overflow-y: scroll">
			<table class="table table-striped">

				<tr>
					<th>Due</th>
					<th>Description</th>
					<th>Priority</th>
					<th>Status</th>
					<th>Complete Date</th>
				</tr>
				${message}
			</table>
		</div>
		<div align="center">
			<br>
			<br> <a href="TaskAdd.jsp" class="btn btn-info" role="button">Add
				Tasks</a>
		</div>
	</div>
	<jsp:include page="/Footer.jsp" />

</body>
</html>
