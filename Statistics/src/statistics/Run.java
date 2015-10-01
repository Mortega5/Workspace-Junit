package statistics;

import java.util.Vector;

public class Run {

	public static void main(String[] args) {
		Vector<Float> prueba = new Vector<Float>();
		for (int j= 0; j < 2; j++ ) {
		for (int i = 0; i < 10; i++) {
			prueba.addElement((float) i);
		}
		}
		Statistics objeto = new Statistics(prueba);

		System.out.println("Tamaño lista: " + prueba.size());
		
		System.out.println(objeto.histogram(2));
	}

}
