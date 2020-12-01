package zombies;
import util.*;
import java.util.ArrayList;

public class Human extends Person{

  //constructor only needs elements from Person class so only super() is needed
  public Human(int x, int y, int dir, boolean[][] w)
  {
    super(x,y,dir,w);
  }
  //for directions, 0 is north, 1 is east, 2 is south, 3 is west

  //method to access xloc
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

  //method to access the walls
  public boolean[][] getw()
  {
    return cit;
  }

  //method to decide where and how the human will move, depending on whether zombies are in sight or not
  public void move(ArrayList<Human> humanArrZ, ArrayList<Zombie> zombieArrZ)
  {
    //check for zombies within a ten space radius, if a zombie is found turn to opposite direction and move two spaces
    for(int i = 0; i < zombieArrZ.size(); i++)
    {
      //if the human is facing north and there is a zombie within ten spaces north
      if(this.direction == 0)
      {
          if((0 < (zombieArrZ.get(i).gety() - this.yLoc)) && ((zombieArrZ.get(i).gety() - this.yLoc) <= 10)&& (zombieArrZ.get(i).getx() == this.xLoc))
          {
            //if the human cannot run away from that zombie because of a wall/moving offscreen continue on to check for other zombies
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
            //if the human cannot run away from that zombie because of a wall/moving offscreen continue on to check for other zombies
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
          if((-10 < (zombieArrZ.get(i).gety() - this.yLoc)) && ((zombieArrZ.get(i).gety() - this.yLoc) <= 0) && (zombieArrZ.get(i).getx() == this.xLoc))
          {
            //if the human cannot run away from that zombie because of a wall/moving offscreen continue on to check for other zombies
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
          if((-10 < (zombieArrZ.get(i).getx() - this.xLoc)) && ((zombieArrZ.get(i).getx() - this.xLoc) <= 0) && (zombieArrZ.get(i).gety() == this.yLoc))
          {
            //if the human cannot run away from that zombie because of a wall/moving offscreen continue on to check for other zombies
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
    //if there are no zombies with ten spaces of the human the human will move using this code
    int turn = Helper.nextInt(10);
    if(turn == 0) //determines whether to turn or not, because getting 0 randomly out of 0-9 is a one in ten chance human has 10% chance of turning
    {
      this.direction = Helper.nextInt(4);
      
    }
    if(this.direction == 0)
    {
      //check for whether the human can move north based on whether there's a wall and whether it'd move offscreen
      if((yLoc+1<cit[0].length)&&(cit[this.xLoc][this.yLoc+1] == false))
      {
        this.yLoc++;
      }
    }
    else if(this.direction == 1)
    {
      //check for whether the human can move east based on whether there's a wall and whether it'd move offscreen
      if((xLoc+1<cit.length)&&(cit[this.xLoc+1][this.yLoc] == false))
      {
        this.xLoc++;
      }
    }
    else if(this.direction == 2)
    {
      //check for whether the human can move south based on whether there's a wall and whether it'd move offscreen
      if((yLoc-1>=0)&&(cit[this.xLoc][this.yLoc-1] == false))
      {
        this.yLoc--;
      }
    }
    else
    {
      //check for whether the human can move west based on whether there's a wall and whether it'd move offscreen
      if((xLoc-1>=0)&&(cit[this.xLoc-1][this.yLoc]==false))
      {
        this.xLoc--;
      }
    }

  }
}