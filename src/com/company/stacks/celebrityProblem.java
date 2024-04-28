package com.company.stacks;

import java.util.Stack;

public class celebrityProblem {
    public static void main(String[] args) {
        int arr[][] = {{0,1,0},{0,0,0},{0,1,0}};
        int n = 3;
        Stack<Integer> s = new Stack<>();

        // step 1:  push all persons in stack
        for (int i = 0 ; i<n ; i++){
            s.push(i);
        }

        // step 2 : check by poping 2 elements
        while(s.size() != 1){
            int a = s.pop();
            int b = s.pop();
            //if a knows b
            if (arr[a][b] == 1){
                s.push(b);
            }else{
                s.push(a);
            }
        }
        int q = s.pop() ;
        for (int i = 0; i<n; i++){
            if (arr[q][i] == 1){
                System.out.println("No celebrity exist");
                return;
            }
            if (arr[i][q] == 0 && i != q){
                System.out.println("No celebrity exist");
                return;
            }

        }
        System.out.println("person " + (q+1) + " is a celebrity");
    }
}
