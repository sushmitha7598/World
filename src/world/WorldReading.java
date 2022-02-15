package world;

/**
 * A WorldReading represents the various worlds that can be created
 * within the Doctor Lucky universe. Classes that implement this interface will vary depending
 * upon the type of world they created.
 */

public interface WorldReading {

  /**
  * Get the Total Number of rows in the world.
  * @return the totalrows
  */
  public int getTotalRows();

  /**
  * Get the Total Number of columns in the world.
  * @return the totalcolumns
  */
  public int getTotalColumns();

  /**
  * Get the Total Health of the Target in the world.
  * @return the totalhealth
  */
  public int getTotalHealth();


}
