package zombies;

import util.Helper;

import java.awt.Color;
import java.util.ArrayList;


public class City {

	/** walls is a 2D array with an entry for each space in the city.
	 *  If walls[x][y] is true, that means there is a wall in the space.
	 *  else the space is free. Humans should never go into spaces that
	 *  have a wall.
	 */
	protected boolean walls[][];
	private int width, height;
  protected ArrayList<Human> humanArr = new ArrayList<Human>();
  protected ArrayList<Zombie> zombieArr = new ArrayList<Zombie>();

	/**
	 * Create a new City and fill it with buildings and people.
	 * @param w width of city
	 * @param h height of city
	 * @param numB number of buildings
	 * @param numP number of people
	 */
	public City(int w, int h, int numB, int numP) {
		width = w;
		height = h;
		walls = new boolean[w][h];

		randomBuildings(numB);
		populate(numP);
	}


	/**
	 * Generates numPeople random people distributed throughout the city.
	 * People must not be placed inside walls!
	 *
	 * @param numPeople the number of people to generate
	 */
	private void populate(int numPeople)
	{
    int xl;
    int yl;
    //for loop to create numPeople new humans
    for(int i = 0; i < numPeople; i++)
    {
      xl = Helper.nextInt(width);
      yl = Helper.nextInt(height);
      //while loop makes sure a human won't spawn in a wall
      while(walls[xl][yl] == true)
      {
        xl = Helper.nextInt(width);
        yl = Helper.nextInt(height);
      }
      //create new human using coordinates with a random direction and add it to the arraylist of humans
      Human h = new Human(xl, yl, Helper.nextInt(3), walls);
      humanArr.add(h);
    }
    xl = Helper.nextInt(width);
    yl = Helper.nextInt(height);
    //makes sure the zombie doesn't spawn in a wall
    while(walls[xl][yl])
      {
        xl = Helper.nextInt(width);
        yl = Helper.nextInt(height);
      }
    //makes sure the zombie doesn't spawn on top of a human
    for(int i = 0; i<humanArr.size(); i++)
    {
      if((humanArr.get(i).getx() == xl) && (humanArr.get(i).gety() == yl))
      {
        xl = Helper.nextInt(width);
        yl = Helper.nextInt(height);
      }
    }
    //creates the zombie and adds it to the zombie arraylist with a random direction
    Zombie z = new Zombie(xl, yl, Helper.nextInt(3), walls);
    zombieArr.add(z);
	}


	/**
	 * Generates a random set of numB buildings.
	 *
	 * @param numB the number of buildings to generate
	 */
	private void randomBuildings(int numB) {
		/* Create buildings of a reasonable size for this map */
		int bldgMaxSize = width/6;
		int bldgMinSize = width/50;

		/* Produce a bunch of random rectangles and fill in the walls array */
		for(int i=0; i < numB; i++) {
			int tx, ty, tw, th;
			tx = Helper.nextInt(width);
			ty = Helper.nextInt(height);
			tw = Helper.nextInt(bldgMaxSize) + bldgMinSize;
			th = Helper.nextInt(bldgMaxSize) + bldgMinSize;

			for(int r = ty; r < ty + th; r++) {
				if(r >= height)
					continue;
				for(int c = tx; c < tx + tw; c++) {
					if(c >= width)
						break;
					walls[c][r] = true;
				}
			}
		}
	}

	/**
	 * Updates the state of the city for a time step.
	 */
	public void update() {
		//move all the humans first
		for(int i = 0; i<humanArr.size(); i++)
    {
      humanArr.get(i).move(humanArr, zombieArr);
	}
		//get current size of zombie array and use in for loop, if you don't do this zombies turned in this update will move and you can end up with all zombies the first run through
	int temp = zombieArr.size();
		//move all the zombies
    for(int m = 0; m<temp; m++)
	{
      zombieArr.get(m).move(humanArr, zombieArr);
    }
	}

	/**
	 * Draw the buildings and all humans.
	 */
	public void draw(){
		/* Clear the screen */
		ZombieSim.dp.clear(Color.black);

		drawWalls();
    drawHumans();
	}

	/**
	 * Draw the buildings.
	 * First set the color for drawing, then draw a dot at each space
	 * where there is a wall.
	 */
	private void drawWalls() {
		ZombieSim.dp.setPenColor(Color.DARK_GRAY);
		for(int r = 0; r < height; r++)
		{
			for(int c = 0; c < width; c++)
			{
				if(walls[c][r])
				{
					ZombieSim.dp.drawDot(c, r);
				}
			}
		}
	}

  private void drawHumans()
  {
    ZombieSim.dp.setPenColor(Color.LIGHT_GRAY);
    //draw the humans in light gray
    for(int i = 0; i<humanArr.size(); i++)
    {
      ZombieSim.dp.drawDot(humanArr.get(i).xLoc, humanArr.get(i).yLoc);
    }
    ZombieSim.dp.setPenColor(Color.RED);
    //draw the zombies in red
    for(int i = 0; i<zombieArr.size(); i++)
    {
      ZombieSim.dp.drawDot(zombieArr.get(i).xLoc, zombieArr.get(i).yLoc);
    }
  }

  protected void addZombie(int xl, int yl)
  {

  }

}
