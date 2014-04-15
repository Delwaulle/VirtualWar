package gameWar;


public class Game {

	public static void main(String[] args) {
		Plateau p = new Plateau();
		System.out.print(p.toString());		
		creerRobots(p, 1);
		creerRobots(p, 2);
		int tour=0;
		while (!p.fini) {
			System.out.print(p.toString());
			jouer(tour%2+1, p);
			tour++;
		}
	}
	
	private static void jouer (int equipe, Plateau p) {
		System.out.println(p.getRobot(equipe).toString());
		String rep=gameController.EntrerAction.entrerAction();
		if (rep.equals("deplacer")) 
			deplacer(p.getRobot(equipe), p);
		else if (rep.equals("attaquer"))
			attaquer(p.getRobot(equipe), p);
	}
	
	private static void deplacer(Robot r, Plateau p) {
		int direction = gameController.EntrerDirection.entrerDirection();
		Action a = new Deplacement(r,direction);
		a.agit();
	}
	
	private static void attaquer(Robot r, Plateau p) {
		int direction = gameController.EntrerDirection.entrerDirection();
		if (r.getType().equals("Tireur")) {
			Action a = new Tir(r,direction);
			a.agit();
		} else if (r.getType().equals("Piegeur")) {
			Action a = new Mine(r,direction);
			a.agit();
		}
	}
	
	private static void creerRobots(Plateau p, int equipe) {
		System.out.println("Joueur "+equipe+", voulez vous un tireur ou un piegeur ?");
		String rep=gameController.EntrerRobot.entrerRobot();
		if (rep.equals("tireur")) {
			p.placerRobot(new Tireur(new Vue(equipe, p), 0, 0, equipe));
		} else if (rep.equals("piegeur"))
			p.placerRobot(new Piegeur(new Vue(equipe, p), 0, 0, equipe));
	}
}
