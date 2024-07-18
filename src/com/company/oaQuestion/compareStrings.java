package com.company.oaQuestion;

import java.util.*;

class Pair {
    char character;
    int frequency;

    Pair(char character, int frequency) {
        this.character = character;
        this.frequency = frequency;
    }
}

public class compareStrings {

    // Function to find the smallest lexicographic character in a string
    public static char smallestLexicographicChar(String str) {
        char smallestChar = Character.MAX_VALUE;
        for (char c : str.toCharArray()) {
            if (c < smallestChar) {
                smallestChar = c;
            }
        }
        return smallestChar;
    }

    // Function to count the frequency of a character in a string
    public static int countFrequency(String str, char ch) {
        int frequency = 0;
        for (char c : str.toCharArray()) {
            if (c == ch) {
                frequency++;
            }
        }
        return frequency;
    }

    // Function to compare strings from str1 with str2 based on given criteria
    public static List<Integer> compareStrings(String[] str1, String[] str2) {
        List<Pair> list1 = new ArrayList<>();
        List<Pair> list2 = new ArrayList<>();

        // Populate list1 with smallest character frequency details from str1
        for (String s : str1) {
            char smallestChar = smallestLexicographicChar(s);
            int freq = countFrequency(s, smallestChar);
            list1.add(new Pair(smallestChar, freq));
        }

        // Populate list2 with smallest character frequency details from str2
        for (String s : str2) {
            char smallestChar = smallestLexicographicChar(s);
            int freq = countFrequency(s, smallestChar);
            list2.add(new Pair(smallestChar, freq));
        }

        List<Integer> result = new ArrayList<>();

        // Compare each string in str2 with str1 based on the defined criteria
        for (Pair p2 : list2) {
            int count = 0;
            for (Pair p1 : list1) {
                if (p1.character <= p2.character && p1.frequency < p2.frequency) {
                    count++;
                }else if (p1.character > p2.character){
                    count++;
                }
            }
            result.add(count);
        }

        return result;
    }

    public static void main(String[] args) {
        String str1 = "oooooooooh eeeeeeeeeh oiyoi bakamitai damedane ahahahaha blahblah trolololol mudamuda ilackmore ideasoops";
        String str2 = "cchcc eeieeye coocoo ollowono zzzzzzzzzz olloho aeera neeres clescey elleine beainbe heehoo aaaaaaaaah";

        String[] st1 = str1.split(" ");
        String[] st2 = str2.split(" ");

        List<Integer> ans = compareStrings(st1, st2);
        System.out.println(ans); // Output: [3, 2]
    }
}
