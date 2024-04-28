package com.company.heaps;

class info implements Comparable<info> {
    char data;
    int count;

    info(char ch, int cnt) {
        this.data = ch;
        this.count = cnt;
    }

    @Override
    public int compareTo(info other) {
        return Integer.compare(other.count, this.count);
    }
}
public class reorganizeString {
    // use this custo comparator function


}
