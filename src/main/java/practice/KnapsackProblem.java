package practice;

public class KnapsackProblem {

    public static void main(String[] args) {
        int val[] = new int[] { 10, 15, 40};
        int wt[] = new int[] {1, 2, 3  };
        int W = 6;
        int max = getMaxVal(val, wt, W, 0, 0);
        System.out.println(max);

    }

    private static int getMaxVal(int[] val,  int[] wt, int w, int index, int value) {
        if(w == 0){
            return value;
        }
        if(w < 0){
            return 0;
        }
        if(index >= val.length){
            return value;
        }
        int pick = getMaxVal(val,wt,w-wt[index], index+1, value + val[index]);
        int dontPick = getMaxVal(val, wt, w, index+1, value);
        return Math.max(pick,dontPick);
    }

}
