package world;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Driver class to check functionality.
 */
public class Driver {

  public static String filename;


  public static void setFilename(String file) {

    filename = file;
  }
  /**
  * main method.
  * @param args to take cmd input.
  */

  public static void main(String[] args) {
    filename = "C:\\Users\\Hp\\Desktop\\JAVA\\temp.txt";
    World world;
    Room room;
    Target target;
    try {
      world = new World(36, 30, 50);
      room = new Room(21, 20);
      target = new Target(21, 50, 0);
      System.out.println("Total rows : " + world.getTotalRows());
      System.out.println("Total columns : " + world.getTotalColumns());
      System.out.println("Total Health of Target : " + world.getTotalHealth());
      System.out.println("Name of mansion and Target : " + world.toString());
      System.out.println("Total rooms : " + room.getTotalRooms());
      System.out.println("Total items : " + room.getTotalItems());
      System.out.println("Get neighbors of space Dining Hall : "
          + room.getneighbours("Dining Hall"));
      System.out.println("Get list of items and their damage values for Kitchen : "
          + room.getitemdamage("Kitchen"));
      room.buildbufferimage();
      System.out.println("Get position of Target : " + target.getPosition());
      System.out.println("Get roomname of Target : " + target.getTargetroom(target.getPosition()));
      target.move();
      target.move();
      target.move();
      System.out.println("Get position of Target : " + target.getPosition());
      System.out.println("Get roomname of Target : " + target.getTargetroom(target.getPosition()));
    }  catch (IOException e) {
      e.printStackTrace();
    }
  }








}
