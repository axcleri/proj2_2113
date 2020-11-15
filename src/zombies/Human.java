package zombies;
import util.*;

public class Human extends Person{
  
  public Human(int x, int y, int dir, boolean[][] w)
  {
    super(x,y,dir,w);
  }

  public void move()
  {
    int turn = Helper.nextInt(9);
    if(turn == 0)
    {
      this.direction = Helper.nextInt(3);
      
    }
    if(this.direction == 0)
    {
      if((yLoc+1<cit[0].length)&&(cit[this.xLoc][this.yLoc+1] == false))
      {
        ZombieSim.dp.setPenColor(DotPanel.BLACK);
        ZombieSim.dp.drawDot(this.xLoc, this.yLoc);
        this.yLoc++;
        ZombieSim.dp.setPenColor(DotPanel.LIGHT_GRAY);
        ZombieSim.dp.drawDot(this.xLoc, this.yLoc);
      }
    }
    else if(this.direction == 1)
    {
      if((xLoc+1<cit.length)&&(cit[this.xLoc+1][this.yLoc] == false))
      {
        ZombieSim.dp.setPenColor(DotPanel.BLACK);
        ZombieSim.dp.drawDot(this.xLoc, this.yLoc);
        this.xLoc++;
        ZombieSim.dp.setPenColor(DotPanel.LIGHT_GRAY);
        ZombieSim.dp.drawDot(this.xLoc, this.yLoc);
      }
    }
    else if(this.direction == 2)
    {
      if((yLoc-1>=0)&&(cit[this.xLoc][this.yLoc-1] == false))
      {
        ZombieSim.dp.setPenColor(DotPanel.BLACK);
        ZombieSim.dp.drawDot(this.xLoc, this.yLoc);
        this.yLoc--;
        ZombieSim.dp.setPenColor(DotPanel.LIGHT_GRAY);
        ZombieSim.dp.drawDot(this.xLoc, this.yLoc);
      }
    }
    else
    {
      if((xLoc-1>=0)&&(cit[this.xLoc-1][this.yLoc]==false))
      {
        ZombieSim.dp.setPenColor(DotPanel.BLACK);
        ZombieSim.dp.drawDot(this.xLoc, this.yLoc);
        this.xLoc--;
        ZombieSim.dp.setPenColor(DotPanel.LIGHT_GRAY);
        ZombieSim.dp.drawDot(this.xLoc, this.yLoc);
      }
    }

  }
}