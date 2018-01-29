package io.github.s8a.javacipher;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for CaesarCipher.
 */
public class CaesarCipherTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CaesarCipherTest(String testName) {
        super(testName);
    }


    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(CaesarCipherTest.class);
    }

    /**
     * Test Caesar cipher implementation.
     */
    public void testApp() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890,.-/*()=?";
        String rot13 = "NOPQRSTUVWXYZABCDEFGHIJKLM1234567890,.-/*()=?";
        String shift11 = "KLMNOPQRSTUVWXYZABCDEFGHIJ1234567890,.-/*()=?";
        String shift22 = "VWXYZABCDEFGHIJKLMNOPQRSTU1234567890,.-/*()=?";
        assertEquals(CaesarCipher.encrypt(alphabet, 0), alphabet);
        assertEquals(CaesarCipher.encrypt(alphabet, 13), rot13);
        assertEquals(CaesarCipher.encrypt(alphabet, 11), shift11);
        assertEquals(CaesarCipher.encrypt(alphabet, 22), shift22);
        assertEquals(CaesarCipher.decrypt(rot13, 13), alphabet);
        assertEquals(CaesarCipher.decrypt(rot13, 0), rot13);
        assertEquals(CaesarCipher.decrypt(shift11, 11), alphabet);
        assertEquals(CaesarCipher.decrypt(shift22, 22), alphabet);
    }
}
