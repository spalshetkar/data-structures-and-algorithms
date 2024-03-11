package graph;

import java.util.*;

public class ShortestStringTransformationUsingDictionary {
    List<String> string_transformation(List<String> words, String start, String stop) {
        if(diffCountInCharacters(start, stop) == 0 && !words.isEmpty()) return new ArrayList<String>(Arrays.asList(start, words.get(0), stop));

        // Visited map to keep track of visited nodes and avoid infinite loop
        Map<String, Integer> visited = new HashMap<>();
        for(String word : words) visited.put(word, -1);
        visited.put(start, -1);
        visited.put(stop, -1);

        // Parent map to keep track of parent nodes
        Map<String, String> parent = new HashMap<>();
        for(String word : words) parent.put(word, "");
        parent.put(start, "");
        parent.put(stop, "");

        Set<String> newWords = new HashSet<>(words);
        newWords.add(stop);

        bfs(newWords, visited, parent, start, stop);

        List<String> result = new ArrayList<>();
        String temp = stop;

        while(temp != start) {
            result.add(temp);
            if(parent.get(temp) == "") return new ArrayList<String>(Arrays.asList("-1"));
            temp = parent.get(temp);
        }
        result.add(temp);

        Collections.reverse(result);
        return result;
    }

    private boolean bfs(Set<String> words, Map<String, Integer> visited, Map<String, String> parent, String start, String stop) {
        visited.put(start, 1);

        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            String word = queue.remove();

            List<String> neighbors = helper(words, word);
            for (String neighbor : neighbors) {
                if (visited.get(neighbor) == -1) {
                    visited.put(neighbor, 1);

                    parent.put(neighbor, word);

                    if (neighbor == stop) return true;

                    queue.add(neighbor);
                }
            }
        }

        return false;
    }

    private List<String> helper(Set<String> words, String word) {
        List<String> result = new ArrayList<>();

        for(String w : words) {
            if(diffCountInCharacters(w, word) == 1) result.add(w);
        }

        return result;
    }

    private int diffCountInCharacters(String w1, String w2) {
        int diff = 0;

        for(int i = 0; i < w2.length(); i++) {
            if(w1.charAt(i) != w2.charAt(i)) diff++;
        }

        return diff;
    }
}
