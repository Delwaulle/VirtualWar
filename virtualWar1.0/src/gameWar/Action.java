package gameWar;

public abstract class Action {
	
	int i;
	private Robot robot;
	private Coordonnee coordonnee;

	public Action (Robot r, int i) {
		this.i=i;
		this.robot=r;
	}
	
	public Robot getRobot() {
		return robot;
	}
	
	public Coordonnee getDirection() {
		return coordonnee;
	}
	
	abstract void agit();
}
