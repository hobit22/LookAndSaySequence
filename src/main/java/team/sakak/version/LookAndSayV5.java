package team.sakak.version;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class LookAndSayV4 {

    public static String getNthTerm(int n) {
        String term = "1";
        for (int i = 1; i < n; i++) {
            term = getNextTerm(term);
        }
        return term;
    }

    private static String getNextTerm(String term) {
        StringBuilder sb = new StringBuilder(term.length() * 2);  // 용량 예측
        int count = 1;
        for (int i = 1; i < term.length(); i++) {
            if (term.charAt(i) == term.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count).append(term.charAt(i - 1));
                count = 1;
            }
        }
        sb.append(count).append(term.charAt(term.length() - 1));
        return sb.toString();
    }

    public static String getMiddleTwoDigits(int n) {
        String term = getNthTerm(n);
        int len = term.length();
        return term.substring((len - 2) / 2, (len - 2) / 2 + 2);
    }

    public static void main(String[] args) {
        System.out.println(getMiddleTwoDigits(5));   // 12
        System.out.println(getMiddleTwoDigits(8));   // 21
        System.out.println(getMiddleTwoDigits(50));  // OK
        System.out.println(getMiddleTwoDigits(99));  // may work if heap size increased
    }
}
