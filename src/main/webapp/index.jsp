<!doctype html>
<html>

<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="generator" content="Jekyll v3.8.5">

    <title>Garage Kay-Net</title>
    
    <!-- Activation de Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    
	<!-- Bootstrap core CSS -->
	<link href="/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet"
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		crossorigin="anonymous">
	
	<style>
		.bd-placeholder-img {
			font-size: 1.125rem;
			text-anchor: middle;
			-webkit-user-select: none;
			-moz-user-select: none;
			-ms-user-select: none;
			user-select: none;
		}
		
		@media ( min-width : 768px) {
			.bd-placeholder-img-lg {
				font-size: 3.5rem;
			}
		}
	</style>
	<!-- Custom styles for this template -->
	<link href="dashboard.css" rel="stylesheet">

</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<h1>Garage Kay-Net</h1>
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
				
				<canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas>
			<%
				if (request.getAttribute("Voitures") != null) {
					System.out.println("Produits pris en jsp");
			%>
				<h2>Liste des Véhicules</h2>
				<div class="table-responsive">
					<table class="table table-striped table-sm">
						

						<thead>
							<tr>
								<th>Matricule</th>
								<th>Marque</th>
								<th>Modèle</th>
								<th>État</th>
								<th>Options</th>
							</tr>
						</thead>
						<tbody>
							<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
							<c:forEach var="voiture" items="${Voitures}">
								<tr>
									<td>${voiture.matricule}</td>
									<td>${voiture.marque}</td>
									<td>${voiture.modele}</td>
									<td>${voiture.etat}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			<%} else { %>
				<h3>Aucune Voiture trouvée</h3>
				<% } %>
			</main>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>

</body>
</html>
