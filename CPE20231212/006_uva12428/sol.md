# UVa 12428 – Enemy at the Gates
* Complexity: O(√M)
* Category: Adhoc
* From: https://forthright48.com/tag/uva/

This was the easiest problem in the set. In this problem, we are given N nodes and M edges, we have to find out how many leaves can this graph have if we maximize leaves.

The problem says the graph will be connected. So I created a star-shaped graph with it using N−1 edges. Let the center node be 0 and remaining nodes be the numbers from 1 to N−1. This gives me N−1 critical edges. Then I checked if I still have more edges left? If I do, then I need to sacrifice a critical edge.

The first edge that gets sacrifice is a special case. This is because, no matter which two nodes you connect, it will reduce the number of critical edges by 2. There is no helping it. So let’s connect 1 and 2 and reduce our edge by 1 and critical edge by 2.

Then if we still have more edges left, then we need to sacrifice another critical length. From now on, at each step, only one critical edge will be removed. Also, this time we can add 2 edges to the graph by removing one critical edge. Connect an edge between (3,1) and (3,2). Reduce M by 2 and critical edge by 1.

Next is node 4. We can add 3 edges by removing 1 critical edge now. We need to keep on doing this until all edges finish.

I guess it is possible to solve the problem in O(1) but I didn’t bother with it. The number of test case was small anyway.

Code: http://ideone.com/X3bWyZ