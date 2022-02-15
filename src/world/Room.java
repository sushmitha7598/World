package world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 * Room represented by totalrooms, totalitems.
 * rnames contains names of all the rooms in an ordered list.
 * everything hashmap, has key values as roomnames and Arraylist which has room dimensions
 * roomitemnames hashmap , has key values as roomnames , and Arraylist which has itemnames
 * damagevalue hashmap, has key value as itemname and value as damage caused
 */
public class Room {
  Model model1 = new Model();
  private int totalrooms;
  private int totalitems;
  private ArrayList<String> rnames = new ArrayList<String>();
  private HashMap<String, ArrayList<Integer>> everything
      = new HashMap<String, ArrayList<Integer>>();
  private Map<String, ArrayList<String>> roomitemnames = new HashMap<String, ArrayList<String>>();
  private Map<String, Integer> damagevalue = new HashMap<String, Integer>();

  /**
  * World constructor consists of totalrows,totalcolumns.
  * @param totalrooms represents total rooms.
  * @param totalitems represents total items.
  */
  public Room(int totalrooms, int totalitems) throws IllegalArgumentException, IOException {

    if (totalrooms < 0 || totalitems < 0) {
      throw new IllegalArgumentException("The value should not be negative");
    }

    model1.helper();
    this.everything = model1.everything;
    this.roomitemnames = model1.roomitemnames;
    this.damagevalue = model1.damagevalue;
    this.rnames = model1.rnames;
    this.totalrooms = model1.totalrooms;
    this.totalitems = model1.totalitems;

  }

  public int getTotalRooms() {

    return totalrooms;
  }

  public int getTotalItems() {

    return totalitems;
  }

  public  ArrayList<String> getneighbours(String rname) {

    return neighbours(rname);
  }

  private ArrayList<String> neighbours(String rname) {
    ///first stuff is the main room for whom we need neighbours
    List<Integer> dim = new ArrayList<Integer>();
    dim = everything.get(rname);
    int r1 = dim.get(0);
    int c1 = dim.get(1);
    int r2 = dim.get(2);
    int c2 = dim.get(3);
    ArrayList<String> neighbornames = new ArrayList<String>();
    for (String str : everything.keySet()) {
      List<Integer> dim1 = new ArrayList<Integer>();
      dim1 = everything.get(str);
      int confirm = 0;
      int confirm1 = 0;
      int rc1 = dim1.get(0);
      int cc1 = dim1.get(1);
      int cc2 = dim1.get(3);
      if (c1 == cc2 + 1) {
        confirm1 = confirm1 + 1;
      }
      if (rc1 == r2 + 1) {
        confirm = confirm + 1;
      }
      if (c1 == cc1 + 1) {
        confirm1 = confirm1 + 1;
      }
      int rc2 = dim1.get(2);
      if (r1 == rc2 + 1) {
        confirm = confirm + 1;
      }
      if (cc1 == c2 + 1) {
        confirm1 = confirm1 + 1;
      }

      for (int j = r1; j <= r2; j++) {
        for (int i = rc1; i <= rc2; i++) {
          if (i == j) {
            confirm = confirm + 1;
          }
        }
      }
      for (int j = c1; j <= c2; j++) {
        for (int i = cc1; i <= cc2; i++) {
          if (i == j) {
            confirm1 = confirm1 + 1;
          }
        }
      }
      if (confirm >= 1 && confirm1 >= 1) {
        if (str.equals(rname) == false) {
          neighbornames.add(str);
        }
      }
    }
    return neighbornames;
  }

  public Map<List<String>, List<Integer>> getitemdamage(String rname) {

    return getitems(rname);
  }

  private Map<List<String>, List<Integer>> getitems(String rname) {
    Map<List<String>, List<Integer>> onetoreturn = new HashMap<>();
    List<String> getitemnames = new ArrayList<String>();
    getitemnames = roomitemnames.get(rname);
    List<Integer> damage = new ArrayList<Integer>();
    for (int i = 0; i < getitemnames.size(); i++) {
      String s1 = getitemnames.get(i);
      damage.add(damagevalue.get(s1));
    }
    onetoreturn.put(getitemnames, damage);
    return onetoreturn;
  }
  /**
   This method prints buffer image.
   */

  public void buildbufferimage() {
    BufferedImage buf = new BufferedImage(1500, 1500,
        BufferedImage.TYPE_INT_RGB);
    Graphics graph = buf.getGraphics();
    for (String str : everything.keySet()) {
      List<Integer> dim1 = new ArrayList<Integer>();
      dim1 = everything.get(str);
      int r1 = dim1.get(0);
      int c1 = dim1.get(1);
      int r2 = dim1.get(2);
      int c2 = dim1.get(3);
      int heighrange = (c2 + 1 - c1) * 27;
      int rowrange = (r2 + 1 - r1) * 27;
      int d1 = r1 * 27;
      int d3 = c1 * 27;
      graph.drawRect(d3, d1, heighrange, rowrange);
      graph.drawString(str, d3 + 10, d1 + 10);
    }
    graph.drawImage(buf, 0, 0, null);
    File output = new File("C:\\Users\\Hp\\CS5010\\Projects\\World\\res\\mansion.png");
    try {
      ImageIO.write(buf, "png", output);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


}



