package team.sakak;

import org.junit.jupiter.api.Test;
import team.sakak.version.LookAndSayV1String;
import team.sakak.version.LookAndSayV2Regex;

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


}
