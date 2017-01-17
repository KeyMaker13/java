package pr1;

public interface BallHandler {
	
	public void hitLeftWall(Ball b);
	public void hitRightWall(Ball b);
	public void collided(Ball b1, Ball b2);
	public void handleBall(Ball b);
	public void handleTick();

}
