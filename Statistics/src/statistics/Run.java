package statistics;

import java.util.Vector;

import exceptions.ErrorCategoryNumber;
import exceptions.ErrorDataEmpty;

public class Run {

	public static void main(String[] args) {
		Vector<Float> prueba = new Vector<Float>();
		for (int j= 0; j < 2; j++ ) {
		for (int i = 0; i < 10; i++) {
			prueba.addElement((float) i);
		}
		}
		
		Statistics objeto = new Statistics(prueba);
		try {
			System.out.println(objeto.variance());
		} catch (ErrorDataEmpty e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			System.out.println(objeto.histogram(2));
		} catch (ErrorCategoryNumber | ErrorDataEmpty e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
