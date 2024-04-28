package com.company.queues;

public class gasStation {
    static void bruteForce(int gas[], int cost[]){
        int g = 0;
        for (int i = 0; i<gas.length; i++){
            if (gas[i] < cost[i]){
                continue;
            }
            if (gas[i] > cost[i]){
                g = g + gas[i] -cost[i];
                gas[i] = 0;
            }
        }
        int i = 0;
        int k = gas.length;
        while(i <= k && gas[i] != 0){
            if (i == k){
                System.out.println("no gas station found");
                return;
            }
            if ((g+gas[i] ) < cost[i]){
                System.out.println("no gas station found");
                return;
            }
            g = g + gas[i] - cost[i];
            i++;
        }
        System.out.println("gas station " + (i+1));

    }
    public static void main(String[] args) {
        int gas[] = {1,2,3,4,5};
        int cost[] = {3,2,5,1,2};

        bruteForce(gas,cost);
    }
}
