import java.util.Scanner;



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
    Jar game = new Jar(itemName,maxNumber);
    game.fillRandoNumber(maxNumber);
                  
    System.out.println("PLAYER");
    System.out.println("======"); 
    System.out.println("How many " + itemName + " are in the jar? pick a number between 1 and " + maxNumberString + " you have " + tries + " tries to get it correct.");
 
    while (checkNumber == true && tries > 0){      
      String guessedNumberString = scanner.nextLine();
     
     
        if (guessedNumber == game.randoNumber){
            checkNumber = false;
            System.out.println("LOOK YOU DID IT! You got it in " + attempt + " attempt(s). GRATZ PLAYA umm sorry PLAYER!");
            tries = 0;
            System.exit(0);
          
        }
      if(guessedNumber>maxNumber){
          System.out.println("Your guess must be less than maximum fill amount");
        
        }

        
       if(guessedNumber>game.randoNumber){
          System.out.println("Your guess is to high");
          tries--;
          attempt++;
          System.out.println(game.randoNumber);
        } 

      if(guessedNumber<game.randoNumber){
        System.out.println("Your guess is to low");
         tries--;
         attempt++;
         System.out.println(game.randoNumber);

    }
     if (tries == 0){
          System.out.println("GAME OVER!");
          System.exit(0);
       
     }
    

 
  }
  


}
}









