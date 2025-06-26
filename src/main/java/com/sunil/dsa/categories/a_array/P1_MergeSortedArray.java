package com.sunil.dsa.categories.a_array;

public class P1_MergeSortedArray {
    public static void main(String[] args) {

        P1_MergeSortedArray o = new P1_MergeSortedArray();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        o.merge(nums1, m, nums2, n);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = nums1.length - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] < nums2[p2]) {
                nums1[p] = nums2[p2];
                p2--;
            }else{
                nums1[p] = nums1[p1];
                p1--;
            }
            p--;
        }

        while(p1 >= 0){
            nums1[p] = nums1[p1];
            p1--;
            p--;
        }

        while(p2 >= 0){
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }
}
