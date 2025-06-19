package team.sakak.version;


/**
 * LookAndSayV1String (V1)
 * - 가장 기본적인 Look-and-Say 수열 생성 방식
 * - StringBuilder를 사용하여 문자열을 순차적으로 생성
 * - 성능이나 메모리 최적화는 고려되지 않음
 * - n이 커질수록 성능 저하 및 OOM 위험 있음
 * - n이 80 일때 OOM
 */
public class LookAndSayV1String {

    public static String getNthTerm(int n) {
        if (n < 3 || n >= 100) {
            throw new IllegalArgumentException("n은 3 이상 100 미만이어야 합니다.");
        }
        String term = "1";
        for (int i = 1; i < n; i++) {
            term = getNextTerm(term);
        }
        return term;
    }

    private static String getNextTerm(String term) {
        StringBuilder next = new StringBuilder();
        int count = 1;
        for (int i = 1; i < term.length(); i++) {
            if (term.charAt(i) == term.charAt(i - 1)) {
                count++;
            } else {
                next.append(count).append(term.charAt(i - 1));
                count = 1;
            }
        }
        next.append(count).append(term.charAt(term.length() - 1));
        return next.toString();
    }

    public static String getMiddleTwoDigits(int n) {
        String term = getNthTerm(n);
        int len = term.length();
        return term.substring((len - 2) / 2, (len - 2) / 2 + 2);
    }

    public static void main(String[] args) {
        System.out.println(getMiddleTwoDigits(5));   // 12
        System.out.println(getMiddleTwoDigits(8));   // 21
    }
}
