package com.company.charAndStringArrays;

public class findAndReplacePattern {

    public static void main(String[] args) {

        String words[] = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";

        for (String word : words) {
            if (matchesPattern(word, pattern)) {
                System.out.println("Matching pattern is " + word);
            }
        }
    }

    public static boolean matchesPattern(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }

        int[] mapping = new int[26]; // Assuming only lowercase letters

        for (int i = 0; i < word.length(); i++) {
            char w = word.charAt(i);
            char p = pattern.charAt(i);

            if (mapping[w - 'a'] == 0) {
                mapping[w - 'a'] = p;
            } else if (mapping[w - 'a'] != p) {
                return false;
            }
        }

        boolean[] used = new boolean[26];

        for (int i = 0; i < mapping.length; i++) {
            if (mapping[i] != 0) {
                int index = mapping[i] - 'a';
                if (used[index]) {
                    return false;
                }
                used[index] = true;
            }
        }

        return true;
    }
}
