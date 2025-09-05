package skothuri.sliding_window;

import java.util.*;
/**
 * Problem: Given a string s and an integer k, find the length of the longest substring that contains at most k distinct characters.
 **/
public class LongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.isEmpty() || k == 0) return 0;

        Map<Character, Integer> freq = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0) + 1);

            while (freq.size() > k) {
                char c = s.charAt(left);
                freq.put(c, freq.get(c) - 1);
                if (freq.get(c) == 0) freq.remove(c);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
