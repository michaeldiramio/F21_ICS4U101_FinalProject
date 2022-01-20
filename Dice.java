import java.util.*;
import DLibX.*;
import java.awt.*;

public class Dice {
  
  Random r = new Random();
  int upperRange = 6;
  int Xpostion = 0;
  int Ypostion = 0;
  ArrayList<Integer> dice;
  int total = 0;
  
  public Dice(DConsole dc, int x, int y){
    this.Xpostion = x;
    this.Ypostion = y;
    dice = new ArrayList<Integer>();
    r = new Random();
  }
  
  public void drawDice(DConsole dc){ // x is the number of dice to appear on the screen
    int x = 0;
    if (dice.size() == 0){
      dc.setOrigin(DConsole.ORIGIN_CENTER);
    dc.setPaint(new Color(0, 0,0));
    dc.drawRect(Xpostion,Ypostion, 50 ,50);
    dc.setPaint(Color.WHITE);
    dc.fillRect(Xpostion,Ypostion, 50 ,50);
    dc.setPaint(Color.BLACK);
    } else {

      for(int i = 0; i < dice.size();i++){
        int die = dice.get(i);
        if(die == 1){
          dc.setOrigin(DConsole.ORIGIN_CENTER);
          dc.setPaint(new Color(0, 0,0));
          dc.drawRect(Xpostion + x,Ypostion, 50 ,50);
          dc.setPaint(Color.WHITE);
          dc.fillRect(Xpostion + x,Ypostion, 50 ,50);
          dc.setPaint(Color.BLACK);
          dc.fillEllipse(Xpostion + x,Ypostion, 8, 8);
        }else if (die == 2){
          dc.setOrigin(DConsole.ORIGIN_CENTER);
          dc.setPaint(new Color(0, 0,0));
          dc.drawRect(Xpostion + x,Ypostion, 50 ,50);
          dc.setPaint(Color.WHITE);
          dc.fillRect(Xpostion + x,Ypostion, 50 ,50);
          dc.setPaint(Color.BLACK);
          dc.fillEllipse((Xpostion - 10),(Ypostion - 10), 8, 8);
          dc.fillEllipse((Xpostion + x) + 10,Ypostion + 10, 8, 8);
        }else if (die == 3){
          dc.setOrigin(DConsole.ORIGIN_CENTER);
          dc.setPaint(new Color(0, 0,0));
          dc.drawRect(Xpostion + x,Ypostion, 50 ,50);
          dc.setPaint(Color.WHITE);
          dc.fillRect(Xpostion + x,Ypostion, 50 ,50);
          dc.setPaint(Color.BLACK);
          dc.fillEllipse(Xpostion + x ,Ypostion , 8, 8);
          dc.fillEllipse(Xpostion + x - 10,Ypostion - 10, 8, 8);
          dc.fillEllipse(Xpostion + x + 10,Ypostion + 10, 8, 8);
        }else if (die == 4){
          dc.setOrigin(DConsole.ORIGIN_CENTER);
          dc.setPaint(new Color(0, 0,0));
          dc.drawRect(Xpostion + x,Ypostion, 50 ,50);
          dc.setPaint(Color.WHITE);
          dc.fillRect(Xpostion + x,Ypostion, 50 ,50);
          dc.setPaint(Color.BLACK);
          dc.fillEllipse(Xpostion + x - 10,Ypostion - 10, 8, 8);
          dc.fillEllipse(Xpostion + x - 10,Ypostion + 10, 8, 8);
          dc.fillEllipse(Xpostion + x + 10,Ypostion + 10, 8, 8);
          dc.fillEllipse(Xpostion + x + 10,Ypostion - 10, 8, 8); 
        }else if (die == 5){
          dc.setOrigin(DConsole.ORIGIN_CENTER);
          dc.setPaint(new Color(0, 0,0));
          dc.drawRect(Xpostion + x,Ypostion, 50 ,50);
          dc.setPaint(Color.WHITE);
          dc.fillRect(Xpostion + x,Ypostion, 50 ,50);
          dc.setPaint(Color.BLACK);
          dc.fillEllipse(Xpostion + x,Ypostion, 8, 8);
          dc.fillEllipse(Xpostion + x - 10,Ypostion - 10, 8, 8);
          dc.fillEllipse(Xpostion + x - 10,Ypostion + 10, 8, 8);
          dc.fillEllipse(Xpostion + x + 10,Ypostion + 10, 8, 8);
          dc.fillEllipse(Xpostion + x + 10,Ypostion - 10, 8, 8); 
        }else{
          dc.setOrigin(DConsole.ORIGIN_CENTER);
          dc.setPaint(new Color(0, 0,0));
          dc.drawRect(Xpostion + x,Ypostion, 50 ,50);
          dc.setPaint(Color.WHITE);
          dc.fillRect(Xpostion + x,Ypostion, 50 ,50);
          dc.setPaint(Color.BLACK);
          dc.fillEllipse(Xpostion + x - 10,Ypostion , 8, 8);
          dc.fillEllipse(Xpostion + x - 10,Ypostion + 10, 8, 8);
          dc.fillEllipse(Xpostion + x - 10,Ypostion - 10, 8, 8);
          dc.fillEllipse(Xpostion + x + 10,Ypostion + 10, 8, 8);
          dc.fillEllipse(Xpostion + x + 10,Ypostion - 10, 8, 8); 
          dc.fillEllipse(Xpostion + x + 10,Ypostion, 8, 8); 
        }
        x = x + 60;
      }
    }
   
   
   
   
   // drawing one dice

    //1
    // dc.fillEllipse(Xpostion,Ypostion, 8, 8);
    // 2 
    // dc.fillEllipse((Xpostion - 10),(Ypostion - 10), 8, 8);
    // dc.fillEllipse(Xpostion + 10,Ypostion + 10, 8, 8);
    //3
    // dc.fillEllipse(Xpostion ,Ypostion , 8, 8);
    // dc.fillEllipse(Xpostion - 10,Ypostion - 10, 8, 8);
    // dc.fillEllipse(Xpostion + 10,Ypostion + 10, 8, 8);
    //4
    // dc.fillEllipse(Xpostion - 10,Ypostion - 10, 8, 8);
    // dc.fillEllipse(Xpostion - 10,Ypostion + 10, 8, 8);
    // dc.fillEllipse(Xpostion + 10,Ypostion + 10, 8, 8);
    // dc.fillEllipse(Xpostion + 10,Ypostion - 10, 8, 8); 
    //5
    // dc.fillEllipse(Xpostion,Ypostion, 8, 8);
    // dc.fillEllipse(Xpostion - 10,Ypostion - 10, 8, 8);
    // dc.fillEllipse(Xpostion - 10,Ypostion + 10, 8, 8);
    // dc.fillEllipse(Xpostion + 10,Ypostion + 10, 8, 8);
    // dc.fillEllipse(Xpostion + 10,Ypostion - 10, 8, 8); 
    //6
    // dc.fillEllipse(Xpostion - 10,Ypostion , 8, 8);
    // dc.fillEllipse(Xpostion - 10,Ypostion + 10, 8, 8);
    // dc.fillEllipse(Xpostion - 10,Ypostion - 10, 8, 8);
    // dc.fillEllipse(Xpostion + 10,Ypostion + 10, 8, 8);
    // dc.fillEllipse(Xpostion + 10,Ypostion - 10, 8, 8); 
    // dc.fillEllipse(Xpostion + 10,Ypostion, 8, 8); 
    
  }
  
  // graphical
  public void rollDice(int x){ // x = number of D6
   // dice results
    total = 0;
    int temp = 0;
    for(int i = 0; i < x; i++){
      temp = (r.nextInt(5) + 1);
      total += temp;// creating total sum of dice
      dice.add(temp); // storing value of each dice
    }
  }

  public int getResults(int x){ // x = slot of arraylist to get result from
    return dice.get(x);
  }

  public int getSum(){ // x = number of D6
    return total;
  }

  public int getXpostion(){
    return Xpostion;
  }

  public int getYpostion(){
    return Ypostion;
  }

}


    
  