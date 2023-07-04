public class SelectionSort {
    static void sort(int[] array) {
        int i, j, min_index;
        for (i = 0; i < array.length - 2; i++) {
            min_index = i;
            for (j = i + 1; j < array.length - 1; j++) {
                if (array[j] < array[min_index]) {
                    min_index = j;
                }
            }
            if (min_index != i) {
                int tmp = array[i];
                array[i] = array[min_index];
                array[min_index] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = { 6, 4, 6, 7, 3, 3, 23 };
        sort(array);
        for (int elem : array) {
            System.out.println(elem);
        }
    }

}
