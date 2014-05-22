package gameWar;

import java.util.Random;

public class Plateau {

	static final int HAUTEUR = 10;
	static final int LARGEUR = 10;
	final double TAUXOBSTACLES = 0;
	boolean fini = false;
	Cellule[][] grille;
	
	public Plateau() {
		grille=new Cellule[HAUTEUR][LARGEUR];
		this.initPlateau();
		this.placerObstacles();
		while (!this.plateauValide()) {
			this.initPlateau();
			this.placerObstacles();
		}
	}
	
	public int estMine (int x, int y) {
		return grille[x][y].estMine();
	}
	
	public int estBase (int x, int y) {
		return grille[x][y].estBase();
	}
	
	public Robot getContenu (int x, int y) {
		return grille[x][y].getContenu();
	}
	
	public Robot getRobot (int equipe, int num) {
		for (int i=0; i<HAUTEUR; i++) {
			for (int j=0; j<LARGEUR; j++) {
				if (this.grille[i][j].getRobot(equipe, num)!=null)
					return this.grille[i][j].getRobot(equipe, num);
			}
		}
		return null;
	}
	
	private void placerObstacles () {
		int obstacles = 0;
		int x, y;
		Random rm = new Random();
		while (obstacles != (Plateau.HAUTEUR*Plateau.LARGEUR)*this.TAUXOBSTACLES) {
			x=rm.nextInt(Plateau.HAUTEUR);
			y=rm.nextInt(Plateau.LARGEUR);
			if (!this.grille[x][y].estObstacle() && this.grille[x][y].estBase()==0) {
				this.grille[x][y].placerObstacle();
				obstacles++;
			}
		}
	}
	
	private void initPlateau() {
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
	
	public void retirerRobot(int x, int y, Robot r){
		grille[x][y].retirerRobot (r);
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
		return parcourtValide(p, 0, 0, 0);
	}
			
	public boolean parcourtValide(boolean[][] p, int x, int y, int test) {
		try {
			if (p[HAUTEUR-1][LARGEUR-1])
				return true;
			// DROITE
			else if (y!=LARGEUR-1 && !this.grille[x][y+1].estObstacle() && !p[x][y+1]) {
				p[x][y+1]=true;
				return parcourtValide(p, x, y+1, test++);
			}
			// BAS
			else if (x!=HAUTEUR-1 && !this.grille[x+1][y].estObstacle() && !p[x+1][y]) {
				p[x+1][y]=true;
				return parcourtValide(p, x+1, y, test++);
			}
			// GAUCHE
			else if (y!=0 && !this.grille[x][y-1].estObstacle() && !p[x][y-1]) {
				p[x][y-1]=true;
				return parcourtValide(p, x, y-1, test++);
			} 
			// HAUT
			else if (x!=HAUTEUR+1 && !this.grille[x+1][y].estObstacle() && !p[x+1][y]) {
				p[x+1][y]=true;
				return parcourtValide(p, x+1, y, test++);
			} 
			else return false;
		} catch(Exception e) {
			return false;
		}
	}
	
	public String toString(int equipe, int num) {
		String s = "+";
		for (int i=0; i<LARGEUR; i++)
			s=s+"---+";
		
		for (int i=0; i<HAUTEUR; i++) {
			s=s+"\n|";
			for (int j=0; j<LARGEUR; j++) {
				if (this.grille[i][j].estMine()!=0) {
					if (equipe == 0)
						s=s+" X |";
					else if (this.grille[i][j].estMine()==equipe)
						s=s+" X |";

				} else if (this.grille[i][j].getContenu() instanceof Tireur) {
					if (this.grille[i][j].getContenu().getEquipe()==1)
						s=s+" T |";
					else
						s=s+" t |";
				} else if (this.grille[i][j].getContenu() instanceof Piegeur) {
					if (this.grille[i][j].getContenu().getEquipe()==1)
						s=s+" P |";
					else
						s=s+" p |";
				} else if (this.grille[i][j].getContenu() instanceof Char) {
					if (this.grille[i][j].getContenu().getEquipe()==1)
						s=s+" C |";
					else
							s=s+" c |";
				} else if(this.grille[i][j] instanceof Base) {
					if (this.grille[i][j].estBase()==1) {
						if (grille[i][j].getRobot(equipe, num) instanceof Tireur)
							s=s+" T |";
						else if (grille[i][j].getRobot(equipe, num) instanceof Piegeur)
							s=s+" P |";
						else if (grille[i][j].getRobot(equipe, num) instanceof Char )
							s=s+" C |";
						else
							s=s+" B |";
					} else if (this.grille[i][j].estBase()==2)
						if (grille[i][j].getRobot(equipe, num) instanceof Tireur)
							s=s+" T |";
						else if (grille[i][j].getRobot(equipe, num) instanceof Piegeur)
							s=s+" P |";
						else if (grille[i][j].getRobot(equipe, num) instanceof Char )
							s=s+" C |";
						else
							s=s+" B |";				}
				else if (this.grille[i][j].estObstacle())
					s=s+" O |";
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
