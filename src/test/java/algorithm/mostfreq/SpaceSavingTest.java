package algorithm.mostfreq;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by dmontero on 1/2/17.
 */
public class SpaceSavingTest {

    private final int K = 6;


    private MostFrequent<Integer> mostFreq;

    @Before
    public void setUp(){
        mostFreq = new MostFreqSpaceSaving<>(K);
    }

    @Test
    public void addElement(){
        boolean result = mostFreq.add(1);
        Assert.assertTrue(result);
    }

    @Test
    public void addElementAndCheckResult(){
        Set<Integer> expected = new TreeSet<>(Arrays.asList(1));
        mostFreq.add(1);

        Set<Integer> result = mostFreq.topItems();

        assertEquals(expected, result);
    }

    @Test
    public void addElementAndCheckCount(){
        mostFreq.add(1);

        Assert.assertEquals(1, mostFreq.additions());
    }

    @Test
    public void addElementAndCheckResultSizeEqualK(){
        for (int i = 0; i < 50; i++) {
            mostFreq.add(i);
        }

        Assert.assertEquals(K, mostFreq.topItems().size());
    }

    @Test
    public void addElementsAndCheckResult(){
        //Guaranteed for elements which appear more than N/k
        //N = 30
        //k = 6
        //Guaranteed  count >= 30/6
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            mostFreq.add(rand.nextInt());
            mostFreq.add(1);
            mostFreq.add(rand.nextInt());
            mostFreq.add(2);
            mostFreq.add(rand.nextInt());
            mostFreq.add(rand.nextInt());
        }

        Set<Integer> result = mostFreq.topItems();

        Assert.assertTrue(result.contains(1));
        Assert.assertTrue(result.contains(2));
        Assert.assertEquals(30, mostFreq.additions());

    }
}
