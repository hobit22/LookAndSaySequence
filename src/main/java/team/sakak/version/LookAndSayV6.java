package team.sakak.version;

public class LookAndSayV5 {

    // 인코딩: 1 → 0b00, 2 → 0b01, 3 → 0b10
    private static int encode(char c) {
        if (c == '1') return 0b00;
        if (c == '2') return 0b01;
        if (c == '3') return 0b10;
        throw new IllegalArgumentException("Unexpected digit: " + c);
    }

    private static char decode(int bits) {
        return switch (bits & 0b11) {
            case 0b00 -> '1';
            case 0b01 -> '2';
            case 0b10 -> '3';
            default -> throw new IllegalArgumentException("Invalid 2-bit code");
        };
    }

    // 수열을 2비트 기반으로 압축 저장
    private static byte[] compress(String term) {
        int len = term.length();
        int byteLen = (len * 2 + 7) / 8; // 2비트 * len => bit수 / 8
        byte[] compressed = new byte[byteLen];

        for (int i = 0; i < len; i++) {
            int val = encode(term.charAt(i));
            int bitIndex = i * 2;
            int byteIndex = bitIndex / 8;
            int offset = bitIndex % 8;

            compressed[byteIndex] |= val << (6 - offset);
        }

        return compressed;
    }

    // 압축된 배열에서 i번째 문자 디코딩
    private static char getDigit(byte[] compressed, int index) {
        int bitIndex = index * 2;
        int byteIndex = bitIndex / 8;
        int offset = bitIndex % 8;

        int b = (compressed[byteIndex] >> (6 - offset)) & 0b11;
        return decode(b);
    }

    // 가운데 두 자리 추출
    public static String getMiddleTwoDigits(int n) {
        String term = "1";
        for (int i = 1; i < n; i++) {
            System.out.println("i = " + i);
            term = getNextTerm(term);
        }

        byte[] compressed = compress(term);
        int len = term.length();
        return "" + getDigit(compressed, (len - 2) / 2) + getDigit(compressed, (len - 2) / 2 + 1);
    }

    private static String getNextTerm(String term) {
        StringBuilder sb = new StringBuilder(term.length() * 2);
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

    public static void main(String[] args) {
        System.out.println(getMiddleTwoDigits(5));  // 12
        System.out.println(getMiddleTwoDigits(8));  // 21
        System.out.println(getMiddleTwoDigits(50)); // OK
        System.out.println(getMiddleTwoDigits(99)); // OK
    }
}
