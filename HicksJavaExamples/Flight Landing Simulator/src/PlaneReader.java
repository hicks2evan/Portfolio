import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//Data reader
public class PlaneReader {
	
	public PlaneReader() {
		
	}
	
	public ArrayList<ArrayList<Plane>> readPlanes(String fileName) throws FileNotFoundException {
		Scanner reader = new Scanner(new File(fileName));
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<ArrayList<Plane>> hashMap = new ArrayList<ArrayList<Plane>>();
		for(int i = 0; i < 1100; i++) {
			ArrayList<Plane> someList = new ArrayList<Plane>();
			hashMap.add(someList);
		}
		
		reader.nextLine();
		while (reader.hasNextLine()) {
			list.add(reader.nextLine());
		}
		reader.close();
		for (int i = 0; i < list.size(); i++) {
			String[] data = list.get(i).split("\\s+");
			String ID = data[0];
			int arrival = Integer.parseInt(data[1]);
			int priority = Integer.parseInt(data[2]);
			Plane myPlane = new Plane(ID, arrival, priority);
			hashMap.get(arrival).add(myPlane);
		}
		return hashMap;
	}
	
	public int readRunways(String fileName) throws FileNotFoundException {
		Scanner reader = new Scanner(new File(fileName));
		int numRunways = reader.nextInt();
		reader.close();
		return numRunways;
	}

}
