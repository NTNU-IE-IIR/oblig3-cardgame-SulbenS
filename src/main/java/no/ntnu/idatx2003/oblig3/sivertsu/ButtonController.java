package no.ntnu.idatx2003.oblig3.sivertsu;

public class ButtonController {

  private Dealer dealFunction;
  private TableTop tableTop;


  public ButtonController (TableTop theTableTop) {
    this.dealFunction = new Dealer();
    this.tableTop = theTableTop;
  }

  public void dealHand(){
    this.dealFunction.dealHand();
    this.tableTop.setHand(this.dealFunction.getHand());
  }

  public void sumOfHand(){
    this.dealFunction.sumOfHand();
    this.tableTop.setSum(this.dealFunction.getSum());
  }

  public void hasFlush(){
    this.dealFunction.hasFlush();
    this.tableTop.setFlush(this.dealFunction.hasFlush());
 }

  public void hasQueenOfSpades() {
    this.dealFunction.hasQueenOfSpades();
    this.tableTop.setQueenOfSpades(this.dealFunction.hasQueenOfSpades());
  }

  public void numberOfHearts() {
    this.dealFunction.numberOfHearts();
    this.tableTop.setNumberOfHearts(this.dealFunction.numberOfHearts());
  }
}
