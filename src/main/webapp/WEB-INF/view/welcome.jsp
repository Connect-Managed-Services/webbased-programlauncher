<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Create Ticket Page</title>
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
			<div class="col-sm-3">
				<div class="card">
					<div class="card-header" style="background: #dc3545;">${p1header}</div>
					<div class="card-body">
						<p>${p1description}</p>
						<input class="btn btn-danger" type="button" value='${p1tagname}'
							onclick="sendingRequest('${p1taskname}')">
					</div>
					<div class="card-footer" id="${p1taskname}" style="display: none"></div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="card">
					<div class="card-header" style="background: orange;">${p2header}</div>
					<div class="card-body">
						<p>${p2description}</p>
						<input class="btn btn-warning" type="button" value='${p2tagname}'
							onclick="sendingRequest('${p2taskname}')">
					</div>
					<div class="card-footer" id="${p2taskname}" style="display: none"></div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="card">
					<div class="card-header" style="background: yellow;">${p3header}</div>
					<div class="card-body">
						<p>${p3description}</p>
						<input class="btn medium" type="button" value='${p3tagname}'
							onclick="sendingRequest('${p3taskname}')">
					</div>
					<div class="card-footer" id="${p3taskname}" style="display: none"></div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="card">
					<div class="card-header" style="background: dodgerblue;">${p4header}</div>
					<div class="card-body">
						<p>${p4description}</p>
						<input class="btn btn-primary" type="button" value='${p4tagname}'
							onclick="sendingRequest('${p4taskname}')">
					</div>
					<div class="card-footer" id="${p4taskname}" style="display: none"></div>
				</div>
			</div>
		</div>
	</div>
	<div class="footer">
		<%@include file="footer.jsp"%>
	</div>
</body>
</html>
