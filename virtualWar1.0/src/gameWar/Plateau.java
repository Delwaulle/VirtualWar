package gameWar;

public class Plateau {

	static final int HAUTEUR = 10;
	static final int LARGEUR = 5;
	boolean fini = false;
	Cellule[][] grille;
	
	public Plateau() {
		grille=new Cellule[HAUTEUR][LARGEUR];
		for (int i=0; i<grille.length; i++) {
			for (int j=0; j<grille[0].length; j++) {
				grille[i][j]=new Case();
			}
		}
		
	}
	
	public int estMine (int x, int y) {
		return grille[x][y].estMine();
	}
	
	public int estBase (int x, int y) {
		return grille[x][y].estBase();
	}
	
	public Robot estRobot (int x, int y) {
		return grille[x][y].getContenu();
	}
	
	public void placerMine (int x, int y, int equipe) {
		grille[x][y].placerMine(equipe);
	}
	
	public void placerBase (int x, int y, int equipe) {
		grille[x][y].placerBase(equipe);
	}
	
	public void placerRobot(Robot r) {
		grille[r.getCoordonnee().getX()][r.getCoordonnee().getY()].placerSur(r);
	}
	
	public void setLibre(int x, int y) {
		grille[x][y].videCase();
	}
	
	public boolean plateauValide() {
		boolean[][] p = new boolean[this.HAUTEUR][this.LARGEUR];
		for (int i=0; i<p.length; i++) {
			for (int j=0; j<p[0].length; j++){
				if (i==0 && j==0)
					p[i][j]=true;
				else
					p[i][j]=false;
			}
		}
		return parcourtValide(p, 0, 0);
	}
			
	public boolean parcourtValide(boolean[][] p, int x, int y) {
		if (p[this.HAUTEUR-1][this.LARGEUR-1])
			return true;
		
		// DROITE
		else if (y!=this.LARGEUR-1 && !this.grille[x][y+1].estObstacle()) {
			p[x][y+1]=true;
			if (parcourtValide(p, x, y+1))
					return true;
		}
		
		// BAS
		else if (x!=0 && !this.grille[x-1][y].estObstacle()) {
			p[x-1][y]=true;
			if (parcourtValide(p, x-1, y))
				return true;
		}
		
		// GAUCHE
		else if (y!=0 && !this.grille[x][y-1].estObstacle()) {
			p[x][y-1]=true;
			if (parcourtValide(p, x, y-1))
				return true;
		}
		
		// HAUT
		else if (x!=this.HAUTEUR-1 && !this.grille[x+1][y].estObstacle()) {
			p[x+1][y]=true;
			if (parcourtValide(p, x+1, y))
				return true;
		}		
		return false;
	}
}
