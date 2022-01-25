import java.util.Random;
import java.util.Collections; //shuffles a list in java
import java.util.ArrayList;
public class Deck {

  private ArrayList<Card> cards = new ArrayList<>();

  public Deck(boolean dum) {
    if(dum == true){
      char[] suits = {'s', 'c', 'h', 'd'};
      for(int i = 0; i < 13; i++){
        for(int j = 0; j < suits.length; j++){
          this.cards.add(new Card(suits[j], i+1));
        }
      }
    }
    
  }

  public void shuffle() {
    Collections.shuffle(cards);
  }

  public int getNumberOfCards() {
    return this.cards.size();
  }

  public Card drawCard() {
    Random r = new Random();
    Card temp = this.cards.get(0);
    this.cards.remove(this.cards.get(0));
    return temp;
  }

  //will make cards arraylist 1 slot bigger
  public void addCard(char suit, int num) {
    this.cards.add(new Card(suit, num));
  }

  //will make cards arraylist 1 slot smaller
  public void removeCard(char suit, int num) {
    Card temp = new Card(suit, num);
    this.cards.remove(temp);
  }

  //testing
  public void printDeck(){
    for(int i = 0; i < cards.size(); i++){
      System.out.println(this.cards.get(i).getSuit() + " " + this.cards.get(i).getNum());
    }
  }

  public Card getCard(int num){
    return this.cards.get(num);
  }
}