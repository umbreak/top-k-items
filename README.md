# top-k-items
Efficient Computation of Frequent and Top-k Elements in Data Streams: The Space-Saving Algorithm 

Implementing Space-Saving algorithm based on [this article](http://www.cse.ust.hk/~raywong/comp5331/References/EfficientComputationOfFrequentAndTop-kElementsInDataStreams.pdf) and on [this presentation](http://romania.amazon.com/techon/presentations/DataStreamsAlgorithms_FlorinManolache.pdf)

##Main characteristics of the algorithm
n = number of elements added. 

k = fix size of items we keep stored and count.

* Smallest counter value, min, is at most n/k
* True count of an unmonitored item is between 0 and min
* Any item x whose true count > n/k is stored
* **The algorithm finds all items with counts > n/k and the error in counts <= n/k**

##Instalation and usage
```bash
mvn clean install
java -jar ./target/space-saving-1.0-SNAPSHOT.jar n_value k_value < input_file
```

##Algorithm
* Keep k items and counts initially zero
* Monitor and count first k distinct items.
* On seeing a new item:
  * If it is already in our set, increment counter.
  * If not, replace item with least count and increment count.
  
##Implementation
* In order to check efficiently (O(1)) if an item exists in our monitored counts a ```Map<T, Integer>``` has been used.
* In order to keep the counts ordered of items a ```TreeMap<Integer, TreeSet<T>``` has been used. This alows us to retrieve efficiently (O(log K)) the **item with least counts**.

Every time the count of an item increases, the item has to be moved to the right treeMap bucket (and removed from the previous one).
