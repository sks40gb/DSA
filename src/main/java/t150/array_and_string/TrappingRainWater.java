package t150.array_and_string;

public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater o = new TrappingRainWater();
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(o.trap(height1)); //6

        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println(o.trap(height2)); //9
    }

    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int[] h = new int[height.length];
        int maxLeft = 0;
        for (int i = 1; i < height.length; i++) {
            h[i] = maxLeft = Math.max(maxLeft, height[i - 1]);
        }

        int maxRight = 0;
        h[height.length - 1] = 0;
        for (int i = height.length - 2; i >= 0; i--) {
            maxRight = Math.max(maxRight, height[i + 1]);
            h[i] = Math.min(maxRight, h[i]);
        }

        int total = 0;
        for (int i = 0; i < height.length; i++) {
            if (h[i] > height[i]) {
                total += h[i] - height[i];
            }
        }
        return total;
    }

    public int trap2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];

        int water = 0;

        while (left < right) {
            if (leftMax < rightMax) {
                left++;
                if (leftMax < height[left]) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
            } else {
                right--;
                if (rightMax < height[right]) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
            }
        }
        return water;
    }
}
