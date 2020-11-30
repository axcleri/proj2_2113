package zombies;
import util.*;
import java.util.ArrayList;

public class Human extends Person{
  
  public Human(int x, int y, int dir, boolean[][] w)
  {
    super(x,y,dir,w);
  }
  //for directions, 0 is north, 1 is east, 2 is south, 3 is west

  public int getx()
  {
    return xLoc;
  }

  public int gety()
  {
    return yLoc;
  }

  public int getdir()
  {
    return direction;
  }

  public boolean[][] getw()
  {
    return cit;
  }

  public void move(ArrayList<Human> humanArrZ, ArrayList<Zombie> zombieArrZ)
  {
    int turn = Helper.nextInt(10);
    if(turn == 0)
    {
      this.direction = Helper.nextInt(4);
      
    }
    if(this.direction == 0)
    {
      if((yLoc+1<cit[0].length)&&(cit[this.xLoc][this.yLoc+1] == false))
      {
        this.yLoc++;
      }
    }
    else if(this.direction == 1)
    {
      if((xLoc+1<cit.length)&&(cit[this.xLoc+1][this.yLoc] == false))
      {
        this.xLoc++;
      }
    }
    else if(this.direction == 2)
    {
      if((yLoc-1>=0)&&(cit[this.xLoc][this.yLoc-1] == false))
      {
        this.yLoc--;
      }
    }
    else
    {
      if((xLoc-1>=0)&&(cit[this.xLoc-1][this.yLoc]==false))
      {
        this.xLoc--;
      }
    }

  }
}