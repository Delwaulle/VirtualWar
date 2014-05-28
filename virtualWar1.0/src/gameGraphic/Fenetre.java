package gameGraphic;

import java.awt.CardLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel content;
	private CardLayout cl;
	public Fenetre() {
		super("Virtual War");
		this.setIconImage(new ImageIcon("rsc/images/icon.png").getImage());
		this.init();
		this.getContentPane().add(content);
		this.setBounds(200,80,800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
	}

	public void init(){
		content=new JPanel();
		cl=new CardLayout();
		MenuDemarrage Menu = new MenuDemarrage(cl,content);
		Jouer card1 = new Jouer(cl,content);
		JoueurVsJoueur card1_1 = new JoueurVsJoueur(cl,content);
		ChoixRobot card1_1_1 = new ChoixRobot(cl,content);
		JoueurVsIa card1_2 = new JoueurVsIa(cl,content);
		IaVsIa card1_3 = new IaVsIa(cl,content);
		Sauvegardes card2 = new Sauvegardes(cl,content);
		Parametres card3 = new Parametres(cl,content);
		content.setLayout(cl);
		content.add(Menu, "menu");
		content.add(card1,"jouer");
		content.add(card1_1,"jvj");
		content.add(card1_1_1,"robots");
		content.add(card1_2,"jvi");
		content.add(card1_3,"ivi");
		content.add(card2, "sauvegardes");
		content.add(card3, "parametres");
	}
}
