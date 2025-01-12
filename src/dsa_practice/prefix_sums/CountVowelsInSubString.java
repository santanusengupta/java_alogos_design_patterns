package dsa_practice.prefix_sums;

import java.util.ArrayList;
import java.util.List;

public class CountVowelsInSubString {
    /*
    Write a function to efficiently count vowels within specified substrings of a given string.
    The substrings will be given to you a list queries of [left, right] pairs, which correspond to the
    substring word[left:right + 1] in Python.
    The function should return a list of integers, where each integer represents the vowel count for the
    corresponding query. You can assume the input string will only contain lowercase letters.
    Your function should be optimized to run efficiently for a large number of queries.
    */
    public static void main(String[] args) {
        String word = "abracadabra";
        int[][] queries = {{0, 3}, {1, 4}, {0, 10}};
        List<Integer> result = countVowels(word, queries);
        System.out.println("Vowel counts for each query: " + result);
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private static List<Integer> countVowels(String word, int[][] queries) {
        int n = word.length();
        int[] prefixVowels = new int[n+1];
        for(int i =0; i< n; i++) {
            prefixVowels[i + 1] = prefixVowels[i] + (isVowel(word.charAt(i)) ? 1 : 0);
        }

        // Step 2: Process each query and calculate the vowel count
        List<Integer> result = new ArrayList<>();
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            int count = prefixVowels[right + 1] - prefixVowels[left];
            result.add(count);
        }

        return result;
    }
}
