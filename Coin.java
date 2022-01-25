import java.util.*;


public class Coin {
  private int num;
  Random r = new Random();

  public int flip(){
    this.num = r.nextInt(2);
    return this.num;
  }

}