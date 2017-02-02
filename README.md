# top-k-items
Efficient Computation of Frequent and Top-k Elements in Data Streams: The Space-Saving Algorithm 

Implementing Space-Saving algorithm based on [this article](http://www.cse.ust.hk/~raywong/comp5331/References/EfficientComputationOfFrequentAndTop-kElementsInDataStreams.pdf)

##Main characteristics of the algorithm
n = number of elements added. 

k = fix size of items we keep stored and count.

* Smallest counter value, min, is at most n/k
* True count of an unmonitored item is between 0 and min
* Any item x whose true count > n/k is stored
* **The algorithm finds all items with counts > n/k and the error in counts <= n/k**
