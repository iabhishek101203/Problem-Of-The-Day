import java.util.*;

public class problem3_LongestIncreasingSubsequence {

    /**
     * Approach 1: O(n^2) DP
     * dp[i] = LIS ending at index i
     */
    public int lengthOfLIS_DP(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    /**
     * Approach 2: O(n log n) using patience sorting + binary search
     */
    public int lengthOfLIS_Optimized(int[] nums) {
        List<Integer> lis = new ArrayList<>();

        for (int num : nums) {
            int pos = Collections.binarySearch(lis, num);
            if (pos < 0) {
                pos = -(pos + 1); // insertion point
            }
            if (pos == lis.size()) {
                lis.add(num);
            } else {
                lis.set(pos, num);
            }
        }

        return lis.size();
    }

    // Quick test
    public static void main(String[] args) {
        problem3_LongestIncreasingSubsequence solver = new problem3_LongestIncreasingSubsequence();

        int[] arr = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15 };

        System.out.println("DP O(n^2) Answer: " + solver.lengthOfLIS_DP(arr)); // Expected 6
        System.out.println("Optimized O(n log n) Answer: " + solver.lengthOfLIS_Optimized(arr)); // Expected 6
    }
}
