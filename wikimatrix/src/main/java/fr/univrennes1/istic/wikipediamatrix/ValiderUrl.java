package fr.univrennes1.istic.wikipediamatrix;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.validation.Validator;

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
	
	
}
