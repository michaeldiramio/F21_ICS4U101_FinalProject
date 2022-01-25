import DLibX.*;
import java.awt.Color;
import java.util.*;
import java.text.DecimalFormat;

public class Quickselect {

  Player player;
  ArrayList<Game> games = new ArrayList<>();

  public Quickselect () {
    player = new Player(1000);

    games.add(new SumGame()); //game 1
    games.add(new Crash()); //game 2
    games.add(new CoinFlip()); //game 3
    games.add(new Klondike()); //game 4
    games.add(new Memory()); //game 5
    games.add(new Slots()); //game 6
    games.add(null); //game 7
    games.add(new War()); //game 8
    
    //games.add(new YourGame());
    //Add the games to the arraylist here as they become complete
  }

  public void printMenu(DConsole dc) {
    dc.clear();
    DecimalFormat df = new DecimalFormat("0.00");
    dc.setOrigin(DConsole.ORIGIN_CENTER);
    dc.setPaint(Color.GRAY);
    dc.fillRect(225, 150, 450, 300);
    dc.setPaint(Color.BLACK);
    dc.drawString("$" + df.format(player.getMoney()), 225, 280);
    dc.setPaint(Color.RED);
    dc.drawImage("CrashAssets/testicon.png", 163.75, 80); //2
    dc.drawImage("Memory_Images/memoryIcon.png", 61.25, 200); //5
    dc.fillRect(61.25, 80, 82.5, 82.5); //1
    dc.setPaint(Color.BLACK);
    dc.drawString("SumGame", 61.25, 80);
    dc.setPaint(Color.RED);
    dc.drawImage("slot_images/slotsIcon.png", 163.75, 200); //6
    dc.fillRect(266.25, 80, 82.5, 82.5); //3
    dc.fillRect(266.25, 200, 82.5, 82.5); //7
    dc.drawImage("Klondike_images/klondike_logo.png",368.75, 80); //4
    dc.drawImage("War_images/war_logo.png", 368.75, 200); //8
  }

  public void checkClicks(DConsole dc) {
    double mouseX = dc.getMouseXPosition();
    double mouseY = dc.getMouseYPosition();
    /*
    [1][2][3][4]
    [5][6][7][8]
    */
    if (dc.isMouseButton(1)) {
      //Game title goes here
      if(mouseX > 20 && mouseX < 102.5 && mouseY > 38.75 && mouseY < 121.25) {
        System.out.println("1");
        games.get(0).run(player, dc);
      }
      if(mouseX > 122.5 && mouseX < 205 && mouseY > 38.75 && mouseY < 121.25) {
        games.get(1).run(player, dc);
      }
      if(mouseX > 224.75 && mouseX < 307.25 && mouseY > 38.75 && mouseY < 121.25) {
        //games[2].run();
        games.get(2).run(player, dc);
      }
      if(mouseX > 327.5 && mouseX < 410 && mouseY > 38.75 && mouseY < 121.25) {
        //games[3].run();
        games.get(3).run(player, dc);
      }
      if(mouseX > 20 && mouseX < 102.5 && mouseY > 158.75 && mouseY < 241.25) {
        //games[4].run();
        games.get(4).run(player, dc);
      }
      if(mouseX > 122.5 && mouseX < 205 && mouseY > 158.75 && mouseY < 241.25) {
        games.get(5).run(player, dc); //games[5].run();
      }
      if(mouseX > 224.75 && mouseX < 307.25 && mouseY > 158.75 && mouseY < 241.25) {
        //games[6].run();
      }
      if(mouseX > 327.5 && mouseX < 410 && mouseY > 158.75 && mouseY < 241.25) {
        //games[7].run();
        games.get(7).run(player, dc);
      }
    }
  }
}