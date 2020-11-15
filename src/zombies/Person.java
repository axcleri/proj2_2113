package zombies;

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

  public abstract void move();

}