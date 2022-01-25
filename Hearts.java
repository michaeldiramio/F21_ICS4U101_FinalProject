import java.util.*;
public class Hearts extends Game{

private int[] score = {0, 0, 0, 0};

public void run(){

  Scanner input = new Scanner(System.in);

  boolean gameOver = false;

  //player and computers hands
  Deck player = new Deck(false);
  //computer to the left of player
  Deck comp1 = new Deck(false);
  //computer across from player
  Deck comp2 = new Deck(false);
  //computer to the right of player
  Deck comp3 = new Deck(false);

  //scores
  int p1s = 0;
  int c1s = 0;
  int c2s = 0;
  int c3s = 0;

  //what round 
  int round = 0;

  while(!gameOver){

    Deck deck = new Deck(true);
    deck.shuffle();
    //deal out the deck
    for(int i = 0; i < 13; i++){
      player.addCard(deck.getCard(0).getSuit(), deck.drawCard().getNum());
      comp1.addCard(deck.getCard(0).getSuit(), deck.drawCard().getNum());
      comp2.addCard(deck.getCard(0).getSuit(), deck.drawCard().getNum());
      comp3.addCard(deck.getCard(0).getSuit(), deck.drawCard().getNum());
    }

    
    //start of a round
    
    //more things to hold the cards taken and in play
    Deck p1t = new Deck(false);
    Deck c1t = new Deck(false);
    Deck c2t = new Deck(false);
    Deck c3t = new Deck(false);
    Deck play = new Deck(false);

    //passing cards
    if(round == 0){
      System.out.println("pick 3 to pass to left");
      for(int j = 0; j < 13; j++){
         System.out.print("[" + player.getCard(j).getSuit() + player.getCard(j).getNum() + "] ");
      }
      System.out.println();
      
      //choices
      String pass1 = input.nextLine();
      String pass2 = input.nextLine();
      String pass3 = input.nextLine();

      //substring it into the suit and number
      char suit1 = pass1.charAt(0);
      String num01 = pass1.substring(1);
      Integer num1 = Integer.valueOf(num01);
          
      char suit2 = pass1.charAt(0);
      String num02 = pass1.substring(1);
      Integer num2 = Integer.valueOf(num02);

      char suit3 = pass1.charAt(0);
      String num03 = pass1.substring(1);
      Integer num3 = Integer.valueOf(num03);

      //give cards to the computer
      comp1.addCard(suit1, num1);
      comp1.addCard(suit2, num2);
      comp1.addCard(suit3, num3);
      //remove those cards from the player
      player.removeCard(suit1, num1);
      player.removeCard(suit2, num2);
      player.removeCard(suit3, num3);

      //computers passing cards as well

      //give cards from computer to the computer
      comp2.addCard(comp1.getCard(10).getSuit(), comp1.getCard(10).getNum());
      comp2.addCard(comp1.getCard(11).getSuit(), comp1.getCard(11).getNum());
      comp2.addCard(comp1.getCard(12).getSuit(), comp1.getCard(12).getNum());
      //remove those cards from the computer
      comp1.removeCard(comp1.getCard(10).getSuit(), comp1.getCard(10).getNum());
      comp1.removeCard(comp1.getCard(10).getSuit(), comp1.getCard(10).getNum());
      comp1.removeCard(comp1.getCard(10).getSuit(), comp1.getCard(10).getNum());

      //give cards from computer to the computer
      comp3.addCard(comp2.getCard(10).getSuit(), comp2.getCard(10).getNum());
      comp3.addCard(comp2.getCard(11).getSuit(), comp2.getCard(11).getNum());
      comp3.addCard(comp2.getCard(12).getSuit(), comp2.getCard(12).getNum());
      //remove those cards from the computer
      comp2.removeCard(comp2.getCard(10).getSuit(), comp2.getCard(10).getNum());
      comp2.removeCard(comp2.getCard(10).getSuit(), comp2.getCard(10).getNum());
      comp2.removeCard(comp2.getCard(10).getSuit(), comp2.getCard(10).getNum());

      //give cards from computer to the player
      player.addCard(comp3.getCard(10).getSuit(), comp3.getCard(10).getNum());
      player.addCard(comp3.getCard(11).getSuit(), comp3.getCard(11).getNum());
      player.addCard(comp3.getCard(12).getSuit(), comp3.getCard(12).getNum());
      //remove those cards from the computer
      comp3.removeCard(comp3.getCard(10).getSuit(), comp3.getCard(10).getNum());
      comp3.removeCard(comp3.getCard(10).getSuit(), comp3.getCard(10).getNum());
      comp3.removeCard(comp3.getCard(10).getSuit(), comp3.getCard(10).getNum());
        
    }else if(round == 1){
      System.out.println("pick 3 to pass to right");
      for(int j = 0; j < 13; j++){
        System.out.print("[" + player.getCard(j).getSuit() + player.getCard(j).getNum() + "] ");
      }
      System.out.println();
      //choices
      String pass1 = input.nextLine();
      String pass2 = input.nextLine();
      String pass3 = input.nextLine();

      //substring it into the suit and number
      char suit1 = pass1.charAt(0);
      String num01 = pass1.substring(1);
      Integer num1 = Integer.valueOf(num01);
          
      char suit2 = pass1.charAt(0);
      String num02 = pass1.substring(1);
      Integer num2 = Integer.valueOf(num02);

      char suit3 = pass1.charAt(0);
      String num03 = pass1.substring(1);
      Integer num3 = Integer.valueOf(num03);

      //give cards to the computer
      comp3.addCard(suit1, num1);
      comp3.addCard(suit2, num2);
      comp3.addCard(suit3, num3);
      //remove those cards from the player
      player.removeCard(suit1, num1);
      player.removeCard(suit2, num2);
      player.removeCard(suit3, num3);

      //computers passing cards as well

      //give cards from computer to the computer
      player.addCard(comp1.getCard(10).getSuit(), comp1.getCard(10).getNum());
      player.addCard(comp1.getCard(11).getSuit(), comp1.getCard(11).getNum());
      player.addCard(comp1.getCard(12).getSuit(), comp1.getCard(12).getNum());
      //remove those cards from the computer
      comp1.removeCard(comp1.getCard(10).getSuit(), comp1.getCard(10).getNum());
      comp1.removeCard(comp1.getCard(10).getSuit(), comp1.getCard(10).getNum());
      comp1.removeCard(comp1.getCard(10).getSuit(), comp1.getCard(10).getNum());

      //give cards from computer to the computer
      comp1.addCard(comp2.getCard(10).getSuit(), comp2.getCard(10).getNum());
      comp1.addCard(comp2.getCard(11).getSuit(), comp2.getCard(11).getNum());
      comp1.addCard(comp2.getCard(12).getSuit(), comp2.getCard(12).getNum());
      //remove those cards from the computer
      comp2.removeCard(comp2.getCard(10).getSuit(), comp2.getCard(10).getNum());
      comp2.removeCard(comp2.getCard(10).getSuit(), comp2.getCard(10).getNum());
      comp2.removeCard(comp2.getCard(10).getSuit(), comp2.getCard(10).getNum());

      //give cards from computer to the player
      comp2.addCard(comp3.getCard(10).getSuit(), comp3.getCard(10).getNum());
      comp2.addCard(comp3.getCard(11).getSuit(), comp3.getCard(11).getNum());
      comp2.addCard(comp3.getCard(12).getSuit(), comp3.getCard(12).getNum());
      //remove those cards from the computer
      comp3.removeCard(comp3.getCard(10).getSuit(), comp3.getCard(10).getNum());
      comp3.removeCard(comp3.getCard(10).getSuit(), comp3.getCard(10).getNum());
      comp3.removeCard(comp3.getCard(10).getSuit(), comp3.getCard(10).getNum());
        
      }else if(round == 2){
      System.out.println("pick 3 to pass across");
        for(int j = 0; j < 13; j++){
          System.out.print("[" + player.getCard(j).getSuit() + player.getCard(j).getNum() + "] ");
        }
        System.out.println();
        //choices
        String pass1 = input.nextLine();
        String pass2 = input.nextLine();
        String pass3 = input.nextLine();

        //substring it into the suit and number
        char suit1 = pass1.charAt(0);
        String num01 = pass1.substring(1);
        Integer num1 = Integer.valueOf(num01);
          
        char suit2 = pass1.charAt(0);
        String num02 = pass1.substring(1);
        Integer num2 = Integer.valueOf(num02);

        char suit3 = pass1.charAt(0);
        String num03 = pass1.substring(1);
        Integer num3 = Integer.valueOf(num03);

        //give cards to the computer
        comp2.addCard(suit1, num1);
        comp2.addCard(suit2, num2);
        comp2.addCard(suit3, num3);
        //remove those cards from the player
        player.removeCard(suit1, num1);
        player.removeCard(suit2, num2);
        player.removeCard(suit3, num3);

        //computers passing cards as well

      //give cards from computer to the computer
      comp3.addCard(comp1.getCard(10).getSuit(), comp1.getCard(10).getNum());
      comp3.addCard(comp1.getCard(11).getSuit(), comp1.getCard(11).getNum());
      comp3.addCard(comp1.getCard(12).getSuit(), comp1.getCard(12).getNum());
      //remove those cards from the computer
      comp1.removeCard(comp1.getCard(10).getSuit(), comp1.getCard(10).getNum());
      comp1.removeCard(comp1.getCard(10).getSuit(), comp1.getCard(10).getNum());
      comp1.removeCard(comp1.getCard(10).getSuit(), comp1.getCard(10).getNum());

      //give cards from computer to the computer
      player.addCard(comp2.getCard(10).getSuit(), comp2.getCard(10).getNum());
      player.addCard(comp2.getCard(11).getSuit(), comp2.getCard(11).getNum());
      player.addCard(comp2.getCard(12).getSuit(), comp2.getCard(12).getNum());
      //remove those cards from the computer
      comp2.removeCard(comp2.getCard(10).getSuit(), comp2.getCard(10).getNum());
      comp2.removeCard(comp2.getCard(10).getSuit(), comp2.getCard(10).getNum());
      comp2.removeCard(comp2.getCard(10).getSuit(), comp2.getCard(10).getNum());

      //give cards from computer to the player
      comp1.addCard(comp3.getCard(10).getSuit(), comp3.getCard(10).getNum());
      comp1.addCard(comp3.getCard(11).getSuit(), comp3.getCard(11).getNum());
      comp1.addCard(comp3.getCard(12).getSuit(), comp3.getCard(12).getNum());
      //remove those cards from the computer
      comp3.removeCard(comp3.getCard(10).getSuit(), comp3.getCard(10).getNum());
      comp3.removeCard(comp3.getCard(10).getSuit(), comp3.getCard(10).getNum());
      comp3.removeCard(comp3.getCard(10).getSuit(), comp3.getCard(10).getNum());
        
      }else if(round == 3){
        System.out.println("keep hand");
        //u dont give any cards away
      }

      //test that the hands dont pass around the same set of cards
      for(int j = 0; j < 13; j++){
          System.out.print("[" + player.getCard(j).getSuit() + player.getCard(j).getNum() + "] ");
        }

      //play begins with the 2 of clubs

      //search all hands to force out the 2 of clubs
      for(int j = 0; j < 13; j++){
        if(player.getCard(j).getSuit() == 'c' && player.getCard(j).getNum() == 2){
          play.addCard('c', 2);
          player.removeCard('c', 2);
        }
      }
      for(int j = 0; j < 13; j++){
        if(comp1.getCard(j).getSuit() == 'c' && comp1.getCard(j).getNum() == 2){
          play.addCard('c', 2);
          comp1.removeCard('c', 2);
        }
      }
      for(int j = 0; j < 13; j++){
        if(comp2.getCard(j).getSuit() == 'c' && comp2.getCard(j).getNum() == 2){
          play.addCard('c', 2);
          comp2.removeCard('c', 2);
        }
      }
      for(int j = 0; j < 13; j++){
        if(comp3.getCard(j).getSuit() == 'c' && comp3.getCard(j).getNum() == 2){
          play.addCard('c', 2);
          comp3.removeCard('c', 2);
        }
      }

  }

}

}