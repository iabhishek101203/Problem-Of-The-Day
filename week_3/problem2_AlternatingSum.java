package week_3;

import java.util.function.IntFunction;

public class problem2_AlternatingSum {
    private int result; // stores cumulative sum
    private boolean add; // flag for add/subtract

    // private constructor
    private problem2_AlternatingSum(int num, boolean addNext) {
        this.result = num;
        this.add = addNext; // true means next will be added, false means subtracted
    }

    // Factory method for first call
    public static IntFunction<problem2_AlternatingSum> add_subtract(int num) {
        return nextNum -> new problem2_AlternatingSum(num, false).apply(nextNum);
    }

    // Apply the next number in chain
    private problem2_AlternatingSum apply(int num) {
        if (add) {
            result += num;
        } else {
            result -= num;
        }
        add = !add; // toggle operation
        return this;
    }

    // Expose method for chaining
    public IntFunction<problem2_AlternatingSum> next() {
        return this::apply;
    }

    // Get final result
    public int get() {
        return result;
    }

    // Example test cases
    public static void main(String[] args) {
        // Single number
        System.out.println(new problem2_AlternatingSum(7, true).get()); // 7

        // 1 + 2 - 3 = 0
        problem2_AlternatingSum ex1 = new problem2_AlternatingSum(1, true);
        ex1.apply(2);
        ex1.apply(3);
        System.out.println(ex1.get()); // 0

        // -5 + 10 - 3 + 9 = 11
        problem2_AlternatingSum ex2 = new problem2_AlternatingSum(-5, true);
        ex2.apply(10);
        ex2.apply(3);
        ex2.apply(9);
        System.out.println(ex2.get()); // 11
    }
}
