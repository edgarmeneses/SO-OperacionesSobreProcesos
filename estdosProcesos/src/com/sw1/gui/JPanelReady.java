package com.sw1.gui;

// Listos 
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.text.DefaultEditorKit;

import com.sw1.logic.Transition;
import com.sw1.model.RenderLabelModel;
import com.sw1.model.ReadyTableModel;

public class JPanelReady extends JPanel{

	private JTable tableReady;
	private ReadyTableModel model ;
	private Transition transition;

	public JPanelReady(Transition transition) {
		// TODO Auto-generated constructor stub

		this.transition=transition;
		init();
	}
	
	private void init(){
		this.setBorder(new TitledBorder("Procesos Originales"));
		this.setLayout(new GridLayout(3, 2));
		model = new ReadyTableModel(transition);
		 tableReady = new JTable(model);
		JScrollPane jScrollPane = new JScrollPane(tableReady);
		add(jScrollPane);
	}
	
	public void removeTable(){
		tableReady.setModel(new ReadyTableModel(transition));
		tableReady.repaint();
	}
	
	
}
