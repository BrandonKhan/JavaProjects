package com.teamtreehouse;  

import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Players;
import com.teamtreehouse.model.Teams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.TreeMap;



public class Organizer{

private Teams mTeam;
private BufferedReader mReader;  
private Map<String,String> mMenu;
public List<Teams> mTeams;
public List<Player> playerList;
public Map<Integer,Player> playerBySize = new TreeMap<>();

  

public Organizer(){
  mReader = new BufferedReader(new InputStreamReader(System.in));
  mMenu = new HashMap<String,String>();
  mTeams = new ArrayList<Teams>();
  playerBySize = new TreeMap<>();
  playerList = Arrays.asList(Players.load());
  mMenu.put("new","create a new team");
  mMenu.put("quit","cancel services");
  mMenu.put("add","add a player");
  mMenu.put("remove","remove a player from an existing team");
  mMenu.put("report", "view team report");
  mMenu.put("balance","view League Balance Report");
  mMenu.put("coach","view all players on your team");
  
  
}
  
//Menu   
  private String promptAction() throws IOException{
    System.out.printf("%n***Soccer League Organizer Menu***%n");
    
   for(Map.Entry<String,String> option : mMenu.entrySet()){
        System.out.printf(" - Type: \"%s\" to %s %n",
                          option.getKey(),
                          option.getValue());
  }
    System.out.print("what do you want to do: ");
    String choice = mReader.readLine();
    return choice.trim().toLowerCase();
    
  }
  //make a new team
  private Teams promptNewTeams() throws IOException{
    System.out.printf("Ah.. Welcome! %nWhat is the Teams Name:");
    String teamName = mReader.readLine();
    System.out.printf("%s Nice one! %nOh.. And what is the Coachs Name:",teamName);
    String coach = mReader.readLine();
    System.out.printf("%n*** Team: %s Coached by: %s was added! ***%n%n",teamName,coach);
  return new Teams(teamName,coach);
    
  }
  //show Availble teams
  private int promptAvailableTeams() throws IOException{
    System.out.println("***Current Teams***");
    System.out.println("Okay... What team did you want add a player to?");
    int i = 1;
    for(Teams eTeams : mTeams){
        System.out.printf("%d.)  %s",i,eTeams.toString());
        System.out.printf(" || ");
        i++;
  }
    String pick = mReader.readLine();
    int pickAsInt = Integer.parseInt(pick) -1;
    return pickAsInt;
    
  }
  // Shows all players aviable to add
  private int promptAvailablePlayers() throws IOException{
    System.out.printf("%n***Current Players***%n");
    int pn =1;
    Collections.sort(playerList);
    for (Player ePlayer : playerList){
          System.out.printf("%d.) ",pn);
          System.out.printf(ePlayer.printPlayer());
          System.out.printf("%n");
          pn++;

    }  
      String pickPN = mReader.readLine();
      System.out.printf("%n");
      int indexPN = Integer.parseInt(pickPN) -1;
      return indexPN;
    
    
  }
  //show coach print out
  private void coachReport(Teams dTeam){
    List<Player> dTeamSetPlayer = dTeam.getListPlayer();
    for(Player dPlayer : dTeamSetPlayer){
    System.out.printf("%n%s",dPlayer.printPlayer());
    
    }  
  
  
  }
  //Show all player currently on chosen team
  private int promptTeamPlayerSet(Teams rTeam) throws IOException{
    Collections.sort(rTeam.getListPlayer());
    List<Player> rTeamSetPlayer = rTeam.getListPlayer();
    System.out.printf("%n And... Who did you want to remove?");
     int rp = 1;
      for(Player rPlayer : rTeamSetPlayer){  
      
        System.out.printf("%n%d.) %s    ",rp,rPlayer.toString());
        rp++;

    }
    String pickRP = mReader.readLine();
    int indexRP = Integer.parseInt(pickRP) - 1;
    return indexRP;
    
  }

  //grabs the team you want to edit
  private Teams getTeamToEdit(int teamIndex){
    Teams aTeam = mTeams.get(teamIndex);
    System.out.printf("Cool... so you want to edit%n %s!",aTeam);
    return aTeam;
  }
  
  //grabs the player you want to add  
  private Player getPlayerToAdd(int playerAdd){   
    Player aPlayer = playerList.get(playerAdd);
    return aPlayer;
  }
  
  //put out current teams players by hight
  private void getPlayersOnTeam(Teams sTeam){
        playerBySize = sTeam.sortTeamByHight();
   for (Map.Entry<Integer,Player> playerMap : playerBySize.entrySet()){
      System.out.printf("%n%d\" Player: %s %n",
                          playerMap.getKey(),
                          playerMap.getValue());
  }
  
  }
  //put out current teams whith exp rating
   private void balanceReport(){
    int exp=0;
    int noexp=0;
     for(Teams brTeam : mTeams){
       exp = brTeam.getExperienced();
       noexp = brTeam.getInexperieced();
       System.out.printf("%s %nHas |%d| Experienced Players.%nHas |%d| Inexperienced Players. %n",brTeam.toString(),exp,noexp);
    } 
   
    }
  
  private Player getPlayerToRemove(Teams rTeam, int irp){
    Collections.sort(rTeam.getListPlayer());
    List<Player> cPlayerList = rTeam.getListPlayer();
    Player cPlayer = cPlayerList.get(irp);
    return cPlayer;
  }
      
  public void run(){
    String choice = "";
    do{
      try{
          choice = promptAction();
        switch(choice){
          case "new":
            Teams team = promptNewTeams();
            mTeams.add(team);
            break;
          case "add":
          if (mTeams.size() > 0){
            int teamIndex = promptAvailableTeams();
            Teams aTeam = getTeamToEdit(teamIndex);
            int playerAdd = promptAvailablePlayers();
            Player aPlayer = getPlayerToAdd(playerAdd);
            aTeam.addPlayer(aPlayer);
            System.out.printf("%n*** %s was added to %s ****%n",aPlayer,aTeam);
            break;
          }else{System.out.printf("%n You need a team before you can add players");break;}
          case "remove":
            int rTeamIndex = promptAvailableTeams();
            Teams rTeam = getTeamToEdit(rTeamIndex);
            List<Player> rTeamList = rTeam.getListPlayer();
            if(rTeamList.size() > 0){
            int irp = promptTeamPlayerSet(rTeam);
            Player rPlayer = getPlayerToRemove(rTeam,irp);
            rTeam.removePlayer(irp);
            System.out.printf("%n*** Awesome %s was removed from %s ***%n",rPlayer,rTeam);
            break;
          }else{System.out.printf("%n You need to add a team and or a player");break;}
          case "report":
          if(mTeams.size() > 0){
            int sTeamIndex = promptAvailableTeams();
            Teams sTeam = getTeamToEdit(sTeamIndex);
            List<Player> sTeamList = sTeam.getListPlayer();
            getPlayersOnTeam(sTeam);
            break;
          }else{System.out.printf("%n You need to add a team and or a player");break;}
          case "balance":
          if(mTeams.size() > 0){
            balanceReport();
            break;
          }else{System.out.printf("%n You need to add a team and or a player");break;}
          case "coach":
            if(mTeams.size() > 0){
            int dTeamIndex = promptAvailableTeams();
            Teams dTeam = getTeamToEdit(dTeamIndex);
            coachReport(dTeam);
            System.exit(0);
            }else{System.out.printf("%n You need to add a team and or a player");break;}
          case "quit":
            System.out.println("Well... May all your soccer dreams come ture.");
            break;
         default:
            System.out.printf("So... %s is not reconized.Maybe try someting else %n",choice);
        }
      
      }catch(IOException ioe){
        System.out.println("Hmm... That input is invalid. Maybe try again.");
      }

    }while(!choice.equals("quit"));
  
  }

}