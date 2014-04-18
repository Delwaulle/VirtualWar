package gameController;

import java.util.Scanner;

/**
 * @author Loic
 *
 */
public class EntrerAction {
	/**
	 * @return la saisie de l'utilisateur
	 */
	public static String entrerAction () {
		System.out.println("Entrez une action (attaquer ou deplacer)");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String rep=sc.nextLine().toLowerCase();
		while (!rep.equals("attaquer") && !rep.equals("deplacer")) {
			System.out.println("Entree non valide, veuillez entrer un type d'action");
			rep = sc.nextLine().toLowerCase();
		}
		return rep;
	}
}
