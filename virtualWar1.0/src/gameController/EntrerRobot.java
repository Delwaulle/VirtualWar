package gameController;

import java.util.Scanner;

/**
 * @author Loic
 *
 */
public class EntrerRobot {

	/**
	 * @return la saisie de l'utilisateur concernant le choix du robot
	 */
	public static String entrerRobot() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String rep=sc.nextLine().toLowerCase();
		while (!rep.equals("tireur") && !rep.equals("piegeur")) {
			System.out.println("Entree non valide, veuillez entrer un type de robot");
			rep = sc.nextLine().toLowerCase();
		}
		return rep;
	}
}
