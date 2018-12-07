package fr.univrennes1.istic.wikipediamatrix;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.validation.Validator;

import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public abstract class ValiderUrl extends Validator{

	public static Boolean estValide(String url) {
        boolean bool = false;
        try {
            URL uneURL = new URL(url.toString());
            HttpURLConnection connexion = (HttpURLConnection)uneURL.openConnection();
            if (connexion.getResponseCode() == HttpURLConnection.HTTP_OK) {
                bool=true;
            }
            connexion.disconnect();
        } 
        catch(Exception e) {
        }
        return bool;
    }
	
	public static Boolean is404(String url) throws IOException {
		boolean bool = false;
		try{
            Document doc = Jsoup.connect(url).get();
            bool=true;
        }  catch (HttpStatusException e) {                  //permet de gérer les problèmes si l'URL n'existe pas : error 404
            System.out.println("L'URL " + url +" n'existe pas");
        }
		return bool;
	}
	
	public static Boolean valide(String url) throws IOException {
		boolean bool1,bool2,bool3 = false;
		bool1 = is404(url);
		bool2 = estValide(url);
		bool3 = bool1&bool2;
		return bool3;
	}
}
