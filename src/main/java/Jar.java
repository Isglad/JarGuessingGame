import java.util.Random;

public class Jar {
  // Add two private instance variables: a String for the item name and an integer for the maximum number of items.
  private final String itemName;
  private int maxNumberOfItems;
  // Add a new private integer instance variable to store the current number of items.
  private int currentNumberOfItems;
  
  
  // Implement a constructor that takes these two parameters and initializes the instance variables.
  public Jar(String itemName, int maxNumberOfItems) {
    this.itemName = itemName;
    this.maxNumberOfItems = maxNumberOfItems;
  }
  
  // Create getter methods for item name.
  public String getItemName() {
    return itemName;
  }
  
  // Create getter methods for maximum number of items.
  public int getMaxNumberOfItems() {
    return maxNumberOfItems;
  }
  
  // Create a fill() method
  public void fill() {
    // Use the Random class to generate a random number of items.
    Random random = new Random();
    // That random number should be between 1 and the maximum number of items.
    int randomNumber = random.nextInt(maxNumberOfItems) + 1;
    // Set the current number of items to this random number.
    currentNumberOfItems = randomNumber;
  }
  
  // Create a getter method for the current number of items.
  public int getCurrentNumberOfItems() {
    return currentNumberOfItems;
  }
}