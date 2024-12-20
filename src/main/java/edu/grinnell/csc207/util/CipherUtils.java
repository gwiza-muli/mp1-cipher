package edu.grinnell.csc207.util;

/**
 * An implementation of different Ciphers from course CSC207-01.
 *
 * @author Sheilla Muligande
 *
 */
public class CipherUtils {

  /** The default offset that I use when enciphering/deciphering. */
  private static final int LOWERCASE_CHAR_OFFSET = 26;


  /**
   * Converts a letter to an integer.
   *
   * @param letter the letter to convert to integer.
   * @return the integer equivalent of the letter.
   */
  private static int letter2int(char letter) {
    int base = (int) 'a';
    int number = (int) letter - base;
    return number;
  } // letter2int

  /**
   * Converts an integer to a letter.
   *
   * @param i the integer to be converted to char.
   * @return the character equivalent of the integer.
   */
  private static char int2letter(int i) {
    int base = (int) 'a';
    char character = (char) (i + base);
    return character;
  } // int2letter

  /**
   * Checks if a string is made of only alphanumeric characters.
   *
   * @param str the string that is checked.
   * @return the boolean true if it is or false if it is not alphaNumeric.
   */
  public static boolean alphaNumericChecker(String str) {
    char[] encryptedWord = str.toCharArray();
    for (int i = 0; i < str.length(); i++) {
      if (!((encryptedWord[i] >= 'a') && (encryptedWord[i] <= 'z'))) {
        return false;
      } // if
    } // for
    return true;

  } // alphaNumericChecker

  /**
   * encrypts a string using the caesar cipher and the char letter as the key.
   *
   * @param str the string that is to be encrypted.
   * @param letter the letter that will serve as the key.
   * @return the encrypted string.
   */
  public static String caesarEncrypt(String str, char letter) { // which uses the Caeser Cipher to
                                                                // encrypt a string consisting of
                                                                // only lowercase letters, using the
                                                                // given letter as the “key”.
    char[] encryptedWord = str.toCharArray();
    int len = str.length();
    for (int i = 0; i < len; i++) {
      encryptedWord[i] = int2letter(
          ((letter2int(encryptedWord[i])) + (letter2int(letter))) % LOWERCASE_CHAR_OFFSET);
    } // for

    String encryptedString = new String(encryptedWord);
    return encryptedString;
  } // caesarEncrypt

  /**
   * decrypts a string using the caesar cipher and the char letter as the key.
   *
   * @param str the string that is to be decrypted.
   * @param letter the letter that will serve as the key.
   * @return the decrypted string.
   */
  public static String caesarDecrypt(String str, char letter) { // uses the Caeser Cipher to
                                                                // decrypt a string consisting of
                                                                // only lowercase letters, using the
                                                                // given letter as the “key”.
    char[] encryptedWord = str.toCharArray();
    int len = str.length();
    for (int i = 0; i < len; i++) {
      encryptedWord[i] =
          int2letter(((letter2int(encryptedWord[i])) - (letter2int(letter)) + LOWERCASE_CHAR_OFFSET)
              % LOWERCASE_CHAR_OFFSET);
    } // for

    // String decryptedString = String.valueOf(encryptedWord);
    String decryptedString = new String(encryptedWord);
    return decryptedString;
  } // caesarDecrypt

  /**
   * encrypts a string using the vigenere cipher and the char letter as the key.
   *
   * @param str the string that is to be encrypted.
   * @param key the string that will serve as the key.
   * @return the encrypted string.
   */
  public static String vigenereEncrypt(String str, String key) {

    int strLength = str.length();
    int keyLength = key.length();
    char[] oldKeyArray = key.toCharArray();
    char[] stringArray = str.toCharArray();
    char[] keyArray = new char[strLength];
    char[] cipheredArray = new char[str.length()];

    for (int i = 0, j = 0; i < strLength; i++, j++) {
      if (j >= keyLength) {
        j = 0;
      } // if
      keyArray[i] = oldKeyArray[j];
    } // for

    for (int x = 0; x < strLength; x++) {
      cipheredArray[x] = int2letter(
          (letter2int(keyArray[x]) + (letter2int(stringArray[x]))) % LOWERCASE_CHAR_OFFSET);
    } // for

    String cipheredString = new String(cipheredArray);
    return cipheredString;

  } // vigenereEncrypt

  /**
   * decrypts a string using the vigenere cipher and the char letter as the key.
   *
   * @param str the string that is to be decrypted.
   * @param key the string that will serve as the key.
   * @return the decrypted string.
   */
  public static String vigenereDecrypt(String str, String key) {
    int strLength = str.length();
    int keyLength = key.length();
    char[] oldKeyArray = key.toCharArray();
    char[] stringArray = str.toCharArray();
    char[] keyArray = new char[strLength];
    char[] decipheredArray = new char[str.length()];

    for (int i = 0, j = 0; i < strLength; i++, j++) {
      if (j >= keyLength) {
        j = 0;
      } // if
      keyArray[i] = oldKeyArray[j];
    } // for

    for (int x = 0; x < strLength; x++) {
      decipheredArray[x] = int2letter(
          ((letter2int(stringArray[x]) - letter2int(keyArray[x])) + LOWERCASE_CHAR_OFFSET)
              % LOWERCASE_CHAR_OFFSET);
    } // for

    String decipheredString = new String(decipheredArray);
    return decipheredString;
  } // vigenereDecrypt

  /**
   * decrypts a string using the vigenere cipher and the char letter as the key.
   *
   * @param str the string that is to be decrypted.
   * @return boolean true if it string is all lowercase letters and false if it isn't.
   */
  public static boolean caseChecker(String str) {
    int stringLength = str.length();
    char[] stringArray = str.toCharArray();
    for (int i = 0; i < stringLength; i++) {
      if (!(stringArray[i] >= 'a' && stringArray[i] <= 'z')) {
        return false;
      } // if
    } // for
    return true;
  } // caseChecker

  /**
   * decrypts a string using the vigenere cipher and the char letter as the key.
   *
   * @param str the string whose dash is to be removed.
   * @return the string with the dash at front removed.
   */
  public static String dashRemover(String str) {
    String newStr = str.substring(1);
    return newStr;
  } // dashRemover

} // CipherUtils
