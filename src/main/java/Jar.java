import java.util.Random;

public class Jar{
  
 private String itemName;
 private int maxNumber;
 public int randoNumber;




  
  public Jar(String itemName, int maxNumber){
   
    this.itemName = itemName;
    this.maxNumber = maxNumber;
    
  
  }  
  public String getItemName(){
    return itemName;
  
  }
  public int getMaxNumber(){  
    return maxNumber;
  
  }
  public int getRandoNumber(){
    return randoNumber;
    
  }
  public int fillRandoNumber(int maxNumber){
    Random random = new Random();
    randoNumber = random.nextInt(maxNumber) + 1;
    return randoNumber;
    
  
  }


  

  


}