import com.teamtreehouse.Organizer;
import com.teamtreehouse.model.Player;
import com.teamtreehouse.model.Players;
import com.teamtreehouse.model.Teams;

public class LeagueManager {

  private Organizer boss;
  
  public static void main(String[] args) {
    Player[] players = Players.load();
    System.out.printf("There are currently %d registered players.%n", players.length);
    // Your code here!
    Organizer boss = new Organizer();
    boss.run();
  }

}
