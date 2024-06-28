package com.company.stacks;

import java.util.Arrays;

public class NstacksInAnArray {
    int n = 3;
    int s = 6;
    int arr[] = new int[s];
    int top[] = new int[n];

    int nex[] = new int[s];
    int freeSpot = 0;


    public void push(int val, int st){
        int index = freeSpot;
        freeSpot = nex[index];
        arr[index] = val;
        nex[index] = top[st-1];
        top[st-1] = index;

    }

    public void pop(int st){
        int index = top[st-1];
        top[st-1] = nex[index];
        nex[index] = freeSpot;
        freeSpot = index;
    }
    public void main(String[] args) {
        Arrays.fill(top,-1);
        for (int i = 0; i<s;i++){
            if (i == s-1){
                nex[i] = -1;
                break;
            }
            nex[i] = i+1;
        }
        System.out.println("pushing elemets");
        push(3,1);
        push(4,2);
        push(7,2);
        push(45,3);
        push(23,1);
        push(12,3);
    }
}
