package fr.univrennes1.istic.wikipediamatrix;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public final class EcrireCSV {


	public static void genererCSV(String cheminFichierSortie, Table table) throws IOException{

		/* ouverture de la connexion avec la destination*/
		BufferedWriter writer = Files.newBufferedWriter(Paths.get(cheminFichierSortie));
		CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);

		/* ecrire variable */
		csvPrinter.printRecord(table.nom_variable.nom_variables);

		/* écriture ligne */
		for(int i=0; i< table.observations.size();i++){
			csvPrinter.printRecord(table.observations.get(i).observation);
		}

		/* fermeture connexion */
		csvPrinter.close();
	}


	public static String creerCheminSortie(String nom) {
		String str = "output/html/"+nom+".csv";
		return str;
	}

	public static void ecrireUnCsv(String nom, Table table) throws IOException {
		String str = creerCheminSortie(nom);
		genererCSV(str, table);
	}

	/* fonction qui cree l'ensemble des tableaux d une page */
	public static void ecrireTables(Pageweb page) throws IOException {
		String nom= page.url;
		nom = simplifier(nom);
		if(page.tableaux.size()!=0) {
			for (int i=0; i< page.tableaux.size();i++) {
				ecrireUnCsv(nom+"-"+i,page.tableaux.get(i));
			}
			System.out.println("page ecrite");
		} else {
			System.out.println("Rien a ecrire");
		}
	}

	public static String simplifier(String str) {
		int last = str.lastIndexOf("/");
		String res = str.substring(last);
		return res;	
	}


}
