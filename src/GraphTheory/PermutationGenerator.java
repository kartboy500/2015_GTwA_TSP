package GraphTheory;





import java.util.ArrayList;
import java.util.List;

/**
 * This class generates the permuations of a word.
 *
 * @author (Eleanor Naudzius)
 * @version (1/23/2015)
 */
public class PermutationGenerator
{
    private List<Point> word;
    private int current;
    private PermutationGenerator tailGenerator;

    /**
     * Constructor for objects of class PermutationGenerator
     */
    public PermutationGenerator(List<Point> aWord)
    {
        word = aWord;
        current = 0;
        if (word.size() >1)
        {
            List<Point> tri = word.subList(1, word.size()-1);
            tailGenerator = new PermutationGenerator(tri);
        }

    }
    public List<Point> nextPermutation()
    {
        if(word.size() == 1)
        {
            current++;
            return word;
        }
        List<Point> r = tailGenerator.nextPermutation();
        r.add(1,word.get(current));
        if(!tailGenerator.hasMorePermutations())
        {
            current ++;
            if (current<word.size())
            {
                List<Point> tailString = word.subList(0, current) ;
                List<Point> t = word.subList(current+1, word.size()-1);
                for(int i = tailString.size(); i<tailString.size()+t.size(); i++)
                {
                    tailString.add(i, word.get(i));
                }
                tailGenerator = new PermutationGenerator(tailString);
            }
        }
        return r;
    }
    public boolean hasMorePermutations()
    {
        return current<word.size();
    }

}