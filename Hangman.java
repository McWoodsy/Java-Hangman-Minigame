import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Hangman {

    public static String[] words = {"ant", "baboon", "badger", "bat", "bear", "beaver", "camel",
    "cat", "clam", "cobra", "cougar", "coyote", "crow", "deer",
    "dog", "donkey", "duck", "eagle", "ferret", "fox", "frog", "goat",
    "goose", "hawk", "lion", "lizard", "llama", "mole", "monkey", "moose",
    "mouse", "mule", "newt", "otter", "owl", "panda", "parrot", "pigeon", 
    "python", "rabbit", "ram", "rat", "raven","rhino", "salmon", "seal",
    "shark", "sheep", "skunk", "sloth", "snake", "spider", "stork", "swan",
    "tiger", "toad", "trout", "turkey", "turtle", "weasel", "whale", "wolf",
    "wombat", "zebra"};

    public static String[] gallows = {"+---+\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "    |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    "+---+\n" +
    "|   |\n" +
    "O   |\n" +
    "|   |\n" +
    "    |\n" +
    "    |\n" +
    "=========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|   |\n" +
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + //if you were wondering, the only way to print '\' is with a trailing escape character, which also happens to be '\'
    "     |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" +
    "/    |\n" +
    "     |\n" +
    " =========\n",

    " +---+\n" +
    " |   |\n" +
    " O   |\n" +
    "/|\\  |\n" + 
    "/ \\  |\n" +
    "     |\n" +
    " =========\n"};

    public static void main(String[] args) {
            
        Scanner scan = new Scanner(System.in);

        String word = randomWord();
       
        char[] placeholders = new char[word.length()];

        int misses = 0;
        
        for (int index = 0; index < placeholders.length; index++) {
            placeholders[index] = '_';
            }

        while (misses <= 6) {
            System.out.println(gallows[misses]);
            System.out.print("Word: ");
            printPlaceholders(placeholders);
            System.out.println("\n");
            System.out.print("\nMisses: "); 
            System.out.println(misses);        
            System.out.println("\nGuess: ");
            char guess = scan.nextLine().charAt(0);
            
            if (checkGuess(word, guess) == true) {
                updatePlaceholders(guess, word, placeholders);
                if (Arrays.equals(placeholders,word.toCharArray())) {
                    String winMessage = ""; 
                    
                    for (int index = 0; index < placeholders.length; index++) {
                        winMessage = winMessage + placeholders[index];
                    }
//                  String upperWinMessage = winMessage.toUpperCase(null);
                    System.out.println("\nThat's right, the word is " + winMessage.toUpperCase() + "!!!");
                    System.out.println("\nAmazing, you are the best hangman player ever, be proud.\n");
                    scan.close();
                    System.exit(0);
                }
            }
            else {misses++;}
                System.out.println(misses);
                System.out.print("\n"); 
            }
                System.out.println("Unimpressive. Try again.\n\n");
                scan.close();
            }

    public static boolean checkGuess(String word, char guess) {
        for (int index = 0; index < word.length(); index++) {
            if (word.charAt(index) == guess) {
                return true;
            }
        }
        return false;
    }


    public static String randomWord() {
        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        String randomWord = words[randomIndex];
        //System.out.println("Random word: " + randomWord);
        return randomWord;
    }
    
    public static void printPlaceholders(char [] placeholder) {
        for (int i = 0; i < placeholder.length; i++) {
            System.out.print(" " + placeholder[i]);}
    }

    public static void updatePlaceholders(char guess, String word, char[] placeholder) {
        for (int index = 0; index < word.length(); index++) {
            if (word.charAt(index) == guess) {
                placeholder[index] = guess;    
        }
    }
    }
}









