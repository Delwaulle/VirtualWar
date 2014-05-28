package gameController;

import java.util.Scanner;

public class EntrerIA {

	public static String rep="";
	public static String entrerIA() {
		System.out.println("Quel type de partiev voulez vous jouer ?? (JcJ, JcAI ou IAcIA)");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		rep=sc.nextLine().toLowerCase();
		while (!rep.equals("jcj") && !rep.equals("jcia") && !rep.equals("iacia")) {
			System.out.println("Saisie incorrecte, veuillez recommencez.");
			rep = sc.nextLine().toLowerCase();
		}
		return rep;
	}
}
