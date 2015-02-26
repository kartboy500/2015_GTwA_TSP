package GraphTheory;

import java.io.FileNotFoundException;

public class SolarDriver {
private static final int nPoints= 15;
private static final int max=1000;
private static final int min=0;
private static Point COM;


public static void main(String[] args) {
	Universe Prince= new Universe(max, min, nPoints);
	Prince.addPoints();
	COM= Prince.findCOM();
	System.out.println(COM.getX() + "\t" + COM.getY());
	for (Point p: Prince.getList())
	{
		System.out.println(p.getX() + "\t" + p.getY());
	}
	
}

}
