package recursion.fibonacci;

public class Main {
    public static void main(String[] args) {
        String text = " hello";
        int spaceNum = 0;
        String[] strList = text.trim().split("\\s+");
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                spaceNum++;
            }
        }

        int tailNum = strList.length - 1 > 0 ? spaceNum % (strList.length - 1) : spaceNum;
        int eachNum = strList.length - 1 > 0 ? spaceNum / (strList.length - 1) : 0;
        String result = "";
        int j = 0;
        for (j = 0; j < strList.length - 1; j++) {
            if ("".equals(strList[j].trim())) {
                continue;
            }
            result += strList[j];
            for (int i = 0; i < eachNum; i++) {
                result += " ";
            }
        }
        result += strList[j];
        for (int i = 0; i < tailNum; i++) {
            result += " ";
        }
        System.out.println(result);

    }
}
