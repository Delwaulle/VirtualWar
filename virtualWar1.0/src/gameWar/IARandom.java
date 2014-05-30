package gameWar;

import java.util.Random;

/**
 * @author Robin
 *
 */
public class IARandom {

	/**
	 * @param plateau
	 * @param equipe
	 * 
	 * 	Créé les robots aléatoirement
	 */
	public static void creerRobots(Plateau p, int equipe) {
		for (int i=1; i<=5; i++){
			Random r = new Random();
			int num = r.nextInt(3);
			if (num==0)
				p.placerRobot(new Tireur(new Vue(equipe, p), equipe, i, "IARandom"));
			else if (num==1)
				p.placerRobot(new Piegeur(new Vue(equipe, p), equipe, i, "IARandom"));
			else if (num==2)
				p.placerRobot(new Char(new Vue(equipe, p), equipe, i, "IARandom"));
		}
	}

	/**
	 * @param plateau
	 * @param equipe
	 * 	Choisit un robot et une action aleatoirement
	 */
	public static void jouer (Plateau p, int equipe) {
		Random r = new Random();
		int num = 0;
		int action = 0;
		while (p.getRobot(equipe, num)==null) {
			num=r.nextInt(5)+1;
			action=r.nextInt(5);
		}
		if (action <= 3) {
			Action a = new Deplacement(p.getRobot(equipe, num));
			a.iaAgit(directionRandom(a.getRobot(), true));
		}
		else {
			if (!p.getRobot(equipe, num).getType().equals("Piegeur")) {
				Action a = new Tir(p.getRobot(equipe, num));
				a.iaAgit(directionRandom(a.getRobot(), false));
			} else {
				Action a = new Mine(p.getRobot(equipe, num));
				a.iaAgit(directionRandom(a.getRobot(), false));
			}
		}
		if (!(p.getRobot(equipe, num) == null) && p.getRobot(equipe, num).getEnergie()<=0)
			p.retirerRobot(p.getRobot(equipe, num).getCoordonnee().getX(), p.getRobot(equipe, num).getCoordonnee().getY(), p.getRobot(equipe, num));
	}

	/**
	 * @param robot
	 * @param deplacement
	 * @return Coordonnee
	 * 	Retourne une direction choisit aleatoirement
	 */
	private static Coordonnee directionRandom (Robot robot, boolean deplacement) {
		Random r = new Random();
		int dir;
		if (deplacement && !robot.getType().equals("Char"))
			dir = r.nextInt(8);
		else
			dir = r.nextInt(4);
		if (dir == 0)
			return Constante.HAUT;
		if (dir == 1)
			return Constante.BAS;
		if (dir == 2)
			return Constante.DROITE;
		if (dir == 3)
			return Constante.GAUCHE;
		if (dir == 4)
			return Constante.HAUT.ajouter(Constante.DROITE);
		if (dir == 5)
			return Constante.HAUT.ajouter(Constante.GAUCHE);
		if (dir == 6)
			return Constante.BAS.ajouter(Constante.DROITE);
		if (dir == 7)
			return Constante.BAS.ajouter(Constante.GAUCHE);
		return null;
	}
}
