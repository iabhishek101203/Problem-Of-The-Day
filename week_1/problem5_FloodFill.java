package week_1;

import java.util.*;

public class problem5_FloodFill {

    // DFS Implementation
    public char[][] floodFillDFS(char[][] image, int sr, int sc, char newColor) {
        int rows = image.length;
        int cols = image[0].length;
        char originalColor = image[sr][sc];

        if (originalColor == newColor)
            return image; // No change needed

        dfs(image, sr, sc, originalColor, newColor, rows, cols);
        return image;
    }

    private void dfs(char[][] image, int r, int c, char originalColor, char newColor, int rows, int cols) {
        // boundary + color check
        if (r < 0 || r >= rows || c < 0 || c >= cols || image[r][c] != originalColor)
            return;

        // fill current pixel
        image[r][c] = newColor;

        // explore neighbors
        dfs(image, r + 1, c, originalColor, newColor, rows, cols);
        dfs(image, r - 1, c, originalColor, newColor, rows, cols);
        dfs(image, r, c + 1, originalColor, newColor, rows, cols);
        dfs(image, r, c - 1, originalColor, newColor, rows, cols);
    }

    // BFS Implementation
    public char[][] floodFillBFS(char[][] image, int sr, int sc, char newColor) {
        int rows = image.length;
        int cols = image[0].length;
        char originalColor = image[sr][sc];

        if (originalColor == newColor)
            return image;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] { sr, sc });
        image[sr][sc] = newColor;

        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1];

            for (int[] d : directions) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && image[nr][nc] == originalColor) {
                    image[nr][nc] = newColor;
                    queue.add(new int[] { nr, nc });
                }
            }
        }

        return image;
    }

    // Helper method to print the image
    public static void printImage(char[][] image) {
        for (char[] row : image) {
            System.out.println(Arrays.toString(row));
        }
    }

    // Quick test
    public static void main(String[] args) {
        char[][] image = {
                { 'B', 'B', 'W' },
                { 'W', 'W', 'W' },
                { 'W', 'W', 'W' },
                { 'B', 'B', 'B' }
        };

        int sr = 2, sc = 2;
        char newColor = 'G';

        problem5_FloodFill solution = new problem5_FloodFill();

        System.out.println("Original Image:");
        printImage(image);

        System.out.println("\nAfter Flood Fill (DFS):");
        char[][] resultDFS = solution.floodFillDFS(copyMatrix(image), sr, sc, newColor);
        printImage(resultDFS);

        System.out.println("\nAfter Flood Fill (BFS):");
        char[][] resultBFS = solution.floodFillBFS(copyMatrix(image), sr, sc, newColor);
        printImage(resultBFS);
    }

    // utility to deep copy a 2D matrix
    private static char[][] copyMatrix(char[][] image) {
        char[][] copy = new char[image.length][];
        for (int i = 0; i < image.length; i++) {
            copy[i] = Arrays.copyOf(image[i], image[i].length);
        }
        return copy;
    }
}
