package zombies;
import util.*;
import java.util.ArrayList;

public class Zombie extends Person{

  public Zombie(int x, int y, int dir, boolean[][] w)
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
      //if there is a human adjacent to the zombie turn human into zombie
      for(int i = 0; i < humanArrZ.size(); i++)
      {
        if ((humanArrZ.get(i).getx() - this.xLoc < 2 && humanArrZ.get(i).getx() - this.xLoc > -2) && (humanArrZ.get(i).gety() - this.yLoc < 2 && humanArrZ.get(i).gety() - this.yLoc > -2) )
        {
          Human temp = humanArrZ.get(i);
          humanArrZ.remove(i);
          Zombie temp1 = new Zombie(temp.getx(), temp.gety(), temp.getdir(), temp.getw());
          zombieArrZ.add(temp1);
        }
      }
      //check for humans within ten spaces
      for(int i = 0; i < humanArrZ.size(); i++)
      {
        //if the zombie is facing north and there is a human within ten spaces north
        if(this.direction == 0)
        {
          if((this.yLoc+1<cit[0].length)&&(cit[this.xLoc][this.yLoc+1] == false))
          {
            if((0 < (humanArrZ.get(i).gety() - this.yLoc)) && ((humanArrZ.get(i).gety() - this.yLoc) <= 10)&& (humanArrZ.get(i).gety() == this.yLoc))
            {
              this.yLoc++;
              return;
            }

          }

        }
        //if the zombie is facing east and there is a human within ten spaces east
        else if (this.direction == 1)
        {
          if((this.xLoc+1<cit.length)&&(cit[this.xLoc+1][this.yLoc] == false))
          {
            if((0 <(humanArrZ.get(i).getx() - this.xLoc)) && ((humanArrZ.get(i).getx() - this.xLoc) <= 10) && (humanArrZ.get(i).gety() == this.yLoc))
            {
              this.xLoc++;
              return;
            }

          }

        }
        //if the zombie is facing south and there is a human within ten spaces south
        else if(this.direction == 2)
        {
          if((yLoc-1>=0)&&(cit[this.xLoc][this.yLoc-1] == false))
          {
            if((-10 < (humanArrZ.get(i).gety() - this.yLoc)) && ((humanArrZ.get(i).gety() - this.yLoc) <= 0) && (humanArrZ.get(i).getx() == this.xLoc))
            {
              this.yLoc--;
              return;
            }

          }


        }
        //if the zombie is facing west and there is a human within ten spaces west
        else
        {
          if((xLoc-1>=0)&&(cit[this.xLoc-1][this.yLoc]==false))
          {
            if((-10 < (humanArrZ.get(i).getx() - this.xLoc)) && ((humanArrZ.get(i).getx() - this.xLoc) <= 0) && (humanArrZ.get(i).gety() == this.yLoc))
            {
              this.xLoc--;
              return;
            }

          }

        }
      }
    //if there are no humans within ten spaces zombie moves normally, 20% chance of turning
    int turn = Helper.nextInt(5);
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