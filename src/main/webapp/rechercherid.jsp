<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="generator" content="Jekyll v3.8.5">

    <title>Garage Kay-Net ID search</title>
    
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

	<div class="modal modal-sheet position-static d-block bg-body-secondary p-4 py-md-5" tabindex="-1" role="dialog" id="modalSheet">
		<div class="modal-dialog">
			<div class="modal-content rounded-4 shadow">
				<div class="modal-header border-bottom-0">
					<h1 class="modal-title fs-5">Modal title</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body py-0">
					<p>This is a modal sheet, a variation of the modal that docs
						itself to the bottom of the viewport like the newer share sheets
						in iOS.</p>
				</div>
				<div class="modal-footer flex-column align-items-stretch w-100 gap-2 pb-3 border-top-0">
					<button type="button" class="btn btn-lg btn-primary">Save changes</button>
					<button type="button" class="btn btn-lg btn-secondary" data-bs-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	
	




		<form class="needs-validation" action="IDRechercherVoitureServlet" method="post" novalidate>
			<input type="text" class="form-control" id="chercheur"
				name="aTrouver" placeholder="ID à chercher" required>
				
				<input id="alter" name="alter" type="radio" class="form-check-input" value="modifier" checked required> 
				<label class="form-check-label" for="credit">Modifier</label>
				<input id="alter" name="alter" type="radio" class="form-check-input" value="supprimer" required> 
				<label class="form-check-label" for="debit">Supprimer</label>
			<button class="w-100 btn btn-primary btn-lg" type="submit">Alterer</button>
		</form>
</body>
</html>