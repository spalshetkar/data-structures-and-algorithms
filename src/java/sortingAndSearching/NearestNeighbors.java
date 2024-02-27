package sortingAndSearching;

/*
Problem:
Given coordinates of a point p and n other points on a two-dimensional surface, find k points out of n which are the nearest to point p.

Example:
{
"p_x": 1,
"p_y": 1,
"k": 1,
"n_points": [
[0, 0],
[1, 0]
]
}

[
[1, 0]
]

Clarifying questions:

Test cases:

Brute force approach:

Optimized approach:

Intuition:

Related questions:

Number of times attempted: 1
 */

import java.util.*;

public class NearestNeighbors {
    public List<List<Integer>> nearest_neighbours(int p_x, int p_y, int k, List<List<Integer>> n_points) {
        Queue<Pair> pq = new PriorityQueue<>((a, b) -> {
            double first = Math.sqrt(Math.pow(Math.abs(a.x - p_x), 2) + Math.pow(Math.abs(a.y - p_y), 2));
            double second = Math.sqrt(Math.pow(Math.abs(b.x - p_x), 2) + Math.pow(Math.abs(b.y - p_y), 2));

            return Double.compare(second, first);
        });

        for(List<Integer> point : n_points) {
            pq.offer(new Pair(point.get(0), point.get(1)));

            if(pq.size() > k)
                pq.poll();
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(Arrays.asList(pq.peek().x, pq.peek().y));
            pq.poll();
        }

        return result;
    }

    private class Pair {
        int x;
        int y;

        Pair(int xIn, int yIn) {
            x = xIn;
            y = yIn;
        }
    }
}

/*
Time Complexity:
Space Complexity:
 */