package com.checkers.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class View {
	
	private int size_x;
	private int size_y;
	private JFrame window;
	private JMenuBar bar;
	private JPanel score;
	
	public View(int size_x, int size_y) {
		this.size_x = size_x;
		this.size_y = size_y;
		init_window();
	}
	
	private void init_window() {
		if (this.size_x != 0 
				&& this.size_y != 0) {
			window = new JFrame();
			window.setTitle("Cherckers V0.1");
			window.setSize(this.size_x, this.size_y);
			window.setResizable(false);
			window.setLayout(new BorderLayout());
			init_menu();
			init_score();
			window.setVisible(true);
		}
	}
	
	private void init_menu() {
		bar = new JMenuBar();
		JMenu file = new JMenu("Fichier");
		JMenuItem new_game = new JMenuItem("Nouvelle partie" );
		JMenuItem about = new JMenuItem("A propos" );
		JMenuItem quit = new JMenuItem("Quitter" );
		
		JMenu game = new JMenu("Jeu");
		JMenuItem save = new JMenuItem("Sauvegarder la partie");
		JMenuItem load = new JMenuItem("Charger la partie");
		JMenuItem restart = new JMenuItem("Recommencer la partie");
		
		file.add(new_game);
		file.add(about);
		file.add(quit);
		game.add(save);
		game.add(load);
		game.add(restart);
		bar.add(file);
		bar.add(game);
		bar.setVisible(true);
		window.add(bar,BorderLayout.NORTH);
	}
	
	private void init_score() {
		score = new JPanel();
		score.add(new JLabel("Score : 0"));
		window.add(score, BorderLayout.SOUTH);
		score.setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
