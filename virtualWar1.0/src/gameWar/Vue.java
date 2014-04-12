package gameWar;

public class Vue {

	Plateau plateau;
	int equipe;
	
	public Vue () {
		
	}
	
	public Vue (int equipe, Plateau p) {
		this.plateau=p;
		this.equipe=equipe;
	}
	
	public int getHauteur() {
		return this.plateau.HAUTEUR;
	}
	
	public int getLargeur() {
		return this.plateau.LARGEUR;
	}
	
	public void poserRobot(Robot r) {
		this.plateau.placerRobot(r);
	}
	
	public boolean estOK(Coordonnee c) {
		return c.getX() >= 0 && c.getX() < this.plateau.LARGEUR && c.getY() >=0 && c.getY() < this.plateau.HAUTEUR;
	}
	
	public boolean estBase(Coordonnee c) {
		return this.plateau.estBase(c.getX(), c.getY()) != 0;
	}
	
	public boolean estMine (Coordonnee c) {
		return this.plateau.estMine(c.getX(), c.getY()) != 0;
	}
	
	public boolean estLibre (Coordonnee c) {
		return this.plateau.estRobot(c.getX(), c.getY()) == null;
	}

}
