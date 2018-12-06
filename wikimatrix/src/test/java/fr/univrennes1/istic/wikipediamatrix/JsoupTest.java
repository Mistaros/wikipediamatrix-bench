package fr.univrennes1.istic.wikipediamatrix;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;


public class JsoupTest {


	public void test() throws IOException {
		Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
		System.out.println((doc.title()));
		Elements newsHeadlines = doc.select("#mp-itn b a");
		for (Element headline : newsHeadlines) {
			System.out.println("%s\n\t%s" + headline.attr("title") + headline.absUrl("href"));
		}
	}

	@Test
	public void testurlCanon() throws IOException {
		// test sur cet url https://en.wikipedia.org/wiki/Comparison_of_Canon_EOS_digital_cameras
		//String url ="https://en.wikipedia.org/wiki/Comparison_of_Canon_EOS_digital_cameras";
		String url ="https://fr.wikipedia.org/wiki/Liste_des_Pok%C3%A9mon_de_Pok%C3%A9mon_Rouge_et_Bleu";
		Document doc = Jsoup.connect(url).get();
		System.out.println(doc.title());


		Elements tableau = doc.select("table");

		// remove les <sup> </sup>
		
		Elements sup =tableau.select("sup");
		System.out.println(sup.text());
		
		sup.remove();
		
		Element table = tableau.get(0);
		Element firstl = table.select("tr").first();
		Elements colonne = firstl.select("th");

		//System.out.println(tableau);
		//System.out.println(colonne);

		// recuperation nom variable
		String str = new String();
		System.out.println(colonne.size());
		System.out.println(colonne);
		for(Element headline : colonne) {
			str = str + headline.text() + ";";
		}
		System.out.println(str);

		// recuperation valeur variable
		System.out.println("separtion");
		Elements ligne = table.select("tr");
		String strl = new String();

		for (int i =0; i<ligne.size();i++) {
			Elements obs = ligne.get(i).select("td");
			for(Element headline : obs) {
				strl = strl + headline.text() + ";";
			}
			strl = strl + "\n";

		}

		PrintWriter pw = new PrintWriter(new File("output/html/test.csv"));
		String S = str + strl + "\n";
		pw.write(S);
		pw.close();
		System.out.println("done!");

		String a,b,c,d;
		a="";
		b="vbel";
		c="";
		d="bla";
		String e;
		e=a+";"+b+";"+c+";"+d+";";
		System.out.println(e);

	}

}
