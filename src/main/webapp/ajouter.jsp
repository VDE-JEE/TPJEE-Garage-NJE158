
		
		<div class="container">
			<form class="needs-validation" action="AjouterVoitureServlet" method="post" novalidate>
	
			<td>
				<input type="text" class="form-control" id="matricule" name="matriculeV" placeholder="Exemple : AA-123-75FR" value="" required>
				<div class="invalid-feedback">Matricule requis.</div>
			</td>
			<td>
				<input type="text" class="form-control" id="marque" name="marqueV" placeholder="Exemple : Peugeot" value="" required>
				<div class="invalid-feedback">La marque de la voiture est requise.</div>
			</td>
			<td>
				<input type="text" class="form-control" id="modele" name="modeleV" placeholder="modele 3008" required>
				<div class="invalid-feedback">Il manque le modèle.</div>
			</td>
			<td>
					<!-- <h4>État Actuel</h4> -->
				<div>
				<input id="PRIS_EN_CHARGE" name="etatV" type="radio" class="form-check-input" value="PRIS_EN_CHARGE" checked required> 
				<label class="form-check-label" for="credit">Pris en Charge</label>
				</div>
				<div>
				<input id="EN_COURS" name="etatV" type="radio" class="form-check-input" value="EN_COURS" required> 
				<label class="form-check-label" for="debit">En cours</label>
				</div>
				<div>
				<input id="TERMINE" name="etatV" type="radio" class="form-check-input" value="TERMINE" required> 
				<label class="form-check-label" for="paypal">Terminé</label>
				</div>								
			</td>
			<td>
				<button class="w-100 btn btn-primary btn-lg" width="80" type="submit">Ajouter</button>
			</td>
			</form>
		</div>
	
