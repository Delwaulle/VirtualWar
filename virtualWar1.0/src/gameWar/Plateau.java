package gameWar;

import java.util.Random;


public class Plateau {

	public static int		hauteur			= 10;
	public static int		largeur			= 10;
	public static double	tauxObstacles	= 0;
	boolean					fini			= false;
	Cellule[][]				grille;

	public Cellule[][] getGrille() {
		return grille;
	}

	public void setGrille(Cellule[][] grille) {
		this.grille = grille;
	}

	/**
	 * 
	 */
	public Plateau(double obstacles) {
		this.tauxObstacles=obstacles;
		grille=new Cellule[hauteur][largeur];
		this.initPlateau();
		this.placerObstacles();
		while (!this.plateauValide()) {
			this.initPlateau();
			this.placerObstacles();
		}
	}

	/**
	 * @param x
	 * @param y
	 * @return int
	 * 	Retourne 0 s'il n'y a pas de mine sur la case de coordonnee x, y ou retourne le numero de l'equipe qui à poser la mine s'il y en a une
	 */
	public int estMine (int x, int y) {
		return grille[x][y].estMine();
	}

	/**
	 * @param x
	 * @param y
	 * @return int
	 * 	Retourne 0 s'il n'y a pas de base sur la case de coordonnee x, y ou retourne le numero de la base s'il y en a une
	 */
	public int estBase (int x, int y) {
		return grille[x][y].estBase();
	}

	/**
	 * @param x
	 * @param y
	 * @return Robot
	 * Retourne le robot que est sur la case de coordonne x, y ou retourne null s'il n'y en a pas
	 */
	public Robot getContenu (int x, int y) {
		return grille[x][y].getContenu();
	}

	/**
	 * @param numEquipe
	 * @param num
	 * @return Robot
	 * 	retourne le robot correspondant au numero et a l'equipe passe en parametre ou retourne null s'il n'est pas dans le plateau
	 */
	public Robot getRobot (int equipe, int num) {
		for (int i=0; i<hauteur; i++) {
			for (int j=0; j<largeur; j++) {
				if (this.grille[i][j].getRobot(equipe, num)!=null)
					return this.grille[i][j].getRobot(equipe, num);
			}
		}
		return null;
	}

	/**
	 * Place les obstacles aleatoirement sur le plateau
	 */
	private void placerObstacles () {
		int obstacles = 0;
		int x, y;
		Random rm = new Random();
		while (obstacles != (int)((Plateau.hauteur*Plateau.largeur)*this.tauxObstacles)) {
			x=rm.nextInt(Plateau.hauteur);
			y=rm.nextInt(Plateau.largeur);
			if (!this.grille[x][y].estObstacle() && this.grille[x][y].estBase()==0) {
				this.grille[x][y].placerObstacle();
				obstacles++;
			}
		}
	}

	/**
	 * 	Initialise le plateau en plaçant les bases
	 */
	private void initPlateau() {
		for (int i=0; i<grille.length; i++) {
			for (int j=0; j<grille[0].length; j++) {
				if (i==0 && j==0)
					grille[i][j]=new Base(1);
				else if (i==hauteur-1 && j==largeur-1)
					grille[i][j]=new Base(2);
				else
					grille[i][j]=new Case();
			}
		}
	}

	/**
	 * @param x
	 * @param y
	 * @param NumEquipe
	 * Place une mine sur la case de coordonnee x, y
	 */
	public void placerMine (int x, int y, int equipe) {
		grille[x][y].placerMine(equipe);
	}

	/**
	 * @param x
	 * @param y
	 * Retir la mine sur la case de coordonnee s, y
	 */
	public void retirerMine(int x, int y) {
		grille[x][y].placerMine(0);
	}

	/**
	 * @param x
	 * @param y
	 * @param equipe
	 * Place une base sur la case de coordonnee x, y
	 */
	public void placerBase (int x, int y, int equipe) {
		grille[x][y].placerBase(equipe);
	}

	/**
	 * @param robot
	 * Place le robot sur le plateau
	 */
	public void placerRobot(Robot r) {
		grille[r.getCoordonnee().getX()][r.getCoordonnee().getY()].placerSur(r);
	}

	/**
	 * @param x
	 * @param y
	 * Libere la case de coordonnee x, y
	 */
	public void setLibre(int x, int y) {
		grille[x][y].videCase();
	}

	/**
	 * @param x
	 * @param y
	 * @param robot
	 * Retir le robot sur la case de coordonnee x, y
	 */
	public void retirerRobot(int x, int y, Robot r){
		grille[x][y].retirerRobot (r);
	}

	/**
	 * @return boolean
	 * 	retourne true si le plateau est valide
	 */
	public boolean plateauValide() {
		boolean[][] p = new boolean[hauteur][largeur];
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

	/**
	 * @param plateauBool
	 * @param x
	 * @param y
	 * @param test
	 * @return
	 */
	public boolean parcourtValide(boolean[][] p, int x, int y, int test) {
		try {
			if (p[hauteur-1][largeur-1])
				return true;
			// DROITE
			else if (y!=largeur-1 && !this.grille[x][y+1].estObstacle() && !p[x][y+1]) {
				p[x][y+1]=true;
				return parcourtValide(p, x, y+1, test++);
			}
			// BAS
			else if (x!=hauteur-1 && !this.grille[x+1][y].estObstacle() && !p[x+1][y]) {
				p[x+1][y]=true;
				return parcourtValide(p, x+1, y, test++);
			}
			// GAUCHE
			else if (y!=0 && !this.grille[x][y-1].estObstacle() && !p[x][y-1]) {
				p[x][y-1]=true;
				return parcourtValide(p, x, y-1, test++);
			}
			// HAUT
			else if (x!=hauteur+1 && !this.grille[x+1][y].estObstacle() && !p[x+1][y]) {
				p[x+1][y]=true;
				return parcourtValide(p, x+1, y, test++);
			}
			else return false;
		} catch(Exception e) {
			return false;
		}
	}

	/**
	 * @param NumEquipe
	 * @param num
	 * @return String
	 * 	Retourne le contenu du plateau sous forme de String
	 */
	public String toString(int equipe, int num) {
		String s = "+";
		for (int i=0; i<largeur; i++)
			s=s+"---+";

		for (int i=0; i<hauteur; i++) {
			s=s+"\n|";
			for (int j=0; j<largeur; j++) {
				if (this.grille[i][j].estMine()!=0) {
					if (equipe == 0)
						s=s+" X |";
					else if (this.grille[i][j].estMine()==equipe)
						s=s+" X |";
					else
						s=s+"   |";

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
			for (int j=0; j<largeur; j++)
				s=s+"---+";
		}
		s=s+"\n";
		return s;
	}
}
