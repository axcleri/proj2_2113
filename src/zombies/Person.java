package zombies;

public abstract class Person{
  protected int xLoc;
  protected int yLoc;
  protected int direction;
  //for directions, 0 is north, 1 is east, 2 is south, 3 is west
  
  public Person(int x, int y, int dir)
  {
    this.xLoc = x;
    this.yLoc = y;
    this.direction = dir;
  }

  public abstract void move();

}