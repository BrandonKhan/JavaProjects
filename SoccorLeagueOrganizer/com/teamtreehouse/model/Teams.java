package com.teamtreehouse.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.Map;


public class Teams implements Comparable<Teams>{

private String mCoach;
private List<Player> mPlayers;
private String mTeamName;
private int mExperienced;
private int mInexperienced;

  
  

public Teams(String teamName,String coach) {
  mTeamName = teamName;
  mCoach = coach;
  mPlayers = new ArrayList<Player>();

  
}
public String getTeamName(){
  return mTeamName;

} 
public String getCoach(){
  return mCoach;

}
public List<Player> getListPlayer(){
  return mPlayers;
}
public void addPlayer(Player player){
  mPlayers.add(player);
  if (player.isPreviousExperience() == true){
    mExperienced+=1;
  }else{
    mInexperienced+=1;
  }
}

public int getExperienced(){
   return mExperienced;
    
  }
public int getInexperieced(){
   return mInexperienced;
    
  }  
  
public void removePlayer(int irp){
  mPlayers.remove(irp);
}
  
@Override
  public String toString(){
    return String.format("Team: %s & Coach: %s",mTeamName,mCoach); 
}
  @Override
  public int compareTo(Teams other) {
    // We always want to sort by last name then first name
    if(equals(other)){
      return 0;
    }
    return mTeamName.compareTo(other.getTeamName());
  }
  
  public Map<Integer,Player> sortTeamByHight(){
  Map<Integer,Player> teamHight = new TreeMap();
  int hight = 0;
  Integer hightInt = new Integer(hight);
  for(Player player : mPlayers){
    hight = player.getHeightInInches();
    hightInt = hight;
    teamHight.put(hightInt,player);
  
  }  
  return teamHight;
  
  }


}