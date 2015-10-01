package test;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
import java.util.Vector;

import statistics.Statistics;

import org.junit.Ignore;
import org.junit.Test;

import exceptions.ErrorDataEmpty;

public class StatisticsTest {
	// Declaramos metodo auxiliar para rellenar los vectores de prueba
	public void filldata(Vector<Double> vector, int size){
		for (int i = 1; i < size+1; i++) 
			vector.addElement((double) i);
	}

	@Test(expected = ErrorDataEmpty.class)
	public void average_null_data() throws ErrorDataEmpty {

		Vector<Double> null_data = new Vector<Double>();
		Statistics test1 = new Statistics(null_data);
		test1.average();
	}

	@Test
	public void average_one_data() throws ErrorDataEmpty {
		Vector<Double> data = new Vector<Double>();
		filldata(data, 1);
		Statistics test2 = new Statistics(data);
		assertEquals((double)1.0, test2.average());
	}

	@Test
	public void average_ten_data() throws ErrorDataEmpty {
		Vector<Double> data = new Vector<Double>();
		filldata(data, 9);
		Statistics test2 = new Statistics(data);
		assertEquals(5, test2.average());		
	}
	
	@Test(expected = ErrorDataEmpty.class)
	public void variance_null_data() throws ErrorDataEmpty {
		Vector<Double> null_data = new Vector<Double>();
		Statistics test1 = new Statistics(null_data);
		test1.variance();
	}
	
	@Test
	public void variance_one_data() throws ErrorDataEmpty {
		Vector<Double> data = new Vector<Double>();
		filldata(data, 1);
		Statistics test2 = new Statistics(data);
		assertEquals(0, test2.variance());
	}
	public void variance_ten_data() throws ErrorDataEmpty {
		Vector<Double> data = new Vector<Double>();
		filldata(data, 9);
		Statistics test2 = new Statistics(data);
		assertEquals(1, test2.variance());		
	}
}
