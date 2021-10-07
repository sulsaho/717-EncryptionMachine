import java.util.Scanner;

/**
  * @author Sulayman Saho
  */

/**
 * Encryption Machine class
 */
public class EncryptionMachine
    {
        private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        private static final short SHIFT = 3;

        private static final String welcomeMessage = "Welcome to the CSCI717 Encryption Machine Construction\n"
        		+ "The program lets you encrypt a message\n"
        		+ "with a key for your recipient to decrypt!";

        private static final String finalMessage = "Message fully encrypted. Happy secret messaging!";

        /**
         * Default constructor
         */
        public EncryptionMachine()
        {
            System.out.println(welcomeMessage);
        }

        /**
         * Asks for and encrypts the KEY
         */
        private void EncryptKey()
        {
            Scanner scanKey = new Scanner(System.in);
            System.out.println("Enter Key:");
            String KEY = scanKey.nextLine();
            String encryptedKey = EncryptWord(KEY);
            System.out.println("\"" + KEY + "\"" + " has been encrypted to: " + encryptedKey);
        }

        /**
         * Encrypts one character
         * @param c - character to be encrypted
         * @return - returns encrypted character
         */
        private char EncryptChar(char c)
        {
            if (ALPHABET.indexOf(c) == -1)
                System.exit(1);
            int newIndex = ALPHABET.indexOf(c) + SHIFT;
            if (newIndex > 25)
                newIndex = newIndex % 26;
            return ALPHABET.charAt(newIndex);
        }

        /**
         * Encrypts a word by encrypting each character
         * @param word - string to be encrypted
         * @return - returns encrypted word
         */
        private String EncryptWord (String word)
        {
            StringBuilder encryptedWord = new StringBuilder();
            for (int i = 0; i < word.length(); i++)
            {
                encryptedWord.append(EncryptChar(word.charAt(i)));
            }
            return encryptedWord.toString();
        }

        /**
         * Asks a user for number of words and encrypts the message word by word
         */
        private void EncryptMessages()
        {
            Scanner scan = new Scanner(System.in);
            System.out.println("\nHow many words is your message?:");
            int numOfWords = Integer.parseInt(scan.nextLine());

            for (int i = 0; i < numOfWords; i++)
            {
                Scanner scanWord = new Scanner(System.in);
                System.out.println("Next word:");
                String word = scanWord.nextLine();
                String encryptedWord = EncryptWord(word);
                System.out.println("\"" + word + "\" " + "has been encrypted to: " + encryptedWord +
                        "\n");
            }
            System.out.println(finalMessage);
        }

        public static void main(String[] args)
        {
            EncryptionMachine encryptionMachine = new EncryptionMachine();
            encryptionMachine.EncryptKey();
            encryptionMachine.EncryptMessages();
        }
    }
