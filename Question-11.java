// Given an integer array, rearrange it such that it contains positive and
// negative numbers at alternate positions. If the array contains extra
// positive or negative numbers, put them at the end of the array.
// 			# Input: arr = {9, -3, 5, -2, -8, -6, 1, 3}
// 			# output: {5, -2, 9, -6,1 -8, 3, -3}

public class AlternatePositions {

  public static void main(String[] args) {
    int[] arr = { 9, 3, 5, 2, -8, -6, 1, 3 };
    AlterArray(arr);
    for (int ele : arr) {
      System.out.print(ele+ " ");
    }
  }

  public static void AlterArray(int[] arr) {
    int n = arr.length;
    int positiveCount = 0;
    int negativeCount = 0;

    // counting total positive and negative element
    for (int i = 0; i < n; i++) {
      if (arr[i] > 0) {
        positiveCount++;
      } else {
        negativeCount++;
      }
    }

    // storing negative and positive no.s separately
    int[] positiveNumbersArray = new int[positiveCount];
    int[] negativeNumbersArray = new int[negativeCount];
    int l = 0, p = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] > 0) {
        positiveNumbersArray[p] = arr[i];
        p++;
      } else {
        negativeNumbersArray[l] = arr[i];
        l++;
      }
    }

    int positiveIndex = 0;
    int negativeIndex = 0;

    // storing diff b/w positiveCount & negativeCount
    int extraNumbers = Math.min(positiveCount, negativeCount);

    // Storing negative and positive numbers alternately
    int index = 0;
    while (positiveIndex < positiveCount && negativeIndex < negativeCount) {
      arr[index++] = positiveNumbersArray[positiveIndex++];
      arr[index++] = negativeNumbersArray[negativeIndex++];
    }

    // Accommodating extra numbers if negativeCount < positiveCount
    if (extraNumbers == negativeCount) {
      while (positiveIndex < positiveCount) {
        arr[index++] = positiveNumbersArray[positiveIndex++];
      }
    }

    // Accommodating extra numbers if positiveCount < negativeCount
    if (extraNumbers == positiveCount) {
      while (negativeIndex < negativeCount) {
        arr[index++] = negativeNumbersArray[negativeIndex++];
      }
    }
  }
}
