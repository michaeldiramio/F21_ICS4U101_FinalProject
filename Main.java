import DLibX.*;

public class Main {

  public static void main(String[] args) {

    //I know you guys were testing things in main but this is actual code that sticks to the final product now so get rid of your testing code before commiting now please :)
    DConsole dc = new DConsole(450, 300);
    Quickselect qs = new Quickselect();

    for (;;) {
      dc.clear();

      //Draws the menu screen
      qs.printMenu(dc);

      //Checks that boxes are clicked
      qs.checkClicks(dc);

      //Needed for DConsole
      dc.redraw();        
      dc.pause(20);
    
      }
    }
  }

