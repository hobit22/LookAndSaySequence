package team.sakak.version;

/**
 * LookAndSayV7BitLong (V7)
 * - long[] 기반으로 2비트 숫자들을 압축 저장
 * - 한 long은 64비트 → 32개의 숫자 저장 가능
 */
public class LookAndSayV7BitLong {

    private static long[] termBuffer = new long[100_000_000];
    private static int bitLength = 2; // 첫 항 "1"

    public static String getMiddleTwoDigits(int n) {
        if (n < 3 || n >= 100) {
            throw new IllegalArgumentException("n은 3 이상 100 미만이어야 합니다.");
        }

        writeDigit(0, 1); // 첫 항은 "1"

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
        long[] newBuffer = new long[termBuffer.length];
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

    private static int writeGroup(long[] buf, int bitPos, int count, int digit) {
        for (char c : Integer.toString(count).toCharArray()) {
            bitPos = writeDigit(buf, bitPos, c - '0');
        }
        return writeDigit(buf, bitPos, digit);
    }

    private static int writeDigit(long[] buf, int bitPos, int digit) {
        int wordIndex = bitPos / 64;
        int bitOffset = bitPos % 64;
        digit &= 0b11;
        buf[wordIndex] |= ((long) digit) << (62 - bitOffset); // store left-aligned
        return bitPos + 2;
    }

    private static void writeDigit(int pos, int digit) {
        termBuffer[0] = ((long)(digit & 0b11)) << 62;
    }

    private static int readDigit(int index) {
        long bitPos = (long) index * 2;
        int wordIndex = (int) (bitPos / 64);
        int bitOffset = (int) (bitPos % 64);

        long word = termBuffer[wordIndex];
        int shift = 62 - bitOffset;

        if (shift >= 0) {
            return (int)((word >> shift) & 0b11);
        } else {
            // 2비트가 2개 워드에 걸쳐 있는 경우
            long nextWord = termBuffer[wordIndex + 1];
            long combined = (word << 64) | nextWord;
            return (int)((combined >> (-(shift))) & 0b11);
        }
    }

    public static void main(String[] args) {
//        System.out.println(getMiddleTwoDigits(5));   // 12
//        System.out.println(getMiddleTwoDigits(8));   // 21
        System.out.println(getMiddleTwoDigits(50));  // OK
//        System.out.println(getMiddleTwoDigits(99));  // OK
    }
}
