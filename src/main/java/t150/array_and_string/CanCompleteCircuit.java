package t150.array_and_string;

public class CanCompleteCircuit {

    public static void main(String[] args) {
        CanCompleteCircuit o = new CanCompleteCircuit();
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int result = o.canCompleteCircuit(gas, cost);
        System.out.println(result);  // Output should be 3
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int currentGas = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            currentGas += gas[i] - cost[i];

            // If current gas becomes negative, we cannot start from the current start
            // Update start to be the next station, and reset current gas
            if (currentGas < 0) {
                currentGas = 0;
                start = i + 1;
            }
        }
        return totalGas < 0 ? -1 : start;
    }

}
