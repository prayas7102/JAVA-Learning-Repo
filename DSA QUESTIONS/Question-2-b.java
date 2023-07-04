public class InsertionSort {
    static void sort(int[] array) {
        int i;
        for (i = 1; i < array.length - 1; i++) {
            int j = i - 1; // before element
            int key = array[i]; //after element
            while (j >= 0 && array[j] > key) {
                array[j+1]=array[j];
                j--;
            }
            array[j + 1] = key;
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
