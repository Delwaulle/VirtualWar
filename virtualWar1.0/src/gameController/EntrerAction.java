package gameController;

import java.util.Scanner;

public class EntrerAction {
	public static String entrerAction () {
		System.out.println("Entrez une action (attaquer ou deplacer)");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String rep=sc.nextLine().toLowerCase();
		while (!rep.equals("attaquer") && !rep.equals("deplacer")) {
			System.out.println("Saisie incorrecte, veuillez recommencez.");
			rep = sc.nextLine().toLowerCase();
		}
		return rep;
	}
}
