package test;

import static org.junit.Assert.*;

import java.util.Vector;

import statistics.Statistics;

import org.junit.Ignore;
import org.junit.Test;

public class StatisticsTest {
	Statistics null_data = new Statistics(null);
	
	Vector ten_values = new Vector();
	for (int j= 0; j < 2; j++ ) {
		for (int i = 0; i < 10; i++) {
			ten_values.addElement((float) i);
		}
		
	Statistics ten_data = new Statistics(ten_values);
	Vector one_value = new Vector();
	one_value.addElement((float)0);
	Statistics one_data = new Statistics(one_value);
	// Pruebas relativas a la media
	@Test
	public void average_0(){
//		assertEquals(0,);
	}
	
	// Pruebas relativas a la dist. tipica
	
	// Pruebas relativas al histograma
	
	
}
