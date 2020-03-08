package useful_codes.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionSortExample2 {
    public static void main(String[] args) {
        List<List<Integer>> paths = new ArrayList<List<Integer>>();
        paths.add(new ArrayList<>(Arrays.asList(10, 3, 3, 6, 2)));
        paths.add(new ArrayList<>(Arrays.asList(10, 3, 3, 6, 3)));
        paths.add(new ArrayList<>(Arrays.asList(10, 4, 3, 6, 1)));
        paths.add(new ArrayList<>(Arrays.asList(10, 5, 2, 7, 2)));
        paths.add(new ArrayList<>(Arrays.asList(9, 9, 2)));
        paths.add(new ArrayList<>(Arrays.asList(10, 3, 3, 6, 2)));
        Collections.sort(paths, (o1, o2) -> {
            int minsize = o1.size() < o2.size() ? o1.size() : o2.size();
            for (int i = 0; i < minsize; i++) {
                if (o1.get(i) > o2.get(i)) {
                    return -1;
                } else {
                    if (o1.get(i) < o2.get(i)) {
                        return 1;
                    }
                }

            }
            if (o1.size() > o2.size()) {
                return -1;
            }
            if (o1.size() < o2.size()) {
                return 1;
            }
            if (o1.size() == o2.size()) {
                return 0;
            }

            return -1;
        });
        System.out.println(paths);
    }
}
