package skothuri.sliding_window;

import java.util.*;

/**
 * Problem: Given an array and an integer k, print the count of distinct elements in every window of size k.
 */
class DistinctElementsWindow {
	public int[] distinctCount(int[] nums, int k) {
		if (nums.length == 0 || k == 0) return new int[0];

		int n = nums.length;
		int[] result = new int[n - k + 1];
		Map<Integer, Integer> freq = new HashMap<>();

		for (int i = 0; i < n; i++) {
			freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);

			if (i >= k) {
				int out = nums[i - k];
				freq.put(out, freq.get(out) - 1);
				if (freq.get(out) == 0) freq.remove(out);
			}

			if (i >= k - 1) {
				result[i - k + 1] = freq.size();
			}
		}
		return result;
	}
}

