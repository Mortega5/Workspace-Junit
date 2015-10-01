package statistics;

import java.util.Vector;
public class Statistics {

	private Vector <Float> data;
	
	/*
	 * Constructor
	 */
	public Statistics (Vector <Float> data) {
		this.data = data;
	}
	
	public Float average() {
		float sum = 0;
		for (Float number:data) {
			sum+=number;
		}
		return sum/data.size();
	}
	
	public float variance() {
		float sum = 0;
		float N = data.size();
		for (Float number:data) {
			sum+=number*number/N;
		}
		return sum - this.average();
	}
	
	public String histogram(){
		String histogram = "";
		return histogram;
	}
}
