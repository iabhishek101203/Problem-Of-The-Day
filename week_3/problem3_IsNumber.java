package week_3;

class Solution {
    public boolean isNumber(String s) {
        if (s == null)
            return false;

        String pattern = "^\\s*[+-]?((\\d+(\\.\\d*)?)|(\\.\\d+))([eE][+-]?\\d+)?\\s*$";
        return s.matches(pattern);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isNumber("10"));
        System.out.println(sol.isNumber("-10.1"));
        System.out.println(sol.isNumber("1e5"));
        System.out.println(sol.isNumber("a -2"));
        System.out.println(sol.isNumber(" .1 "));
        System.out.println(sol.isNumber("3."));
        System.out.println(sol.isNumber("."));
        System.out.println(sol.isNumber("1e"));
        System.out.println(sol.isNumber("e9"));
        System.out.println(sol.isNumber("+"));
    }
}
