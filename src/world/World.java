package world;

import java.io.IOException;

/**
 * World represented by totalrows,totalcolumns,totalhealth, name of world,name of target.
 */
public class World implements WorldReading {
  Model model = new Model();
  private int totalrows;
  private int totalcolumns;
  private int totalhealth;
  private String nworld;
  private String ntarget;
  /**
  * World constructor consists of totalrows,totalcolumns.
   * @param totalrows represents total rows.
   * @param totalcolumns represents total columns.
   * @param totalhealth represents total health.
  */

  public World(int totalrows, int totalcolumns, int totalhealth) throws
      IllegalArgumentException, IOException {
    if (totalrows < 0 || totalcolumns < 0 || totalhealth < 0) {
      throw new IllegalArgumentException("The value should be non negative");
    }

    //model.totalrows = this.totalrows;
    //model.totalcolumns = this.totalcolumns;
    //model.totalhealth = this.totalhealth;
    //model.worldname = this.nworld;
    //model.target = this.ntarget;
    model.helper();
    this.totalrows = model.totalrows;
    this.totalcolumns = model.totalcolumns;
    this.totalhealth = model.totalhealth;
    this.nworld = model.worldname;
    this.ntarget = model.target;
  }

  @Override
 public int getTotalRows()  {

    return totalrows;
  }

  @Override
  public int getTotalColumns() {

    return totalcolumns;
  }

  @Override
 public int getTotalHealth() {

    return totalhealth;
  }

  @Override
 public String toString() {
    String result = String.format("%s%s", nworld, ntarget);
    return result;
  }

  @Override
 public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof WorldReading)) {
      return false;
    }
    WorldReading that = (WorldReading) o;
    return this.getTotalRows() == that.getTotalRows();
  }

  @Override
  public int hashCode() {

    return Long.hashCode(this.getTotalHealth());
  }
}
