package gameGraphic;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

public class ChoixRobot2 extends JPanel {
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
	Font f2;
	JLabel label;
	JPanel panel;
	static int team=2;

	public ChoixRobot2(final CardLayout cl, final JPanel pan) {
		this.cl = cl;
		this.pan = pan;
		this.setLayout(new BorderLayout());

		//Spinner
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

		//JButton
		//valider = new Bouton("Valider", pan, cl, "jeu");
		valider=new JButton("Lancer la partie");
		valider.setEnabled(false);
		f2= new Font(Font.DIALOG, Font.BOLD, 20);
		valider.setFont(f2);
		//valider.setIcon(new ImageIcon(("rsc/images/bouton1.png")));
		valider.setPreferredSize(new Dimension(300,60));
		valider.setMinimumSize(new Dimension(300,60));
		valider.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ClicMenu son=new ClicMenu();
				son.setDaemon(true);
				son.start();
				gameController.EntrerRobot.tireurs2=SpinnerListener.cpt1_2;
				gameController.EntrerRobot.piegeurs2=SpinnerListener.cpt2_2;
				gameController.EntrerRobot.chars2=SpinnerListener.cpt3_2;
				cl.show(pan, "jeu");
			}

		});
		retour = new Bouton("Retour", pan, cl, "robots");

		//JLabel
		label = new JLabel("L'équipe "+ team +" choisit 5 robots :");
		f=new Font(Font.DIALOG, Font.BOLD, 13);
		label.setFont(f);
		label.setForeground(Color.WHITE);
		label.setOpaque(false);

		//JPanel
		JPanel p4 = new JPanel();
		p4.setOpaque(false);
		p4.setLayout(new FlowLayout(0,90,10));
		p4.add(retour);
		p4.add(valider);
		p = new JPanel();
		p.setLayout(new GridLayout(3,1,5,5));
		p.setOpaque(false);
		JPanel pp = new JPanel();
		pp.setOpaque(false);
		pp.setLayout(new FlowLayout(5,90,10) );
		pp.add(spinner1);
		pp.add(spinner2);
		pp.add(spinner3);
		p.add(label);
		p.add(pp);
		p.add(p4);
		this.add(BorderLayout.CENTER,p);
		gameController.EntrerIA.rep = "jcj";
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}

}
