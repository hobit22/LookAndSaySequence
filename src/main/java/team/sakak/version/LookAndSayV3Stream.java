package team.sakak.version;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * LookAndSayV3Stream (V3)
 * - ByteArrayInputStream / OutputStream 기반으로 수열 생성
 * - 문자열 대신 스트림을 통해 읽고 쓰는 방식으로 메모리 효율 향상
 * - 객체는 여전히 생성되지만, 문자열 생성 비용을 피함
 * - n = 80 일때 OOM
 */
public class LookAndSayV3Stream {

    public static ByteArrayOutputStream nextTerm(ByteArrayInputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int prev = -1;
        int count = 0;
        int curr;

        while ((curr = in.read()) != -1) {
            if (curr == prev) {
                count++;
            } else {
                if (prev != -1) {
                    out.write(Integer.toString(count).getBytes());
                    out.write(prev);
                }
                prev = curr;
                count = 1;
            }
        }

        if (prev != -1) {
            out.write(Integer.toString(count).getBytes());
            out.write(prev);
        }

        return out;
    }

    public static String getMiddleTwoDigits(int n) throws IOException {
        if (n < 3 || n >= 100) {
            throw new IllegalArgumentException("n은 3 이상 100 미만이어야 합니다.");
        }

        byte[] term = new byte[]{'1'};
        for (int i = 2; i <= n; i++) {
            ByteArrayInputStream in = new ByteArrayInputStream(term);
            ByteArrayOutputStream out = nextTerm(in);
            term = out.toByteArray();
        }

        int len = term.length;
        return "" + (char) term[(len - 2) / 2] + (char) term[(len - 2) / 2 + 1];
    }

    public static void main(String[] args) throws IOException {
        System.out.println(getMiddleTwoDigits(5));   // 12
        System.out.println(getMiddleTwoDigits(8));   // 21
    }
}
