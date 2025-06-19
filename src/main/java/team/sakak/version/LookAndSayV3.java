package team.sakak.version;

import java.util.ArrayList;
import java.util.List;

public class LookAndSayV2 extends LookAndSayV1{

    public static String getMiddleTwoDigits(int n) {
        if (n == 1) return "1";

        List<Character> current = new ArrayList<>();
        current.add('1');

        for (int i = 1; i < n; i++) {
            List<Character> next = new ArrayList<>();
            int count = 1;
            for (int j = 1; j < current.size(); j++) {
                if (current.get(j) == current.get(j - 1)) {
                    count++;
                } else {
                    addGroup(next, count, current.get(j - 1));
                    count = 1;
                }
            }
            addGroup(next, count, current.get(current.size() - 1));
            current = next;
        }

        int len = current.size();
        return "" + current.get((len - 2) / 2) + current.get((len - 2) / 2 + 1);
    }

    private static void addGroup(List<Character> list, int count, char digit) {
        for (char c : String.valueOf(count).toCharArray()) {
            list.add(c);
        }
        list.add(digit);
    }

}
