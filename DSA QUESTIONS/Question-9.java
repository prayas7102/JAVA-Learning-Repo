public class ClosestNumber {
    public static int findClosestNum(int[] arr, int number) {
        int left = 0;
        int right = arr.length - 1;
        int closest = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (Math.abs(arr[mid] - number) < Math.abs(closest - number)) {
                closest = arr[mid];
            }

            if (arr[mid] > number) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return closest;
    }

    public static void main(String[] args) {
        int[] arr = {-2, -5, 42, 82, 122, 162, 202, 242, 282, 322, 362};
        int number = -3;
        int closestNumber = findClosestNum(arr, number);
        System.out.println(closestNumber);
    }
}
