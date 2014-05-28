package gameController;


import java.util.Scanner;

public class EntrerInt {

	public static int entrerInt () {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String rep = sc.nextLine();
		int i = 0;
		try {
			i = Integer.parseInt(rep);
		} catch (Exception e) {
			System.out.println("Saisie incorrecte, veuillez recommencez.");
		}
		return i;
	}
}
