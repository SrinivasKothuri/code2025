package skothuri.sliding_window;

import java.util.*;

/**
 * Problem: Given an array nums and integer k, return the maximum of each sliding window of size k.
 **/
class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) return new int[0];
        
        int n = nums.length;
        int[] result = new int[n - k + 1];
        LinkedList<Integer> dq = new LinkedList<>(); // stores indices

        for (int i = 0; i < n; i++) {
            // Remove out-of-window elements
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();

            // Maintain decreasing order
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }
            dq.offerLast(i);

            // Capture result when window is full
            if (i >= k - 1) {
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return result;
    }
}
