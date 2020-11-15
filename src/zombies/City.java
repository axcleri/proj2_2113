package zombies;

import util.Helper;

import java.awt.Color;


public class City {

	/** walls is a 2D array with an entry for each space in the city.
	 *  If walls[x][y] is true, that means there is a wall in the space.
	 *  else the space is free. Humans should never go into spaces that
	 *  have a wall.
	 */
	private boolean walls[][];
	private int width, height;
  private Human[] humanArr;

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
    humanArr = new Human[numP];

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
    for(int i = 0; i < numPeople; i++)
    {
      int xl = Helper.nextInt(width);
      int yl = Helper.nextInt(height);
      while(walls[xl][yl] == true)
      {
        xl = Helper.nextInt(width);
        yl = Helper.nextInt(height);
      }
      humanArr[i] = new Human(xl, yl, Helper.nextInt(3), walls);
      //then draw humanArr[i]
      ZombieSim.dp.setPenColor(Color.PINK);
      ZombieSim.dp.drawDot(xl, yl);
    }
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
		for(int i = 0; i<humanArr.length; i++)
    {
      humanArr[i].move();
    }
	}

	/**
	 * Draw the buildings and all humans.
	 */
	public void draw(){
		/* Clear the screen */
		ZombieSim.dp.clear(Color.black);

		drawWalls();
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

}
