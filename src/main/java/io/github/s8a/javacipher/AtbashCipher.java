package io.github.s8a.javacipher;


/**
 * AtbashCipher
 * The Atbash cipher is a type of monoalphabetic cipher formed by 
 * taking the alphabet and mapping it to its reverse, so that the 
 * first letter becomes the last letter, the second letter becomes 
 * the second to last letter, and so on.
 */
public class AtbashCipher {

    /**
     * Encrypts text using the Atbash cipher.
     *
     * @params text Text to encrypt.
     * @return Encrypted text.
     */
    public static String encrypt(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                int start = Character.isUpperCase(c) ? 'A' : 'a';
                int newChar = ((c - start + 26) % 26) + start;
                sb.append((char) newChar);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    
    /**
     * Decrypts text ciphered with Atbash. Same as encrypting again.
     *
     * @params text Text to decrypt.
     * @return Decrypted text.
     */
    public static String decrypt(String text) {
        return encrypt(text);
    }
    
}