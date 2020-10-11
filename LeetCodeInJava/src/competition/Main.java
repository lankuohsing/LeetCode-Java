package competition;

public class Main {
    public static void main(String[] args) {
        System.out.println("hello");
        String address = "1.1.1.1";
        String[] subs = address.split(".");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < subs.length; i++) {
            sb.append(subs[i]);
            sb.append("[.]");
        }
        System.out.println(sb.toString());
    }
}
