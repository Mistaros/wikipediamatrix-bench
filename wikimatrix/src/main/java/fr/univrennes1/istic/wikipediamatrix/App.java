package fr.univrennes1.istic.wikipediamatrix;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

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
		//		String url ="https://www.pokepedia.fr/Liste_des_Pok%C3%A9mon_dans_l'ordre_du_Pok%C3%A9dex_National";
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
		//String url = "Comparison_of_file_sharing_applications";

		//Pageweb test=new Pageweb(url,true);
		//test.toCSV(";");
		//System.out.println("prie");
		//System.out.println(test.tableaux.size());
		//EcrireCSV.ecrireTables(test);
//
		
		/* test page pokemon */
//		String url ="https://www.pokepedia.fr/Liste_des_Pok%C3%A9mon_dans_l'ordre_du_Pok%C3%A9dex_National";
//		Pageweb test=new Pageweb(url,false);
//		EcrireCSV.ecrireTables(test);
		
		Scanner scanner=new Scanner(new File("inputdata/wikiurls.txt"));
		while (scanner.hasNextLine()) {
			String nom = scanner.nextLine();
			Pageweb temp = new Pageweb(nom,true);
			if (temp.tableaux.size()!=0 ) {
				EcrireCSV.ecrireTables(temp);
			}

		}
		scanner.close();

	}
}
