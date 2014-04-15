package gameWar;

public class Game {

	public static void main(String[] args) {
		Plateau p = new Plateau();
		System.out.print(p.toString());		
		creerRobots(p, 1);
		creerRobots(p, 2);
		System.out.print(p.toString());
		int tour=0;
		while (!p.fini) {
			// jouer(tour%2+1, p);
		}
	}
	
	/*private static void jouer (int equipe, Plateau p) {
		String rep=gameController.EntrerAction.entrerAction();
		if (rep.equals("stats"))
			System.out.println(p.getRobot(equipe));
	}*/
	
	private static void creerRobots(Plateau p, int equipe) {
		System.out.println("Joueur "+equipe+", voulez vous un tireur ou un piegeur ?");
		String rep=gameController.EntrerRobot.entrerRobot();
		if (rep.equals("tireur")) {
			p.placerRobot(new Tireur(new Vue(), 0, 0, equipe));
		} else if (rep.equals("piegeur"))
			p.placerRobot(new Piegeur(new Vue(), 0, 0, equipe));
	}
}
