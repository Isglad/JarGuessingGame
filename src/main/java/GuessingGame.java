public class GuessingGame {
    public static void main(String[] args) {
      Jar jar = new Jar("", 0);
      Prompter prompter = new Prompter(jar);
      
      // Prompt the administrator and store responses in variables.
      System.out.println("ADMINISTRATOR SET UP");
      System.out.println("--------------------");
      String itemType = prompter.promptForItemType();
      int maxAmountOfItem = prompter.promptForMaxAmount(itemType);
      
      // Create a new Jar object using the collected information.
      jar = new Jar(itemType, maxAmountOfItem);
      
      // Fill the jar with a random number of items
      jar.fill();
      
      // Create the Game Loop
      System.out.printf("%n%n%n----------------------%n");
      System.out.println("Welcome to the guessing game!");
      int playerGuess;
      int guessCount = 0;
      boolean correctGuess = false;
      
      while(!correctGuess) {
        // Present the range of items and get the player's guess
        playerGuess = prompter.presentRangeOfItems(jar);
        
        // Increment the guess count only for valid guesses
        guessCount++;
          
        // Compare the guess to the actual number of items in the jar.
        // If the guess is correct, break the loop.
        // If the guess is too high or too low, inform the player and continue the loop.
        if (playerGuess == jar.getCurrentNumberOfItems()) {
          System.out.printf("You got it in %d attempt%s.%n", guessCount, guessCount == 1 ? "" : "s");
          correctGuess = true;
        } else if (playerGuess < jar.getCurrentNumberOfItems()) {
          System.out.println("too low");
        } else {
          System.out.println("too high");
        }
      
      }

    }
}
