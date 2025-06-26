package com.sunil.dsa.categories.a_array;

import java.util.Arrays;

public class P11_H_Index {

    public static void main(String[] args) {
        P11_H_Index o = new P11_H_Index();
        System.out.println(o.hIndex(new int[]{3, 0, 6, 1, 5})); //3
        System.out.println(o.hIndex(new int[]{1, 3, 1})); //1
    }

    public int hIndex(int[] citations) {

        int n = citations.length;
        int[] times = new int[n + 1];

        for (int i = 0; i < citations.length; i++) {
            int num = citations[i];
            if (num > n) {
                times[n]++;
            } else {
                times[num]++;
            }
        }

        int total = 0;
        for (int i = times.length - 1; i > 0; i--) {
            total += times[i];
            if (total >= i) {
                return i;
            }
        }
        return 0;
    }

    public int hIndex2(int[] citations) {
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int n = citations.length - i;
            if (citations[i] >= n) {
                return n;
            }
        }
        return 0;
    }

}
