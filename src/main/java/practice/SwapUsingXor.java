package practice;

public class SwapUsingXor {
    public static void main(String[] args) {
        long[] arr1 = {1, 4, 8, 10};
        long[] arr2 = {2, 3, 9};

        int n = 4, m = 3;
        sort(arr1, arr2);
        System.out.println("The merged arrays are:");
        System.out.print("arr1[] = ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.print("\narr2[] = ");
        for (int i = 0; i < m; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();

        long[] arr = {5, 3, 1, 9, 7};
        long[] arr_2 = {2,6,4};
        sort(arr, arr_2);
        System.out.println("A1-------------");
        for (long l : arr) {
            System.out.print(" " + l);
        }
        System.out.println();
        System.out.println("A2-------------");
        for (long l : arr_2) {
            System.out.print(" " + l);
        }
    }

    public static void sort(long[] arr1, long[] arr2) {

        //[ ] [ ] -> [   ]
        int n = arr1.length + arr2.length;
        for (int i = 0; i < n; i++) {
            long min = getElement(i, arr1, arr2);// arr1[i];
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (min > getElement(j, arr1, arr2)) { //arr1[j]
                    min = getElement(j, arr1, arr2);//arr1[j];
                    minIndex = j;
                }
            }
            long temp = getElement(i, arr1, arr2);//arr1[i];
            setElement(i, arr1, arr2, getElement(minIndex, arr1, arr2));
            setElement(minIndex, arr1, arr2, temp);
        }

    }

    private static void setElement(int index, long[] arr1, long[] arr2, long element) {
        if (index < arr1.length) {
            arr1[index] = element;
        } else {
            arr2[index - arr1.length] = element;
        }
    }

    private static long getElement(int index, long[] arr1, long[] arr2) {
        if (index < arr1.length) {
            return arr1[index];
        } else {
            return arr2[index - arr1.length];
        }
    }

}

// [                           ]
//            gap
// left       right
//-> switch elements if left is greater
// reduce the gap by half


//     gap
//gap

// left->                    ->
//            right->         ->