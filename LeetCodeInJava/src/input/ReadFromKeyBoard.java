package input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadFromKeyBoard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> lineList = new ArrayList<>();
        /*
         * 判断第一行是否是空行
         */
        if (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) {
                if (line.isEmpty()) {
                    System.out.println("Empty line!");
                }
            }
            else {
                lineList.add(line);
            }

        }
        /*
         * 将非空行保存下来，并在后面统一输出
         */
        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            if (line.isEmpty()) {
                break;
            }
            lineList.add(line);

        }
        for (String line : lineList) {
            System.out.println(line);
        }
        System.out.println("End!");
    }
}
