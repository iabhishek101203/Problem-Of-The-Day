package week_1;

public class problem3_EqualSumPartition {

    // ✅ Dynamic Programming approach
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums)
            sum += num;

        // If total sum is odd → cannot split
        if (sum % 2 != 0)
            return false;

        int target = sum / 2;

        // DP array: dp[i] = can we form sum i?
        boolean[] dp = new boolean[target + 1];
        dp[0] = true; // sum=0 always possible

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] arr1 = { 15, 5, 20, 10, 35, 15, 10 };
        System.out.println(canPartition(arr1)); // true

        int[] arr2 = { 15, 5, 20, 10, 35 };
        System.out.println(canPartition(arr2)); // false
    }
}
