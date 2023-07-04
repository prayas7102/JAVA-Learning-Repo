// Reverse a string using stack. Implement your own stack. [-Stack]
// # input: string = “reverse me”
// # output: “em esrever”

public class ReverseStringWithStack {

  public static void main(String[] args) {
    String stringToBeReversed = "reverse me";
    System.out.println(reverseString(stringToBeReversed));
  }

  public static String reverseString(String stringToBeReversed) {
    int length = stringToBeReversed.length();
    Stack stackInstance = new Stack(length);

    // Pushing operation in stack
    for (int i = 0; i < length; i++) {
      stackInstance.push(stringToBeReversed.charAt(i));
    }

    // Poping from stack
    String reversedString = "";
    while (!stackInstance.isEmpty()) {
      reversedString += stackInstance.pop();
    }

    return reversedString.toString();
  }
}

class Stack {

  private char[] stackArray;
  private int top, maxLen;

  public Stack(int size) {
    maxLen = size;
    stackArray = new char[maxLen];
    top = -1;
  }

  public void push(char c) {
    if (top == maxLen - 1) {
      System.out.println("Stack overflow!");
      return;
    }
    stackArray[++top] = c;
  }

  public char pop() {
    if (top == -1) {
      System.out.println("Stack underflow!");
      return '\0'; 
    }
    return stackArray[top--];
  }

  public boolean isEmpty() {
    return (top == -1);
  }
}
