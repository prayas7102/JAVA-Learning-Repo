// Find the closest number in the array. Given an array of sorted integers. 
// Find the closest value to the given number. Arrays may contain duplicate values and negative numbers. 
// # Input: 
//              arr[] = [2, 42, 82, 122, 162, 202, 242, 282, 322, 362], 
//  number = 80
// # Output: 82

public class Main {
    static int BinarySearch(int[] array, int num) {

        int l = 0, r = array.length - 1, mid = 0, n = array.length - 1;

        while (l <= r) {
            mid = (l + r) / 2;
            if (array[mid] < num) {
                l = mid + 1;
            } else
                r = mid - 1;
        }

        int[] nearestNumIndexArray = new int[3];
        nearestNumIndexArray[0] = mid - 1;
        nearestNumIndexArray[1] = mid;
        nearestNumIndexArray[2] = mid + 1;
        System.out.println(mid);
        int nearestNumIndex = Integer.MAX_VALUE;

        for (int index : nearestNumIndexArray) {
            if (index >= 0 && index <= n && nearestNumIndex > Math.abs(Math.abs(array[index]) - Math.abs(num)))
                nearestNumIndex = index;
        }

        return array[nearestNumIndex];
    }

    public static void main(String[] args) {
        int[] array = { -2, -5, 82, 122, 162, 202, 242, 282, 322, 362 };
        int num = -3;
        System.out.println(BinarySearch(array, num));
    }
}