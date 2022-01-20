import java.util.Random;
import java.util.Collections; //shuffles a list in java
import java.util.ArrayList;
public class Deck {

  private ArrayList<Card> cards;
  private int numberOfCards;

  public Deck(int numberOfCards) {
    this.numberOfCards = numberOfCards;
    this.cards = new ArrayList<Card>();
  }


  public void shuffle() {
    // Random r = new Random();
    // for(int i = 0; i < cards.size(); i++) {
    //   Collections.shuffle(cards);
    // }
    Collections.shuffle(cards);
  }

  public int getNumberOfCards() {
    return this.numberOfCards;
  }

  public Card getCard() {
    return cards.get(0);
  }

  //will make cards arraylist 1 slot smaller
  public void addCard(Card card) {
    cards.add(card);
  }

  //will make cards arraylist 1 slot bigger
  public void removeCard(Card card) {
    cards.remove(card);
  }


}