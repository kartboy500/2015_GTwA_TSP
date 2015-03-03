package GraphTheory;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

//import Temperature1.Projectile;

public class Universe {
	
	private int Points;
	private double max;
	private double min;
	private double nPoints;
	private ArrayList<Point>pointlist;
	private Random random = new Random();
	private Point COM;
	private ArrayList<Double>averagelist = new ArrayList<Double>();
	private ArrayList<Double>differencelist = new ArrayList<Double>();
	private double standarddeviation;
	private double averagedistance;
	private ArrayList<Double>zscore;
	
	public Universe(double max, double min, int nPoints)
	{
		this.max=max;
		this.min=min;
		this.nPoints= nPoints;
		pointlist= new ArrayList<Point>();
	}
	
	
	
	public Point PointGenerator()
	{
		double x = random.nextDouble() * max+40;
		double y = random.nextDouble() * max+40;
		
		return new Point(x,y);
	}
	
	public ArrayList addPoints()
	{
		for (int i=0; i <nPoints; i++)
		{
			pointlist.add(PointGenerator());
		}
		
		return pointlist;
	}
	
	public ArrayList<Point> getList()
	{
		return pointlist;
	}
	
	public Point findCOM()
	{
		double COMXvalue=0;
		double COMYvalue=0;
		
		for (Point p: pointlist)
		{
			COMXvalue+=p.getX();
			COMYvalue+=p.getY();
		}
		
		COMXvalue= COMXvalue/nPoints;
		COMYvalue=COMYvalue/nPoints;
		
		COM= new Point(COMXvalue, COMYvalue);
		return COM;
	}

	public ArrayList<Double> getAverages(ArrayList<Point> orderpoints)
	{
		for (Point p: orderpoints)
		{
			double distance = p.getDistance(findCOM());
			averagelist.add(distance);
		}
		return averagelist;
	}	

	public ArrayList<Double> getDifferences(ArrayList<Double> averagelist)
	{
		for (int i =0; i<averagelist.size(); i++)
		{
			if (i==averagelist.size()-1)
			{
				double difference = averagelist.get(averagelist.size()-1)-averagelist.get(0);
				difference= Math.abs(difference);
				differencelist.add(difference);
			}
			else 
			{
				double difference= averagelist.get(i+1)-averagelist.get(i);
				difference= Math.abs(difference);
				differencelist.add(difference);
			}
		}
		return differencelist;
	}

	public double findaveragedistance(ArrayList<Double> differencelist)
	{
		double averagedistance=0;
		for (double d: differencelist)
		{
			averagedistance+=d;
		}
		averagedistance=averagedistance/(differencelist.size());
		return averagedistance;
	}
	public double findSD(ArrayList<Double> differencelist)
	{
		double deviationnumber=0;
		for (double d: differencelist)
		{
			deviationnumber += Math.pow((d - averagedistance),2);
		}
		standarddeviation= Math.sqrt(deviationnumber/(differencelist.size()));
		return standarddeviation;
	}
	public ArrayList<Double> findZscore(ArrayList<Double> differencelist)
	{
		double standarddev= findSD(differencelist);
		for (double d: differencelist)
		{
			double divisible= d- findaveragedistance(differencelist);
			zscore.add(divisible);
		}
		return zscore;
	}
}
