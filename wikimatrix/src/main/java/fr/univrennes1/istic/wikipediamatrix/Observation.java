package fr.univrennes1.istic.wikipediamatrix;

import java.util.ArrayList;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Observation {

	ArrayList<String> observation;
	int nb_variable;
	
	public Observation (Elements liste) {	
		String str;
		this.observation = new ArrayList<String>();
		for (Element variable : liste) {
			str=variable.text();
			observation.add(str);
		}
		this.nb_variable=observation.size();
	}

	
	
	
	/* Fonction pour csv perso*/
	public String toCSV(String sep) {
		String str = new String();
		for(int i=0;i<this.observation.size();i++) {
			str = str + observation.get(i) + sep;
		}
		return str;
	}
	
	
}
