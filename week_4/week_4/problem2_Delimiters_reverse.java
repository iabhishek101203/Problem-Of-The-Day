
package week_4;

import java.util.*;
import java.util.regex.*;

public class problem2_Delimiters_reverse {
    public static String reverseWordsPreserveDelimiters(String s) {
        if (s == null || s.isEmpty())
            return s;

        Pattern p = Pattern.compile("[a-z]+|[^a-z]+");
        Matcher m = p.matcher(s);

        List<String> tokens = new ArrayList<>();
        List<Boolean> isWord = new ArrayList<>();

        while (m.find()) {
            String t = m.group();
            tokens.add(t);
            isWord.add(Character.isLetter(t.charAt(0))); // true for word tokens
        }

        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < tokens.size(); i++) {
            if (isWord.get(i))
                stack.push(tokens.get(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tokens.size(); i++) {
            if (isWord.get(i))
                sb.append(stack.pop());
            else
                sb.append(tokens.get(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.hasNextLine() ? sc.nextLine() : "";
        System.out.println(reverseWordsPreserveDelimiters(input));
    }
}
