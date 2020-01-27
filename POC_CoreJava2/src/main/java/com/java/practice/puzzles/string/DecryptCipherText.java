package com.java.practice.puzzles.string;

import java.util.Scanner;

/*
The intelligence service intercepted some ciphertexts. It is known that plain text was encrypted using a cyclical shift
 method (Ceasar method). The idea of this method is that every letter in the plain text substituted with another letter
 with the fixed distance DIST. For example, for DIST=2 letter D will be replaced with F, Q with S and Z with B. It is
 known the enemy uses DIST= [0-25] and only English alphabet capital letters. Also, every message uses different DIST
 to make communication more secure.  After hard work cryptographers could uncover partial content of the messages, now
 we can tell one of the words included for every message.

Input data:
In the first line, there is ciphertext intercepted by security service, in the second line is the plaintext word from
the message. Both lines only contain English capitalized letters. Both lines are at most 40 letters length.

Output Data:
Print (the decrypted) text or "IMPOSSIBLE" if ciphertext cannot be decrypted. If more then 1 DIST can be used to
decrypt the ciphertext, print the text associated with the lowest DIST.

test:
1
Input:
HELLOAMERICA
AMERICA
Output:
HELLOAMERICA

2.
Input:
KHOORDPHULFD
HELLOAMERICA
Output:
HELLOAMERICA

2.5
Input:
KHOORDPHULFD
AMERICA
Output:
HELLOAMERICA

3.
Input:
KHOORDPHULFD
KHOORDPHULFC
Output:
IMPOSSIBLE

for every possible DIST
   decode the cipher
   check to see if the plaintext is there

do some math on the plain text
use the result to do some math on the cipher

for every char in the cipher
   do math to compute the dist if that is the first char in the plaintext
   check if the following chars in the cipher, using the computed dist, match the plaintext

*/

public class DecryptCipherText {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        String cipherText = sc.nextLine();
        cipherText = cipherText.toUpperCase();

        String plainText = sc.nextLine();
        plainText = plainText.toUpperCase();

        int dist = 0;
        boolean isDecryptPossible = true;
        int realDist = 0;

        for (int i = 0; i < cipherText.length() - plainText.length(); i++) {
            char ch1 = cipherText.charAt(i);
            dist = (ch1 - plainText.charAt(0) + 26) % 26;
            isDecryptPossible = true;

            for (int j = 0; j < plainText.length(); j++) {
                ch1 = cipherText.charAt(i + j);
                char ch2 = plainText.charAt(j);
                int newDist = (ch1 - ch2 + 26) % 26;

                if (dist != newDist) {
                    isDecryptPossible = false;
                }
            }
            if (isDecryptPossible) {
                realDist = dist;
            }

        }

        if (isDecryptPossible) {
            for (char ch : cipherText.toCharArray()) {
                char chout = (char) (ch - dist);
                System.out.print(chout);
            }
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}