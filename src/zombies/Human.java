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
    //check for zombies within a ten space radius
    for(int i = 0; i < zombieArrZ.size(); i++)
    {
      //if the human is facing north and there is a zombie within ten spaces north
      if(this.direction == 0)
      {
          if((0 < (zombieArrZ.get(i).gety() - this.yLoc)) && ((zombieArrZ.get(i).gety() - this.yLoc) <= 10)&& (humanArrZ.get(i).getx() == this.xLoc))
          {
            //if the human cannot run away from that zombie because of a wall continue on to check for other zombies
            //if the human can run away turn and move two spaces in other direction
            if((this.yLoc-2>=0)&&(cit[this.xLoc][this.yLoc-2]==false))
            {
              this.direction = 2;
              this.yLoc-=2;
              return;
            }
          }
      }
      //if the human is facing east and there is a zombie within ten spaces east
      else if (this.direction == 1)
      {
          if((0 <(zombieArrZ.get(i).getx() - this.xLoc)) && ((zombieArrZ.get(i).getx() - this.xLoc) <= 10) && (zombieArrZ.get(i).gety() == this.yLoc))
          {
            //if the human cannot run away from that zombie because of a wall continue on to check for other zombies
            //if the human can run away turn and move two spaces in other direction
            if((this.xLoc-2>=0)&&(cit[this.xLoc-2][this.yLoc]==false))
            {
              this.direction = 3;
              this.xLoc-=2;
              return;
            }
          }
      }
      //if the human is facing south and there is a zombie within ten spaces south
      else if(this.direction == 2)
      {
          if((-10 < (zombieArrZ.get(i).gety() - this.yLoc)) && ((zombieArrZ.get(i).gety() - this.yLoc) <= 0) && (humanArrZ.get(i).getx() == this.xLoc))
          {
            //if the human cannot run away from that zombie because of a wall continue on to check for other zombies
            //if the human can run away turn and move two spaces in other direction
            if((this.yLoc+2<cit[0].length)&&(cit[this.xLoc][this.yLoc+2]==false))
            {
              this.direction = 0;
              this.yLoc+=2;
              return;
            }
          }
      }
      //if the human is facing west and there is a zombie within ten spaces west
      else
      {
          if((-10 < (zombieArrZ.get(i).getx() - this.xLoc)) && ((zombieArrZ.get(i).getx() - this.xLoc) <= 0) && (humanArrZ.get(i).gety() == this.yLoc))
          {
            //if the human cannot run away from that zombie because of a wall continue on to check for other zombies
            //if the human can run away turn and move two spaces in other direction
            if((this.xLoc+2<cit.length)&&(cit[this.xLoc+2][this.yLoc]==false))
            {
              this.direction = 1;
              this.xLoc+=2;
              return;
            }
          }
      }
    }
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