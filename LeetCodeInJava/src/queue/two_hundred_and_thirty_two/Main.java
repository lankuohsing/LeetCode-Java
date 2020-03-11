package queue.two_hundred_and_thirty_two;

public class Main {
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.peek();
        int param_3 = obj.pop();
        boolean param_4 = obj.empty();
        System.out.println(param_2 + "," + param_3 + "," + param_4);
    }
}
