package com.checkers.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class View {
	
	private int size_x;
	private int size_y;
	private JFrame window;
	private JMenuBar bar;
	
	public View(int size_x, int size_y) {
		this.size_x = size_x;
		this.size_y = size_y;
		init_window();
		init_menu();
	}
	
	private void init_window() {
		if (this.size_x != 0 
				&& this.size_y != 0) {
			window = new JFrame();
			window.setTitle("Cherckers V0.1");
			window.setSize(this.size_x, this.size_y);
			window.setResizable(false);
			window.setLayout(new BorderLayout());
			window.setVisible(true);
		}
	}
	
	private void init_menu() {
		bar = new JMenuBar();
		JMenu fichier = new JMenu("Fichier" );
		JMenuItem new_game = new JMenuItem("Nouvelle partie" );
		JMenuItem about = new JMenuItem("A propos" );
		JMenuItem quit = new JMenuItem("Quitter" );
		fichier.add(new_game);
		fichier.add(about);
		fichier.add(quit);
		bar.add(fichier);
		window.add(bar,BorderLayout.NORTH);
	}
}
