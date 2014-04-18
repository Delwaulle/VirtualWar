package gameController;
import gameWar.Constante;
import gameWar.Coordonnee;

import java.util.Scanner;

/**
 * @author Loic
 *
 */
public class EntrerDirection {

	/**
	 * @return la saisie de l'utilisateur concernant les choix de déplacement
	 */
	public static Coordonnee entrerDirection() {
		System.out.println("Entrez une direction");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (true) {
			String rep=sc.nextLine().toLowerCase();
			if (rep.equals("haut"))
				return Constante.HAUT;
			if (rep.equals("bas"))
				return Constante.BAS;
			if (rep.equals("droite"))
				return Constante.DROITE;
			if (rep.equals("gauche"))
				return Constante.GAUCHE;
			if (rep.equals("haut gauche"))
				return Constante.HAUT.ajouter(Constante.GAUCHE);
			if (rep.equals("haut droite"))
				return Constante.HAUT.ajouter(Constante.DROITE);
			if (rep.equals("bas droite"))
				return Constante.BAS.ajouter(Constante.DROITE);
			if (rep.equals("bas gauche"))
				return Constante.BAS.ajouter(Constante.GAUCHE);
			else
				System.out.println("Entrée non valide !");
		}
	}
}
