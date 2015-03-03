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
	
	
	public Universe(double max, double min, int nPoints)
	{
		this.max=max;
		this.min=min;
		this.nPoints= nPoints;
		pointlist= new ArrayList<Point>();
	}
	
	
	
	public Point PointGenerator()
	{
		double x = random.nextDouble() * max;
		double y = random.nextDouble() * max;
		
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

}
