package statistics;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import exceptions.ErrorCategoryNumber;
import exceptions.ErrorDataEmpty;

public class Statistics {

	private Vector<Double> data;

	/*
	 * Constructor
	 */
	public Statistics(Vector<Double> data) {
		this.data = data;
	}

	public double average() throws ErrorDataEmpty {
		if (data.size() == 0) {
			throw new ErrorDataEmpty();
		}
		double sum = 0;
		for (Double number : data) {
			sum += number;
		}
		return sum / data.size();
	}

	public double variance() throws ErrorDataEmpty {
		if (data.size() == 0) {
			throw new ErrorDataEmpty();
		}
		double sum = 0;
		double N = data.size();
		double mean = average();
		for (Double number : data) {
			sum += Math.pow(number - average(),2);
		}
		return sum/N;
	}

	private double length() {
		// TODO comprobar que la lista no esta vacia
		double max = data.get(0);
		double min = data.get(0);
		for (Double number : data) {
			if (max < number) {
				max = number;
			}
			if (min > number) {
				min = number;
			}
		}
		return Math.abs(max - min);
	}

	private Map<Integer, Integer> mapping(int intervalo, int nCat) {
		Map<Integer, Integer> list = new HashMap<Integer, Integer>();

		for (Double number : data) {
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

	public String histogram(int categoryNumber) throws ErrorCategoryNumber, ErrorDataEmpty {
		if (categoryNumber < 1) {
			throw new ErrorCategoryNumber();
		} else if (data.size() == 0) {
			throw new ErrorDataEmpty();
		}
		double length = length();
		int interval = (int) (Math.ceil(length / categoryNumber));

		// Contamos elementos dentro del rango
		Map<Integer, Integer> list = mapping(interval, categoryNumber);
		int maxOcurrency = 0;
		for (Map.Entry<Integer, Integer> entry : list.entrySet()) {
			if (maxOcurrency < entry.getValue()) {
				maxOcurrency = entry.getValue();
			}
		}
		String[] histogram = new String[interval + 2];
		histogram[0] = "  ";
		
  		for (int i = 0; i <= maxOcurrency + 1; i++) {
			histogram[0] += "- ";
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
