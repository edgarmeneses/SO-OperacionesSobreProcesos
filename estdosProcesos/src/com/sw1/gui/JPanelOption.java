package com.sw1.gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import com.sw1.logic.Transition;

public class JPanelOption extends JPanel {

	private JLabel labelAdd;
	private JLabel labelRun;
	private JLabel labelReport;
	private JLabel labelSetting;
	private JLabel labelExit;
	private MainWindow window;
	private WindowsCreateProcess createProcess;
	private Transition transition;
	private JPanelReady ready;
	private JPanelProcess process;
	private JPanelTableLocked locked;
	private JPanelTableFinished finished;
	private JPanelTableRunning running;

	public JPanelOption(Transition transition, JPanelReady ready, JPanelProcess process, JPanelTableLocked locked,
			JPanelTableFinished finished, JPanelTableRunning running, MainWindow window) {

		this.transition=transition;
		this.ready=ready;
		this.process=process;
		this.locked = locked;
		this.finished = finished;
		this.running = running;
		this.window = window;
		
		this.setLayout(null);
		this.setBackground(new Color(223,211,182));

		addProcess();
		running();
		setting();
		exit();
	}

	public void addProcess(){

		labelAdd = new JLabel("crear");
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/agregarp.png"));
		labelAdd.setIcon(icon);
		labelAdd.setBounds(50, (MainWindow.DEFOULT_DIMENSION.height/4)-130, 100, 100);
		labelAdd.addMouseListener(new MouseListener() {

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				labelAdd.setToolTipText("Crear nuevo proceso");

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				window = new MainWindow(transition);
				createProcess = new WindowsCreateProcess(window,transition,ready);
				createProcess.setVisible(true);


			}


		});

		this.add(labelAdd);

	}


	public void running(){

		labelRun = new JLabel();
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/ejecutarp.png"));
		labelRun.setIcon(icon);
		labelRun.setBounds(50,(MainWindow.DEFOULT_DIMENSION.height/4)*2-130, 100, 100);
		labelRun.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				labelRun.setToolTipText("Ejecutar");

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				if(!transition.getReady().getReady().isEmpty()){
					labelAdd.setEnabled(false);
					labelSetting.setEnabled(true);
					startProces();
					transition.runProcess();
					process.removeTable();
					locked.removeTable();
					finished.removeTable();
					running.removeTable();
				}else{
					JOptionPane.showMessageDialog(null, "Para ejecutar deben existir procesos");
				}
			}
		});

		this.add(labelRun);

	}



	public void setting(){

		labelSetting = new JLabel();
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/configuracion.png"));
		labelSetting.setIcon(icon);
		labelSetting.setBounds(50, (MainWindow.DEFOULT_DIMENSION.height/4)*3-130, 100, 100);
		labelSetting.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				labelSetting.setToolTipText("Configuración");
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				
				PropertiesWindow propertiesWindow = new PropertiesWindow(window, transition);
				propertiesWindow.setVisible(true);
			}
		});

		this.add(labelSetting);

	}

	public void exit(){

		labelExit = new JLabel();
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/salir.png"));
		labelExit.setIcon(icon);
		labelExit.setBounds(50, (MainWindow.DEFOULT_DIMENSION.height/4)*4-130, 100, 100);
		labelExit.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				labelExit.setToolTipText("Salir");
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir?", "Confirmación de salida",  JOptionPane.YES_NO_OPTION);
				if(option==0){
					System.exit(0);

				}
			}
		});

		this.add(labelExit);

	}
	
	public void startProces(){
		ProgressBar mainFrame = new ProgressBar();
		mainFrame.setVisible(true);
		mainFrame.pack();
	}

}
