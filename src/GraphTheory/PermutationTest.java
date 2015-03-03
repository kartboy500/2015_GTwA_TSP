package GraphTheory;

import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class PermutationsTest here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PermutationTest
{
    // instance variables - replace the example below with your own
    private double x;
    private List<Point> array;
    ArrayList<Point> fi;
    /**
     * Constructor for objects of class PermutationsTest
     */
    public PermutationTest(ArrayList<Point> points)
    {
        List<Point> p = new ArrayList<Point>();
        for(int i = 0; i<points.size(); i++)
        {
            p.add(i,points.get(i));
        }
        PermutationGenerator generator = new PermutationGenerator(p);
        array = new ArrayList<Point>();
        List<Point> s;
        x=0;
        boolean b = true;
        double n = 0;
        while(generator.hasMorePermutations())
        {
            s = generator.nextPermutation();
            n = getDistanceT(s);
            if(b==true)
            {
                x = n;
                array = s;
                b = false;
            }
            if(n<x)
            {
                x = n;
                array = s;
            }

        }
        fi = new ArrayList();
        for(int i = 0; i<array.size(); i++)
        {
            fi.add(i,array.get(i));
        }

    }
    public double getDistanceT(List<Point> t)
    {
        double n =0;
        for(int i = 0; i<t.size()-1; i++)
        {
            n+=t.get(i).getDistance(t.get(i+1));
        }
        n+=t.get(t.size()-1).getDistance(t.get(0));
        return n;
    }
    public double getMax()
    {
        return x;
    }
    public ArrayList<Point> getArray()
    {
        return fi;
    }



}