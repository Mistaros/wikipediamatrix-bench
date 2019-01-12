package fr.univrennes1.istic.wikipediamatrix;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ValiderTableTest {

	@Test
	public void testTable1_1() {
		Table tableTest = new Table();
		ArrayList<Observation> liste= new ArrayList<Observation>();
		
		Header head = new Header();
		head.nb_variable=1;
		tableTest.nom_variable=head;
		
		Observation obsTest = new Observation();
		obsTest.nb_variable=1;
		tableTest.observations=liste;
		tableTest.observations.add(obsTest);
		if(ValiderTable.table1_1(tableTest)) 
			fail("La fonction accepte des tableaux 1 x 1 ou de dimension inférieur");
	}
	
	@Test
	public void testTableNbVar() {
		Table tableTest = new Table();
		ArrayList<Observation> liste= new ArrayList<Observation>();
		
		Header head = new Header();
		head.nb_variable=5;
		tableTest.nom_variable=head;
		
		Observation obsTest = new Observation();
		obsTest.nb_variable=1;
		tableTest.observations=liste;
		tableTest.observations.add(obsTest);
		if(ValiderTable.tableNbVar(tableTest)) 
			fail("La fonction accepte des tableaux alors que le nombre de variables du header et celui d'une des observation différent");
	}
}

