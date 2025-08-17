package week_1;

public class problem2_WordSearch {

    public static boolean wordSearch(char[][] matrix, String word) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        // ✅ Check rows
        for (int r = 0; r < rows; r++) {
            String rowStr = new String(matrix[r]);
            if (rowStr.contains(word)) {
                return true;
            }
        }

        // ✅ Check columns
        for (int c = 0; c < cols; c++) {
            StringBuilder colStr = new StringBuilder();
            for (int r = 0; r < rows; r++) {
                colStr.append(matrix[r][c]);
            }
            if (colStr.toString().contains(word)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                { 'F', 'A', 'C', 'I' },
                { 'O', 'B', 'Q', 'P' },
                { 'A', 'N', 'O', 'B' },
                { 'M', 'A', 'S', 'S' }
        };

        System.out.println(wordSearch(matrix, "FOAM")); // true
        System.out.println(wordSearch(matrix, "MASS")); // true
        System.out.println(wordSearch(matrix, "FACE")); // false
    }
}
