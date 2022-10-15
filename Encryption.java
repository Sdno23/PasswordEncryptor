/*
 * @author 3156908
 *
 * @version 1.0 06/21/2020
 *
 * Title: Password Encryption and Decription
 *
 * Semester: Summer 2020
 *
 * Lecturer's Name: C. Charters
 */
package main;

/**
 *
 * @author 3159608
 */
public class Encryption {

    private String origWord;
    private String encryptWord;

    public Encryption(String word, boolean encrypt) {
        if (encrypt) {
            this.origWord = word;
            this.encryptWord = "";
        } else {
            this.encryptWord = word;
            this.origWord = "";
        }
    }

    public String getOrigWord() {
        return origWord;
    }

    public void setOrigWord(String origWord) {
        this.origWord = origWord;
    }

    public String getEncryptedWord() {
        return encryptWord;
    }

    public void setEncryptedWord(String encryptWord) {
        this.encryptWord = encryptWord;
    }

    public String toString() {
        return "Original Word: " + origWord + "\nEncrypted Word:" + encryptWord;
    }

    public void encryptOrig() {
        char letter;
        char newLetter;
        int newLetterNum;

        origWord = origWord.toLowerCase();

        for (int i = 0; i < origWord.length(); i++) {

            letter = origWord.charAt(i);

            switch (letter) {
                case 'x':
                    newLetter = 'a';
                    break;
                case 'y':
                    newLetter = 'b';
                    break;
                case 'z':
                    newLetter = 'c';
                    break;
                default:
                    newLetterNum = ((int) letter) + 3;
                    newLetter = (char) newLetterNum;
                    break;
            }

            encryptWord += newLetter;
        }
    }

    public void decryptEncrypt() {
        char newLetter;
        char encryptChar;
        int i;
        int newLetterNum;

        for (i = 0; i < encryptWord.length(); i++) {

            encryptChar = encryptWord.charAt(i);

            switch (encryptChar) {
                case 'a':
                    newLetter = 'x';
                    break;
                case 'b':
                    newLetter = 'y';
                    break;
                case 'c':
                    newLetter = 'z';
                    break;
                default:
                    newLetterNum = ((int) encryptChar) - 3;
                    newLetter = (char) newLetterNum;
                    origWord += newLetter;
                    break;
            }

        }

    }
}
