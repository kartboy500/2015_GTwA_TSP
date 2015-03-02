package GraphTheory;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class SolarDriver {
private static final int nPoints= 15;
private static final int max=1000;
private static final int min=0;
private static Point COM;


public static void main(String[] args) {
	Universe Prince= new Universe(max, min, nPoints);
	Prince.addPoints();
	COM = Prince.findCOM();
	
	ArrayList<Point> points = Prince.getList();
	ArrayList<Double> angles = new ArrayList<>(nPoints);
	HashMap<Double, Point> anglesToPoints = new HashMap<>(nPoints);
	
	for(Point p : points) {
		angles.add(COM.findAngle(p));
		anglesToPoints.put(COM.findAngle(p), p);
	}
	
	ArrayList<Double> orderedAngles = new ArrayList<>(nPoints);
	// add sort for angles from least to greatest
	
	ArrayList<Point> orderedPoints = new ArrayList<>(nPoints);
	for(double angle : angles) {
		orderedPoints.add(anglesToPoints.get(angle));
	}
	
	// Now, use the ArrayList orderedPoints and the ArrayList orderedAngles for the visualization
	
	// Why are you printing to terminal? I am commenting this out for now
	/*System.out.println(COM.getX() + "\t" + COM.getY());
	for (Point p: Prince.getList())
	{
		System.out.println(p.getX() + "\t" + p.getY());
	}*/
	
}

}
