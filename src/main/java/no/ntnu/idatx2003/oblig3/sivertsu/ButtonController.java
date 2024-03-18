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
}
