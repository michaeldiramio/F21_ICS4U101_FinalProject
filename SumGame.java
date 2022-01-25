import java.util.*;
import DLibX.*;

public class SumGame extends Game{


  public void run(Player p, DConsole dc){
    dc.clear();
    double bet = 0;
    int guess = 0;
    int total = 0;
    int in = 0;
    Scanner sc = new Scanner(System.in);
    Dice d = new Dice(dc, 50 , 50);
    boolean con = true;
    double money = p.getMoney();
    System.out.println("Welcome to YahtzeeGuess!");
    System.out.println("How To play:");
    System.out.println("Before each round you will place a bet and then select what you think will be rolled on 5 dice");
    System.out.println("You will guess the collective sum of all five dice");
    System.out.println("the closer it is to role the more money you will get!!!!!");   
    while(con == true){
      System.out.println("Your current money: " + p.getMoney());
      System.out.print("Place your bet: ");
      bet = sc.nextDouble();
      sc.nextLine();
        while(bet > p.getMoney() || bet < 1){
          System.out.println("invalid bet");
          bet = sc.nextDouble();
        }
      p.setMoney( money - bet);
      System.out.println("What is going to be rolled?");
      guess = sc.nextInt();
      d.rollDice(5);
      d.drawDice(dc);
      total = d.getSum();
      if (guess == total){
        p.changeMoney(bet*2);
        System.out.println("Right on the money!");
      } else if (guess == (total -1) || guess == (total + 1) || guess == (total -2) || guess == (total +2) ){
        System.out.println("so close");
        p.changeMoney(bet*1.5);
      } else if (guess == (total -3) || guess == (total + 3) || guess == (total -4) || guess == (total +4) || guess == (total +5)|| guess == (total -5)){
        p.changeMoney(bet*1.25);
        System.out.println("Just barly close enough");
      } else {
        System.out.println("not close enough");
      }
      System.out.println("Actual Total: " + d.getSum());
      System.out.println("Contiune? 1 to continue, 2 to stop");
      in = sc.nextInt();
      if (in == 2){
        con = false;
      }
      dc.clear();
    }
  }
}