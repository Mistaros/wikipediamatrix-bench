package fr.univrennes1.istic.wikipediamatrix;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Hello world!
 *
 */
public class App 
{
	public static void main( String[] args ) throws IOException{
		System.out.println( "Hello World!" );

//		/* test */
//		String url ="https://fr.wikipedia.org/wiki/Liste_des_Pok%C3%A9mon_de_Pok%C3%A9mon_Rouge_et_Bleu";
//		//String url ="https://en.wikipedia.org/wiki/Comparison_of_Canon_EOS_digital_cameras";
//		Document doc = Jsoup.connect(url).get();
//		System.out.println(doc.title());
//		Elements tableau = doc.select("table");
//		Table test = new Table("Titre",tableau.get(0));
//		String str = test.toCSV(";");
//		System.out.println(str);
//		test.Test();
//		System.out.println(test.observations.get(test.observations.size()-1).observation.toString());
//		System.out.println(test.nom_table);
//		
//		Elements titre = doc.select("table caption");
//		System.out.println(titre.text());
//		
//		
		
		//String url = "Comparison_of_Canon_EOS_digital_cameras";
		String url = "Comparison_between_Esperanto_and_Ido";
		
		Pageweb test=new Pageweb(url,true);
		//test.toCSV(";");
		System.out.println("prie");
		System.out.println(test.tableaux.size());
		EcrireCSV.ecrireTables(test);
		
		
		
		
		
		
		
	}
}
