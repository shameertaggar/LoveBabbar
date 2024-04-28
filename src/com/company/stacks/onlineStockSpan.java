package com.company.stacks;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

class Span {
    private Stack<Pair<Integer, Integer>> st;

    public Span() {
        st = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!st.isEmpty() && price >= st.peek().getKey()) {
            span += st.pop().getValue();
        }

        st.push(new Pair<>(price, span));
        return span;
    }
}

public class onlineStockSpan {
    public static void main(String[] args) {
        Span s = new Span();
        int arr[] = {100, 80, 60, 70, 60, 75};

        System.out.println(s.next(100)); // Output: 1
        System.out.println(s.next(80));  // Output: 1
        System.out.println(s.next(60));  // Output: 1
        System.out.println(s.next(70));  // Output: 2
        System.out.println(s.next(60));  // Output: 4
        System.out.println(s.next(75));  // Output: 6
    }
}
