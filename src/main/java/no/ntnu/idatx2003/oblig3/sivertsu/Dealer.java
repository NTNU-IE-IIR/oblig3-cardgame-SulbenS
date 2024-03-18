package no.ntnu.idatx2003.oblig3.sivertsu;

/**
 * class that deals a hand of cards
 */
public class Dealer {
  private String hand;

  /**
   * deals a hand of 5 cards
   */
  public void dealHand() {
    DeckOfCards deck = new DeckOfCards();
    this.hand = "";
    for (int i = 0; i < 5; i++) {
      hand += deck.deal() + " ";
    }
    System.out.println("Hand: " + this.hand);
  }

  public String getHand() {
    return this.hand;
  }

}
