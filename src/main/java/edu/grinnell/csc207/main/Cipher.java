package edu.grinnell.csc207.main;

import edu.grinnell.csc207.util.CipherUtils;

/**
 * An implementation of the Caesar and Vigenere Ciphers.
 *
 * @author Sheilla Muligande
 */
public class Cipher {

  /** The default/required number of arguments, 4. */
  private static final int EXPECTED_NUM_PARAMS = 4;

  /**
   * implements a Caesar or vigenere cipher.
   *
   * @param args the different parts of the cipher, which are the word to be en/deciphered, the
   *        action(encipher or decipher), the key which we will use to en/decipher, and the type of
   *        cipher (caesar or vigenere).
   */
  public static void main(String[] args) {
    // PrintWriter pen = new PrintWriter(System.out, true);
    String action = "";
    String key = "";
    String cipher = "";
    String word = "";
    if (args.length != EXPECTED_NUM_PARAMS) {
      System.err.println(
          "Error: Invalid number of parameters. Expected 4 parameters, received " + args.length);
      return;
    } else {
      for (int i = 0; i < args.length; i++) {
        String currArg = args[i];
        if (currArg.length() != 0 && currArg.charAt(0) == '-') {
          if ((currArg.equals("-encode")) || currArg.equals("-decode")) {
            if (action.isEmpty()) {
              action = CipherUtils.dashRemover(currArg);
            } else {
              System.err.println("Error: You can't give more than one action.");
              return;
            } // if
          } else if ((currArg.equals("-caesar")) || currArg.equals("-vigenere")) {
            if (cipher.isEmpty()) {
              cipher = CipherUtils.dashRemover(currArg);
            } else {
              System.err.println("Error: You can't give more than one cipher type.");
              return;
            } // else
          } // if
        } else {
          if (word.isEmpty()) {
            word = currArg;
          } else if (key.isEmpty()) {
            key = currArg;
          } else {
            System.err.println("Error: Empty keys are not permitted");
            return;
          } // if
        } // else
      } // for

      if (action.isEmpty() | cipher.isEmpty() || word.isEmpty() || key.isEmpty()) {
        System.err.println("missing arguments");
        return;
      } //if
      if (cipher.equals("caesar") && ((key.length() == 1))) {
        if (action.equals("encode")) {
          System.out.print(CipherUtils.caesarEncrypt(word, key.charAt(0)));
          System.out.print("\n");
          System.out.flush();
        } else if (action.equals("decode")) {
          System.out.print(CipherUtils.caesarDecrypt(word, key.charAt(0)));
          System.out.print("\n");
          System.out.flush();
        } else {
          System.err
              .println("No valid action specified." + "Legal values are '-encode' and '-decode'");
        } // else
      } else if (cipher.equals("caesar") && (key.length() != 1)) {
        System.err.println("Error: Your key must be 1 character long for Caesar Ciphers.");
        return;
      } // if
      if (cipher.equals("vigenere")) {
        if (action.equals("encode")) {
          System.out.print(CipherUtils.vigenereEncrypt(word, key));
          System.out.print("\n");
          System.out.flush();
        } else if (action.equals("decode")) {
          System.out.print(CipherUtils.vigenereDecrypt(word, key));
          System.out.print("\n");
          System.out.flush();
        } else {
          System.err
              .println("No valid action specified." + "Legal values are '-encode' and '-decode'");
          return;
        } // if
      } // if

    } // else

    // pen.close();
  } // main
} // Cipher
