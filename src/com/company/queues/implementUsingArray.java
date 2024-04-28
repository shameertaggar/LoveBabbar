package com.company.queues;


import java.util.Queue;

class queue{
     int arr[];
     int size;
     int front;
     int rear;
     public queue(int size){
         arr = new int[size];
         this.size = size;
         front = -1;
         rear = -1;
     }
     void push(int data){
         if (rear == size-1){
             System.out.println("queue overflow");
             return;
         }else if (front == -1 & rear == -1){
             front++;
             rear++;
             arr[rear] = data;
         }else{
             rear++;
             arr[rear] = data;
         }
     }
     void pop(){
         if (front == -1 && rear == -1){
             System.out.println("queue Underflow");
             return;
         }else if (front==rear){
             arr[rear] = -1;
             front = -1;
             rear = -1;
         }else{
             arr[front] = -1;
             front++;
         }
     }

     boolean isEmpty(){
         if (front == -1 && rear == -1){
             return true;
         }else{
             return false;
         }
    }

    int getSize(){
         return rear-front+1;
    }

    int getFront(){
         if (front == -1){
             System.out.println("queue underflow");
             return -1;
         }else{
             return arr[front];
         }
    }
    void print(){
        System.out.println("printing queue");
         for (int i = 0 ; i<arr.length;i++ ){
             System.out.print(arr[i] + " | ");
         }
        System.out.println();
    }

}
public class implementUsingArray {


    public static void main(String[] args) {
       queue q = new queue(10);
       for (int i = 0 ; i< q.size; i++){
           q.push(i+2);
       }


       q.print();
       q.pop();
       q.print();
        q.pop();
        q.print();
        q.pop();
        q.print();
        q.pop();
        q.print();
        for (int i = 0 ; i< q.size; i++){
            q.push(i+2);
        }


    }
}
