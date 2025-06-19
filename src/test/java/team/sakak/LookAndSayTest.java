package team.sakak;

import org.junit.jupiter.api.Test;
import team.sakak.version.LookAndSayV1;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LookAndSayTest {


    @Test
    void testGetNthTerm() {
        assertEquals("21", LookAndSayV1.getNthTerm(3));
        assertEquals("1211", LookAndSayV1.getNthTerm(4));
        assertEquals("111221", LookAndSayV1.getNthTerm(5));
        assertEquals("312211", LookAndSayV1.getNthTerm(6));
    }

    @Test
    void testGetMiddleTwoDigits() {
        assertEquals("12", LookAndSayV1.getMiddleTwoDigits(5));
        assertEquals("21", LookAndSayV1.getMiddleTwoDigits(8));
    }

    @Test
    void testLagreNumber() {
        assertEquals("21", LookAndSayV1.getMiddleTwoDigits(50));
    }


    @Test
    void testBiggestNumber() {
        assertEquals("21", LookAndSayV1.getMiddleTwoDigits(99));
    }


}
