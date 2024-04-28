package com.company.charAndStringArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int findMinDifference(List<String> tp) {
        boolean[] ok = new boolean[24 * 60 + 1];
        int n = tp.size();
        for (int i = 0; i < n; i++) {
            String[] timeParts = tp.get(i).split(":");
            int hr = Integer.parseInt(timeParts[0]);
            int min = Integer.parseInt(timeParts[1]);
            int time = hr * 60 + min;
            if (ok[time])
                return 0;
            ok[time] = true;
        }
        int last = 0;
        int first = Integer.MAX_VALUE;
        int ret = Integer.MAX_VALUE;
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i <= 24 * 60; i++) {
            if (ok[i]) {
                last = Math.max(i, last);
                first = Math.min(i, first);
                if (prev != Integer.MIN_VALUE)
                    ret = Math.min(ret, last - prev);
                prev = i;
            }
        }
        return Math.min(ret, 24 * 60 + first - last);
    }
}
public class findMinDifference {
    public static void main(String[] args) {
        List<String> v = new ArrayList<>();
        v.add("12:30");
        v.add("15:17");
        Solution ob = new Solution();
        System.out.println(ob.findMinDifference(v));
    }
}
