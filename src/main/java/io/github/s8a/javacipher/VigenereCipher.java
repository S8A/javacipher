package io.github.s8a.javacipher;


/**
 * VigenereCipher
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
        return algorithm(text, keyword, CipherMode.ENCRYPT);
    }

    /**
     * Decrypts text using the Vigenere cipher with a given keyword.
     *
     * @param text Text to encrypt.
     * @param keyword Keyword used to encrypt the text.
     * @return Decrypted text.
     */
    public static String decrypt(String text, String keyword) {
        return algorithm(text, keyword, CipherMode.DECRYPT);
    }

    /** Algorithm behind the encrypt and decrypt methods. */
    private static String algorithm(String text, String keyword, CipherMode m) {
        StringBuilder sb = new StringBuilder();
        int count = 0; // Index of current keyword character
        for (char c : text.toCharArray()) {
            char currentKey = keyword.toLowerCase()
                                     .charAt(count++ % keyword.length());
            if (Character.isLetter(c)) {
                String charStr = Character.toString(c);
                int shift = (int) currentKey - 'a'; // Current key position
                String newChar = m.equals(CipherMode.ENCRYPT)
                                 ? CaesarCipher.encrypt(charStr, shift)
                                 : CaesarCipher.decrypt(charStr, shift);
                sb.append(newChar);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}