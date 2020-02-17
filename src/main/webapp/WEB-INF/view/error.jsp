<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Error Page</title>
<link href="<spring:url value="/css/ticketservice.css"/>"
	rel="stylesheet">
<link href="<spring:url value="/css/bootstrap.min.css"/>"
	rel="stylesheet">
<script src="<spring:url value="/js/ticketservice.js"/>"></script>
<script src="<spring:url value="/js/jquery-3.3.1.slim.min.js" />"></script>
<script src="<spring:url value="/js/jquery-3.4.1.min.js" />"></script>
<script src="<spring:url value="/js/popper.min.js"/>"></script>
<script src="<spring:url value="/js/bootstrap.min.js"/>"></script>
</head>
<body class="main_body">
	<div class="header">
		<%@include file="header.jsp"%>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<div class="card">
					<div class="card-header">Exception</div>
					<div class="card-body">
						<div class="card">
							<div class="card-body">
								<h4>Timestamp</h4>
								<p>${timestamp}</p>
							</div>
						</div>
						<div class="card">
							<div class="card-body">
								<h4>Message</h4>
								<p>${message}</p>
							</div>
						</div>
						<div class="card">
							<div class="card-body">
								<h4>Exception</h4>
								<p>${exception}</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<%@include file="footer.jsp"%>
	</div>
</body>

</html>