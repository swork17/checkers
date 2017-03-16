package com.checkers.model;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;

import com.checkers.view.View;

public class Case extends JButton {

	protected int column;
	protected int line;
	protected String color;
	protected boolean available;
	private EventListenerList listeners;

	public Case(int line, int column, String color, boolean available) {
		super();
		setColumn(column);
		setLine(line);
		setCouleur(color);
		this.setOpaque(true);
		this.available = available;

	}

	public String getCouleur() {
		return color;
	}

	public void setCouleur(String couleur) {
		this.color = couleur;
		if (couleur.compareTo("yellow") == 0)
			setIcon(new ImageIcon("img/yellow.jpg"));
		if (couleur.compareTo("White") == 0) {
			setIcon(new ImageIcon("img/blanc.jpg"));
			this.setEnabled(true);
		}

		if (couleur.compareTo("Black") == 0) {
			setIcon(new ImageIcon("img/brun.jpg"));
			if (this.line < (View._SIZE_X / 2) - 1) {
				Pawn jp = new Pawn("black", this.column, this.line, false);
				jp.addActionListener(this.actionListener);
				jp.setBorderPainted(false);
				this.add(jp);
				this.available = false;
				System.out.println("Set pawn, case is " + this.isAvailable());
			} else if (this.line > (View._SIZE_X / 2)) {
				Pawn jp = new Pawn("white", this.column, this.line, false);
				jp.addActionListener(this.actionListener);
				jp.setBorderPainted(false);
				this.add(jp);
			}
			
		}
	}

	public void setColorAfter(String couleur) {
		if (couleur.compareTo("yellow") == 0)
			setIcon(new ImageIcon ("img/yellow.jpg"));
		if (couleur.compareTo("White") == 0) {
			setIcon(new ImageIcon("img/blanc.jpg"));
			this.setEnabled(true);
		}
		if (couleur.compareTo("Black") == 0) {
			setIcon(new ImageIcon("img/brun.jpg"));
		}
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