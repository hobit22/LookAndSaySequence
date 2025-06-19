package team.sakak.version;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class LookAndSayV7 {


    public static ByteArrayOutputStream nextTerm(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int prev = -1;
        int count = 0;

        int curr;
        while ((curr = in.read()) != -1) {
            if (curr == prev) {
                count++;
            } else {
                if (prev != -1) {
                    out.write(Integer.toString(count).getBytes()); // count
                    out.write(prev);                               // digit
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
        byte[] term = new byte[]{'1'};
        for (int i = 2; i <= n; i++) {
            System.out.println("i = " + i);
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
        System.out.println(getMiddleTwoDigits(50));  // OOM 없이 가능
        System.out.println(getMiddleTwoDigits(99));  // OK
    }
}
