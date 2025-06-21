package t150.array_and_string;

import util.ArrayUtil;

public class ProductExceptSelf {
    public static void main(String[] args) {
        ProductExceptSelf o = new ProductExceptSelf();
        int[] result = o.productExceptSelf(new int[]{1, 2, 3, 4});
        ArrayUtil.print1D(result);
    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int rightProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] = result[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }
        return result;
    }
}
