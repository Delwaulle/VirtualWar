package gameWar;

public class Coordonnee {

	private int x;
	private int y;
	
	public Coordonnee (int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public Coordonnee ajouter (Coordonnee coord) {
		return new Coordonnee(this.x+coord.getX(), this.y+coord.getY());
	}
	
	public String toString() {
		return "";
	}
}
