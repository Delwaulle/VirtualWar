package gameWar;

public class Plateau {

	final int HAUTEUR = 10;
	final int LARGEUR = 5;
	boolean fini = false;
	Cellule[][] grille;
	
	public Plateau() {
		grille=new Cellule[HAUTEUR][LARGEUR];
		for (int i=0; i<grille.length; i++) {
			for (int j=0; j<grille[0].length; j++) {
				if (i==0 && j==0)
					grille[i][j]=new Base(1);
				else if (i==this.HAUTEUR-1 && j==this.LARGEUR-1)
					grille[i][j]=new Base(2);
				else
					grille[i][j]=new Case();
			}
		} 
		
	}
	// test
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
		else if (y!=this.LARGEUR-1 && !this.grille[x][y+1].estObstacle() && !p[x][y+1]) {
			System.out.print("droite");
			p[x][y+1]=true;
			return parcourtValide(p, x, y+1);
		}
		// BAS
		else if (x!=this.HAUTEUR-1 && !this.grille[x+1][y].estObstacle() && !p[x+1][y]) {
			System.out.print("bas");
			p[x+1][y]=true;
			return parcourtValide(p, x+1, y);
		}
		// GAUCHE
		else if (y!=0 && !this.grille[x][y-1].estObstacle() && !p[x][y-1]) {
			System.out.print("gauche");
			p[x][y-1]=true;
			return parcourtValide(p, x, y-1);
		} 
		// HAUT
		 else if (x!=this.HAUTEUR+1 && !this.grille[x+1][y].estObstacle() && !p[x+1][y]) {
			System.out.print("haut");
			p[x+1][y]=true;
			return parcourtValide(p, x+1, y);
		} 
		return false;
	}
	
	public String toString() {
		String s = "+";
		for (int i=0; i<this.LARGEUR; i++)
			s=s+"---+";
		
		for (int i=0; i<this.HAUTEUR; i++) {
			s=s+"\n|";
			for (int j=0; j<this.LARGEUR; j++) {
				if (this.grille[i][j].estBase()==1)
					s=s+" B |";
				else if (this.grille[i][j].estBase()==2)
					s=s+" b |";
				else if (this.grille[i][j].estMine()==1)
					s=s+" X |";
				else if (this.grille[i][j].estMine()==2)
					s=s+" x |";
				else if (this.grille[i][j].getContenu() instanceof Tireur) {
					if (this.grille[i][j].getContenu().getEquipe()==1)
						s=s+" T |";
					else
						s=s+" t |";
				} else if (this.grille[i][j].getContenu() instanceof Piegeur) {
					if (this.grille[i][j].getContenu().getEquipe()==1)
						s=s+" P |";
					else
						s=s+" p |";
				} else 
					s=s+"   |";
				
			} 
			s = s+"\n+";
			for (int j=0; j<this.LARGEUR; j++)
				s=s+"---+";
		}
		
		return s;
	}
}
