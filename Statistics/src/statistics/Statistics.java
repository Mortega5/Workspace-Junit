package statistics;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Statistics {

	private Vector<Float> data;
	private static int bar = 3;
	private static int space = 4;

	/*
	 * Constructor
	 */
	public Statistics(Vector<Float> data) {
		this.data = data;
	}

	public Float average() {
		float sum = 0;
		for (Float number : data) {
			sum += number;
		}
		return sum / data.size();
	}

	public float variance() {
		float sum = 0;
		float N = data.size();
		for (Float number : data) {
			sum += number * number / N;
		}
		return sum - this.average();
	}

	private float length() {
		// TODO comprobar que la lista no esta vacia
		float max = data.get(0);
		float min = data.get(0);
		for (Float number : data) {
			if (max < number) {
				max = number;
			}
			if (min > number) {
				min = number;
			}
		}
		return Math.abs(max - min);
	}

	private Map<Integer, Integer> mapeo(int intervalo, int nCat) {
		Map<Integer, Integer> list = new HashMap<Integer, Integer>();

		for (Float number : data) {
			int key = (int) Math.ceil(number) / nCat;
			if (key > intervalo)
				key--;
			if (list.get(key) != null) {
				list.replace(key, list.get(key) + 1);
			} else {
				list.put(key, 1);
			}
		}
		return list;
	}

	public String histogram(int categoryNumber) {
		float length = length();

		int intervalo = (int) (Math.ceil(length / categoryNumber));

		// Contamos elementos dentro del rango
		Map<Integer, Integer> list = mapeo(intervalo, categoryNumber);
		int maxOcurrency = 0;
		for (Map.Entry<Integer, Integer> entry : list.entrySet()) {
			if (maxOcurrency < entry.getValue()) {
				maxOcurrency = entry.getValue();
			}
		}
		String[] histogram = new String[intervalo + 2];
		histogram[0] = "  ";
  		for (int i = 0; i <= maxOcurrency + 1; i++) {
			histogram[0] += "- ";
		}
  		for (Map.Entry<Integer, Integer> entry: list.entrySet()) {
  			System.out.println("Clave: " + entry.getKey() + " Value: " + entry.getValue());
  		}

		for (int i = 1; i < histogram.length; i++) {
			histogram[i] = i-1 + "|";
			if (i - 1 < list.size()) {
				for (int j = 0; j < list.get(i-1); j++) {
					histogram[i] += "*  ";
				}
			}
		}
		String output = "";
		for (int i = 0; i < histogram.length; i++) {
			output += histogram[i] + "\n";
			output += " |\n";
		}
		return output;
	}
}
