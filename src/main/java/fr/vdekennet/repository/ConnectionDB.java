package fr.vdekennet.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=GarageVdE;"
			+ "user=Kennet;password=Kennet2024!;trustServerCertificate=true;";
	private static Connection connection = null;

	// Méthode pour obtenir la connexion à la base de données
	public static Connection getConnection() {
		if (connection == null) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");         // Établit la connexion à la base de données
				connection = DriverManager.getConnection(URL);
				System.out.println("Connexion réussie à la base de données.");
			} catch (SQLException | ClassNotFoundException e) {
				// En cas d'échec de la connexion, on affiche l'erreur
				System.err.println("Échec de la connexion à la base de données.");
				e.printStackTrace();
			}
		}
		return connection;
	}

	// Méthode pour fermer la connexion
	public static void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
				System.out.println("Connexion fermée.");
			} catch (SQLException e) {
				System.err.println("Échec de la fermeture de la connexion.");
				e.printStackTrace();
			}
		}
	}

	public static void chargeDB () {
		if (connection != null) {
			Statement stmt = null;
			ResultSet rs = null;

			try {
				stmt = connection.createStatement();

				// 1. Créer la table si elle n'existe pas
				String createTableSQL = 
						"IF NOT EXISTS (SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'Voiture') " +
								"BEGIN " +
								"CREATE TABLE Voiture (" +
								"matricule VARCHAR(15) PRIMARY KEY, " +
								"marque VARCHAR(40) NOT NULL, " +
								"modele VARCHAR(50) , " +
								"etat VARCHAR(15) CHECK (etat IN('EN_COURS','PRIS_EN_CHARGE', 'TERMINE')) " +
								"END";

				stmt.executeUpdate(createTableSQL);
				System.out.println("Table 'Voiture' vérifiée/créée.");


			} catch (SQLException e) {
				System.err.println("Erreur SQL :");
				e.printStackTrace();
			} finally {
				try {
					if (rs != null) rs.close();
					if (stmt != null) stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			System.err.println("Échec de connexion à la base de données.");
		}
	}
}
