public class Player implements PlayerInterface {

  double money;

  public Player(double startingCash) {
    money = startingCash;
  }

  public void setMoney(double x){
    money = x;
  }

  public void changeMoney(double x){
    money+=x;
  }
  
  public double getMoney() {
    return money;
  }
}