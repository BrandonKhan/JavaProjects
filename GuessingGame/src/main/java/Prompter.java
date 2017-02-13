import java.util.Scanner;
import java.util.Random;


public class Prompter{
  
  
  private boolean checkNumber = true;
  private Jar game;
  private int tries = 7;
  private int guessedNumber;
  private int randoNumber; 
  private int attempt = 1;
  
  public Prompter(){
    
    System.out.println("ADMINISTRATOR");      
    System.out.println("=============");
    Scanner scanner = new Scanner(System.in);
    System.out.println("So... What type of item is in the Jar...Hmm?");
    String itemName = scanner.nextLine();
    itemName.toLowerCase();
    System.out.println("What is the maximum amount of " + itemName);
    String maxNumberString = scanner.nextLine();
    int maxNumber = Integer.parseInt(maxNumberString);    
    fillRandoNumber(maxNumber);    
    Jar game = new Jar(itemName,maxNumber);
                  
    System.out.println("PLAYER");
    System.out.println("======"); 
    System.out.println("How many " + itemName + " are in the jar? pick a number between 1 and " + maxNumberString + " you have " + tries + " to get it correct.");
 
    while (checkNumber == true && tries > 0){      
      String guessedNumberString = scanner.nextLine();
      guessedNumber = Integer.parseInt(guessedNumberString);
     
        if (guessedNumber == randoNumber){
            checkNumber = false;
            System.out.println("LOOK YOU DID IT! You got it in " + attempt + " attempt(s). GRATZ PLAYA umm sorry PLAYER!");
            tries = 0;
            System.exit(0);
          
        }
        if(tries == 0){
          System.out.println("GAME OVER!");
          continue;
        }
        else{
          System.out.println("Wrong..try again?");
          tries--;
          attempt++;
        }

    }
    

 
  }
  private int fillRandoNumber(int maxNumber){
    Random random = new Random();
    randoNumber = random.nextInt(maxNumber) + 1;
    return randoNumber;
    
  
  }



}









