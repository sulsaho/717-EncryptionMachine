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
         * Scans input from a user
         * @param scanMessage - message prompt instruction
         * @return - returns scanned string
         */
        private String ScanInput(String scanMessage)
        {
        	@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
        	System.out.println(scanMessage);
        	return scan.nextLine();
        }

        /**
         * Asks for and encrypts the KEY
         */
        private void EncryptKey()
        {
            String KEY = ScanInput("Enter Key:");
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
            {
            	System.out.println("Not a valid character");
                System.exit(1);
            }
            int newIndex = (ALPHABET.indexOf(c) + SHIFT) % 26;
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
            int numOfWords = Integer.parseInt(ScanInput("\nHow many words is your message?:"));

            for (int i = 0; i < numOfWords; i++)
            {
                String word = ScanInput("Next word:");
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
