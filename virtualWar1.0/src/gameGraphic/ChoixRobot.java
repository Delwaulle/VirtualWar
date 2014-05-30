package gameGraphic;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;


public class ChoixRobot extends JPanel {
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;
	CardLayout					cl;
	JPanel						pan;
	Image						img;
	JButton						retour;
	JButton						valider;
	JPanel						p;
	static int							choix;
	int							choix2;
	int							choix3;
	JSpinner					spinner1;
	JSpinner					spinner2;
	JSpinner					spinner3;
	Font f;
	JLabel label;
	JPanel panel;

	public ChoixRobot(CardLayout cl, JPanel pan) {
		this.cl = cl;
		this.pan = pan;
		this.setLayout(new FlowLayout(0, 250, 30));
		p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		p.setOpaque(false);
		SpinnerModel model1 = new SpinnerNumberModel(0, 0, 5, 1);
		spinner1 = new JSpinner(model1);
		spinner1.addChangeListener(new SpinnerListener(this));
		SpinnerModel model2 = new SpinnerNumberModel(0, 0, 5, 1);
		spinner2 = new JSpinner(model2);
		spinner2.addChangeListener(new SpinnerListener(this));
		SpinnerModel model3 = new SpinnerNumberModel(0, 0, 5, 1);
		spinner3 = new JSpinner(model3);
		spinner3.addChangeListener(new SpinnerListener(this));
		try {
			img = ImageIO.read(new File("rsc/images/bg1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		valider = new Bouton("Valider", pan, cl, "jeu");
		retour = new Bouton("Retour", pan, cl, "jvj");
		panel = new JPanel();
		panel.setLayout(new FlowLayout(0, 20, 30));
		panel.add(spinner1);
		panel.add(spinner2);
		panel.add(spinner3);
		panel.setOpaque(false);
		label = new JLabel("Choisissez 5 robots :");
		f=new Font(Font.DIALOG, Font.BOLD, 13);
		label.setFont(f);
		label.setForeground(Color.WHITE);
		label.setOpaque(false);
		JPanel pp = new JPanel();
		pp.add(panel);
		p.add(label);
		p.add(pp);
		p.add(valider);
		p.add(retour);
		this.add(p);
		gameController.EntrerIA.rep = "iacia";
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}
}
