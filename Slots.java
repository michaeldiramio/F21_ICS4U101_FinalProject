import java.util.*;
import DLibX.*;
import java.awt.*;
import java.awt.image.*;

public class Slots extends Game {

  public void run(Player p, DConsole dc) {
    boolean end = false;

    int[] mySlots = null;
    boolean magnet = false; //magnet for rigging machine

    //bet has not been made
    boolean betMade = false;
    double bet = 0;

    //spins slot machine if lever is clicked
    while(!end) {
      dc.drawImage("slot_images/slotMachine.png", 225, 150);
      dc.drawImage("slot_images/magnet.png", 441, 240);

      //get mouse position
      int mouseX = dc.getMouseXPosition();
      int mouseY = dc.getMouseYPosition();

      //button clicking for lever
      if (mouseX > 412 && mouseX < 450){
        if (mouseY > 43 && mouseY < 81){
          if(dc.isMouseButton(1)) {

            //proceed only if bet has been made
            if(betMade == true){
              if (magnet == false){
                mySlots = this.generateSlots();
              } else {
                mySlots = this.rigSlots();
              }
              this.printSlots(mySlots, dc);
              int score = this.evaluateSlots(mySlots);
              System.out.println("Score: " + score);
              double winnings = ((score - 300) / 100) * bet;
              if (winnings > 0){
                System.out.println("Winnings: $" + winnings);
                p.changeMoney(+winnings);
              } else {
                System.out.println("Winnings: $0");
              }
              System.out.println("Money: " + p.getMoney());
              System.out.println();
              betMade = false;

              //pause and reset
              try {
                Thread.sleep(2500);
              } catch (InterruptedException e) {
                System.out.println("error :(");
              }
              this.run(p, dc);
            } else {
              System.out.println("Make a bet before playing");

              //pause
              try {
                Thread.sleep(900);
              } catch (InterruptedException e) {
                System.out.println("error :(");
              }

            }

          }
        }
      }

      //button clicking for magnet
      if (mouseX > 426 && mouseX < 456){
        if (mouseY > 225 && mouseY < 255){
          if (dc.isMouseButton(1)){

            if (magnet == false){
              magnet = true;
              System.out.println("Magnet enabled");
            } else {
              magnet = false;
              System.out.println("Magnet disabled");
            }

            //pause so it only prints once
            try {
              Thread.sleep(800);
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          }
        }
      }

      //bet button
      dc.drawImage("slot_images/betButton.png", 210, 285);

      //escape button
      dc.drawImage("slot_images/arrow.png", 60, 285);

      //button clicking for bet
      if (mouseX > 145 && mouseX < 275){
        if (mouseY > 273 && mouseY < 297){
          if (dc.isMouseButton(1)){

            //scanner
            Scanner sc = new Scanner(System.in);

            //declare variables
            boolean validInput = false;
            bet = 0;

            //check input validity
            while (!validInput){

              System.out.print("Bet: ");
              String betInput = sc.nextLine();

              try {
                bet = Double.parseDouble(betInput);
                if (0 < bet && bet <= p.getMoney()) {
                  validInput = true;
                  betMade = true;
                  p.changeMoney(-bet);

                } else if (bet <= 0) {
                  System.out.println("Bet must be > 0\n");
                } else {
                  System.out.println("Insufficient funds\n");
                }

                } catch (Exception e) {
                System.out.println("Invalid input\n");
              }
            }

          }
        }
      }

      //button clicking for escape
      if (mouseX > 43 && mouseX < 77){
        if (mouseY > 271.5 && mouseY < 298.5){
          if (dc.isMouseButton(1)){
            end = true;
            dc.clear();
          }
        }
      }

      dc.redraw();
      dc.pause(20);
    }
  }

  //generates three random numbers
  public int[] generateSlots(){
    Random r = new Random();
    int slots[] = new int[3];

    for (int i = 0; i < 3; i++){
      int randomInt = r.nextInt(18);
      slots[i] = randomInt;
    }
    return slots;
  }

  //uses the three generated numbers to print slots
  public void printSlots(int[] slots, DConsole dc){

    String images[] = new String[3];

    //repeat for each of the three slots
    for (int i = 0; i < slots.length; i++){
      int slotVal = slots[i];
      String slot = "";

      //determine which slot based on generated number
      if (slotVal == 0 || slotVal == 9 || slotVal == 15){
        slot = "7";
      } else if (slotVal == 1 || slotVal == 10 || slotVal == 16){
        slot = "banana";
      } else if (slotVal == 2 || slotVal == 11 || slotVal == 17){
        slot = "bar";
      } else if (slotVal == 3 || slotVal == 12){
        slot = "bell";
      } else if (slotVal == 4 || slotVal == 13){
        slot = "cherry";
      } else if (slotVal == 5 || slotVal == 14){
        slot = "lemon";
      } else if (slotVal == 6){
        slot = "orange";
      } else if (slotVal == 7){
        slot = "plum";
      } else if (slotVal == 8){
        slot = "watermelon";
      }

      images[i] = ("slot_images/" + slot + ".png");

    }

    //spinning slots graphics
    this.roll(images, dc);

  }

  //calculates the score of the slots
  public int evaluateSlots(int[] slots){

    //standardize slot numbers
    for (int i = 0; i < 3; i++){

      if (slots[i] > 14){
        slots[i] = slots[i] - 15;
      } else if (slots[i] > 8){
        slots[i] = slots[i] - 9;
      }
      
    }

    int score = 0;

    //if all slots are same
    if (slots[0] == slots[1] && slots[1] == slots[2]){
      score = score + 1000;

    //if two of slots are same
    } else if (slots[0] == slots[1] || slots[1] == slots[2] || slots[2] == slots[0]){
      score = score + 500;
    }

    //additional points for symbols
    for (int i = 0; i < 3; i++){
      score = score + (slots[i] * 10);
    }
      
    return score;
  }

  // spins the slots
  public void roll(String[] finalImages, DConsole dc){

    //image codes for printing
    ArrayList<String> images = new ArrayList<String>(9);
    images.add("slot_images/7.png");
    images.add("slot_images/banana.png");
    images.add("slot_images/bar.png");
    images.add("slot_images/bell.png");
    images.add("slot_images/cherry.png");
    images.add("slot_images/lemon.png");
    images.add("slot_images/orange.png");
    images.add("slot_images/plum.png");
    images.add("slot_images/watermelon.png");

    //variable for slowing down spinning
    int lag = 50;

    //three cycles of slots
    for (int i = 0; i < 3; i++){

      //spin slot wheels
      for (int j = 0; j < 9; j++){
        dc.drawImage("slot_images/slotMachine2.png", 225, 150);
        dc.drawImage("slot_images/magnet.png", 441, 240);

        if (j == 8){ //last spin of set
          if (i == 2){ //last spin total
            dc.drawImage(finalImages[0], 80, 150);
            dc.drawImage(finalImages[1], 200, 150);
            dc.drawImage(finalImages[2], 320, 150);
          } else {
            dc.drawImage(images.get(j), 80, 150);
            dc.drawImage(images.get(0), 200, 150);
            dc.drawImage(images.get(1), 320, 150);
          }
        } else if (j == 7){
          dc.drawImage(images.get(j), 80, 150);
          dc.drawImage(images.get(j + 1), 200, 150);
          dc.drawImage(images.get(0), 320, 150);
        } else {
          dc.drawImage(images.get(j), 80, 150);
          dc.drawImage(images.get(j + 1), 200, 150);
          dc.drawImage(images.get(j + 2), 320, 150);
        }

        dc.redraw();
        dc.pause(lag);
      }

      //slow spin
      lag = lag + 150;
    }
  }

  //use instead of generateSlots to cheat
  public int[] rigSlots(){
    Random r = new Random();
    int slots[] = new int[3];

    for (int i = 0; i < 3; i++){
      int randomInt = r.nextInt(4) + 5; //can only generate certain slots
      slots[i] = randomInt;
    }
    return slots;
  }

}