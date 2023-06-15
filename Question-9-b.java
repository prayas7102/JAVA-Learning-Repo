// Write a program without using any libraries in java that, 
// given an array A[] of n numbers and another number x, 
// determines whether or not there exist two elements in 
// S whose sum is exactly x. 
// # Input: arr[] = {0, -1, 2, -3, 1},  sum=-2
// # output: -3, 1

public class TwoSum {

  public static void main(String[] args) {
    int[] arr = { 0, -1, 2, -3, 1 };
    int targetSum = -2;
    // to check if there's required element which sum up to targetsum
    boolean found = false;
    // traversing array in two loops and comparing all elements with each other
    for (int i = 0; i < arr.length; i++) {
      int num1 = arr[i];
      for (int j = i + 1; j < arr.length; j++) {
        int num2 = arr[j];
        if (num1 + num2 == targetSum) {
          System.out.println(num1 + ", " + num2);
          found = true;
          break;
        }
      }
      if (found) {
        break;
      }
    }

    if (!found) {
      System.out.println("No two elements sum to " + targetSum);
    }
  }
}
