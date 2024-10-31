import java.util.Scanner;

class Prompter {
  private Jar jar;
  private final Scanner scanner;
  
  public Prompter(Jar jar) {
    this.jar = jar;
    // Set up the proper way to handle user input and output by initializing Scanner once
    this.scanner = new Scanner(System.in);
  }
  
  // Prompt the administrator with type of item should fill the jar. 
  public String promptForItemType() {
    String itemType;
    while(true) {
      System.out.print("What type of item should fill the jar? ");
      // remove white space
      itemType = scanner.nextLine().trim();
      // Check if user input is empty or doesn't contain letters
      if (itemType.isEmpty() || !itemType.matches("[a-zA-Z]+")) {
        System.out.println("Please enter a valid item type (letters only).");
      } else {
        break;
      }
    }
    return itemType;
  }
  
  // Prompt the administrator with maximum amount of item type.
  public int promptForMaxAmount(String itemType) {
    int maxAmountOfItem;
    while(true) {
      System.out.printf("What is the maximum amount of %s? ", itemType);
      // Check if the next input is an integer
      if (scanner.hasNextInt()) {
        maxAmountOfItem = scanner.nextInt();
        // Ensure the provide input is a positive number
        if (maxAmountOfItem > 0) {
          scanner.nextLine();
          break;
        } else {
          System.out.println("Please enter a positive number.");
        }
      } else {
        System.out.println("That's not a valid number. Please enter a valid integer.");
        scanner.next();
      }
    }
    return maxAmountOfItem;
  }
  
  // Present the range of items to the administrator
  public int presentRangeOfItems(Jar jar) {
    int playerGuess = -1;
    while (true) {
      System.out.printf("How many %s are in the jar? Pick a number between 1 and %d.",
                     jar.getItemName(), jar.getMaxNumberOfItems());
      // Check if the next input is an integer
      if (scanner.hasNextInt()) {
        playerGuess = scanner.nextInt();
        // Ensure that the player guess number is between 1 and max number of items
        if (playerGuess < 1 || playerGuess > jar.getMaxNumberOfItems()) {
          System.out.printf("Your guess must be less than %d.%n",
                            jar.getMaxNumberOfItems());
        } else {
            break;
        } 
      } else { 
          System.out.println("Invalid input. Please enter a number.");
          scanner.next();
      }
    }
    return playerGuess;
  }
}