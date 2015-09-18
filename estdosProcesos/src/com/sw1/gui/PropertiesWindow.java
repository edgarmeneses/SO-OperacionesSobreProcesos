package com.sw1.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sw1.logic.Process;
import com.sw1.logic.Transition;

public class PropertiesWindow extends JDialog {

	private JLabel labelQuantum;
	private JLabel labelValueQuantum;
	private JLabel labelNewQuantum;
	private JTextField textQuantum;
	private JButton buttonOk;
	private JButton buttonNew;
	private MainWindow window;
	private Transition transition;
	
	public PropertiesWindow(MainWindow mainWindow, Transition transition) {
		
		super(mainWindow, true);
		this.transition=transition;
		this.window =mainWindow;
		this.setTitle("Configuración");
		this.setSize(400, 250);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null);
		init();
		acceptChanges();
		newProject();
	
	}
	
	public void init(){ 

	this.labelQuantum = new JLabel("Quantum Actual:");
	this.labelQuantum.setBounds(40, 20, 130, 30);
	this.add(labelQuantum);
	
	this.labelValueQuantum = new JLabel();
	this.labelValueQuantum.setBounds(150, 20, 20, 30);
	this.labelValueQuantum.setText(Integer.toString(transition.getQuantum()));
	this.add(labelValueQuantum);
	
	this.labelNewQuantum = new JLabel("Nuevo Quantum:");
	this.labelNewQuantum.setBounds(40, 60, 130, 30);
	this.add(labelNewQuantum);
	
	this.textQuantum = new JTextField();
	this.textQuantum.setBounds(150, 60, 100, 30);
	this.textQuantum.setVisible(true);
	this.add(textQuantum);
	
	}
	
	public void acceptChanges(){
		this.buttonOk= new JButton("Aceptar");
		this.buttonOk.setBounds(270, 60, 100, 30);
		this.buttonOk.setVisible(true);
		this.add(buttonOk);
		this.buttonOk.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub	
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub	
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				int response = JOptionPane.showConfirmDialog(null, "¿Desea realizar los cambios?", "Confirmar",
															JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
				
			    if (response == JOptionPane.NO_OPTION) {
			  
			    } else if (response == JOptionPane.YES_OPTION) {
			    	int quantum = Integer.parseInt(textQuantum.getText());
					transition.setQuantum(quantum);
					labelValueQuantum.setText(textQuantum.getText());
					textQuantum.setText("");
			    } else if (response == JOptionPane.CLOSED_OPTION) {
			    
			    }
			  }
		});
	}
	
	public void newProject(){
		this.buttonNew= new JButton("Nuevo proyecto");
		this.buttonNew.setBounds(130,130, 130, 30);
		this.buttonNew.setVisible(true);
		this.add(buttonNew);
		this.buttonNew.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub	
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub	
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				window.setVisible(false);
				MainWindow mainWindow = new MainWindow(new Transition(5));
				mainWindow.setVisible(true);
				
				
			}
		});
	}
	
	public void ennableWindow(){
		this.setVisible(false);
	}
	
}
