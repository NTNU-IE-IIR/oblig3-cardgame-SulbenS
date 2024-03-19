package no.ntnu.idatx2003.oblig3.sivertsu;

/**
 * class that deals a hand of cards
 */
public class Dealer {
  private String hand;
  private int sum;

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

  /**
   * get the sum of the 5 cards in the hand that has been dealt
   */
  public void sumOfHand() {
    String[] cards = this.hand.split(" ");
    int sum = 0;
    for (String card : cards) {
      sum += Integer.parseInt(card.substring(1));
    }
    this.sum = sum;
  }

  /**
   * show true if the hand has a flush
   */
  public boolean hasFlush() {
    String[] cards = this.hand.split(" ");
    char suit = cards[0].charAt(0);
    for (String card : cards) {
      if (card.charAt(0) != suit) {
        return false;
      }
    }
    return true;
  }

  public int getSum() {
    return this.sum;
  }

  public boolean hasQueenOfSpades() {
    String[] cards = this.hand.split(" ");
    for (String card : cards) {
      if (card.equals("S12")) {
        return true;
      }
    }
    return false;
  }

  public int numberOfHearts() {
    String[] cards = this.hand.split(" ");
    int numberOfHearts = 0;
    for (String card : cards) {
      if (card.charAt(0) == 'H') {
        numberOfHearts++;
      }
    }
    return numberOfHearts;
  }
}
