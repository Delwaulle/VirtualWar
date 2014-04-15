package gameWar;

public abstract class Cellule {

	protected int mine=0;
	protected int base=0;
	private boolean obstacle=false;
	Robot r;
	Coordonnee coord;
	
	public Cellule() {
		
	}
	
	public int estMine(){
		return this.mine;
	}
	
	public void placerMine (int equipe) {
		this.mine=equipe;
	}
	
	public int estBase () {
		return this.base;
	}
	
	public void placerBase(int equipe) {
		this.base=equipe;
	}
	
	public Coordonnee getCoordonnee() {
		return this.coord;
	}
	
	public boolean estObstacle() {
		return this.obstacle;
	}
	
	public void placerObstacle() {
		this.obstacle=true;
	}
	
	public Robot getContenu() {
		return this.r;
	}
	
	public String toString() {
		return "";
	}
	
	abstract void placerSur (Robot r);
	abstract void videCase();
}
