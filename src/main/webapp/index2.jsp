<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="fr.vdekennet.model.Voiture" %>
<%@ page import="fr.vdekennet.repository.VoitureDAO" %>
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
	<link href="/docs/4.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="canonical"
	href="https://getbootstrap.com/docs/5.3/examples/modals/">
<script src="/docs/5.3/assets/js/color-modes.js"></script>
<link href="/docs/5.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4Q6Gf2aSP4eDXB8Miphtr37CMZZQ5oXLH2yaXMJ2w8e2ZtHTl7GptT4jmndRuHDT">

<meta name="theme-color" content="#712cf9">
<link href="modals.css" rel="stylesheet">

<style>
	 .radio-group {
        display: flex;
        gap: 20px;
    }

    .radio-group input[type="radio"] {
        accent-color: royalblue; /* Change la couleur du bouton */
        width: 18px;
        height: 18px;
        cursor: pointer;
    }

    .radio-group label {
        font-weight: 500;
        cursor: pointer;
    }

	.bd-placeholder-img {
		font-size: 1.125rem;
		text-anchor: middle;
		-webkit-user-select: none;
		-moz-user-select: none;
		user-select: none
	}
	
	@media ( min-width : 768px) {
		.bd-placeholder-img-lg {
			font-size: 3.5rem
		}
	}
	
	.b-example-divider {
		width: 100%;
		height: 3rem;
		background-color: #0000001a;
		border: solid rgba(0, 0, 0, .15);
		border-width: 1px 0;
		box-shadow: inset 0 .5em 1.5em #0000001a, inset 0 .125em .5em #00000026
	}
	
	.b-example-vr {
		flex-shrink: 0;
		width: 1.5rem;
		height: 100vh
	}
	
	.bi {
		vertical-align: -.125em;
		fill: currentColor
	}
	
	.nav-scroller {
		position: relative;
		z-index: 2;
		height: 2.75rem;
		overflow-y: hidden
	}
	
	.nav-scroller .nav {
		display: flex;
		flex-wrap: nowrap;
		padding-bottom: 1rem;
		margin-top: -1px;
		overflow-x: auto;
		text-align: center;
		white-space: nowrap;
		-webkit-overflow-scrolling: touch
	}
	
	.btn-bd-primary {
		--bd-violet-bg: #712cf9;
		--bd-violet-rgb: 112.520718, 44.062154, 249.437846;
		--bs-btn-font-weight: 600;
		--bs-btn-color: var(--bs-white);
		--bs-btn-bg: var(--bd-violet-bg);
		--bs-btn-border-color: var(--bd-violet-bg);
		--bs-btn-hover-color: var(--bs-white);
		--bs-btn-hover-bg: #6528e0;
		--bs-btn-hover-border-color: #6528e0;
		--bs-btn-focus-shadow-rgb: var(--bd-violet-rgb);
		--bs-btn-active-color: var(--bs-btn-hover-color);
		--bs-btn-active-bg: #5a23c8;
		--bs-btn-active-border-color: #5a23c8
	}
	
	.bd-mode-toggle {
		z-index: 1500
	}
	
	.bd-mode-toggle .bi {
		width: 1em;
		height: 1em
	}
	
	.bd-mode-toggle .dropdown-menu .active .bi {
		display: block !important
	}
</style>
	<!-- Custom styles for this template -->
	<link href="dashboard.css" rel="stylesheet">

</head>
<body>

	<div class="container-fluid">
		<div class="row">
		
			<div style="width: 200px; margin: 0 auto;">
				<a href="AfficherVoitureServlet" ><h1>Garage Kay-Net</h1></a>
			</div>
				
			<main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
				
				<canvas class="my-4 w-100" id="myChart" width="900" height="80"></canvas>
			<%
			
				if (request.getAttribute("Voitures") != null) {
					System.out.println("Voitures récupérées dans la JSP");
			%>
				
				<h2>Liste des Véhicules</h2>
				<div class="table-responsive">
					<table class="table table-striped table-sm">
							<form action="RechercherVoitureServlet" method="post">
								   <div class="d-flex gap-2 align-items-center">
								        <div class="form-floating flex-grow-1">
								            <input type="text" class="form-control" id="chercheur" name="aTrouver" placeholder="valeur à chercher" required>
								            <label for="chercheur">Valeur à chercher</label>
								        </div>
								        <button class="btn btn-primary btn-lg" type="submit">Rechercher</button>
								    </div>
							</form>	
					    <div class="form-floating flex-grow-3">
							<p> ${resultatR} </p>
						</div>
	
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
								<tr>
									<jsp:include page="ajouter.jsp"></jsp:include>
								</tr>
							<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
							<c:forEach var="voiture" items="${Voitures}">
								<tr>
									<td>${voiture.matricule}</td>
									<td>${voiture.marque}</td>
									<td>${voiture.modele}</td>
									<td>${voiture.etat}</td>
									<td>
										<form method="get">
											<input type="text" class="form-control" id="chercheSur" name="matricule" value="${voiture.matricule}" hidden>
											<button class="w-80 btn btn-primary btn-lg" type="button" data-bs-toggle="modal" data-bs-target="#modifier"
											  name="alter" value="modifier">Modifier</button>
											<button class="w-80 btn btn-secondary btn-lg" type="button" data-bs-toggle="modal" data-bs-target="#supprimer"
											  name="alter" value="supprimer" >Supprimer</button>
											  <div class="modal fade" id="modifier" tabindex="-1" aria-hidden="true">
											<div class="modal-dialog modal-lg">
													<jsp:include page="modifier.jsp"/>
						   					</div>
										</div>
										<div class="modal fade" id="supprimer" tabindex="-1" aria-hidden="true">
											<div class="modal-dialog modal-lg">
						    						<jsp:include page="supprimer.jsp" />
						   					</div>
										</div>
										</form>
										 <!-- 
										<form action="IDRechercherVoitureServlet" method="post">
											<input type="text" class="form-control" id="chercheSur" name="aTrouver" value="${voiture.matricule}" hidden>
											<button class="w-80 btn btn-primary btn-lg" type="submit" data-bs-toggle="modal" data-bs-target="#modifier"
											  name="alter" value="modifier">Modifier</button>
											<button class="w-80 btn btn-secondary btn-lg" type="submit" data-bs-toggle="modal" data-bs-target="#supprimer"
											  name="alter" value="supprimer" >Supprimer</button>
										</form>
										 -->
									</td>
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
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
