package zombies;
import util.Helper;

public class Human extends Person{
  
  public Human(int x, int y, int dir)
  {
    super(x,y,dir);
  }

  public void move()
  {
    int turn = Helper.nextInt(9);
    if(turn == 0)
    {
      this.direction = Helper.nextInt(3);
    }
    if (this.direction == 0)
    {
      if(walls[x][yLoc+1] == false)
      {
        this.yLoc++;
      }
    }
    else if (this.direction == 1)
    {
      this.xLoc++;
    }
    else if(this.direction == 2)
    {
      this.yLoc--;
    }
    else
    {
      this.xLoc--;
    }

  }
}