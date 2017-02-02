package algorithm.mostfreq;

import java.util.*;

/**
 * Created by dmontero on 1/2/17.
 */
public class MostFreqSpaceSaving<T extends Comparable> implements MostFrequent<T> {
    private final int K;
    private Map<T, Integer> items;

    private TreeMap<Integer, TreeSet<T>> countItems;

    private long additions;



    public MostFreqSpaceSaving(int k) {
        K = k;
        additions =0;
        countItems = new TreeMap<>();
        items = new HashMap<>();
    }


    public boolean add(T item) {
        if (items.containsKey(item))
            incrementCountWhenItemExist(item);
        else if(items.size() < K)
            add(item, 1);
        else
            replaceWithMinWhenNotAvailableSpace(item);
        additions++;
        return true;
    }


    private void replaceWithMinWhenNotAvailableSpace(T item){
        Map.Entry<Integer, TreeSet<T>> entry = countItems.firstEntry();
        Integer count = entry.getKey();

        TreeSet<T> set = entry.getValue();
        T toRemove = set.pollFirst();
        removeCountSetIfEmpty(count, set);

        items.remove(toRemove);
        add(item, ++count);
    }

    private void incrementCountWhenItemExist(T item){
        Integer count = items.get(item);
        TreeSet<T> set = countItems.get(count);
        set.remove(item);
        removeCountSetIfEmpty(count, set);
        add(item, ++count);

    }

    private void removeCountSetIfEmpty(int count, Set<T> set){
        if(set.isEmpty()) countItems.remove(count);
    }

    private void add(T item, int count){
        items.put(item, count);

        TreeSet<T> set = countItems.get(count);
        if(set == null){
            set = new TreeSet<>();
            countItems.put(count, set);
        }
        set.add(item);
    }


    public Set<T> topItems() {
        return items.keySet();
    }

    @Override
    public long additions() {
        return additions;
    }
}
