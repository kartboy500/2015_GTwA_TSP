package GraphTheory;

/**
 * Sorts an array usign the merge-sort algorithm.
 *
 * @author (Eleanor Naudzius)
 * @version (2/5/2015)
 */

import java.util.ArrayList;

public class MergeSorter
{
    // instance variables - replace the example below with your own
    private ArrayList<Double> a;

    /**
     * Constructor for objects of class MergeSorter
     */
    public MergeSorter(ArrayList<Double> anArray)
    {
        a = anArray;
    }
    public ArrayList<Double> sort()
    {
        if(a.size()<= 1) return a;
        ArrayList<Double> first = new ArrayList<Double>(a.size()/2);
        ArrayList<Double> second = new ArrayList<Double>(a.size()-first.size());
        System.arraycopy(a,0,first, 0, first.size());
        System.arraycopy(a, first.size(), second, 0, second.size());
        MergeSorter firstSorter = new MergeSorter(first);
        MergeSorter secondSorter = new MergeSorter(second);
        firstSorter.sort();
        secondSorter.sort();
        merge(first, second);
        
        return a;
    }
    private void merge(ArrayList<Double> first, ArrayList<Double> second)
    {
        int iFirst = 0;
        int iSecond = 0;
        int j = 0;
        while(iFirst<first.size() && iSecond<second.size())
        {
            if(first.get(iFirst)<second.get(iSecond))
            {
                a.add(j,first.get(iFirst));
                iFirst++;
            }
            else
            {
                a.add(j,second.get(iSecond));
                iSecond++;
            }
            j++;
        }
        System.arraycopy(first, iFirst, a, j, first.size()-iFirst);
        System.arraycopy(second, iSecond, a, j, second.size()-iSecond);

    }
}