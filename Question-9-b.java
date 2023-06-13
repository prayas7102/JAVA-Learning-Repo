import java.util.*;
public class TwoSum
{
    public static void findTwoSum(int[] arr, int targetSum) {
        HashSet<Integer> targetSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            int target = targetSum - arr[i];
            if (targetSet.contains(target)) {
                System.out.println(arr[i] + ", " + target);
                return;
            }
            targetSet.add(arr[i]);
        }
        System.out.println("No two elements sum ");
    }

    public static void main(String[] args) {
        int[] arr1 = {0, -1, 2, -3, 1};
        int sum1 = -2;
        System.out.print("Output: ");
        findTwoSum(arr1, sum1);
    }
}
