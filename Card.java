import java.util.*;
import DLibX.*;

public class Card{
  private char suit;
  private int num;
  private boolean flipped = false;

  public Card(char suit, int num){
    this.suit = suit;
    this.num = num;
  }

  public void flipCard(){
    if( flipped = true){
      flipped = false;
    }else{
      flipped = true;
    }
  }

  public String printCard(){

    if flipped = true{
      // what file to print
      String temp = ("Card_Images/" + num + suit + ".png");
    
    return temp;
    }
    return "Card_Images/card_back.png";
    
  }
}