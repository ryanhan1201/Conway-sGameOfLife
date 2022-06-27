import javax.swing.JFrame;
class World {
	int[][] grid;
	static int[][] prevGen;
	//Initiallizing a Grid of 50 X 50 where we have 9 middle cells be alive
	/*
	 * Representing the grid in terms of ints where
	 * 1 = alive
	 * 0 = dead
	 */
	public final static int GRID_LENGTH = 50;
	public final static int GRID_WIDTH = 50;
	public World(){
		grid = new int[50][50];
		grid[24][24] = 1;
		grid[24][25] = 1;
		grid[24][23] = 1;
		grid[25][24] = 1;
		grid[23][24] = 1;
		grid[23][23] = 1;
		grid[23][25] = 1;
		grid[25][25] = 1;
		grid[25][23] = 1;
	}
	public void setPrevGen(int[][] grid) {
		prevGen = new int[GRID_LENGTH][GRID_WIDTH];
		for(int i = 0; i < GRID_LENGTH; i++) {
			prevGen[i] = grid[i].clone(); 
		}
	}
 	public boolean isAlive(int i, int j) {
		return prevGen[i][j] == 1;
	}
	public int countPerim(int i, int j) {
		int count = 0;
		for(int row = i - 1; i < i + 2; i++) {
			for(int col = j - 1; j < j + 2; j++) {
				if(row < 0) continue;
				if(col < 0) continue;
				if(row > GRID_LENGTH) continue;
				if(col > GRID_LENGTH) continue;
				if(row == i && col == j) continue;
				if(isAlive(row, col)) count++;
			}
		}
		return count;
	}
	public void setStatus(int i, int j, int status) {
		grid[i][j] = status;
	}
}	
public class main {

	
	public static void main(String[] args) {
		/*implement when done with Console outputs */
		//setup Graphic Output
		// GraphicOutput m = new GraphicOutput();
		// JFrame f = new JFrame();
		// f.add(m);
		World w = new World();
		printGrid(w.grid);
		
		int gen = 0;
		while(gen != 1000) { //run for 1000 generations
			w.setPrevGen(w.grid);

			//Use nested for loop to scan for each cell
			// int count_alive = 0;
			// int count_dead = 0;
			for(int i = 0; i < World.GRID_LENGTH; i++) {
				for(int j = 0; j < World.GRID_WIDTH; j++) {
					// if(w.isAlive(i,j)) {
					// 	// count_alive++;
					// }
					// else {
					// 	// count_dead++;
					// }
					int count = w.countPerim(i,j);

					//per cell need to check on the 4 conditions 
					if(w.isAlive(i, j)) {
						//check number of alive cells around it
						if(count < 2) {
							w.setStatus(i, j, 0);
						}
						else if(count == 2 || count == 3) {
							continue;
						}
						else if(count > 3) {
							w.setStatus(i, j, 0);
						}
					}
					else {
						if(count == 3) {
							w.setStatus(i, j, 1);
						}
					}
				}
			}
			gen++;
			// System.out.println(count_alive + " : " + count_dead);
		} 
		System.out.println("Done");


	}
	public static void printGrid(int[][] grid) {
		for(int i = 0; i < World.GRID_LENGTH; i++) {
			for(int j = 0; j < World.GRID_WIDTH; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-------------------------------------------------");
	}
}
