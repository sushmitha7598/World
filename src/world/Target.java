package world;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Target represented by totalhealth, totalrooms.
 */
public class Target {
  Model model2 = new Model();
  private int totalrooms;
  private int totalhealth;
  private int position;
  private ArrayList<String> rnames = new ArrayList<String>();

  /**
  * World constructor consists of totalrows,totalcolumns.
  *
  * @param totalrooms  represents total rooms.
  * @param totalhealth represents total health.
  * @param position represents current position of target.
  */

  public Target(int totalrooms, int totalhealth, int position) throws
      IllegalArgumentException, IOException {
    if (totalrooms < 0 || totalhealth < 0 || position < 0 || position > totalrooms) {
      throw new IllegalArgumentException("The value should not be negative");
    }
    model2.helper();
    this.totalrooms = model2.totalrooms;
    this.totalhealth = model2.totalhealth;
    this.rnames = model2.rnames;
    this.position = this.position;
  }
  /**
  This method is move the position of the target.
  */

  public void move() {
    position = position + 1;
    if (position == rnames.size()) {
      position = 0;
    }
  }

  public int getPosition() {
    return position;
  }

  public String getTargetroom(int position) {
    return rnames.get(this.position);
  }

}