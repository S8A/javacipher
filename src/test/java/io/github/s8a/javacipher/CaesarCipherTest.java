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
        String shift11 = "LMNOPQRSTUVWXYZABCDEFGHIJK1234567890,.-/*()=?";
        String shift22 = "WXYZABCDEFGHIJKLMNOPQRSTUV1234567890,.-/*()=?";
        assertEquals(alphabet, CaesarCipher.encrypt(alphabet, 0));
        assertEquals(rot13, CaesarCipher.encrypt(alphabet, 13));
        assertEquals(shift11, CaesarCipher.encrypt(alphabet, 11));
        assertEquals(shift22, CaesarCipher.encrypt(alphabet, 22));
        assertEquals(alphabet, CaesarCipher.decrypt(rot13, 13));
        assertEquals(rot13, CaesarCipher.decrypt(rot13, 0));
        assertEquals(alphabet, CaesarCipher.decrypt(shift11, 11));
        assertEquals(alphabet, CaesarCipher.decrypt(shift22, 22));
    }
}
