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
		this(url, false);
	}

	public Pageweb(String url, boolean wiki) throws IOException {
		String effectiveUrl = "";
		if (wiki) {
			effectiveUrl = "https://en.wikipedia.org/wiki/"+url;
		} else {
			effectiveUrl = url;		
		}

		if (ValiderUrl.estValide(effectiveUrl)) {
			this.url=effectiveUrl;
			this.tableaux = new ArrayList<Table>();
			System.out.println(this.url);
			Document doc = Jsoup.connect(this.url).get();

			Elements tableaux = doc.select("[class~=(?i)sortable(?i)]");
			Elements wikitable = doc.select("table[class=wikitable]");
			tableaux.addAll(wikitable);
			//Elements span=tableaux.select("colspan");
			Elements listeTableau=tableaux.select("tbody");

			for(int i =0; i<listeTableau.size();i++) {
				Table temp = new Table("Titre", listeTableau.get(i));
				this.tableaux.add(temp);
			}
		} else {
			System.out.println("page/url non valide chef!");
		}
	}


	
	
	
	
	
	/*Fonction pour csv perso*/
	public void  toCSV(String sep) {
		String str = new String();
		str=url + "\n";
		for( int i =0; i<tableaux.size();i++) {
			str = str + tableaux.get(i).nom_table + "\n";
			str = str + tableaux.get(i).toCSV(sep);			
		}
		System.out.println(str);
	}










	/* cimetiere des idées*/	
	/* création de l'ensemble des tableaux*/
	/*ancienne version */
	//Document doc = Jsoup.connect(url).get();
	//Elements listeTableau = doc.select("table");

	/* nouvelle version */
	//Elements tableaux = Jsoup.connect(url).get().getElementsByClass("wikitable sortable");
	//tableaux.addAll(Jsoup.connect(url).get().getElementsByClass("tableaustandard sortable"));

}
