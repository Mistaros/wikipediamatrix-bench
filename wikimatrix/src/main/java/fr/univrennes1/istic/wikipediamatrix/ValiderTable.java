package fr.univrennes1.istic.wikipediamatrix;

import javax.xml.validation.Validator;

public abstract class ValiderTable extends Validator{

	/* Fonction global pour valider tableau */
	public static boolean validerTableau(Table table) {
		boolean bool = true;
		
		bool= bool & table1_1(table);
		return bool;
	}
	
	/* vérification que le tableau n est pas 1*1 */
	public static boolean table1_1(Table table){
		boolean bool=true;
		if (table.observations.size()==1 && table.nom_variable.nb_variable==1) {
			bool =false;
		}
		return bool;
	}
	
	
}
