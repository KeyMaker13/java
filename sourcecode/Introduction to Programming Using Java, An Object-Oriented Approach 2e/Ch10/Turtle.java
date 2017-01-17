import java.io.*;
class Turtle {
    // Creates turtle in a world “size”-by-“size” squares
    public Turtle(int size) {
        world = new boolean[size][size];
        int i, j;
        for (i = 0; i < size; i++)
            for (j = 0; j < size; j++)
				world[i][j] = false;
        direction = NORTH;
        x = size / 2;
        y = size / 2;
    }
    // Move distance squares in the current direction.
    public void move(int distance) {
        int startX = this.x,
		startY = this.y;
        switch (direction) {
			case NORTH:
				this.y = Math.max(this.y - distance, 0);
				break;
			case SOUTH:
				this.y = Math.min(this.y + distance, 
								  world.length-1);
				break;
			case WEST:
				this.x = Math.max(this.x - distance, 0);
				break;
			case EAST:
				this.x = Math.min(this.x + distance, 
								  world.length-1);
				break;
        }
        if (penLowered)
			draw(startX, startY, this.x, this.y);
    }
    private void draw(int startX, int startY, int destX, 
					  int destY) {
        switch (direction) {
			case NORTH:
				for (int i = startY; i >= destY; i--)
					world[destX][i] = true;
				break;
			case SOUTH:
				for (int i = startY; i <= destY; i++)
					world[destX][i] = true;
				break;
			case WEST:
				for (int i = startX; i >= destX; i--)
					world[i][destY] = true;
				break;
			case EAST:
				for (int i = startX; i <= destX; i++)
					world[i][destY] = true;
				break;
        }
    }
    // Raises drawing pen
    public void penUp() {
        penLowered = false;  
    }
    // Lowers drawing pen
    public void penDown() {
        penLowered = true;   
    }
    // Turns left
    public void left() {
        switch (direction) {
			case NORTH:
				direction = WEST; break;
			case WEST:
				direction = SOUTH; break;
			case SOUTH:
				direction = EAST; break;
			case EAST:
				direction = NORTH; break;
        }
    }
    // Turns right
    public void right() {
        switch (direction) {
			case NORTH:
				direction = EAST; break;
			case EAST:
				direction = SOUTH; break;
			case SOUTH:
				direction = WEST; break;
			case WEST:
				direction = NORTH; break;
        }
    }
    public void display() { // Displays turtle’s world on System.out
        int i, j;
        for (i = 0; i < world.length; i++) {
            for (j = 0; j < world.length; j++)
                if (world[i][j])
                    System.out.print("*");
                else
                    System.out.print(" ");
			System.out.println();
        }
    }
    // Instance variables
    private boolean [][] world;
    private int x, y;
    private int direction;
    private boolean penLowered = true;
    // Static variables
    private static final int NORTH=0, EAST=1, SOUTH=2,WEST=3;
    public static void main(String [] args) {
        Turtle t = new Turtle(40);
        t.penUp();
        t.move(5);
        t.left();
        t.move(5);
        t.penDown();
        for (int i = 0; i < 4; i++) {
			t.move(10);
			t.left();
        }
        t.display();
    }
}
