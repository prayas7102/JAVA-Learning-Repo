public class AlternatePositions {
    static void swap(int l, int r, int[] arr) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }

    static void solve(int[] arr) {

        int len = arr.length;
        int left = 0, right = len - 1;

        while (left != right) {
            if (arr[left] < 0 && arr[right] >= 0) {
                swap(left, right, arr);
                left++;
                right--;
            }
            if (arr[left] > 0 && arr[right] >= 0) {
                swap(left, right, arr);
                left++;
            }
            if (arr[left] < 0 && arr[right] <= 0) {
                swap(left, right, arr);
                right--;
            }
        }

        if (left == 0)
            return;

        int[] positiveArray = new int[left];
        int[] negativeArray = new int[len - left];

        for (int i = left; i < len ; i++) {
            negativeArray[i-left] = arr[i];
        }
        for (int i = 0; i < left; i++) {
            positiveArray[i] = arr[i];
        }
        
        int p = 0, n = 0;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0 && p < positiveArray.length) {
                arr[i] = positiveArray[p];
                p++;
            }

            if (i % 2 != 0 && n < negativeArray.length) {
                arr[i] = negativeArray[n];
                n++;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = { 9, 3, -5, -2, -8, -6, 1, 3 };
        solve(arr);
        for (int element : arr) {
        System.out.print(element + " ");
        }
    }
}
