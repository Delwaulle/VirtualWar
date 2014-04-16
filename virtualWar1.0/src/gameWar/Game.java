package gameWar;


public class Game {

	public static void main(String[] args) {
		afficherLogo();
		Plateau p = new Plateau();
		System.out.print(p.toString(1));		
		creerRobots(p, 1);
		creerRobots(p, 2);
		int tour=0;
		while (!p.fini) {
			System.out.print(p.toString(tour%2+1));
			jouer(tour%2+1, p);
			tour++;
			testFini(p);
		}
	}
	
	private static void jouer (int equipe, Plateau p) {
		System.out.println(p.getRobot(equipe).toString());
		String rep=gameController.EntrerAction.entrerAction();
		if (rep.equals("deplacer")) 
			deplacer(p.getRobot(equipe), p);
		else if (rep.equals("attaquer"))
			attaquer(p.getRobot(equipe), p);
		if (p.getRobot(equipe).getEnergie()<=0)
			p.setLibre(p.getRobot(equipe).getCoordonnee().getX(), p.getRobot(equipe).getCoordonnee().getY());
	}
	
	private static void deplacer(Robot r, Plateau p) {
		Coordonnee direction = gameController.EntrerDirection.entrerDirection();
		if (testSortiePlateau(r, direction)) {
			System.out.println("Déplacement impossible, vous ne pouvez pas quitter le champ de bataille ! Choisissez une destination valide ou une autre action.");
			jouer(r.getEquipe(), p);
		} else if (testCollision(r, direction)) {
			System.out.println("Déplacement impossible, le terrain est déjà occupé, le risque de collision est important, choisissez une autre destination ou une autre action.");
			jouer(r.getEquipe(), p);
		} else if (p.estBase(r.getCoordonnee().getX()+direction.getX(), r.getCoordonnee().getY()+direction.getY())!=0 
				&&p.estBase(r.getCoordonnee().getX()+direction.getX(), r.getCoordonnee().getY()+direction.getY()) != r.getEquipe()) {
				System.out.println("Alerte ! Vous essayez de pénétrer une base ennemie ! Vous avez l’ordre de battre en retraite, choisissez une destination différente.");
				jouer(r.getEquipe(), p);
		} else {
			Action a = new Deplacement(r,direction);
			a.agit();
		}
	}
	
	private static void attaquer(Robot r, Plateau p) {
		Coordonnee direction = gameController.EntrerDirection.entrerDirection();
		while (direction != Constante.HAUT && direction != Constante.BAS && direction != Constante.GAUCHE && direction != Constante.DROITE) {
			System.out.println("Vous ne pouvez effectuer cette action en diagonale");
			direction=gameController.EntrerDirection.entrerDirection();
		}
		if (r.getType().equals("Tireur")) {
			if (r.getVue().estLibre(r.getCoordonnee().ajouter(direction))) {
				System.out.print("Attention soldat, vous ne visez personne ! Ne décevez pas votre pays, ciblez un ennemi ou choisissez une autre action !");
				jouer(r.getEquipe(), p);
			} else {
				Action a = new Tir(r,direction);
				a.agit();
			}
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

	private static boolean testSortiePlateau(Robot r, Coordonnee direction) {
		return (!r.getVue().estOK(r.getCoordonnee().ajouter(direction)));
	}
	
	private static boolean testCollision(Robot r, Coordonnee direction) {
		return (!r.getVue().estLibre(r.getCoordonnee().ajouter(direction)));
	}
	
	private static void testFini(Plateau p) {
		int equipe1 = 0;
		int equipe2 = 0;
		for (int i=0; i<p.grille.length; i++) {
			for (int j=0; j<p.grille[0].length; j++) {
				if (p.grille[i][j].getContenu()!= null && p.grille[i][j].getContenu().getEquipe()==1)
					equipe1++;
				else if (p.grille[i][j].getContenu()!= null && p.grille[i][j].getContenu().getEquipe()==2)
					equipe2++;
			}
		} if (equipe1 == 0 && equipe2 == 0) {
			p.fini=true;
			System.out.println("Egalité !!");
		} else if (equipe1 == 0) {
			p.fini=true;
			System.out.println("Joueur 2 à gagner !!");
		} else if (equipe2 == 0) {
			p.fini=true;
			System.out.println("Joueur 1 à gagner !!");
		}
		
	}
	
	private static void afficherLogo() {
		System.out.println("\n\n\n\n  _______________ ");
		try{
			Thread.sleep(100);
		}
		catch(Exception e){System.out.println(e.getMessage());}
		System.out.println("/_______________/|");
		try{
			Thread.sleep(100);
		}
		catch(Exception e){System.out.println(e.getMessage());}
		System.out.println("|   |_  \\     | ||");
		try{
			Thread.sleep(100);
		}
		catch(Exception e){System.out.println(e.getMessage());}
		System.out.println("|     \\  \\    | ||");
		try{
			Thread.sleep(100);
		}
		catch(Exception e){System.out.println(e.getMessage());}
		System.out.println("|      \\  \\   | ||");
		try{
			Thread.sleep(100);
		}
		catch(Exception e){System.out.println(e.getMessage());}
		System.out.println("|       \\  \\  | ||");
		try{
			Thread.sleep(100);
		}
		catch(Exception e){System.out.println(e.getMessage());}
		System.out.println("|        \\  \\ | ||");
		try{
			Thread.sleep(100);
		}
		catch(Exception e){System.out.println(e.getMessage());}
		System.out.println("|         \\  \\| ||");
		try{
			Thread.sleep(100);
		}
		catch(Exception e){System.out.println(e.getMessage());}
		System.out.println("|          \\    ||");
		try{
			Thread.sleep(100);
		}
		catch(Exception e){System.out.println(e.getMessage());}
		System.out.println("|           \\   ||");
		try{
			Thread.sleep(100);
		}
		catch(Exception e){System.out.println(e.getMessage());}
		System.out.println("|_______________||");
		try{
			Thread.sleep(100);
		}
		catch(Exception e){System.out.println(e.getMessage());}
		System.out.println("|  B R O N Z E  ||");
		try{
			Thread.sleep(100);
		}
		catch(Exception e){System.out.println(e.getMessage());}
		System.out.println("|_______________|/\n\n\n\n\n\n\n\n\n\n\n");
		try{
			Thread.sleep(100);
		}
		catch(Exception e){System.out.println(e.getMessage());}
	}
}


