package week_2;

public class problem2_NimMisere {
    public boolean canFirstPlayerWin(int[] heaps) {
        boolean allOnes = true;
        for (int h : heaps) {
            if (h != 1) {
                allOnes = false;
                break;
            }
        }

        if (allOnes) {
            return heaps.length % 2 == 0;
        }

        int xor = 0;
        for (int h : heaps) {
            xor ^= h;
        }
        return xor != 0;
    }

    public static void main(String[] args) {
        problem2_NimMisere game = new problem2_NimMisere();
        int[] heaps1 = { 3, 4, 5 };
        int[] heaps2 = { 1, 1, 1 };
        int[] heaps3 = { 1, 1, 2 };

        System.out.println(game.canFirstPlayerWin(heaps1));
        System.out.println(game.canFirstPlayerWin(heaps2));
        System.out.println(game.canFirstPlayerWin(heaps3));
    }
}
