public class problem2_BitwiseAndOfRange {

    /**
     * Returns the bitwise AND of all integers between m and n (inclusive).
     * 
     * @param m lower bound
     * @param n upper bound
     * @return bitwise AND result
     */
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        // Keep shifting until m and n are the same (common prefix)
        while (m < n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }
        return m << shift;
    }

    public static void main(String[] args) {
        problem2_BitwiseAndOfRange solver = new problem2_BitwiseAndOfRange();
        System.out.println(solver.rangeBitwiseAnd(5, 7)); // Expected 4
        System.out.println(solver.rangeBitwiseAnd(0, 1)); // Expected 0
        System.out.println(solver.rangeBitwiseAnd(12, 15)); // Expected 12
        System.out.println(solver.rangeBitwiseAnd(8, 16)); // Expected 0
    }
}