import java.util.*;

public class AlternatePositions {

  public static void main(String[] args) {
    int[] arr = { 9, -3, 5, -2, -8, 6, 1, 3 };
    AlterArray(arr);
    System.out.println(Arrays.toString(arr));
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

    ArrayList<Integer> list = new ArrayList<Integer>();

    // storing negative and positive no.s alternately
    while (positiveIndex < positiveCount && negativeIndex < negativeCount) {
      list.add(positiveNumbersArray[positiveIndex]);
      list.add(negativeNumbersArray[negativeIndex]);
      positiveIndex++;
      negativeIndex++;
    }

    //  to accomodate extra no.s if negativeCount < positiveCount
    if (extraNumbers == negativeCount) {
      while (positiveIndex < positiveCount) {
        list.add(positiveNumbersArray[positiveIndex]);
        positiveIndex++;
      }
    }
    
    // to accomodate extra no.sif positiveCount < negativeCount
    if (extraNumbers == positiveCount) {
      while (negativeIndex < negativeCount) {
        list.add(negativeNumbersArray[negativeIndex]);
        negativeIndex++;
      }
    }

    // copying the elements in list to arr
    int i = 0;
    for (int ele : list) {
      arr[i] = ele;
      i++;
    }
  }
}
