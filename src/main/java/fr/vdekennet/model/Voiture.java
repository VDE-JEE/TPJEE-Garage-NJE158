package fr.vdekennet.model;

public class Voiture {
	private String matricule;
	private String marque;
	private String modele;
	private EtatVoiture etat;
	
	public Voiture(String matricule, String marque2, String modele2, EtatVoiture etat2) {
		this.matricule = matricule;
		this.marque = marque2;
		this.modele = modele2;
		this.etat = etat2;
	}
	
	public Voiture(String marque2, String modele2, EtatVoiture etat2) {
		this.marque = marque2;
		this.modele = modele2;
		this.etat = etat2;
	}

	public String getMatricule() {
		return matricule;
	}
	public EtatVoiture getEtat() {
		return etat;
	}
	public String getMarque() {
		return marque;
	}
	public String getModele() {
		return modele;
	}
	public void setEtat(EtatVoiture etat) {
		this.etat = etat;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	
	@Override
	public String toString() {
		return "N°"+this.matricule + " | " + this.marque + " " + this.modele + " | " + this.etat;
	}
}
