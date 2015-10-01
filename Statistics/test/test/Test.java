package test;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.Vector;

import statistics.Statistics;

import org.junit.Ignore;
import org.junit.Test;

public class StatisticsTest {
	//Declaramos metodo auxiliar para rellenar los vectores de prueba
	public void filldata(Vector<Float> vector, int size){
		for (int j= 0; j < 2; j++ ) {
			for (int i = 0; i < size; i++) {
				vector.addElement((float) i);
			}
		}
	}
	// Creamos un objeto Statistics formado por un vector vacio
	Statistics null_data = new Statistics(null);

	//Creamos un objeto Statistics formado por un vector con un elemento
	Vector<Float> one_value = new Vector<Float>();
	one_value.addElement(0);
	Statistics one_data = new Statistics(one_value);


	//Creamos un objeto Statistics formado por un vector con diez elementos
	Vector<Float> ten_values = new Vector<Float>();
	filldata(ten_values,10);
	Statistics ten_data = new Statistics(ten_values);


	// Pruebas relativas a la media
	@Test
	public void average_null_data(){
		assertEquals(0,null_data.average());
	}

	@Test
	public void average_one_data(){
		assertEquals(0,one_data.average());
	}

	// Pruebas relativas a la dist. tipica

	// Pruebas relativas al histograma

