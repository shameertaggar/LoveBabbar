package com.company.stacks;

import sun.jvm.hotspot.code.StubQueue;

import java.util.ArrayList;
import java.util.Stack;

//do it again
public class carFleetII {
    public static void main(String[] args) {
        int car[][] = {{1,2},{2,1},{4,3},{7,2}};
        ArrayList<Double> colTime = new ArrayList<Double>( );
        Stack<Integer> s = new Stack<>();

        for (int i  = car.length-1; i>=0; i--){
            while (!s.isEmpty() && car[s.peek()][1] >= car[i][1]){
                s.pop();
            }

            while (!s.isEmpty()){
                double colTym = (double) (car[s.peek()][0] -car[i][0])/(car[i][1]-car[s.peek()][1]);
                if (colTym == -1 || colTym <=s.peek()){
                     colTime.add(colTym);
                     break;
                }
                s.pop();
            }
            s.push(i);
        }

        System.out.println(colTime);

    }
}
