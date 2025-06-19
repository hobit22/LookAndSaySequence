package team.sakak.version;


import java.io.ByteArrayOutputStream;
import java.util.ArrayDeque;
import java.util.Deque;

public class LookAndSayV6 {
    static void writeGroup(Deque<Character> sink, int count, char digit) {
        for (char c : String.valueOf(count).toCharArray()) {
            sink.addLast(c);
        }
        sink.addLast(digit);
    }

    static Deque<Character> nextTerm(Deque<Character> term) {
        Deque<Character> next = new ArrayDeque<>();
        char prev = term.peekFirst();
        int count = 0;

        for (char c : term) {
            if (c == prev) {
                count++;
            } else {
                writeGroup(next, count, prev);
                prev = c;
                count = 1;
            }
        }
        writeGroup(next, count, prev);
        return next;
    }

    public static String getMiddleTwoDigits(int n) {
        try {
            Deque<Character> term = new ArrayDeque<>();
            term.add('1');

            for (int i = 1; i < n; i++) {
                System.out.println("i = " + i);
                term = nextTerm(term);
                System.out.println("term.size() = " + term.size());
            }

            int len = term.size();
            int mid = (len - 2) / 2;
            char[] arr = new char[len];
            int i = 0;
            for (char c : term) arr[i++] = c;

            return "" + arr[mid] + arr[mid + 1];

        } catch (Exception e) {
            System.out.println("e = " + e);
        }

        return "FAIL";
    }

    public static void main(String[] args) {
//        System.out.println(getMiddleTwoDigits(5));   // 12
//        System.out.println(getMiddleTwoDigits(8));   // 21
//        System.out.println(getMiddleTwoDigits(50));  // OK
        System.out.println(getMiddleTwoDigits(99));  // OK
    }
}
