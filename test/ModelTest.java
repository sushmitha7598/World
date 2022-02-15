import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import world.Room;
import world.Target;
import world.World;

/**
 * A JUnit test class for the Model Class.
 */

public class ModelTest {
  private World worldtest;
  private Room roomtest;
  private Target targettest;

  /**
  * Setting up the objects.
  **/

  @Before

 public void setUp() throws IOException {
    worldtest = new World(36, 30, 50);
    roomtest = new Room(21, 20);
    targettest = new Target(21, 50, 0);
  }

  @Test
 public void testgettotalrows() {

    assertEquals(36, worldtest.getTotalRows());
  }

  @Test(expected = IllegalArgumentException.class)
 public void testinvalidrows() throws IOException {
    World w = new World(-23, 12, 14);
    assertEquals(-23, w.getTotalRows());
  }

  @Test
 public void testgettotalcolumns() {

    assertEquals(30, worldtest.getTotalColumns());
  }

  @Test(expected = IllegalArgumentException.class)
 public void testinvalidcolumns() throws IOException {
    World w = new World(23, -12, 14);
    assertEquals(-12, w.getTotalColumns());
  }

  @Test
 public void testgettotalhealth() {

    assertEquals(50, worldtest.getTotalHealth());
  }

  @Test(expected = IllegalArgumentException.class)
 public void testinvalidhealth() throws IOException {
    World w = new World(23, 12, -14);
    assertEquals(-14, w.getTotalColumns());
  }

  @Test
 public void testtoString() {
    assertEquals(" DoctorLucky'sMansionDoctorLucky", worldtest.toString());
  }

  @Test
 public void testgettotalrooms() {

    assertEquals(21, roomtest.getTotalRooms());
  }

  @Test(expected = IllegalArgumentException.class)
 public void testinvalidrow() throws IOException {
    Room r = new Room(-23, 12);
    assertEquals(-23, r.getTotalRooms());
  }

  @Test
  public void testgettotalitems() {

    assertEquals(20, roomtest.getTotalItems());
  }

  @Test(expected = IllegalArgumentException.class)
 public void testinvaliditems() throws IOException {
    Room r = new Room(23, -12);
    assertEquals(-12, r.getTotalRooms());
  }

  @Test
 public void testgetneighbors() {
    ArrayList<String> answers = new ArrayList<String>();
    answers.add("Master Suite");
    answers.add("Library");
    assertEquals(answers, roomtest.getneighbours("Nursery"));
  }

  @Test
 public void testgetneighborsanotherroom() {
    ArrayList<String> answers = new ArrayList<String>();
    answers.add("Tennessee Room");
    answers.add("Trophy Room");
    answers.add("Kitchen");
    answers.add("Drawing Room");
    answers.add("Armory");
    answers.add("Billiard Room");
    answers.add("Parlor");
    answers.add("Wine Cellar");
    assertEquals(answers, roomtest.getneighbours("Dining Hall"));
  }

  @Test
  public void testgetitems() {
    Map<List<String>, List<Integer>> answers = new HashMap<>();
    List<String> itemname = new ArrayList<String>();
    List<Integer> damagevalue = new ArrayList<Integer>();
    itemname.add("Bad Cream");
    damagevalue.add(2);
    answers.put(itemname, damagevalue);
    assertEquals(answers, roomtest.getitemdamage("Nursery"));
  }

  @Test
 public void testgetPosition() {
    assertEquals(0, targettest.getPosition());
    targettest.move();
    targettest.move();
    assertEquals(1, targettest.getPosition());
  }

  @Test(expected = IllegalArgumentException.class)
 public void testinvalidposition() throws IOException {
    Target r = new Target(23, 12, -2);
    assertEquals(-2, r.getPosition());
  }

  @Test
 public void testgetTargetroomname() {
    assertEquals("Armory", targettest.getTargetroom(targettest.getPosition()));
    //targettest.move();
    //targettest.move();
    //targettest.move();
    //assertEquals("Dining Hall", targettest.getTargetroom(targettest.getPosition()));
    for (int i = 0; i < 21; i++) {
      targettest.move();
    }
    assertEquals(0, targettest.getPosition());
  }

  @Test(expected = IllegalArgumentException.class)
 public void testinvalidtargetroom() throws IOException {
    Target r = new Target(23, 12, 50);
    assertEquals(50, r.getTargetroom(50));
  }
}
