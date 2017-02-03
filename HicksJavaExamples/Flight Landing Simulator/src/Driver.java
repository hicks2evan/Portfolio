import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Evan Hicks
 * @author Evan
 * Introduction to Algorithms and Data Structures
 *Programming Assignment 3
 */

public class Driver {

	public static void main(String[] args) throws IOException {
		ArrayList<ArrayList<Plane>> hashMap = new ArrayList<ArrayList<Plane>>();
		PlaneReader reader = new PlaneReader();
		
		//Read plane data into driver
		int numRunways = reader.readRunways(args[0]);
		hashMap = reader.readPlanes(args[0]);
		
		//for(int i = 0; i < hashMap.size(); i++) {
		//	System.out.println(hashMap.get(i));
		//}
		
		Simulator mySimulator = new Simulator(hashMap, numRunways);
		
		ArrayList<Plane> simulatedOutput = mySimulator.simulate();
		
		FileWriter fw;
		fw = new FileWriter(new File(args[1]));
		for (int i = 0; i < simulatedOutput.size(); i++)
		{
			fw.write(simulatedOutput.get(i).getFlightID() + " " + simulatedOutput.get(i).getArrivalTime() + " " + simulatedOutput.get(i).getPriority() + " " + simulatedOutput.get(i).getLandingTime());
			fw.write("\n");
			
		}
		fw.close();
		
	//	for(int i = 0; i < simulatedOutput.size(); i++) {
		//	System.out.println(simulatedOutput.get(i));
		//}
		
		//System.out.println(mySimulator.inserstionSort(hashMap.get(1)));
		
		
		

		
		
	}
}
