package stack;

public class Main {
    public static void main(String[] args) {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.top();
        int param_3 = obj.pop();
        boolean param_4 = obj.empty();
        System.out.println(param_2 + "," + param_3 + "," + param_4);

    }
}
