package io.github.s8a.javacipher;


import java.util.Scanner;


/**
 * Command line interface for the JavaCipher program. If no 
 * arguments are given, the user is repeatedly prompted for a 
 * command to execute; otherwise, it runs the commands given as 
 * console arguments.
 */
public class JavaCipher {
    
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println(".:..:: JAVACIPHER ::..:.\n");
            System.out.println("Type command to execute.");
            System.out.println("Use 'help' to list commands. Or 'exit'.\n");
            while (true) {
                System.out.print(">> ");
                Scanner scan = new Scanner(System.in);
                String command = scan.nextLine();
                System.out.println();
                int limit = command.startsWith("atbash") ? 2 : 5;
                parseCommand(command.split(" ", limit));
            }
        } else {
            parseCommand(args);
            System.exit(0);
        }
    }

    private static void parseCommand(String[] cmd) {
        if (cmd[0].equals("atbash") && cmd.length == 2) {
            printAtbashCipher(cmd[1]);
        } else if (cmd.length == 4) {
            if (cmd[0].equals("caesar")) {
                printCaesarCipher(cmd[1], Integer.valueOf(cmd[2]), cmd[3]);
            } else if (cmd[0].equals("vigenere")) {
                printVigenereCipher(cmd[1], cmd[2], cmd[3]);
            }
        } else if (cmd[0].equals("exit")) {
            System.exit(0);
        } else {
            printHelp();
        }
    }

    private static void printHelp() {
        System.out.println("..:: COMMANDS ::..\n");
        System.out.println("Atbash Cipher:  >> atbash text\n");
        System.out.println("Caesar Cipher:  >> caesar mode key text");
        System.out.println("\tmode: encrypt/decrypt");
        System.out.println("\tkey: Number of positions to shift.\n");
        System.out.println("Vigenere Cipher:  >> vigenere mode keyword text");
        System.out.println("\tmode: encrypt/decrypt");
        System.out.println("\tkeyword: Encryption keyword.\n");
        System.out.println("Exit program:  >> exit\n");
    }

    private static void printAtbashCipher(String text) {
        System.out.println("..:: ATBASH CIPHER ::..");
        System.out.println("Original: " + text);
        System.out.println("Encrypted: " + AtbashCipher.encrypt(text));
        System.out.println();
    }

    private static void printCaesarCipher(String mode, int key, String text) {
        System.out.println("..:: CAESAR CIPHER ::..");
        System.out.println("Original: " + text);

        switch (mode) {
            case "encrypt":
                System.out.println("Encrypted with key " + key + ": " 
                        + CaesarCipher.encrypt(text, key));
                break;
            case "decrypt":
                System.out.println("Decrypted with key " + key + ": " 
                        + CaesarCipher.decrypt(text, key));
                break;
            default: System.out.println("ERROR: Incorrect mode.");
        }

        System.out.println();
    }

    private static void printVigenereCipher(String mode, String keyword, 
            String text) {
        System.out.println("..:: VIGENERE CIPHER ::..");
        System.out.println("Original: " + text);
        switch (mode) {
            case "encrypt":
                System.out.println("Encrypted with keyword '" + keyword 
                        + "': " + VigenereCipher.encrypt(text, keyword));
                break;
            case "decrypt":
                System.out.println("Decrypted with keyword '" + keyword 
                        + "': " + VigenereCipher.decrypt(text, keyword));
                break;
            default: System.out.println("ERROR: Incorrect mode.");
        }

        System.out.println();
    }
}