package io.github.s8a.javacipher;


/**
 * The Vigenere cipher is type of polyalphabetic substitution cipher 
 * that encrypts plaintext using a series of interwoven Caesar 
 * ciphers based on the letters of a keyword.
 */
public class VigenereCipher {

    private enum CipherMode {ENCRYPT, DECRYPT}

    /**
     * Encrypts text using the Vigenere cipher with a given keyword.
     *
     * @param text Text to encrypt.
     * @param keyword Keyword used to encrypt the text.
     * @return Decrypted text.
     */
    public static String encrypt(String text, String keyword) {
        return cipher(text, keyword, CipherMode.ENCRYPT);
    }

    /**
     * Decrypts text using the Vigenere cipher with a given keyword.
     *
     * @param text Text to encrypt.
     * @param keyword Keyword used to encrypt the text.
     * @return Decrypted text.
     */
    public static String decrypt(String text, String keyword) {
        return cipher(text, keyword, CipherMode.DECRYPT);
    }

    /**
     * Applies the Vigenere cipher algorithm to encrypt or decrypt.
     */
    private static String cipher(String text, String keyword, CipherMode m) {
        StringBuilder sb = new StringBuilder();
        int count = 0; // Index of current keyword character
        for (char c : text.toCharArray()) {
            char currentKey = keyword.toLowerCase().charAt(
                    count++ % keyword.length()); // Handle wrap around keyword
            if (Character.isLetter(c)) {
                int shift = (int) currentKey - 'a'; // Current key ordinal
                char shifted = m.equals(CipherMode.ENCRYPT)
                               ? CaesarCipher.shift(c, shift)
                               : CaesarCipher.shift(c, -shift);
                sb.append(shifted);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}