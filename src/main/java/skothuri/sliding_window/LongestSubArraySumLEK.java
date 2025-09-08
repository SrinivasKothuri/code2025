package skothuri.sliding_window;

import java.util.*;

/**
 * Problem: Given an array of integers and a target k,
 * find the length of the longest subarray whose sum is less than or equal to k.
 */

public class LongestSubArraySumLEK {
	public int longestSubArray(int[] nums, int k) {
		int n = nums.length;
		long prefixSum = 0;
		int maxLen = 0;

		TreeMap<Long, Integer> prefixMap = new TreeMap<>();
		prefixMap.put(0L, -1); // base case

		for (int i = 0; i < n; i++) {
			prefixSum += nums[i];

			// Find smallest prefixSum >= prefixSum - k
			Map.Entry<Long, Integer> entry = prefixMap.ceilingEntry(prefixSum - k);
			if (entry != null) {
				maxLen = Math.max(maxLen, i - entry.getValue());
			}

			// Only keep earliest index for prefixSum
			prefixMap.putIfAbsent(prefixSum, i);
		}
		return maxLen;
	}
}
