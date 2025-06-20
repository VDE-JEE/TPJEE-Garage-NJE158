package fr.vdekennet.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.vdekennet.model.EtatVoiture;
import fr.vdekennet.model.Voiture;


public class VoitureDAO {
	static Connection connex = ConnectionDB.getConnection();
	static Statement stmt = null;
    static ResultSet resu = null;
   
    
   static public void ajouter(String matricule, String marque, String modele, String etatString) {
		EtatVoiture etat;
    	if (connex!=null) {
    		try {
    			etat = EtatVoiture.valueOf(etatString);
				stmt = connex.createStatement();
    			String requeteSQL = "INSERT INTO Voiture VALUES ('" + 
    					matricule +"', '"+ marque +"', '" + modele + "', '" + etat +"' );";
    			stmt.executeUpdate(requeteSQL);
    			System.out.println("Ajout du produit effectué.");
			} catch (Exception e) {
				System.err.println("Erreur SQL :");
                e.printStackTrace();
			} 
    		finally {
				try {
	                    if (resu != null) resu.close();
	                    if (stmt != null) stmt.close();
	             } 
				 catch (SQLException e) {  e.printStackTrace(); }
			}
    	}
    	
	}
    
   static public List<Voiture> afficher() {
		System.out.println("Démarragede la fonction afficher.");
    	if (connex!=null) {
    		EtatVoiture etat;
    		try {
    			List<Voiture> garage = new ArrayList<Voiture>();
				stmt = connex.createStatement();
				
    			String requeteSQL = "Select * FROM Voiture";
    			resu = stmt.executeQuery(requeteSQL);
    			
    			System.out.println("Voitures du garage : ");
    			while (resu.next()) {
    				String matricule = resu.getString("matricule");
	                String marque = resu.getString("marque");
	                String modele = resu.getString("modele");
	                String etatStr = resu.getString("etat");
					
	              //quand tu veux caster en enum, c'est important de placer des try/catch autour 
					etat = EtatVoiture.valueOf(etatStr);
					garage.add(new Voiture(matricule, marque, modele, etat));  
					System.out.println("Voiture " + garage.getLast());
    			}
    			return garage;
			} catch (Exception e) {
				System.err.println("Erreur SQL :");
                e.printStackTrace();
			} 
    		finally {
				try {
	                    if (resu != null) resu.close();
	                    if (stmt != null) stmt.close();
	             } 
				 catch (SQLException e) {  e.printStackTrace(); }
			}
    	} else System.err.println("Échec de connexion à la base de données.");
    	System.out.println("Aucun véhicule à afficher...");
    	return null;
	}
    
    
   static public List<Voiture> rechercher( String trouve) {
			
	    	if (connex!=null) {
	    		try {
	    			List<Voiture> garage = new ArrayList<Voiture>();
					stmt = connex.createStatement();
					
	    			String requeteSQL = "Select * FROM Voiture "
    								  + "WHERE modele ='" + trouve + "' OR marque = '" + trouve + "' ;";
	    			resu = stmt.executeQuery(requeteSQL);
	    			System.out.println("Voitures trouvées : ");
	    			while (resu.next()) {
	    				String matricule = resu.getString("matricule");
		                String marque = resu.getString("marque");
		                String modele = resu.getString("modele");
		                String etatStr = resu.getString("etat");

		              //quand tu veux caster en enum, c'est important de placer des try/catch
		                try {
		                	EtatVoiture etat = EtatVoiture.valueOf(etatStr);
							garage.add(new Voiture(matricule,marque, modele, etat));
							System.out.println("Véhicule " + garage.getLast() );
						} catch (Exception e) {
							e.printStackTrace();
						}  
	    			}
	    			return garage;
				} catch (Exception e) {
					System.err.println("Erreur SQL :");
	                e.printStackTrace();
				} 
	    		finally {
					try {
		                    if (resu != null) resu.close();
		                    if (stmt != null) stmt.close();
		             } 
					 catch (SQLException e) {  e.printStackTrace(); }
				}
	    	} else System.err.println("Échec de connexion à la base de données.");
	    	System.out.println("Aucun Véhicule trouvé...");
	    	return null;
		}

   static public Voiture rechercherID(String matricule) {
	   Voiture baniole=null;
	   
	   EtatVoiture etat ;
	   if (connex!=null) {
    		try {
				stmt = connex.createStatement();
				
    			String requeteSQL = "Select * FROM Voiture "
    								+ "WHERE matricule ='" + matricule + "' ;";
    			resu = stmt.executeQuery(requeteSQL);
    			
	    			while (resu.next()) {
						String marque = resu.getString("marque");
		                String modele = resu.getString("modele");
		                String etatStr = resu.getString("etat");
		            	etat = EtatVoiture.valueOf(etatStr);
		
		            	baniole = new Voiture(matricule, marque, modele, etat);
						System.out.println("Voiture " + baniole + " trouvée !\n");
	    			}
    			
    			
			} catch (Exception e) {
				System.err.println("Erreur SQL :");
				e.printStackTrace();
			} 
    	} else {
    		System.err.println("Échec de connexion à la base de données.");
    	}
    	return baniole;
	}

   static public Voiture modifier(String trouve, String marque, String modele, String etatString ) {
    	EtatVoiture etat;
    	if (connex!=null) {
    		try {
    			Voiture voitureAChanger = rechercherID(trouve);
    			stmt = connex.createStatement();
    			
    			System.out.println("voiture trouvée par ID : " + voitureAChanger +
    					"\nChangements à faire : " +marque+ " " + modele +" | "+ etatString);
    			
    			Voiture voitureChangee;
    			if (voitureAChanger != null) {
    				 
    				etat = EtatVoiture.valueOf(etatString);
    				String requeteSQL = "UPDATE Voiture "
    						+ "SET marque = '" + marque + "' , modele = '" + modele + "', etat = '" + etatString + "' "
    								+ "WHERE matricule = '" + trouve + "'";
    				System.out.println("requete : " + requeteSQL);
    				stmt.executeUpdate(requeteSQL);
    				voitureChangee = new Voiture(trouve, marque, modele, etat);
    				System.out.println("Modification effectuée avec succès :"
    						+ " \nLa voiture " + voitureAChanger 
    						+ " \n\t est désormais "
    						+ " \nLa voiture" + voitureChangee
    						+ " \n");
    				return voitureChangee;
    			}else System.err.println("Echec de la mise à jour : Voiture non trouvée.");
			} 
    		catch (SQLException e) {
    			 System.out.println("Echec de la mise à jour : Erreur SQL.");
                e.printStackTrace();
			} 
    		finally {
    			   try {
	                    if (resu != null) resu.close();
	                    if (stmt != null) stmt.close();
	                }
	                catch (SQLException e) {
	                    e.printStackTrace();
	                }
			}
    	}
    	return null;
	}

   static public void supprimer(String trouve) {
		
    	if (connex!=null) {
    		try {
    			
    			Voiture aLaCasse = rechercherID(trouve);
    			stmt = connex.createStatement();
    			if (aLaCasse!= null) {
    				
    				String requeteSQL = "DELETE FROM Voiture "
										+ " WHERE matricule = '" 
										+ trouve + "' ;";
    				stmt.executeUpdate(requeteSQL);
    				System.out.println("Véhicule "+ aLaCasse + " supprimé avec succès.");
    			}else System.err.println("Echec de la suppression : Voiture non trouvée.");
			} 
    		catch (Exception e) {
    			 System.out.println("Echec de la suppression : Erreur SQL.");
                e.printStackTrace();
			} 
    		finally {
    			   try {
	                    if (resu != null) resu.close();
	                    if (stmt != null) stmt.close();
	                }
	                catch (SQLException e) {
	                    e.printStackTrace();
	                }
			}
    	}	
	}










}
