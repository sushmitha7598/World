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
 * MODEL represented by totalrows,totalcolumns, totalhealth, totalitems, totalrooms
 * MODEL represented by worldname and target.
 */
public class Model {
  int totalrows;
  int totalcolumns;
  int totalhealth;
  int totalitems;
  int totalrooms;
  String worldname;
  String target;
  ArrayList<String> al = new ArrayList<String>();
  ArrayList<String> rnames = new ArrayList<String>(); //arraylist which stores only roomnaes
  ArrayList<Integer> dimensions = new ArrayList<Integer>();
  HashMap<String, ArrayList<Integer>> everything = new HashMap<String, ArrayList<Integer>>();
  Map<String, ArrayList<String>> roomitemnames = new HashMap<String, ArrayList<String>>();
  Map<String, Integer> damagevalue = new HashMap<String, Integer>();
  ArrayList<Integer> itemroom = new ArrayList<Integer>();
  ArrayList<Integer> damage = new ArrayList<Integer>();
  ArrayList<String> itemname = new ArrayList<String>();

  /**
  * helper method helps in calculating values.
  */
  public void helper() throws IOException {

    File fr = new File("C:\\Users\\Hp\\Desktop\\JAVA\\temp.txt");
    FileReader frr = new FileReader(fr);
    BufferedReader br = new BufferedReader(frr);
    String line;
    while ((line = br.readLine()) != null) {
      al.add(line);
    }
    String[] first = al.get(0).split(" ");
    worldname = " ";
    totalrows = Integer.parseInt(first[0]);
    totalcolumns = Integer.parseInt(first[1]);
    for (int i = 2; i < first.length; i++) {
      worldname = worldname + first[i];
    }

    target = "";
    String[] second = al.get(1).split(" ");
    totalhealth = Integer.parseInt(second[0]);
    for (int i = 1; i < second.length; i++) {
      target = target + second[i];
    }
    totalrooms = Integer.parseInt(al.get(2));
    for (int i = 3; i < totalrooms + 3; i++) {
      String temp = al.get(i);
      temp = temp.trim();
      temp = temp.replaceAll("  ", " ");
      String[] help = temp.split(" ");
      ArrayList<Integer> t = new ArrayList<Integer>();
      for (int k = 0; k < 4; k++) {
        int x = Integer.parseInt(help[k]);
        dimensions.add(x);
        t.add(x);
      }
      if (help.length != 5) {
        String rn = help[4] + " ";
        for (int j = 5; j < help.length; j++) {
          rn = rn + help[j];
        }
        rnames.add(rn);
        everything.put(rn, t);
      } else {
        rnames.add(help[4]);
        everything.put(help[4], t);
      }
    }
    totalitems = Integer.parseInt(al.get(totalrooms + 3));
    int itemstart = totalrooms + 3;
    for (int i = itemstart + 1; i < al.size(); i++) {
      String temp = al.get(i);
      String[] help = temp.split(" ");
      int z = Integer.parseInt(help[0]);
      int y = Integer.parseInt(help[1]);
      itemroom.add(z);
      damage.add(y);
      if (help.length != 3) {
        String rn = help[2] + " ";
        for (int j = 3; j < help.length; j++) {
          rn = rn + help[j];
        }
        itemname.add(rn);
      } else {
        itemname.add(help[2]);
      }
    }
    for (int i = 0; i < rnames.size(); i++) {
      ArrayList<String> f = new ArrayList<String>();
      for (int j = 0; j < itemroom.size(); j++) {
        if (i == itemroom.get(j)) {
          f.add(itemname.get(j));
        }
      }
      roomitemnames.put(rnames.get(i), f);
    }

    for (int i = 0; i < damage.size(); i++) {
      damagevalue.put(itemname.get(i), damage.get(i));
    }
  }
}



