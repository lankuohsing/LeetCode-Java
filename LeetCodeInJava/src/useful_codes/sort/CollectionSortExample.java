package useful_codes.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionSortExample {
    public static void main(String[] args) {
        List<String> lineList = new ArrayList<>(Arrays.asList(
           "China 50 32 21",
           "America 50 40 12",
           "Japan 23 43 13",
           "Britain 23 43 13",
           "Russia 38 23 12",
           "France 38 21 12",
           "Austrilia 23 22 1"
        ));
        List<Map<String, String>> countryMedalsMapList = new ArrayList<>();
        List<String> priorityList = new ArrayList<>(Arrays.asList(
                "gold",
                "silver",
                "bronze",
                "name"
                ));
        for (String line : lineList) {
            Map<String, String> countryMedalsMap = new HashMap<>();
            List<String> strList = new ArrayList<>(Arrays.asList(line.trim().split(" ")));
            countryMedalsMap.put("name", strList.get(0));
            countryMedalsMap.put("gold", strList.get(1));
            countryMedalsMap.put("silver", strList.get(2));
            countryMedalsMap.put("bronze", strList.get(3));
            countryMedalsMapList.add(countryMedalsMap);
        }
        Collections.sort(countryMedalsMapList, new Comparator<Map<String, String>>() {
            @Override
            public int compare(Map<String, String> o1, Map<String, String> o2) {
                if (Integer.parseInt(o1.get("gold")) > Integer.parseInt(o2.get("gold"))) {
                    return -1;//代表降序排列
                } else {
                    if (Integer.parseInt(o1.get("gold")) < Integer.parseInt(o2.get("gold"))) {
                        return 1;
                    } else {
                        if (Integer.parseInt(o1.get("silver")) > Integer.parseInt(o2.get("silver"))) {
                            return -1;
                        } else {
                            if (Integer.parseInt(o1.get("silver")) < Integer.parseInt(o2.get("silver"))) {
                                return 1;
                            } else {
                                if (Integer.parseInt(o1.get("bronze")) > Integer.parseInt(o2.get("bronze"))) {
                                    return -1;
                                } else {
                                    if (Integer.parseInt(o1.get("bronze")) < Integer.parseInt(o2.get("bronze"))) {
                                        return 1;
                                    } else {
                                      //代表按照字典序输出，字典序在前的话返回-1
                                        return o1.get("name").compareTo(o2.get("name"));
                                      }
                                  }

                              }
                          }
                    }
                }
            }
        }
                  );
        for (String line : lineList) {
            System.out.println(line);
        }
        System.out.println("-------------");
        for (Map<String, String> countryMedalsMap : countryMedalsMapList) {
            System.out.println(countryMedalsMap.get("name"));
        }
    }
}
