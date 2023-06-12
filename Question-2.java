// # input : arr = {Given an array, print the number of rounds needed in bubble sort.
// 1,2,3}
// # output: 0 (already sorted, no bubble sort needed)

// #input: arr = {1,3,2}
// # output: 1 (we need one round of bubble sort)

// # input: arr = {3,2,1}
// # output:  2 (we need two round of bubble sort)

class Main {
    static int CountBubbleSort(int[] array) {

        int count = 0, n = array.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    swapped = true;
                }
            }
            if (!swapped) return count;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] array = { 1,3,2 };
        System.out.println(CountBubbleSort(array));
    }
}