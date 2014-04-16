package gameController;

import java.util.Scanner;

public class EntrerRobot {

	public static String entrerRobot() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String rep=sc.nextLine();;
		while (!rep.equals("tireur") && !rep.equals("piegeur")) { 
			System.out.println("Entree non valide, veuillez entrer un type de robot");
			rep = sc.nextLine();
		}
		return rep;
	}
}
