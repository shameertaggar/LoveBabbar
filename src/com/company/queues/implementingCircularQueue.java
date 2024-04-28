package com.company.queues;


class queuee{
    int arr[];
    int size;
    int front;
    int rear;
    public queuee(int size){
        arr = new int[size];
        this.size = size;
        front = -1;
        rear = -1;
    }
    void push(int data){
        if (rear == size-1 && front == 0 || rear == front - 1){
            if (rear == front - 1){
                System.out.println("queue overflow");
                return;
            }
            System.out.println("queue overflow");
            return;
        }else if (front == -1 & rear == -1){
            front++;
            rear++;
            arr[rear] = data;
        }else if (rear == size-1 && front != 0){
            rear = 0;
            arr[rear] = data;
        }
        else{
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
        }else if (front == size-1){
            arr[front] = -1;
            front = 0;

        }
        else{
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
public class implementingCircularQueue {
    public static void main(String[] args) {

        queuee q = new queuee(10);
        for (int i = 0 ; i< q.size; i++){
            q.push(i+2);
        }

        q.print();
        q.push(2);
        q.pop();
        q.pop();
        q.print();
        q.push(3);
        q.print();
        q.push(4);
        q.print();
        q.push(3);
        q.print();
    }
}
