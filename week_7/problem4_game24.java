package week_7;

import java.util.*;

public class problem4_game24 {
    static final double EPS = 1e-6;

    public static boolean canReach24(double[] nums) {
        int n = nums.length;
        if (n == 1) {
            return Math.abs(nums[0] - 24) < EPS;
        }

        // Try all pairs of numbers
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Build list of remaining numbers
                double[] next = new double[n - 1];
                int idx = 0;
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j)
                        next[idx++] = nums[k];
                }

                // Try all operations between nums[i], nums[j]
                for (double val : compute(nums[i], nums[j])) {
                    next[n - 2] = val; // put result in new list
                    if (canReach24(next))
                        return true;
                }
            }
        }
        return false;
    }

    // All possible results of combining a and b
    private static List<Double> compute(double a, double b) {
        List<Double> res = new ArrayList<>();
        res.add(a + b);
        res.add(a - b);
        res.add(b - a);
        res.add(a * b);
        if (Math.abs(b) > EPS)
            res.add(a / b);
        if (Math.abs(a) > EPS)
            res.add(b / a);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] nums = new double[4];
        for (int i = 0; i < 4; i++)
            nums[i] = sc.nextDouble();

        System.out.println(canReach24(nums));
    }
}
