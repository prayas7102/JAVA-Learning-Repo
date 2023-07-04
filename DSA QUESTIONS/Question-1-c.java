// Implement fibonacci in space complexity O(1). 
class Fibonnaci {
    static int FibonnaciMethod(int n) {
        if (n <= 1)
            return n - 1;
        int curr = 1, prev = 0;
        for (int index = 2; index < n; index++) {
            int temp = curr;
            curr = curr + prev;
            prev = temp;
        }
        return curr;
    }

    public static void main(String[] args) {
        System.out.println(FibonnaciMethod(5));
    }
}