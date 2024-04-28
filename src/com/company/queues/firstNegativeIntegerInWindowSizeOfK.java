package com.company.queues;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

public class firstNegativeIntegerInWindowSizeOfK {
    static void printFirstNegative(int arr[],int k){



    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        int k  = 3;
        int arr[] = {2,-5,-4,-1,-2,0,5};
        for (int i = 0; i < k; i++){
            if (arr[i] < 0){
                q.add(i);
            }
        }

        for (int i = k; i < arr.length; i++){

            if (q.isEmpty()){
                System.out.println("Answer : " + 0);
            }else{
                System.out.println("Answer : " + q.peek() + " of value = " + arr[q.peek()]);
            }
            if ((i-q.peek()) >= k){
                q.remove();
            }
            int e = arr[i];



            q.add(i);
        }

        if (q.isEmpty()){
            System.out.println("Answer : " + 0);
        }else{
            System.out.println("Answer : " + q.peek() + " of value = " + arr[q.peek()]);
        }


    }
}
