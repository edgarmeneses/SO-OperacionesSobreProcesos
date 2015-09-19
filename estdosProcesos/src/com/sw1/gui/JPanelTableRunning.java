package com.sw1.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.sw1.logic.Transition;
import com.sw1.model.FinishedTableModel;
import com.sw1.model.RunningTableModel;

public class JPanelTableRunning extends JPanel {

	private JTable tableRunning;
	private RunningTableModel model;
	private Transition transition;

	public JPanelTableRunning(Transition transition) {

		this.transition = transition;
		init();
		tableRunning();
	}

	public void init(){
		this.setLayout(new GridLayout(4, 3));
		this.setBorder(new TitledBorder("En Ejecucion"));
	}

	public void tableRunning(){

		model = new RunningTableModel(transition);
		tableRunning = new JTable(model);
		JScrollPane jScrollPane = new JScrollPane(tableRunning);
		add(jScrollPane);
	}

	public void removeTable(){

		tableRunning.setModel(new RunningTableModel(transition));
		tableRunning.repaint();

	}
}
