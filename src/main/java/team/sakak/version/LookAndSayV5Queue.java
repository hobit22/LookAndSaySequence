package team.sakak.version;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LookAndSayV5Queue (V5)
 * - Queue를 사용하여 항을 계산
 * - 중간 값 구하는 로직이 느림
 */
public class LookAndSayV5Queue {

    public static String getMiddleTwoDigits(int n) {
        if (n < 3 || n >= 100) {
            throw new IllegalArgumentException("n은 3 이상 100 미만이어야 합니다.");
        }

        Queue<Character> queue = new LinkedList<>();
        queue.offer('1');

        for (int i = 2; i <= n; i++) {
            Queue<Character> next = new LinkedList<>();

            char prev = queue.poll();
            int count = 1;
            while (!queue.isEmpty()) {
                char curr = queue.poll();
                if (curr == prev) {
                    count++;
                } else {
                    enqueueGroup(next, count, prev);
                    prev = curr;
                    count = 1;
                }
            }
            enqueueGroup(next, count, prev);
            queue = next;
        }

        // 중간 두 자리 추출
        int size = queue.size();
        int mid = (size - 2) / 2;
        for (int i = 0; i < mid; i++) queue.poll();
        char first = queue.poll();
        char second = queue.poll();
        return "" + first + second;
    }

    private static void enqueueGroup(Queue<Character> queue, int count, char digit) {
        for (char c : Integer.toString(count).toCharArray()) {
            queue.offer(c);
        }
        queue.offer(digit);
    }

    public static void main(String[] args) {
        System.out.println(getMiddleTwoDigits(5));   // 12
        System.out.println(getMiddleTwoDigits(8));   // 21
    }
}
