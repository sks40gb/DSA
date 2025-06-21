package t150.array_and_string;

public class HIndex {

    public static void main(String[] args) {
        HIndex o = new HIndex();
//        int result = o.hIndex2(new int[]{3, 0, 6, 1, 5});
        int result = o.hIndex2(new int[]{1, 3, 1});
        System.out.println(result);
    }

    public int hIndex(int[] citations) {
        int max = 0;
        for (int cnt = citations.length; cnt > 0; cnt--) {
            int h = 0;
            for (int i = 0; i < citations.length; i++) {
                if (citations[i] >= cnt) {
                    h++;
                }
            }
            if (h >= cnt) {
                return cnt;
            }
        }
        return max;
    }

    public int hIndex2(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n) {
                buckets[n]++;
            } else {
                buckets[citations[i]]++;
            }
        }
        int cnt = 0;
        for (int i = n; i >= 0; i--) {
            cnt += buckets[i];
            if (cnt >= i) {
                return i;
            }
        }
        return 0;
    }
}
