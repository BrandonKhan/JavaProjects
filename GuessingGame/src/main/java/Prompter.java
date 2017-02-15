import java.util.Scanner;



public class Prompter{
  
  
  private boolean checkNumber = true;
  private int guessedNumber;
  private int tries = 7;
  private int attempt = 0;
  
  
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
      int guessedNumber = Integer.parseInt(guessedNumberString);
     
       tries--;
       attempt++;
     
     
        if (guessedNumber == game.randoNumber){
            checkNumber = false;
            System.out.println("LOOK YOU DID IT! You got it in " + attempt + " attempt(s). GRATZ PLAYA umm sorry PLAYER!");
            tries = 0;
            System.exit(0);
          
        }
      if(guessedNumber>maxNumber || guessedNumber == 0){
          System.out.println("Your guess must be less than maximum fill amount and not 0 smarty pants...");
          tries++;
          attempt--;
        }

        
       if(guessedNumber>game.randoNumber){
          System.out.println("Your guess is to high");
         
          
        } 

      if(guessedNumber<game.randoNumber){
        System.out.println("Your guess is to low");
       

    }
    
    

 
  }
     if (tries == 0){
          System.out.println("GAME OVER!");
          System.exit(0);
       
     }
  


}
}









