package sortingAndSearching;

/*
Problem:
Given some balls of three colors arranged in a line, rearrange them such that all the red balls go first, then green and then blue ones.

Do rearrange the balls in place. A solution that simply counts colors and overwrites the array is not the one we are looking for.

Example:
{
"balls": ["G", "B", "G", "G", "R", "B", "R", "G"]
}
["R", "R", "G", "G", "G", "G", "B", "B"]

Clarifying questions:

Test cases:

Brute force approach:

Optimized approach:

Intuition:

Related questions:

Number of times attempted: 1
 */

import java.util.List;

public class DutchNationalFlag {
    public List<Character> dutch_flag_sort(List<Character> balls) {
        int red = 0;
        int blue = balls.size() - 1;
        int curr = 0;

        while(curr <= blue) {
            if(balls.get(curr) == 'R') {
                char temp = balls.get(curr);
                balls.set(curr, balls.get(red));
                balls.set(red, temp);

                red++;
                curr++;
            }
            else if(balls.get(curr) == 'G')
                curr++;
            else {
                char temp = balls.get(curr);
                balls.set(curr, balls.get(blue));
                balls.set(blue, temp);

                blue--;
            }
        }


        return balls;
    }
}

/*
Time Complexity: O(n)
Space Complexity: O(1)
 */