
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> -->

	<div class="modal-content rounded-4">
		<% request.getAttribute("voiture"); %>
		<div class="modal-header p-5 pb-4 border-bottom-0">
			<h5 class="fw-bold mb-0 fs-2">Modifier la voiture</h5>
			<button type="button" class="btn-close" data-bs-dismiss="modal"
				aria-label="Close"></button>
		</div>

	<div class="modal-body p-9 pt-10">
		<form class="needs-validation" action="ModifierVoitureServlet"
			method="post" novalidate>
			<div class="form-floating mb-3">
				<input type="text" class="form-control" style="bgcolor: red"
					name="matricule" value="${voiture.getMatricule()}" readonly>
				<label for="matricule" class="form-label">Matricule</label>
			</div>

			<div class="form-floating mb-3">
				<input type="text" class="form-control" id="marque"
					name="VoitureMarque" placeholder="Exemple : Peugeot"
					value="${voiture.getMarque()}" required> <label
					for="marque" class="form-label">Marque</label>
				<div class="invalid-feedback">La marque de la voiture est
					requise.</div>
			</div>

			<div class="form-floating mb-3">
				<input type="text" class="form-control" id="modele"
					name="VoitureModele" value="${voiture.modele}"
					placeholder="modele 3008" required> <label for="modele"
					class="form-label">Modèle</label>
				<div class="invalid-feedback">Il manque le modèle.</div>
			</div>

			<div class="w-100  mb-3">
				<h6>État Actuel</h6>
				<input id="PRIS_EN_CHARGE" name="VoitureEtat" type="radio"
					class="form-check-input" value="PRIS_EN_CHARGE" checked required>
				<label class="form-check-label" for="PRIS_EN_CHARGE"
					style="display: inline;">Pris en Charge</label> <input
					id="EN_COURS" name="VoitureEtat" type="radio"
					class="form-check-input" value="EN_COURS" required> <label
					class="form-check-label" for="EN_COURS" style="display: inline;">En
					cours</label> <input id="TERMINE" name="VoitureEtat" type="radio"
					class="form-check-input" value="TERMINE" required> <label
					class="form-check-label" for="TERMINE" style="display: inline;">Terminé</label>

			</div>
			<button class="w-100 btn btn-primary btn-lg" type="submit">Valider</button>
		</form>
	</div>
</div>

<!-- 				<div class="modal modal-sheet position-static d-block bg-body-secondary p-4 py-md-5"
							tabindex="-1" role="dialog" id="modalSheet">
							<div class="modal-dialog">
								<div class="modal-content rounded-4 shadow">
									<div class="modal-header border-bottom-0">
										<h1 class="modal-title fs-5">Confirmation de la
											suppression</h1>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>

									<form class="needs-validation" action="ModifierVoitureServlet"
										method="post" novalidate>
										<input type="text" class="form-control" style="bgcolor: red"
											name="matricule" value="${voiture.getMatricule()}" readonly>
										<input type="text" class="form-control" id="marque"
											name="VoitureMarque" placeholder="Exemple : Peugeot"
											value="${voiture.getMarque()}" required>
										<div class="invalid-feedback">La marque de la voiture
											est requise.</div>
										<input type="text" class="form-control" id="modele"
											name="VoitureModele" value="${voiture.modele}"
											placeholder="modele 3008" required>
										<div class="invalid-feedback">Il manque le modèle.</div>

										<p>État Actuel</p>
										<input id="PRIS_EN_CHARGE" name="VoitureEtat" type="radio"
											class="form-check-input" value="PRIS_EN_CHARGE" checked
											required> <label class="form-check-label"
											for="credit">Pris en Charge</label> <input id="EN_COURS"
											name="VoitureEtat" type="radio" class="form-check-input"
											value="EN_COURS" required> <label
											class="form-check-label" for="debit">En cours</label> <input
											id="TERMINE" name="VoitureEtat" type="radio"
											class="form-check-input" value="TERMINE" required> <label
											class="form-check-label" for="paypal">Terminé</label>

										<button class="w-100 btn btn-primary btn-lg" type="submit">Valider</button>
									</form>
								</div>
							</div>
						</div>
						 -->
	
						<!-- 	
</body>
</html>
 -->