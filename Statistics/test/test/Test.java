package test;

import static org.junit.Assert.*;

import java.util.Vector;

import statistics.Statistics;

import org.junit.Ignore;
import org.junit.Test;

public class StatisticsTest {
	// Creamos un objeto Statistics formado por un vector vacio
	Statistics null_data = new Statistics(null);
	
	//Creamos un objeto Statistics formado por un vector con un elemento
	Vector one_value = new Vector();
	one_value.addElement((float)0);
	Statistics one_data = new Statistics(one_value);
		
	
	//Creamos un objeto Statistics formado por un vector con diez elementos
	Vector ten_values = new Vector();
	for (int j= 0; j < 2; j++ ) {
		for (int i = 0; i < 10; i++) {
			ten_values.addElement((float) i);
		}
	}
	Statistics ten_data = new Statistics(ten_values);
	
	
	// Pruebas relativas a la media
	@Test
	public void average_null_data(){
		assertEquals(0,null_data.average());
	}
	
	// Pruebas relativas a la dist. tipica
	
	// Pruebas relativas al histograma
	
