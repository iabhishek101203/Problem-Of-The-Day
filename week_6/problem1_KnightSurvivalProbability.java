public class problem1_KnightSurvivalProbability {

    // 8 possible knight moves
    private static final int[][] MOVES = {
            { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 },
            { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }
    };

    public double knightProbability(int n, int k, int row, int col) {
        // dp[i][j] = probability of being at (i,j) after current step
        double[][] dp = new double[n][n];
        dp[row][col] = 1.0;

        for (int step = 0; step < k; step++) {
            double[][] next = new double[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][j] > 0) {
                        for (int[] move : MOVES) {
                            int ni = i + move[0];
                            int nj = j + move[1];
                            if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                                next[ni][nj] += dp[i][j] / 8.0;
                            }
                        }
                    }
                }
            }
            dp = next;
        }

        double probability = 0.0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                probability += dp[i][j];
            }
        }

        return probability;
    }

    // quick test
    public static void main(String[] args) {
        problem1_KnightSurvivalProbability solver = new problem1_KnightSurvivalProbability();

        System.out.println(solver.knightProbability(8, 1, 0, 0)); // Expected 0.25
        System.out.println(solver.knightProbability(8, 2, 0, 0)); // Expected 0.0625
        System.out.println(solver.knightProbability(8, 3, 4, 4)); // Center example
    }
}
