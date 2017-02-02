package algorithm.mostfreq;

import java.util.Set;

/**
 * Created by dmontero on 1/2/17.
 */
public interface MostFrequent<T extends Comparable> {
    boolean add(T item);
    Set<T> topItems();
    long additions();
}
