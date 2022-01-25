import DLibX.*;
import java.awt.Color;
import java.util.*;
import java.text.DecimalFormat;

public class Quickselect {

  Player player;
  ArrayList<Game> games = new ArrayList<>();

  public Quickselect () {
    player = new Player(1000);
    games.add(new Crash());
    games.add(new War());
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
    dc.drawImage("CrashAssets/testicon.png", 61.25, 80); //1
    dc.fillRect(61.25, 200, 82.5, 82.5); //5
    dc.fillRect(163.75, 80, 82.5, 82.5); //2
    dc.fillRect(163.75, 200, 82.5, 82.5); //6
    dc.fillRect(266.25, 80, 82.5, 82.5); //3
    dc.fillRect(266.25, 200, 82.5, 82.5); //7
    dc.fillRect(368.75, 80, 82.5, 82.5); //4
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
        games.get(0).run(player, dc);
      }
      if(mouseX > 122.5 && mouseX < 205 && mouseY > 38.75 && mouseY < 121.25) {
        //games[1].run();
        System.out.println("2");
      }
      if(mouseX > 224.75 && mouseX < 307.25 && mouseY > 38.75 && mouseY < 121.25) {
        //games[2].run();
        System.out.println("3");
      }
      if(mouseX > 327.5 && mouseX < 410 && mouseY > 38.75 && mouseY < 121.25) {
        //games[3].run();
        System.out.println("4");
      }
      if(mouseX > 20 && mouseX < 102.5 && mouseY > 158.75 && mouseY < 241.25) {
        //games[4].run();
        System.out.println("5");
      }
      if(mouseX > 122.5 && mouseX < 205 && mouseY > 158.75 && mouseY < 241.25) {
        //games[5].run();
        System.out.println("6");
      }
      if(mouseX > 224.75 && mouseX < 307.25 && mouseY > 158.75 && mouseY < 241.25) {
        //games[6].run();
        System.out.println("7");
      }
      if(mouseX > 327.5 && mouseX < 410 && mouseY > 158.75 && mouseY < 241.25) {
        //games[7].run();
        games.get(7).run(player, dc);
      }
    }
  }
}