package io.github.s8a.javacipher;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for AtbashCipher.
 */
public class AtbashCipherTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AtbashCipherTest(String testName) {
        super(testName);
    }


    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AtbashCipherTest.class);
    }

    /**
     * Test Atbash cipher implementation.
     */
    public void testApp() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890,.-/*()=?";
        String omegachi = "ZYXWVUTSRQPONMLKJIHGFEDCBA1234567890,.-/*()=?";
        String lowerAlphabet = alphabet.toLowerCase();
        String lowerOmegachi = omegachi.toLowerCase();
        assertEquals(omegachi, AtbashCipher.encrypt(alphabet));
        assertEquals(alphabet, AtbashCipher.decrypt(omegachi));
        assertEquals(lowerOmegachi, AtbashCipher.encrypt(lowerAlphabet));
        assertEquals(lowerAlphabet, AtbashCipher.decrypt(lowerOmegachi));
    }
}
