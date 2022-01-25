import java.util.*;

public class ModularDeck {

  int size;
  ArrayList<Card> cards;

  public ModularDeck() {
    cards = new ArrayList<Card>();
    //Suit
    char suit = '.';
    for (int i = 0; i < 4; i++) {
      //Number
      for (int j = 0; j < 13; j++) {
        if (i == 0) {
          suit = 's';
        } else if (i == 1) {
          suit = 'h';
        } else if (i == 2) {
          suit = 'd';
        } else if (i == 3) {
          suit = 'c';
        }
        cards.add(new Card(suit, j));
      }
    }
  }

  public ModularDeck(ArrayList<Card> cardz) {
    cards = cardz;
  }

  public void addCard(Card c) {
    cards.add(c);
  }

  public Card drawCard() {
    Card x = cards.get(0);
    cards.remove(0);
    return x;
  }

  public int checkSize() {
    return cards.size();
  }

  public int removeCard(int num, char suit) {
    for (int i = 0; i < cards.size(); i++) {
      if (cards.get(i).getNum() == num && cards.get(i).getSuit() == suit) {
        cards.remove(i);
        return 1;
      }
    }
    return -1;
  }

  public Card seeCard(int x) {
    return cards.get(x);
  }

  public void returnCard(Card toTheBottom) {
    cards.add(toTheBottom);
  }

  public void shuffle() {
    Collections.shuffle(cards);
  }

  public ModularDeck splitInTwo() {
    ArrayList<Card> cards2 = new ArrayList<>();
    for (int i = 0; i < cards.size(); i++) {
      cards2.add(cards.get(0));
      cards.remove(0);
    }

  ModularDeck toReturn = new ModularDeck(cards2);
  return toReturn;

  }


} //class end