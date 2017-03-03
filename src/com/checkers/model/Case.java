package com.checkers.model;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Case extends JButton{

	private int column;
	private int line;
	private String color;
	private boolean available;

	public Case(int column, int line, String color, boolean available) {
		super();
		setCouleur(color);
		setColumn(column);
		setLine(line);
	}


	public String getCouleur() {
		return color;
	}
	public void setCouleur(String couleur) {
		this.color = couleur;
		if(couleur.compareTo("Blanc" )==0)
			setIcon(new ImageIcon("img/blanc.jpg"));
		if(couleur.compareTo("Noir" )==0)
			setIcon(new ImageIcon("img/brun.jpg"));
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int colonne) {
		this.column = colonne;
	}
	public int getLine() {
		return line;
	}
	public void setLine(int ligne) {
		this.line = ligne;
	}
	public boolean isAvailable() {
		return available;
	}

}
