package gameWar;

import gameGraphic.BoardDisplayer;

/**
 * @author Robin
 *
 */
public class Joueur {

	/**
	 * @param plateau
	 * @param equipe
	 * 	Fait jouer le joueur en demandant quel robot jouer et quelle action effectuer
	 */
	public static void jouer (Plateau p, int equipe) {
		boolean ok=false;
		int num=0;
		System.out.println(p.toString(equipe, 0));
		while (!ok) {
			System.out.println("Quel Robot voulez-vous jouer ??");
			num = 0;
			while (num <=0 || num > 5) {
				if (num > 5) {
					System.out.println("Vous ne possedez que 5 Robots !");
				}
				num=gameController.EntrerInt.entrerInt();
			}
			if (p.getRobot(equipe, num)==null)
				System.out.println("Ce Robot est détruit, choisissez en un autre.");
			else
				ok=true;
		}
		System.out.print(p.toString(equipe, num));
		System.out.println(p.getRobot(equipe, num).toString());
		String rep=gameController.EntrerAction.entrerAction();
		if (rep.equals("deplacer")) {
			Action a = new Deplacement(p.getRobot(equipe, num));
			a.agit();
		}
		else if (rep.equals("attaquer"))
			if (!p.getRobot(equipe, num).getType().equals("Piegeur")) {
				Action a = new Tir(p.getRobot(equipe, num));
				a.agit();
			} else {
				Action a = new Mine(p.getRobot(equipe, num));
				a.agit();
			}
		if (p.getRobot(equipe, num).getEnergie()<=0)
			p.retirerRobot(p.getRobot(equipe, num).getCoordonnee().getX(), p.getRobot(equipe, num).getCoordonnee().getY(), p.getRobot(equipe, num));
	}

	/**
	 * @param plateau
	 * @param equipe
	 * 	Créé les robots en demandant au joueur quels robots il veut
	 */
	public static Plateau creerRobots(Plateau p,boolean ia) {



		System.out.print("coucou");
		int tireurs=gameController.EntrerRobot.tireurs;
		int piegeurs=gameController.EntrerRobot.piegeurs;
		int chars=gameController.EntrerRobot.chars;
		int tireurs2=gameController.EntrerRobot.tireurs2;
		int piegeurs2=gameController.EntrerRobot.piegeurs2;
		int chars2=gameController.EntrerRobot.chars2;
		if(ia) {
			for (int i = 1;i<=tireurs;i++) {
				p.placerRobot(new Tireur(new Vue(1, p), 1, i, "Joueur"));
			}
			for (int i =tireurs+1;i<=piegeurs+tireurs;i++) {
				p.placerRobot(new Piegeur(new Vue(1, p), 1, i, "Joueur"));
			}

			for (int i =tireurs+piegeurs+1;i<=chars+piegeurs+tireurs;i++) {
				p.placerRobot(new Char(new Vue(1, p), 1, i, "Joueur"));
			}
		}

		else {
			for (int i = 1;i<=tireurs;i++) {
				p.placerRobot(new Tireur(new Vue(1, p), 1, i, "Joueur"));
			}
			for (int i =tireurs+1;i<=piegeurs+tireurs;i++) {
				p.placerRobot(new Piegeur(new Vue(1, p), 1, i, "Joueur"));
			}

			for (int i =tireurs+piegeurs+1;i<=chars+piegeurs+tireurs;i++) {
				p.placerRobot(new Char(new Vue(1, p), 1, i, "Joueur"));
			}

			for (int i = 1;i<=tireurs2;i++) {
				p.placerRobot(new Tireur(new Vue(2, p), 2, i, "Joueur"));
			}
			for (int i =tireurs2+1;i<=piegeurs2+tireurs2;i++) {
				p.placerRobot(new Piegeur(new Vue(2, p), 2, i, "Joueur"));
			}
			for (int i =tireurs2+piegeurs2+1;i<=chars2+piegeurs2+tireurs2;i++) {
				p.placerRobot(new Char(new Vue(2, p), 2, i, "Joueur"));
			}
		}
		if (BoardDisplayer.board.getRobot(1, 1) instanceof Tireur )
			gameGraphic.ActionPanel.r1.setText("Tireur 1");
		else if (BoardDisplayer.board.getRobot(1, 1) instanceof Piegeur )
			gameGraphic.ActionPanel.r1.setText("Piegeur 1");
		else if (BoardDisplayer.board.getRobot(1, 1) instanceof Char )
			gameGraphic.ActionPanel.r1.setText("Char 1");
		if (BoardDisplayer.board.getRobot(1, 2) instanceof Tireur )
			gameGraphic.ActionPanel.r2.setText("Tireur 2");
		else if (BoardDisplayer.board.getRobot(1, 2) instanceof Piegeur )
			gameGraphic.ActionPanel.r2.setText("Piegeur 2");
		else if (BoardDisplayer.board.getRobot(1, 2) instanceof Char )
			gameGraphic.ActionPanel.r2.setText("Char 2");
		if (BoardDisplayer.board.getRobot(1, 3) instanceof Tireur )
			gameGraphic.ActionPanel.r3.setText("Tireur 3");
		else if (BoardDisplayer.board.getRobot(1, 3) instanceof Piegeur )
			gameGraphic.ActionPanel.r3.setText("Piegeur 3");
		else if (BoardDisplayer.board.getRobot(1, 3) instanceof Char )
			gameGraphic.ActionPanel.r3.setText("Char 3");
		if (BoardDisplayer.board.getRobot(1, 4) instanceof Tireur )
			gameGraphic.ActionPanel.r4.setText("Tireur 4");
		else if (BoardDisplayer.board.getRobot(1, 4) instanceof Piegeur )
			gameGraphic.ActionPanel.r4.setText("Piegeur 4");
		else if (BoardDisplayer.board.getRobot(1, 4) instanceof Char )
			gameGraphic.ActionPanel.r4.setText("Char 4");
		return p;
	}
}
