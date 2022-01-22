public class Player implements PlayerInterface {

  int money;

  public Player(int startingCash) {
    money = startingCash;
  }

  public void setMoney(int x){
    money = x;
  }

  public void changeMoney(int x){
    money=+x;
  }
  
  public int getMoney() {
    return money;
  }
}