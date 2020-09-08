package string.basic_usage;

public class Main {
    public static void main(String[] args) {
        String str = "languoxing";
        char[] charArr = str.toCharArray();
        char c1 = 0;
        charArr[0] = '\0';
        System.out.println(charArr.length);
        int i = 0;
        for (char c : charArr) {
            i++;
            System.out.println(c);
        }
        System.out.println(charArr[0]);
    }
}
