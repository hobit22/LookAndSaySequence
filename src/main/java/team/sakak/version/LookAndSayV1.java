package team.sakak.version;

public class LookAndSayV1 {

    // n번째 항의 수열을 반환
    public static String getNthTerm(int n) {
        if (n <= 0) return "";
        String term = "1";
        for (int i = 1; i < n; i++) {
            term = getNextTerm(term);
        }
        return term;
    }

    // 현재 항으로부터 다음 항을 생성
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

    // 가운데 두 자리 수를 추출
    public static String getMiddleTwoDigits(int n) {
        String term = getNthTerm(n);
        int len = term.length();
        if (len < 2) {
            return term;
        }
        return term.substring((len - 2) / 2, (len - 2) / 2 + 2);
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println("n = " + n + ", Middle Two Digits = " + getMiddleTwoDigits(n));
    }
}
