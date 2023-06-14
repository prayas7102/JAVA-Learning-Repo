// Count Inversions in an array. Inversion Count for an array indicates
// – how far (or close) the array is from being sorted. If the array is
// already sorted, then the inversion count is 0, but if the array is sorted
// in the reverse order, the inversion count is the  9p maximum. Formally
// speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j]
// and i < j.

// # Input: arr[] = {8, 4, 2, 1}
// # Output: 6
// Explanation: Given array has six inversions:
// (8, 4), (4, 2), (8, 2), (8, 1), (4, 1), (2, 1).
// 0,1,3,6,10,14

public class InversionCount {

  public static void main(String[] args) {
    int[] arr = { 8, 4, 2, 1, 0 };
    int inversionCount = mergeSortAndCount(arr, 0, arr.length - 1);
    System.out.println("Inversion count: " + inversionCount);
  }

  public static int mergeSortAndCount(int[] arr, int left, int right) {
    // calculate total inversion count in arr using merge sort
    int inversionCount = 0;
    if (left < right) {
      int mid = (left + right) / 2;
      // incrementing inversion count for left and right partition
      inversionCount += mergeSortAndCount(arr, left, mid);
      inversionCount += mergeSortAndCount(arr, mid + 1, right);
      inversionCount += mergeAndCount(arr, left, mid, right);
    }
    return inversionCount;
  }

  public static int mergeAndCount(int[] arr, int low, int mid, int high) {
    int left = low;
    int right = mid + 1;
    // temp array to store sorted numbers from arr
    int[] temp = new int[high + 1];
    int i = 0;
    // cnt would be returned as total inversion in the particular division of arr
    int cnt = 0;
    while (left <= mid && right <= high) {
      if (arr[left] <= arr[right]) {
        temp[i++] = arr[left++];
      } else {
        // Inversion count increases only when arr[left] > arr[right] (left<right)
        cnt += mid - left + 1;
        temp[i++] = arr[right++];
      }
    }
    // in case right > high
    while (left <= mid) {
      temp[i++] = arr[left++];
    }
    // in case left > mid
    while (right <= high) {
      temp[i++] = arr[right++];
    }
    // copying from temp array to the given arr
    for (i = low; i < high; i++) {
      arr[i] = temp[i];
    }
    return cnt;
  }
}
