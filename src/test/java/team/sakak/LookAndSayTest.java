package team.sakak;

import org.junit.jupiter.api.Test;
import team.sakak.version.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LookAndSayTest {


    @Test
    void testGetNthTerm() {
        assertEquals("21", LookAndSayV1String.getNthTerm(3));
        assertEquals("1211", LookAndSayV1String.getNthTerm(4));
        assertEquals("111221", LookAndSayV1String.getNthTerm(5));
        assertEquals("312211", LookAndSayV1String.getNthTerm(6));
    }

    @Test
    void testGetMiddleTwoDigits() {
        assertEquals("12", LookAndSayV1String.getMiddleTwoDigits(5));
        assertEquals("21", LookAndSayV1String.getMiddleTwoDigits(8));
    }

    @Test
    void testLagreNumber() {
        assertEquals("21", LookAndSayV1String.getMiddleTwoDigits(50));
    }


    @Test
    void testBiggestNumber() {
        assertEquals("21", LookAndSayV1String.getMiddleTwoDigits(99));
    }



    @Test
    void testV2GetMiddleTwoDigits() {
        assertEquals("12", LookAndSayV2Regex.getMiddleTwoDigits(5));
        assertEquals("21", LookAndSayV2Regex.getMiddleTwoDigits(8));
    }

    @Test
    void testV2LagreNumber() {
        assertEquals("21", LookAndSayV2Regex.getMiddleTwoDigits(50));
    }


    @Test
    void testV2BiggestNumber() {
        assertEquals("21", LookAndSayV2Regex.getMiddleTwoDigits(80));
    }



    @Test
    void testV3GetMiddleTwoDigits() throws IOException {
        assertEquals("12", LookAndSayV3Stream.getMiddleTwoDigits(5));
        assertEquals("21", LookAndSayV3Stream.getMiddleTwoDigits(8));
    }

    @Test
    void testV3LagreNumber() throws IOException {
        assertEquals("21", LookAndSayV3Stream.getMiddleTwoDigits(50));
    }


    @Test
    void testV3BiggestNumber() throws IOException {
        assertEquals("21", LookAndSayV3Stream.getMiddleTwoDigits(80));
    }


    @Test
    void testV4GetMiddleTwoDigits() {
        assertEquals("12", LookAndSayV4TwoPointer.getMiddleTwoDigits(5));
        assertEquals("21", LookAndSayV4TwoPointer.getMiddleTwoDigits(8));
    }

    @Test
    void testV4LagreNumber() {
        assertEquals("21", LookAndSayV4TwoPointer.getMiddleTwoDigits(50));
    }


    @Test
    void testV4BiggestNumber() {
        assertEquals("21", LookAndSayV4TwoPointer.getMiddleTwoDigits(80));
    }

    @Test
    void testV5GetMiddleTwoDigits() {
        assertEquals("12", LookAndSayV5Queue.getMiddleTwoDigits(5));
        assertEquals("21", LookAndSayV5Queue.getMiddleTwoDigits(8));
    }

    @Test
    void testV5LagreNumber() {
        assertEquals("21", LookAndSayV5Queue.getMiddleTwoDigits(50));
    }


    @Test
    void testV5BiggestNumber() {
        assertEquals("21", LookAndSayV5Queue.getMiddleTwoDigits(80));
    }

    @Test
    void testV6GetMiddleTwoDigits() {
        assertEquals("12", LookAndSayV6Bit.getMiddleTwoDigits(5));
        assertEquals("21", LookAndSayV6Bit.getMiddleTwoDigits(8));
    }

    @Test
    void testV6LagreNumber() {
        assertEquals("21", LookAndSayV6Bit.getMiddleTwoDigits(50));
    }


    @Test
    void testV6BiggestNumber() {
        assertEquals("21", LookAndSayV6Bit.getMiddleTwoDigits(80));
    }
    @Test
    void testV7GetMiddleTwoDigits() {
        assertEquals("12", LookAndSayV7BitLong.getMiddleTwoDigits(5));
        assertEquals("21", LookAndSayV7BitLong.getMiddleTwoDigits(8));
    }

    @Test
    void testV7LagreNumber() {


        long max = Runtime.getRuntime().maxMemory();
        long total = Runtime.getRuntime().totalMemory();
        long free = Runtime.getRuntime().freeMemory();

        System.out.println("Max memory:   " + (max / (1024 * 1024)) + " MB");
        System.out.println("Total memory: " + (total / (1024 * 1024)) + " MB");
        System.out.println("Free memory:  " + (free / (1024 * 1024)) + " MB");

        assertEquals("21", LookAndSayV7BitLong.getMiddleTwoDigits(50));
    }


    @Test
    void testV7BiggestNumber() {
        assertEquals("21", LookAndSayV7BitLong.getMiddleTwoDigits(80));
    }

}
