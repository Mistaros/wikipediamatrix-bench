package fr.univrennes1.istic.wikipediamatrix;

import java.util.ArrayList;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Header {

	ArrayList<String> nom_variables;
	int nb_variable;
	
	public Header (Elements liste) {	
		String str;
		this.nom_variables = new ArrayList<String>();
		for (Element variable : liste) {
			str=variable.text();
			nom_variables.add(str);
		}
		this.nb_variable=nom_variables.size();
	}

	
	
	
	/* Fonction pour csv perso*/
	public String toCSV(String sep) {
		String str = new String();
		for(int i=0;i<this.nom_variables.size();i++) {
			str = str + nom_variables.get(i) + sep;
		}
		return str;
	}
	
}
