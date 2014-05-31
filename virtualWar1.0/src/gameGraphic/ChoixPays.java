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
import javax.swing.ImageIcon;
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
	JLabel d1;
	JLabel d2;
	JButton valider;
	ImageIcon i1;
	ImageIcon i2;
	final static String france ="France";
	final static String angleterre ="Angleterre";
	final static String etatsUnis ="Etats-Unis";
	final static String allemagne ="Allemagne";
	static String choix1="France";
	static String choix2="Etats-Unis";
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

		i1=new ImageIcon("rsc/images/flags/France.png");
		i2=new ImageIcon("rsc/images/flags/Etats-Unis.png");
		d1=new JLabel(i1);
		d2=new JLabel(i2);

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
		bg2.add(radioFrance2);
		bg2.add(radioAngleterre2);
		bg2.add(radioEtatsUnis2);
		bg2.add(radioAllemagne2);

		radioFrance2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				choix2="France";
				ChoixRobot.l1.setIcon(new ImageIcon("rsc/images/tanks/"+choix1+".png"));
				ChoixRobot.l2.setIcon(new ImageIcon("rsc/images/piegeurs/"+choix1+".png"));
				ChoixRobot.l3.setIcon(new ImageIcon("rsc/images/tanks/"+choix1+".png"));
				d2.setIcon(new ImageIcon("rsc/images/flags/France.png"));
			}

		});
		radioAngleterre2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				choix2="Angleterre";
				ChoixRobot.l1.setIcon(new ImageIcon("rsc/images/tanks/"+choix1+".png"));
				ChoixRobot.l2.setIcon(new ImageIcon("rsc/images/piegeurs/"+choix1+".png"));
				ChoixRobot.l3.setIcon(new ImageIcon("rsc/images/tanks/"+choix1+".png"));
				d2.setIcon(new ImageIcon("rsc/images/flags/Angleterre.png"));

			}

		});
		radioEtatsUnis2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				choix2="Etats-Unis";
				ChoixRobot.l1.setIcon(new ImageIcon("rsc/images/tanks/"+choix1+".png"));
				ChoixRobot.l2.setIcon(new ImageIcon("rsc/images/piegeurs/"+choix1+".png"));
				ChoixRobot.l3.setIcon(new ImageIcon("rsc/images/tanks/"+choix1+".png"));
				d2.setIcon(new ImageIcon("rsc/images/flags/Etats-Unis.png"));
			}

		});
		radioAllemagne2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				choix2="Allemagne";
				ChoixRobot.l1.setIcon(new ImageIcon("rsc/images/tanks/"+choix1+".png"));
				ChoixRobot.l2.setIcon(new ImageIcon("rsc/images/piegeurs/"+choix1+".png"));
				ChoixRobot.l3.setIcon(new ImageIcon("rsc/images/tanks/"+choix1+".png"));
				d2.setIcon(new ImageIcon("rsc/images/flags/Allemagne.png"));
			}

		});

		//JPanel
		this.setLayout(new BorderLayout());

		JPanel p = new JPanel();
		p.setLayout(new GridLayout(5,1,0,0));
		p.setOpaque(false);

		JPanel p2=new JPanel();
		p2.setOpaque(false);
		p2.setLayout(new FlowLayout(0,320,0));


		JPanel p3 = new JPanel();
		p3.setOpaque(false);
		p3.setLayout(new FlowLayout(0,200,0));

		JPanel p4 = new JPanel();
		p4.setOpaque(false);
		p4.setLayout(new FlowLayout(0,70,10));

		JPanel p5 = new JPanel();
		p5.setOpaque(false);
		p5.setLayout(new FlowLayout(0,200,0));

		JPanel p6 = new JPanel();
		p6.setOpaque(false);
		p6.setLayout(new FlowLayout(0,185,0));

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
		p6.add(d1);
		p6.add(d2);
		p3.add(e1);
		p3.add(e2);
		p5.add(radioPanel);
		p5.add(radioPanel2);
		p2.add(pays);
		p.add(p2);
		p.add(p3);
		p.add(p6);
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
			ChoixRobot.l1.setIcon(new ImageIcon("rsc/images/tanks/"+choix1+".png"));
			ChoixRobot.l2.setIcon(new ImageIcon("rsc/images/piegeurs/"+choix1+".png"));
			ChoixRobot.l3.setIcon(new ImageIcon("rsc/images/tanks/"+choix1+".png"));
			d1.setIcon(new ImageIcon("rsc/images/flags/France.png"));
		}
		else if(radioAngleterre.isSelected()){
			choix1="Angleterre";
			ChoixRobot.l1.setIcon(new ImageIcon("rsc/images/tanks/"+choix1+".png"));
			ChoixRobot.l2.setIcon(new ImageIcon("rsc/images/piegeurs/"+choix1+".png"));
			ChoixRobot.l3.setIcon(new ImageIcon("rsc/images/tanks/"+choix1+".png"));
			d1.setIcon(new ImageIcon("rsc/images/flags/Angleterre.png"));
		}
		else if(radioEtatsUnis.isSelected()){
			choix1="Etats-Unis";
			ChoixRobot.l1.setIcon(new ImageIcon("rsc/images/tanks/"+choix1+".png"));
			ChoixRobot.l2.setIcon(new ImageIcon("rsc/images/piegeurs/"+choix1+".png"));
			ChoixRobot.l3.setIcon(new ImageIcon("rsc/images/tanks/"+choix1+".png"));
			d1.setIcon(new ImageIcon("rsc/images/flags/Etats-Unis.png"));
		}
		else if(radioAllemagne.isSelected()){
			choix1="Allemagne";
			ChoixRobot.l1.setIcon(new ImageIcon("rsc/images/tanks/"+choix1+".png"));
			ChoixRobot.l2.setIcon(new ImageIcon("rsc/images/piegeurs/"+choix1+".png"));
			ChoixRobot.l3.setIcon(new ImageIcon("rsc/images/tanks/"+choix1+".png"));
			d1.setIcon(new ImageIcon("rsc/images/flags/Allemagne.png"));
		}
	}
}
