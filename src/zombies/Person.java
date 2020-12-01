package zombies;
import java.util.ArrayList;

public abstract class Person{
  protected int xLoc;
  protected int yLoc;
  protected int direction;
  protected boolean[][] cit;
  //for directions, 0 is north, 1 is east, 2 is south, 3 is west
  
  public Person(int x, int y, int dir, boolean[][] w)
  {
    this.xLoc = x;
    this.yLoc = y;
    this.direction = dir;
    this.cit = w;
  }

  //method to access xLoc
  public int getx()
  {
    return xLoc;
  }

  //method to access yLoc
  public int gety()
  {
    return yLoc;
  }

  //method to access direction
  public int getdir()
  {
    return direction;
  }

  //method to access walls
  public boolean[][] getw()
  {
    return cit;
  }

  public abstract void move(ArrayList<Human> humanArrZ, ArrayList<Zombie> zombieArrZ);

}