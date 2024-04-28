package com.company.queues;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class onRepeatingCHaracterInAString {
    public static void main(String[] args) {
        String a = "ababc";
        HashMap<Character,Integer> map = new HashMap<>();

        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < a.length(); i++){
            if (map.containsKey(a.charAt(i))){
                map.put(a.charAt(i), map.get(a.charAt(i)) + 1);
            }else{
                map.put(a.charAt(i),1);
            }
            q.add(a.charAt(i));

            while(!q.isEmpty() && map.get(q.peek()) != 1  ){

                q.remove();
            }

            if (q.isEmpty()){
                System.out.println("Answer : " + "#");
            }else{
                System.out.println("Answer : " + q.peek());
            }


        }


    }
}
