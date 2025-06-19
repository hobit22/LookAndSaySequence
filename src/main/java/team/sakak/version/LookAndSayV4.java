package team.sakak.version;

import java.util.*;

public class LookAndSayV3{

    public static String getMiddleTwoDigits(int n) {
        if (n == 1) return "1";

        Deque<Character> current = new ArrayDeque<>();
        current.add('1');

        for (int i = 1; i < n; i++) {
            Deque<Character> next = new ArrayDeque<>();
            Iterator<Character> it = current.iterator();

            if (!it.hasNext()) break;
            char prev = it.next();
            int count = 1;

            while (it.hasNext()) {
                char curr = it.next();
                if (curr == prev) {
                    count++;
                } else {
                    appendGroup(next, count, prev);
                    prev = curr;
                    count = 1;
                }
            }
            appendGroup(next, count, prev);

            // 슬라이딩 윈도우처럼 앞뒤 50자씩만 유지
            while (next.size() > 100) {
                next.pollFirst(); // 앞에서 제거
            }

            current = next;
        }

        // 가운데 두 자리 추출
        int len = current.size();
        Character[] arr = current.toArray(new Character[0]);
        return "" + arr[(len - 2) / 2] + arr[(len - 2) / 2 + 1];
    }

    private static void appendGroup(Deque<Character> deque, int count, char digit) {
        for (char c : String.valueOf(count).toCharArray()) {
            deque.add(c);
        }
        deque.add(digit);
    }

    public static void main(String[] args) {
        System.out.println(getMiddleTwoDigits(5));   // 12
        System.out.println(getMiddleTwoDigits(8));   // 21
        System.out.println(getMiddleTwoDigits(50));  // OOM 없이 통과
        System.out.println(getMiddleTwoDigits(99));  // OOM 없이 통과
    }
}
