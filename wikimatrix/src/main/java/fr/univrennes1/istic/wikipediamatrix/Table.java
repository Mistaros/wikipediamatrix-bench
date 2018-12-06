package fr.univrennes1.istic.wikipediamatrix;

import java.util.ArrayList;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Table {

	public String nom_table;
	public Header nom_variable;
	public ArrayList<Observation> observations;

	public Table(String nom_table, Element tableau) {

		this.nom_table=nom_table;
		this.observations = new ArrayList<Observation>();

		/*suppression annotation*/
		Elements sup= tableau.select("sup");
		sup.remove();

		/* initialisation header */
		Element nom = tableau.select("tr").first();
		Elements colonne = nom.select("th");

		this.nom_variable= new Header(colonne);

		/* initialisation variable*/
		Elements lignes = tableau.select("tr");
		for(int i =1; i<lignes.size();i++) {
			Observation temp = new Observation(lignes.get(i).select("td"));
			if(temp.observation.size()!=0) {
				observations.add(temp);
			}
		}

	}




	/* Fonction pour csv perso*/
	public String toCSV(String sep) {
		String str = new String();
		str = nom_variable.toCSV(sep)+"\n";

		for(int i =0; i<observations.size();i++) {
			str = str +  observations.get(i).toCSV(sep) + "\n";
		}
		return str;
	}

	/* Verif*/
	public void Test() {
		for (int i=0; i<this.observations.size(); i++) {
			if(this.nom_variable.nb_variable == this.observations.get(i).nb_variable) {
				System.out.println("TRUE");
			} else {
				System.out.println("FALSE");
			}
		}
	}

}
