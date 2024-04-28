package com.company.queues;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class findWinnerOfCircularGame {


    static int findTheWinner(int n, int k) {

        Deque<Integer> q = new LinkedList<>();
        for(int i =0; i< n; i++){
            q.add(i+1);
        }



        while(q.size() != 1){
            System.out.println("size " + q.size());

                for(int i = 0; i < k-1; i++){
                    int w = q.remove();
                    q.addLast(w);
                }
                int e = q.remove();
                System.out.println(e);
        }


        int r = q.remove();
        return r;

    }
    public static void main(String[] args) {
        int ans = findTheWinner(6,5);
        System.out.println(ans);
    }
}
