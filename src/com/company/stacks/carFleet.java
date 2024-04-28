package com.company.stacks;

import java.util.*;

class Car{
    int pos,speed;
    Car(int p, int s){
        this.pos = p;
        this.speed = s;
    }


}

public class carFleet {
    public static void main(String[] args) {
        int pos[] = {10,8,0,5,3};
        int speed[] = {2,4,1,1,3};

        int totDis = 12;
        ArrayList<Car> cars = new ArrayList<>();

        for (int i = 0; i < pos.length; i++){
            Car c = new Car(pos[i],speed[i]);
            cars.add(c);
        }
        Collections.sort(cars,Comparator.comparingInt(Car-> Car.pos) );


       double time[] = new double[pos.length];
       for (int i = 0; i<cars.size(); i++){
           Car car = cars.get(i);
           double dis = totDis-car.pos;
           double tym = dis/car.speed;
           time[i] = tym;
       }

       Stack<Double> s = new Stack<>();
       s.push((double) -1);
       for (int i = 0; i<time.length ; i++){
           if (time[i] >= s.peek()){
               s.pop();
           }
               s.push(time[i]);

       }

        System.out.println(s.size());
        System.out.println(s.toString());
    }
}
