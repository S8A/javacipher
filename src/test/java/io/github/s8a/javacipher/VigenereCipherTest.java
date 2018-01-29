package io.github.s8a.javacipher;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for VigenereCipher.
 */
public class VigenereCipherTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public VigenereCipherTest(String testName) {
        super(testName);
    }


    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(VigenereCipherTest.class);
    }

    /**
     * Test Vigenere cipher implementation.
     */
    public void testApp() {
        String attack = "ATTACKATDAWN1234/(";
        String lemon = "LEMON";
        String smallLemon = "lemon";
        String crazyLemon = "LeMOn";
        String lemonAttack = "LXFOPVEFRNHR1234/(";
        assertEquals(VigenereCipher.encrypt(attack, lemon), lemonAttack);
        assertEquals(VigenereCipher.encrypt(attack, smallLemon), lemonAttack);
        assertEquals(VigenereCipher.encrypt(attack, crazyLemon), lemonAttack);
        assertEquals(VigenereCipher.decrypt(lemonAttack, lemon), attack);
        assertEquals(VigenereCipher.decrypt(lemonAttack, smallLemon), attack);
        assertEquals(VigenereCipher.decrypt(lemonAttack, crazyLemon), attack);
    }
}
