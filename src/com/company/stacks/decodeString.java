package com.company.stacks;

import java.util.Stack;

// do it again
public class decodeString {
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]12[bc]"));
    }

    public static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();
        StringBuilder current = new StringBuilder();
        int index = 0;

        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                countStack.push(count);
            } else if (s.charAt(index) == '[') {
                resultStack.push(current);
                current = new StringBuilder();
                index++;
            } else if (s.charAt(index) == ']') {
                StringBuilder temp = current;
                current = resultStack.pop();
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    current.append(temp);
                    System.out.println(current.toString());
                }
                index++;
            } else {
                current.append(s.charAt(index));
                index++;
            }
        }

        return current.toString();
    }
}
