public class LinearSearch {
    public static void findLetterOccurrences(String word) {
        int[] occurances = new int[26];
        int len = word.length();
        String newWord="";
        for (int i = 0; i < len; i++) {
            char wordChar = word.charAt(i);
            if (occurances[wordChar- 'a']==0)
                newWord += wordChar;
            occurances[wordChar - 'a']++;
        }
        for (int i = 0; i < newWord.length(); i++) {
            char newWordChar = newWord.charAt(i);
            System.out.print(newWordChar+" ");
            System.out.println(occurances[newWordChar-'a']);
        }
    }

    public static void main(String[] args) {
        String str = "elephant";
        findLetterOccurrences(str);
    }
}
