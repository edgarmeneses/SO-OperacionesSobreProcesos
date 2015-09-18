package com.sw1.gui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.ProcessBuilder.Redirect;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

import com.sw1.logic.Process;
import com.sw1.logic.Transition;

public class WindowsCreateProcess  extends JDialog {

	private JLabel lblName;
	private JLabel lblPriority;
	private JLabel lblTime;
	private JLabel lblBloqueade;
	private JTextField txtName;
	private JTextField txtPriority;
	private JTextField txtTime;
	private JComboBox<String>  txtBloqueade;
	private JButton btnCreate;
	private Transition transition;
	private JPanelReady ready;


	public WindowsCreateProcess(MainWindow window,Transition transition, JPanelReady ready) {
		super(window, true);
		this.transition=transition;
		this.ready=ready;
		init();
	}

	public void init(){

		this.setTitle("Crear Proceso");
		this.setSize(400, 400);
		this.setLocationRelativeTo(null);

		this.lblName = new JLabel("Nombre:");
		this.lblName.setBounds(100, 20, 100, 30);
		this.lblName.setVisible(true);


		this.txtName = new JTextField();
		this.txtName.setBounds(170, 20, 100, 30);
		this.txtName.setVisible(true);
		validateSpaces(txtName);

		this.lblPriority = new JLabel("Prioridad:");
		this.lblPriority.setBounds(100, 80, 100, 30);
		this.lblPriority.setVisible(true);

		this.txtPriority = new JTextField();
		this.txtPriority.setBounds(170, 80, 100, 30);
		this.txtPriority.setVisible(true);
		validateNumber(txtPriority);


		this.lblTime = new JLabel("Tiempo:");
		this.lblTime.setBounds(100, 140, 120, 30);
		this.lblTime.setVisible(true);

		this.txtTime = new JTextField();
		this.txtTime.setBounds(170, 140, 100, 30);
		this.txtTime.setVisible(true);
		validateNumber(txtTime);

		this.lblBloqueade = new JLabel("Bloqueado:");
		this.lblBloqueade.setBounds(100, 200, 100, 30);
		this.lblBloqueade.setVisible(true);

		this. txtBloqueade= new JComboBox<>();
		this.txtBloqueade.setBounds(170,200, 100, 30);
		this.txtBloqueade.setVisible(true);
		this.txtBloqueade.addItem("Si");
		this.txtBloqueade.addItem("No");



		this.add(lblName);
		this.add(txtName);
		this.add(lblPriority);
		this.add(txtPriority);
		this.add(lblTime);
		this.add(txtTime);
		this.add(lblBloqueade);
		this.add(txtBloqueade);
		addProcess();

		this.getContentPane().setLayout(null);

	}

	public void addProcess(){
		this.btnCreate= new JButton("Crear");
		this.btnCreate.setBounds(150,280, 100, 30);
		this.btnCreate.setVisible(true);
		this.add(btnCreate);
		this.btnCreate.addMouseListener(new MouseListener() {

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
				if(validatCrear()){
					if(!valiateName()){
//						transition.getReady().add(new Process(txtName.getText().toUpperCase(), validateLocked(), Integer.parseInt(txtPriority.getText()), Integer.parseInt(txtTime.getText())));
						ready.removeTable();
						clearProcess();
					}else{
						JOptionPane.showMessageDialog(null, "El nombre del proceso ya existe ");
					}
				}else{
					JOptionPane.showMessageDialog(null, "Debe llenar todos los campos para "
							+ "crear un proceso");
				}
			}
		});   
	}

	public boolean validateLocked(){
		return  txtBloqueade.getSelectedItem().equals("Si");
	}

	public void clearProcess(){
		txtName.setText("");
		txtPriority.setText("");
		txtTime.setText("");
	}

	public void validateNumber(JTextField field){
		field.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent ke) {
				// TODO Auto-generated method stub
				char c=ke.getKeyChar();

				String txt=field.getText();

				if(!Character.isDigit(c) && !(ke.getKeyChar()==ke.VK_BACK_SPACE)
						&& !(ke.getKeyChar()==ke.VK_DELETE)) {
					getToolkit().beep();

					ke.consume();
					JOptionPane.showMessageDialog(null, "Solo se pueden ingresar numeros");
					field.setText(txt);

				}

			}
		});
	}

	public void validateSpaces(JTextField field){
		field.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent ke) {
				// TODO Auto-generated method stub
				char c=ke.getKeyChar();

				String txt=field.getText();
				if(!Character.isAlphabetic(c) && !Character.isDigit(c)) {
					getToolkit().beep();

					ke.consume();
					field.setText(txt);

				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	public boolean validatCrear(){
		return !txtName.getText().equalsIgnoreCase("") &&
				!txtPriority.getText().equalsIgnoreCase("") &&
				!txtTime.getText().equalsIgnoreCase("");
	}

	public boolean valiateName(){
		for (Process process : transition.getReady().getReady()) {
			if(process.getName().equalsIgnoreCase(txtName.getText())){
				return true;
			}
		}
		return false;
	}
	
	public boolean valiatepecialCharacters(KeyEvent event){
		
		return event.getKeyCode()>=33 && event.getKeyCode()<=47 ||
			   event.getKeyCode()>=58 && event.getKeyCode()<=64 ||
			   event.getKeyCode()>=123 && event.getKeyCode()<=170 ;
		
//		String REG_EXP="\\¿+|\\?+|\\°+|\\¬+|\\|+|\\!+|\\#+|\\$+|"+
//		"\\%+|\\&+|\\+|\\=+|\\’+|\\¡+|\\++|\\*+|\\~+|\\[+|\\"+
//		"+|\\{+|\\}+|\\^+|\\<+|\\>+|\\\"+";
//		Pattern pattern = Pattern.compile(REG_EXP);
//		Matcher matcher = pattern.matcher(cadena);
//		return matcher.find();
	}

}
