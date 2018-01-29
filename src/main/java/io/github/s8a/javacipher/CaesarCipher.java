package io.github.s8a.javacipher;


/**
 * CaesarCipher
 * The Caesar cipher is a type of monoalphabetic substitution cipher 
 * in which each letter in the plaintext is replaced by a letter 
 * some fixed number of positions down the alphabet.
 */
public class CaesarCipher {

    /**
     * Encrypts text using the Caesar cipher with the given key.
     *
     * @params text Text to encrypt.
     * @params key Number of positions to shift down the alphabet.
     * @return Encrypted text.
     */
    public static String encrypt(String text, int key) {
        StringBuilder sb = new StringBuilder();
        key %= 26;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                int start = Character.isUpperCase(c) ? 'A' : 'a';
                int newChar = ((c + key - start) % 26) + start;
                sb.append((char) newChar);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    /**
     * Decrypts text ciphered with a given Caesar shift.
     *
     * @params text Text to decrypt.
     * @params key Number of positions to shift up the alphabet.
     * @return Decrypted text.
     */
    public static String decrypt(String text, int key) {
        return encrypt(text, -key);
    }
    
}