/*
 * @author XXXXX08
 *
 * @version 1.0 06/21/2020
 *
 * Title: Password Encryption and Decription
 *
 * Semester: Summer 2020
 *
 * Lecturer's Name: C. Charters
 */
package passwordencryptor;

import java.util.Scanner;

/**
 *
 * @author XXXXX08
 */
public class Tester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
     /* in the main method, the do-while loop will allow the moption menu to run\
      * over and over until the user stops it with option 3. 
      */

        int menuOption = 0;

        do {
            menuOption = displayMenu();

            switch (menuOption) {
                case 1:
                    encryptPassword();
                    break;
                case 2:
                    decryptPassword();
                    break;
                case 3:
                    selfDestruct();
                    break;
            }
        } while (menuOption != 3);

    }

    public static int displayMenu() {
        Scanner scan = new Scanner(System.in);
        int userTypes;

       /* When called, displatMenu() method allows the user to see the options
        * available before a selection begins to run. Menu will continue to loop
        * until user selects option 3.
        */
        
        System.out.println("1. Encrypt a Password?"); // Option 1: Asks user if they would like to encrypt a password.

        System.out.println("2. Decrypt a Password?"); // Option 2: Asks user if they would like to decrypt a password.

        System.out.println("3. Stop Spying..."); // Option 3: Asks user if they are done using the program.

        userTypes = scan.nextInt(); //User input is stored inside the userTypes variable.

        if (userTypes < 1 || userTypes > 3) { //Gives user to give an input if their chosen option was either 1 or 2.

            System.out.println("Enter Valid Value"); //Asks user to enter a value. 

            userTypes = scan.nextInt();
        }

        return userTypes; //user input is outputed to the user. 
    }

    public static void encryptPassword() {
        Scanner key = new Scanner(System.in);
        String chosenWord;
        String goodGuess;
      
      /* When called, the encryptPassword() method will allow the user to input a
       * selected word and encrypt it.
       */
        
        System.out.println("Type a word you would like to encrypt."); //Asks user to type in a chosen word to encrypt.
        chosenWord = key.nextLine();

        Encryption yes = new Encryption(chosenWord, true); // Encrypts the user's chosen word.
        yes.encryptOrig();

        System.out.println("Guess the encrypted word!"); //Asks user to make a guess on the encryted word.

        goodGuess = key.nextLine(); //The user's input is stored inside the vairable goodGuess.

        if (goodGuess.equalsIgnoreCase(yes.getEncryptedWord())) {

            System.out.println("Successfully encrypted… mission accomplished!"); //Output if user successfully guesses encryted word.
        } else {
            System.out.println("Unsuccessfully encrypted... Danger, danger!"); //Output if user unsuccessfully guesses encrypted word.
        }

        System.out.println(yes.toString() + "\n"); //Outputs the encrypted password to the user.

    }

    public static void decryptPassword() {
        Scanner typing = new Scanner(System.in);
        String chosenWord = "";
        String goodGuess;

      /* When called, the decryptPassword() method will allow the user to input a
       * selected word and decrypt it.
       */
        
        System.out.println("What word do you wish to decrypt?"); //Asks user what word they wish to decrypt.
        chosenWord = typing.nextLine();

        Encryption yes = new Encryption(chosenWord, false); //Decrypts the user's chosen word.
        yes.decryptEncrypt();

        System.out.println("Guess the decrypted word!"); //Asks the user to guess the dycrypted word.

        goodGuess = typing.nextLine(); //The user's input is stored inside the goodGuess variable.

        if (goodGuess.equalsIgnoreCase(yes.getOrigWord())) {

            System.out.println("Successfully decrypted…mission accomplished!"); //Output if user successfully guesses decryted word.
        } else {
            System.out.println("Unsuccessfully decrypted...Danger, danger!");   //Output if user unsuccessfully guesses decrypted word.
        }

        System.out.println(yes.toString() + "\n"); //Outputs the decrypted password to the user.

    }

    public static void selfDestruct() {
        
       /* When called, the selfDestruct() method will shut down the program and
        * end the process.
        */

        System.out.println("This program will self-destruct in 5 seconds!"); //Output when the user selcets option 3 from the looping menu.
        System.out.println("5 - 4 - 3 - 2 - 1 - 0 BOOM!"); //Second output after user selects option 3. NOTE: PROGRAM WILL NOT LITERALLY SELF-DESTRUCT. :P

    }

}
