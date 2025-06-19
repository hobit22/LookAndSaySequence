package team.sakak.version;

/**
 * LookAndSayV4TwoPointer (V4 개량)
 * - 초기 버전에서 StringBuilder를 유지하되 투포인터 방식 도입
 */
public class LookAndSayV4TwoPointer {

    public static String nextTerm(String current) {
        StringBuilder next = new StringBuilder();
        int n = current.length();
        int i = 0;

        while (i < n) {
            char digit = current.charAt(i);
            int count = 1;
            int j = i + 1;
            while (j < n && current.charAt(j) == digit) {
                count++;
                j++;
            }
            next.append(count).append(digit);
            i = j;
        }


        return next.toString();
    }

    public static String getMiddleTwoDigits(int n) {
        if (n < 3 || n >= 100) {
            throw new IllegalArgumentException("n은 3 이상 100 미만이어야 합니다.");
        }

        String term = "1";
        for (int i = 2; i <= n; i++) {
            term = nextTerm(term);
        }

        int len = term.length();
        return term.substring((len - 2) / 2, (len - 2) / 2 + 2);
    }

    public static void main(String[] args) {
        System.out.println(getMiddleTwoDigits(5));   // 12
        System.out.println(getMiddleTwoDigits(8));   // 21
    }
}
