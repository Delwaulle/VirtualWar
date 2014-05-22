package gameController;

import java.util.Scanner;

public class EntrerIA {

	public static String entrerIA() {
		System.out.println("Quel type de partiev voulez vous jouer ?? (JcJ, JcAI ou IAcIA)");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String rep=sc.nextLine().toLowerCase();
		while (!rep.equals("jcj") && !rep.equals("jcia") && !rep.equals("iacia")) { 
			System.out.println("Entree non valide, veuillez entrer un type d'adversaire");
			rep = sc.nextLine().toLowerCase();
		}
		return rep;
	}
}
