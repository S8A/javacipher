package io.github.s8a.javacipher;


/**
 * The Caesar cipher is a type of monoalphabetic substitution cipher 
 * in which each letter in the plaintext is replaced by a letter 
 * some fixed number of positions down the alphabet.
 */
public class CaesarCipher {

    private static final int ALPHABET_LENGTH = 26;

    /**
     * Encrypts text using the Caesar cipher with the given key.
     * Non-letter characters are ignored.
     *
     * @param text Text to encrypt.
     * @param key Number of positions to shift down the alphabet.
     * @return Encrypted text.
     */
    public static String encrypt(String text, int key) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(shift(c, key));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Decrypts text ciphered with a given Caesar shift.
     * Non-letter characters are ignored.
     *
     * @param text Text to decrypt.
     * @param key Number of positions to shift up the alphabet.
     * @return Decrypted text.
     */
    public static String decrypt(String text, int key) {
        return encrypt(text, -key);
    }

    /**
     * Shifts a character a fixed number of places down the alphabet.
     */
    static char shift(char c, int key) {
        // Handle key values >=ALPHABET_LENGTH 
        key %= ALPHABET_LENGTH;
        char start = Character.isUpperCase(c) ? 'A' : 'a';
        // Shift down to 0-25 for a-z
        char shifted = (char) (c - start);
        // Handle wrap-around for negative values:
        shifted = (char) ((shifted + key + ALPHABET_LENGTH) % ALPHABET_LENGTH);
        return (char) (shifted + start);
    }

}