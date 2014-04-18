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
				if (i==0 && j==0)
					grille[i][j]=new Base(1);
				else if (i==HAUTEUR-1 && j==LARGEUR-1)
					grille[i][j]=new Base(2);
				else
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
	
	public Robot getRobot (int x, int y) {
		return grille[x][y].getContenu();
	}
	
	public Robot getRobot (int equipe) {
		for (int i=0; i<HAUTEUR; i++) {
			for (int j=0; j<LARGEUR; j++) {
				if (this.grille[i][j].getContenu()!=null && this.grille[i][j].getContenu().getEquipe() == equipe)
					return this.grille[i][j].getContenu();
			}
		}
		return null;
	}
	
	public void placerMine (int x, int y, int equipe) {
		grille[x][y].placerMine(equipe);
	}
	
	public void retirerMine(int x, int y) {
		grille[x][y].placerMine(0);
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
		boolean[][] p = new boolean[HAUTEUR][LARGEUR];
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

		if (p[HAUTEUR-1][LARGEUR-1])
			return true;
		// DROITE
		else if (y!=LARGEUR-1 && !this.grille[x][y+1].estObstacle() && !p[x][y+1]) {
			System.out.print("droite");
			p[x][y+1]=true;
			return parcourtValide(p, x, y+1);
		}
		// BAS
		else if (x!=HAUTEUR-1 && !this.grille[x+1][y].estObstacle() && !p[x+1][y]) {
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
		 else if (x!=HAUTEUR+1 && !this.grille[x+1][y].estObstacle() && !p[x+1][y]) {
			System.out.print("haut");
			p[x+1][y]=true;
			return parcourtValide(p, x+1, y);
		} 
		return false;
	}
	
	public String toString(int equipe) {
		String s = "+";
		for (int i=0; i<LARGEUR; i++)
			s=s+"---+";
		
		for (int i=0; i<HAUTEUR; i++) {
			s=s+"\n|";
			for (int j=0; j<LARGEUR; j++) {
				if (this.grille[i][j].estMine()==equipe)
					s=s+" X |";
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
				} else if(this.grille[i][j].estBase()==1)
					s=s+" B |";
				else if (this.grille[i][j].estBase()==2)
					s=s+" b |";
				else 
					s=s+"   |";
			} 
			s = s+"\n+";
			for (int j=0; j<LARGEUR; j++)
				s=s+"---+";
		}
		s=s+"\n";		
		return s;
	}
}
