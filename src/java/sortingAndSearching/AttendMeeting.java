package sortingAndSearching;

/*
Problem:
Given a list of meeting intervals where each interval consists of a start and an end time, check if a person can attend all the given meetings such that only one meeting can be attended at a time.

Example:
{
"intervals": [
[1, 5],
[5, 8],
[10, 15]
]
}
1

Clarifying questions:
- Are the intervals in some sorted form?

Test cases:

Brute force approach:

Optimized approach:

Intuition:

Related questions:

Number of times attempted: 1
 */

import java.util.Collections;
import java.util.List;

public class AttendMeeting {
    public Integer can_attend_all_meetings(List<List<Integer>> intervals) {
        Collections.sort(intervals, (a, b) -> {
           if(a.get(0).equals(b.get(0))) return Integer.compare(a.get(1), b.get(1));
           return Integer.compare(a.get(0), b.get(0));
        });

        for(int i = 1; i < intervals.size(); i++) {
            int prevStart = intervals.get(i - 1).get(0);
            int prevEnd = intervals.get(i - 1).get(1);
            int currStart = intervals.get(i).get(0);

            if(currStart < prevEnd) return 0;
        }

        return 1;
    }
}

/*
Time Complexity: O(n log n)
Space Complexity: O(1)
 */