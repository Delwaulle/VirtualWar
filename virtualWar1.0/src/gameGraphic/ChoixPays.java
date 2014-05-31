package gameGraphic;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
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
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ChoixPays extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CardLayout cl;
	JPanel pan;
	Image img;
	JButton retour;
	Font f;
	JLabel pays;
	JLabel e1;
	JLabel e2;
	JButton valider;
	static String france ="France";
	static String angleterre ="Angleterre";
	static String etatsUnis ="Etats-Unis";
	static String allemagne ="Allemagne";
	static String choix1="France";
	static String choix2="France";
	JRadioButton radioFrance;
	JRadioButton radioAngleterre;
	JRadioButton radioEtatsUnis;
	JRadioButton radioAllemagne;

	JRadioButton radioFrance2;
	JRadioButton radioAngleterre2;
	JRadioButton radioEtatsUnis2;
	JRadioButton radioAllemagne2;
	public ChoixPays(CardLayout cl, JPanel pan) {
		this.cl=cl;
		this.pan=pan;

		//Radio button
		ButtonGroup bg1 = new ButtonGroup ();
		radioFrance = new JRadioButton(france);
		radioFrance.setSelected(true);
		radioAngleterre = new JRadioButton(angleterre);
		radioEtatsUnis = new JRadioButton(etatsUnis);
		radioAllemagne = new JRadioButton(allemagne);
		JPanel radioPanel = new JPanel(new GridLayout(0, 1));
		radioPanel.add(radioFrance);
		radioPanel.add(radioAngleterre);
		radioPanel.add(radioEtatsUnis);
		radioPanel.add(radioAllemagne);
		//radioPanel.setOpaque(false);
		bg1.add(radioFrance);
		bg1.add(radioAngleterre);
		bg1.add(radioEtatsUnis);
		bg1.add(radioAllemagne);

		radioFrance.addActionListener(this);
		radioAngleterre.addActionListener(this);
		radioEtatsUnis.addActionListener(this);
		radioAllemagne.addActionListener(this);


		ButtonGroup bg2 = new ButtonGroup ();
		radioFrance2 = new JRadioButton(france);
		radioAngleterre2 = new JRadioButton(angleterre);
		radioEtatsUnis2 = new JRadioButton(etatsUnis);
		radioEtatsUnis2.setSelected(true);
		radioAllemagne2 = new JRadioButton(allemagne);
		JPanel radioPanel2 = new JPanel(new GridLayout(0, 1));
		radioPanel2.add(radioFrance2);
		radioPanel2.add(radioAngleterre2);
		radioPanel2.add(radioEtatsUnis2);
		radioPanel2.add(radioAllemagne2);
		//radioPanel2.setOpaque(false);
		bg2.add(radioFrance2);
		bg2.add(radioAngleterre2);
		bg2.add(radioEtatsUnis2);
		bg2.add(radioAllemagne2);

		radioFrance2.addActionListener(this);
		radioAngleterre2.addActionListener(this);
		radioEtatsUnis2.addActionListener(this);
		radioAllemagne2.addActionListener(this);

		//JPanel
		this.setLayout(new BorderLayout());

		JPanel p = new JPanel();
		p.setLayout(new GridLayout(4,1,5,5));
		p.setOpaque(false);

		JPanel p2=new JPanel();
		p2.setOpaque(false);
		p2.setLayout(new FlowLayout(250,300,10));


		JPanel p3 = new JPanel();
		p3.setOpaque(false);
		p3.setLayout(new FlowLayout(20,200,15));

		JPanel p4 = new JPanel();
		p4.setOpaque(false);
		p4.setLayout(new FlowLayout(0,70,0));

		JPanel p5 = new JPanel();
		p5.setOpaque(false);
		p5.setLayout(new FlowLayout(20,200,15));

		try {
			img=ImageIO.read(new File("rsc/images/bg1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//JButton
		valider=new Bouton("Valider",pan,cl,"robots");
		retour=new Bouton("Retour",pan,cl,"jvj");

		// JLabel
		f=new Font(Font.DIALOG, Font.BOLD, 14);
		pays=new JLabel("Choisissez votre pays : ");
		pays.setOpaque(false);
		pays.setFont(f);
		pays.setForeground(Color.WHITE);

		e1=new JLabel("Joueur 1 :");
		e1.setOpaque(false);
		e1.setFont(f);
		e1.setForeground(Color.WHITE);

		e2=new JLabel("Joueur 2 :");
		e2.setOpaque(false);
		e2.setFont(f);
		e2.setForeground(Color.WHITE);


		//Position
		p3.add(e1);
		p3.add(e2);
		p5.add(radioPanel);
		p5.add(radioPanel2);
		p2.add(pays);
		p.add(p2);
		p.add(p3);
		p.add(p5);
		p4.add(retour);
		p4.add(valider);
		p.add(p4);
		this.add(BorderLayout.CENTER,p);
	}
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0,this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(radioFrance.isSelected()){
			choix1="France";
		}
		else if(radioAngleterre.isSelected()){
			choix1="Angleterre";
		}
		else if(radioEtatsUnis.isSelected()){
			choix1="Etats-unis";
		}
		else if(radioAllemagne.isSelected()){
			choix1="Allemagne";
		}

		else if(radioFrance2.isSelected()){
			choix2="France";
		}
		else if(radioAngleterre2.isSelected()){
			choix2="Angleterre";
		}
		else if(radioEtatsUnis2.isSelected()){
			choix2="Etats-unis";
		}
		else if(radioAllemagne2.isSelected()){
			choix2="Allemagne";
		}

	}
}
