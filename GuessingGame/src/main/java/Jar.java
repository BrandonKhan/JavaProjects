import java.util.Random;

public class Jar{
  
 private String itemName;
 public int maxNumber;
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


  public void fillRandoNumber(int maxNumber){
    Random random = new Random();
    this.randoNumber = random.nextInt(maxNumber) + 1;
    
    
  
  }


  

  


}