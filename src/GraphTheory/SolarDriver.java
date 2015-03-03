package GraphTheory;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

public class SolarDriver {
private int nPoints;
private int max;
private int min;
public Point COM;
private ArrayList<Point> pf;
private ArrayList<Double> af;
private ArrayList<Point> pf2;
private ArrayList<Point> pf3;
private ArrayList<Point> points;
public double totalLength;
public double totalLength2; //heuristic 2
public double totalLength3; //exhaustive


public SolarDriver(int min1, int max2, int nPoints2) {
	max=max2;
	min=min1;
	nPoints=nPoints2;
	Universe Prince= new Universe(max, min, nPoints);
	Prince.addPoints();
	COM = Prince.findCOM();
	
	points = Prince.getList();
	ArrayList<Double> orderedAngles = new ArrayList<>(nPoints);
	HashMap<Double, Point> anglesToPoints = new HashMap<>(nPoints);
	
	for(Point p : points) {
		//orderedAngles.add(COM.findAngle(p));
		//anglesToPoints.put(COM.findAngle(p), p);
		orderedAngles.add(p.findAngle(COM));
		anglesToPoints.put(p.findAngle(COM), p);
	}
	
	Collections.sort(orderedAngles);
	
	/*
	for(int i = 0; i < orderedAngles.size(); i++) {
		System.out.println(orderedAngles.get(i));
	}
	*/
	
	ArrayList<Point> orderedPoints = new ArrayList<>(nPoints);
	for(double angle : orderedAngles) {
		orderedPoints.add(anglesToPoints.get(angle));
	}
	
	totalLength = 0;
	for(int i = 0; i < orderedPoints.size(); i++) {
		if(i < orderedPoints.size()-1) {
			totalLength += orderedPoints.get(i).getDistance(orderedPoints.get(i+1));
		}
		else {
			totalLength += orderedPoints.get(i).getDistance(orderedPoints.get(0));
		}
	}
	pf = orderedPoints;
	af = orderedAngles;
	
	pf2 = orderedPoints;
	//Heuristic 2
	ArrayList<Double> distances = Prince.getAverages(orderedPoints);
	ArrayList<Double> differenceList = Prince.getDifferences(distances);
	double averageDifference = Prince.findaveragedistance(differenceList);
	double standardDeviation = Prince.findSD(differenceList);
	ArrayList<Integer> indexes = new ArrayList<Integer>();
	for(double difference : differenceList) {
		if(difference > 1.5*standardDeviation + averageDifference) {
			indexes.add(differenceList.indexOf(difference));
		}
	}
	for(int i : indexes) {
		Point p = pf2.get(i);
		if(i == 0) {
			double o1 = p.getDistance(pf2.get(pf2.size()-2))+p.getDistance(pf2.get(pf2.size()-1));
			double o2 = p.getDistance(pf2.get(pf2.size()-1))+p.getDistance(pf2.get(i+1));
			double o3 = p.getDistance(pf2.get(i+1))+p.getDistance(pf2.get(i+2));
			ArrayList<Double> options = new ArrayList<Double>(3);
			options.add(o1);
			options.add(o2);
			options.add(o3);
			Collections.sort(options);
			if(options.get(0) == o1) {
				pf2.remove(i);
				pf2.add(pf2.size()-1, p);
			}
			else if (options.get(0) == o2) {
				
			}
			else {
				pf2.remove(i);
				pf2.add(i+1, p);
			}
		}
		else if (i == 1) {
			double o1 = p.getDistance(pf2.get(pf2.size()-1))+p.getDistance(pf2.get(i-1));
			double o2 = p.getDistance(pf2.get(i-1))+p.getDistance(pf2.get(i+1));
			double o3 = p.getDistance(pf2.get(i+1))+p.getDistance(pf2.get(i+2));
			ArrayList<Double> options = new ArrayList<Double>(3);
			options.add(o1);
			options.add(o2);
			options.add(o3);
			Collections.sort(options);
			if(options.get(0) == o1) {
				pf2.remove(i);
				pf2.add(i-1, p);
			}
			else if (options.get(0) == o2) {
				
			}
			else {
				pf2.remove(i);
				pf2.add(i+1, p);
			}
		}
		else if (i == pf2.size()-1) {
			double o1 = p.getDistance(pf2.get(i-2))+p.getDistance(pf2.get(i-1));
			double o2 = p.getDistance(pf2.get(i-1))+p.getDistance(pf2.get(0));
			double o3 = p.getDistance(pf2.get(0))+p.getDistance(pf2.get(1));
			ArrayList<Double> options = new ArrayList<Double>(3);
			options.add(o1);
			options.add(o2);
			options.add(o3);
			Collections.sort(options);
			if(options.get(0) == o1) {
				pf2.remove(i);
				pf2.add(i-1, p);
			}
			else if (options.get(0) == o2) {
				
			}
			else {
				pf2.remove(i);
				pf2.add(0, p);
			}
		}
		else if (i == pf2.size()-2) {
			double o1 = p.getDistance(pf2.get(i-2))+p.getDistance(pf2.get(i-1));
			double o2 = p.getDistance(pf2.get(i-1))+p.getDistance(pf2.get(i+1));
			double o3 = p.getDistance(pf2.get(i+1))+p.getDistance(pf2.get(0));
			ArrayList<Double> options = new ArrayList<Double>(3);
			options.add(o1);
			options.add(o2);
			options.add(o3);
			Collections.sort(options);
			if(options.get(0) == o1) {
				pf2.remove(i);
				pf2.add(i-1, p);
			}
			else if (options.get(0) == o2) {
				
			}
			else {
				pf2.remove(i);
				pf2.add(i+1, p);
			}
		}
		else {
			double o1 = p.getDistance(pf2.get(i-2))+p.getDistance(pf2.get(i-1));
			double o2 = p.getDistance(pf2.get(i-1))+p.getDistance(pf2.get(i+1));
			double o3 = p.getDistance(pf2.get(i+1))+p.getDistance(pf2.get(i+2));
			ArrayList<Double> options = new ArrayList<Double>(3);
			options.add(o1);
			options.add(o2);
			options.add(o3);
			Collections.sort(options);
			if(options.get(0) == o1) {
				pf2.remove(i);
				pf2.add(i-1, p);
			}
			else if (options.get(0) == o2) {
				
			}
			else {
				pf2.remove(i);
				pf2.add(i+1, p);
			}
		}
	}
	
	totalLength2 = 0;
	for(int i = 0; i < pf2.size(); i++) {
		if(i < pf2.size()-1) {
			totalLength2 += pf2.get(i).getDistance(pf2.get(i+1));
		}
		else {
			totalLength2 += pf2.get(i).getDistance(pf2.get(0));
		}
	}
	
	/*
	totalLength3 = this.getExDist();
	pf3 = this.getExList();
	*/
}
	public ArrayList<Point> getPoints()
	{
		return pf;
	}
	public ArrayList<Double> getAngles()
	{
		return af;
	}
	public ArrayList<Point> getPoints2() {
		return pf2;
	}
	/*
    public ArrayList<Point> getExList()
    {
        PermutationTest t = new PermutationTest(points);
        return t.getArray();
    }
    
    public double getExDist()
    {
        PermutationTest t = new PermutationTest(points);
        return t.getMax();
    }
    */
	
	// Now, use the ArrayList orderedPoints and the ArrayList orderedAngles for the visualization
	// totalLength now has the total length of the cycle
	
	
	// Why are you printing to terminal? I am commenting this out for now
	/*System.out.println(COM.getX() + "\t" + COM.getY());
	for (Point p: Prince.getList())
	{
		System.out.println(p.getX() + "\t" + p.getY());
	}*/

}
