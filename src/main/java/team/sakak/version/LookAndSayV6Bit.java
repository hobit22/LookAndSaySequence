package team.sakak.version;

/**
 * LookAndSayV7BitPacked (V7)
 * - 1, 2, 3만 등장하는 개미수열의 특성을 이용해 2비트만으로 수를 저장
 * - 메모리 사용량을 최소화함 (최대 4개 숫자 = 1바이트)
 * java에서 배열의 크기가 int로 제한되어 있어 n이 클경우 overflow 일어남.
 */
public class LookAndSayV6Bit {

    private static byte[] termBuffer = new byte[Integer.MAX_VALUE];
    private static int bitLength = 2;  // 첫 항: '1'

    public static String getMiddleTwoDigits(int n) {
        if (n < 3 || n >= 100) {
            throw new IllegalArgumentException("n은 3 이상 100 미만이어야 합니다.");
        }

        writeDigit(0, 1); // 첫 항은 '1' → 01

        for (int i = 2; i <= n; i++) {
            nextTerm();
        }

        int digitCount = bitLength / 2;
        int mid = (digitCount - 2) / 2;
        int first = readDigit(mid);
        int second = readDigit(mid + 1);
        return "" + first + second;
    }

    private static void nextTerm() {
        byte[] newBuffer = new byte[termBuffer.length];
        int newBitLength = 0;

        int i = 0;
        int prev = readDigit(i);
        int count = 1;
        int totalDigits = bitLength / 2;

        for (i = 1; i < totalDigits; i++) {
            int curr = readDigit(i);
            if (curr == prev) {
                count++;
            } else {
                newBitLength = writeGroup(newBuffer, newBitLength, count, prev);
                prev = curr;
                count = 1;
            }
        }
        newBitLength = writeGroup(newBuffer, newBitLength, count, prev);

        termBuffer = newBuffer;
        bitLength = newBitLength;
    }

    private static int writeGroup(byte[] buf, int bitPos, int count, int digit) {
        for (char c : Integer.toString(count).toCharArray()) {
            bitPos = writeDigit(buf, bitPos, c - '0');
        }
        return writeDigit(buf, bitPos, digit);
    }

    private static int writeDigit(byte[] buf, int bitPos, int digit) {
        int byteIndex = bitPos / 8;
        int bitOffset = bitPos % 8;
        digit &= 0b11;

        buf[byteIndex] |= digit << (6 - bitOffset);
        return bitPos + 2;
    }

    private static void writeDigit(int pos, int digit) {
        termBuffer[0] = (byte) ((digit & 0b11) << 6);
    }

    private static int readDigit(int index) {
        int bitPos = index * 2;
        int byteIndex = bitPos / 8;
        int bitOffset = bitPos % 8;
        return (termBuffer[byteIndex] >> (6 - bitOffset)) & 0b11;
    }

    public static void main(String[] args) {
//        System.out.println(getMiddleTwoDigits(5));   // 12
//        System.out.println(getMiddleTwoDigits(8));   // 21
//        System.out.println(getMiddleTwoDigits(50));  // OK
        System.out.println(getMiddleTwoDigits(80));  // OK
    }
}
