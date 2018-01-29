package io.github.s8a.javacipher;


public class JavaCipher {
    
    private static void printUsage() {
        System.out.println("Usage: java JavaCipher cipher mode key text");
        System.out.println("\tcipher: atbash, caesar, vigenere");
        System.out.println("\tmode: encrypt, decrypt");
        System.out.println("\tkey: Integer (caesar) or string (vigenere)");
        System.out.println("\ttext: Text to encrypt or decrypt");       
    }

    public static void main(String[] args) {
        if (args[0].equals("atbash") && args.length == 2) {
            System.out.println("..:: ATBASH CIPHER ::..");
            System.out.println("Original: " + args[1]);
            System.out.println("Encrypted: " + AtbashCipher.encrypt(args[1]));
        } else if (args.length == 4) {
            if (args[0].equals("caesar")) {
                System.out.println("..:: CAESAR CIPHER ::..");
                System.out.println("Original: " + args[3]);
                int key = Integer.valueOf(args[2]);
                if (args[1].equals("encrypt")) {
                    System.out.println("Encrypted with key " + key + ": " 
                            + CaesarCipher.encrypt(args[3], key));
                } else if (args[1].equals("decrypt")) {
                    System.out.println("Decrypted with key " + key + ": " 
                            + CaesarCipher.decrypt(args[3], key));
                }
            } else if (args[0].equals("vigenere")) {
                System.out.println("..:: VIGENERE CIPHER ::..");
                System.out.println("Original: " + args[3]);
                if (args[1].equals("encrypt")) {
                    System.out.println("Encrypted with keyword '" + args[2] + 
                            "': " + VigenereCipher.encrypt(args[3], args[2]));
                } else if (args[1].equals("decrypt")) {
                    System.out.println("Decrypted with keyword '" + args[2] + 
                            "': " + VigenereCipher.decrypt(args[3], args[2]));
                }
            }
        } else {
            printUsage();
            System.exit(1);
        }
    }
}