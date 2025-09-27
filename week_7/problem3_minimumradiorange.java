package week_7;

import java.util.*;

public class problem3_minimumradiorange {
    public static int findMinRange(int[] listeners, int[] towers) {
        Arrays.sort(towers);
        int maxRange = 0;

        for (int listener : listeners) {
            int idx = Arrays.binarySearch(towers, listener);

            if (idx >= 0) {
                // Listener exactly at a tower
                continue;
            }

            idx = -idx - 1; // insertion point
            int dist = Integer.MAX_VALUE;

            if (idx < towers.length) {
                dist = Math.min(dist, Math.abs(listener - towers[idx]));
            }
            if (idx > 0) {
                dist = Math.min(dist, Math.abs(listener - towers[idx - 1]));
            }

            maxRange = Math.max(maxRange, dist);
        }

        return maxRange;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] listeners = new int[n];
        for (int i = 0; i < n; i++)
            listeners[i] = sc.nextInt();

        int m = sc.nextInt();
        int[] towers = new int[m];
        for (int i = 0; i < m; i++)
            towers[i] = sc.nextInt();

        System.out.println(findMinRange(listeners, towers));
    }
}
