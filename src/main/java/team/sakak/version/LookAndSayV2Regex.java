package team.sakak.version;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * LookAndSayV2Regex (V2)
 * - 정규표현식 기반 구현: (.)\1* 패턴으로 그룹 단위 추출
 * - 코드가 간결하고 직관적이나, 내부적으로 문자열 전체를 다시 생성하므로 메모리 사용은 큼
 * - 성능 최적화보다는 가독성과 간단한 구조를 우선시한 버전
 * - n = 80 일때 OOM
 */
public class LookAndSayV2Regex {

    private static final Pattern GROUP_PATTERN = Pattern.compile("(.)\\1*");

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
        Matcher matcher = GROUP_PATTERN.matcher(term);
        StringBuilder next = new StringBuilder();

        while (matcher.find()) {
            String group = matcher.group();
            next.append(group.length()).append(group.charAt(0));
        }

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
