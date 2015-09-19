package com.sw1.gui;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;

import com.sw1.logic.Process;
import com.sw1.logic.Transition;
import com.sw1.model.LockedTableModel;
import com.sw1.model.RunningTableModel;

public class JPanelTableLocked extends JPanel{

	private JTable tableLocked;
	private LockedTableModel model;
	private Transition transition;


	public JPanelTableLocked(Transition transition) {

		this.transition = transition;
		init();
		tableLocked();
	}

	public void init(){
		this.setLayout(new GridLayout(4, 3));
		this.setBorder(new TitledBorder("Bloqueo"));
	}


	public void tableLocked(){
		model = new LockedTableModel(transition);
		tableLocked = new JTable(model);
		JScrollPane jScrollPane = new JScrollPane(tableLocked);
		add(jScrollPane);
	}

	public void removeTable(){
		for (Process process : transition.getBlock().getListHistoryLock()) {
			System.out.println("NNNN"+ process);
		}
		
		tableLocked.setModel(new LockedTableModel(transition));
		tableLocked.repaint();
		
	}

}
