package no.ntnu.idatx2003.oblig3.sivertsu;

import java.util.ArrayList;
import java.util.Random;

public class DeckOfCards {
  private final char[] face = {1,2,3,4,5,6,7,8,9,10,11,12,13};
  private final char[] suits = { 'S', 'H', 'D', 'C' };
  private PlayingCard[] deck;

  /**
   * constructor for the deck of cards, that creates a deck of 52 cards
   */
  public DeckOfCards() {
    this.deck = new PlayingCard[52];
    int index = 0;
    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 13; j++) {
        this.deck[index] = new PlayingCard(suits[i], face[j]);
        index++;
      }
    }
  }

  /**
   * represent a dealer for cards, that gives 1 to 52 random card from the deck
   */
  public String deal() {
    Random random = new Random();
    int cardIndex = random.nextInt(52);
    System.out.println("Dealt card: " + this.deck[cardIndex].getAsString());

    return this.deck[cardIndex].getAsString();
  }
}