package zombies;
import util.*;
import java.util.ArrayList;

public class Zombie extends Person{

  //zombie requires only variables from person class so only super() is needed in the constructor
  public Zombie(int x, int y, int dir, boolean[][] w)
    {
      super(x,y,dir,w);
    }
    //for directions, 0 is north, 1 is east, 2 is south, 3 is west

    //method to decide where and how the zombie will move depending on whether there are humans in sight or not
    public void move(ArrayList<Human> humanArrZ, ArrayList<Zombie> zombieArrZ)
    {
      //goes through human list to check for adjacency
      for(int i = 0; i < humanArrZ.size(); i++)
      {
        //if there is a human adjacent to the zombie turn human into zombie, then move
        if ((humanArrZ.get(i).getx() - this.xLoc < 2 && humanArrZ.get(i).getx() - this.xLoc > -2) && (humanArrZ.get(i).gety() - this.yLoc < 2 && humanArrZ.get(i).gety() - this.yLoc > -2) )
        {
          //removes human from human list and puts new zombie with human's parameters in zombie list
          Human temp = humanArrZ.get(i);
          humanArrZ.remove(i);
          Zombie temp1 = new Zombie(temp.getx(), temp.gety(), temp.getdir(), temp.getw());
          zombieArrZ.add(temp1);
        }
      }
      //check for humans within ten spaces
      for(int i = 0; i < humanArrZ.size(); i++)
      {
        //check for humans within ten spaces north
        if(this.direction == 0)
        {
          //check for whether the zombie can move north based on whether there's a wall and whether it'd move offscreen
          if((this.yLoc+1<cit[0].length)&&(cit[this.xLoc][this.yLoc+1] == false))
          {
            //check for humans within ten spaces
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
          //check for whether the zombie can move east based on whether there's a wall and whether it'd move offscreen
          if((this.xLoc+1<cit.length)&&(cit[this.xLoc+1][this.yLoc] == false))
          {
            //check for humans within ten spaces
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
          //check for whether the zombie can move south based on whether there's a wall and whether it'd move offscreen
          if((yLoc-1>=0)&&(cit[this.xLoc][this.yLoc-1] == false))
          {
            //check for humans within ten spaces
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
          //check for whether the zombie can move west based on whether there's a wall and whether it'd move offscreen
          if((xLoc-1>=0)&&(cit[this.xLoc-1][this.yLoc]==false))
          {
            //check for humans within ten spaces
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
      //check for whether the zombie can move north based on whether there's a wall and whether it'd move offscreen
      if((yLoc+1<cit[0].length)&&(cit[this.xLoc][this.yLoc+1] == false))
      {
        this.yLoc++;
      }
    }
    else if(this.direction == 1)
    {
      //check for whether the zombie can move east based on whether there's a wall and whether it'd move offscreen
      if((xLoc+1<cit.length)&&(cit[this.xLoc+1][this.yLoc] == false))
      {
        this.xLoc++;
      }
    }
    else if(this.direction == 2)
    {
      //check for whether the zombie can move south based on whether there's a wall and whether it'd move offscreen
      if((yLoc-1>=0)&&(cit[this.xLoc][this.yLoc-1] == false))
      {
        this.yLoc--;
      }
    }
    else
    {
      //check for whether the zombie can move west based on whether there's a wall and whether it'd move offscreen
      if((xLoc-1>=0)&&(cit[this.xLoc-1][this.yLoc]==false))
      {
        this.xLoc--;
      }
    }
  }
    
}