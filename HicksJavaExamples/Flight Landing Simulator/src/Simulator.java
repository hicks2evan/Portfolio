import java.util.ArrayList;

public class Simulator {
	int numberRunways;
	ArrayList<ArrayList<Plane>> data;
	public Simulator(ArrayList<ArrayList<Plane>> planeData, int numRunways) {
		data = planeData;
		numberRunways = numRunways;
	}
	ArrayList<Plane> queue = new ArrayList<Plane>();
	ArrayList<Plane> output = new ArrayList<Plane>();

	public ArrayList<Plane> simulate() {
		int i = 1;
		while(!data.get(i).isEmpty()) {
			for(int j = 0; j < data.get(i).size(); j++) {
				queue.add(data.get(i).get(j));
			}
			inserstionSort(queue);
			int k = 0;
			while((queue.isEmpty() == false) && (k < numberRunways)) {
				queue.get(0).setLandingTime(i);
				output.add(queue.get(0));
				queue.remove(0);
				k++;
			}
			i++;
		}
		while(queue.isEmpty() == false) {
			for(int m = 0; m < numberRunways; m++) {
				queue.get(0).setLandingTime(i);
				output.add(queue.get(0));
				queue.remove(0);
			}
			i++;
		}
		return output;
	}
	
	public ArrayList<Plane> inserstionSort(ArrayList<Plane> queuedPlanes) {
		int j;
		Plane key;
		int i;
		for (j = 1; j < queuedPlanes.size(); j++) {
			key = queuedPlanes.get(j);
			for(i = j - 1; (i >= 0) && (queuedPlanes.get(i).compareTo(key) > 0); i--) {
	                 queuedPlanes.set(i+1, queuedPlanes.get(i));
	        }
			queuedPlanes.set(i+1, key);
	    }
		return queuedPlanes;
	}

}
