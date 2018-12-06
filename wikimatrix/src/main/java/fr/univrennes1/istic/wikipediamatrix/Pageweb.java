package fr.univrennes1.istic.wikipediamatrix;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Pageweb {

	public String url;
	public ArrayList<Table> tableaux;
	
	public Pageweb(String url) throws IOException {
		this.url=url;
		this.tableaux = new ArrayList<Table>();
		/* création de l'ensemble des tableaux*/
		Document doc = Jsoup.connect(url).get();

		Elements listeTableau = doc.select("table");

		for(int i =0; i<listeTableau.size();i++) {
			Table temp = new Table("Titre", listeTableau.get(i));
			this.tableaux.add(temp);
		}
	}
	
	public void  toCSV(String sep) {
		String str = new String();
		str=url + "\n";
		for( int i =0; i<tableaux.size();i++) {
			str = str + tableaux.get(i).nom_table + "\n";
			str = str + tableaux.get(i).toCSV(sep);			
		}
		System.out.println(str);
	}
	
	
	
	
	
}
