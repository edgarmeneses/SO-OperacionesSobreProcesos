package com.sw1.gui;


// panel principal 
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;

import com.sw1.logic.Transition;

public class JPanelFunction extends JPanel{

	private JPanelTableRunning running;
	private JPanelTableLocked locked;
	private JPanelTableFinished finished;
	private JPanelTableTimeout timeout;
	private JPanelTableDistroyed distroyed;
	private JPanelTableRestart restart;
	private JPanelTableComunicate comunicate;
	private JPanelReady ready;
	private JPanelProcess process;
	private Transition transition;
	private int DEFAUL_WIDTH=(MainWindow.DEFOULT_DIMENSION.width/7)*6;
	
	public JPanelFunction(Transition transition) {
		
		this.transition=transition;
		
		setBorder(new TitledBorder("Funcion"));
		setLayout(null);
		// TODO Auto-generated constructor stub
		init();
	}
	
	public void init(){
		//jPnlState = new JPanelListState();
		//this.add(jPnlState);
		
		
		restart = new JPanelTableRestart(transition);
		restart.setBounds(0, (MainWindow.DEFOULT_DIMENSION.height/2), (DEFAUL_WIDTH/5)-10, (int) (MainWindow.DEFOULT_DIMENSION.height*1.4));
		add(restart);
		
		comunicate = new JPanelTableComunicate(transition);
		comunicate.setBounds((DEFAUL_WIDTH/5),(MainWindow.DEFOULT_DIMENSION.height/2) , (DEFAUL_WIDTH/5)-10, (int) (MainWindow.DEFOULT_DIMENSION.height*1.4));
		add(comunicate);
		
		distroyed = new JPanelTableDistroyed(transition);
		distroyed.setBounds((DEFAUL_WIDTH/5)*2, (MainWindow.DEFOULT_DIMENSION.height/2), (DEFAUL_WIDTH/5)-10, (int) (MainWindow.DEFOULT_DIMENSION.height*1.4));
		add(distroyed);
		
		timeout = new JPanelTableTimeout(transition);
		timeout.setBounds((DEFAUL_WIDTH/5)*3, (MainWindow.DEFOULT_DIMENSION.height/2), (DEFAUL_WIDTH/5)-10, (int) (MainWindow.DEFOULT_DIMENSION.height*1.4));
	    add(timeout);
	    
	    finished = new JPanelTableFinished(transition);
		finished.setBounds((DEFAUL_WIDTH/5)*4, (MainWindow.DEFOULT_DIMENSION.height/2), (DEFAUL_WIDTH/5)-10,(int) (MainWindow.DEFOULT_DIMENSION.height*1.4));
	    add(finished);
	    
	    process = new JPanelProcess(transition);
	    process.setBounds( DEFAUL_WIDTH/2, 0, (DEFAUL_WIDTH/2)/3-10,(int) (MainWindow.DEFOULT_DIMENSION.height*1.4)-20);
	    add(process);
	    
		running = new JPanelTableRunning(transition);
		running.setBounds((DEFAUL_WIDTH/2)+(DEFAUL_WIDTH/2)/3, 0, (DEFAUL_WIDTH/2)/3-10, (int) (MainWindow.DEFOULT_DIMENSION.height*1.4)-20);
		add(running);
		
		locked = new JPanelTableLocked(transition);
		locked.setBounds((DEFAUL_WIDTH/2)+(((DEFAUL_WIDTH/2)/3)*2), 0,(DEFAUL_WIDTH/2)/3-10, (int) (MainWindow.DEFOULT_DIMENSION.height*1.4)-20);
	    add(locked);
	    
	    ready = new JPanelReady(transition);
	    ready.setBounds(0, 0, (DEFAUL_WIDTH/2)-10, (int)(MainWindow.DEFOULT_DIMENSION.height*1.4)-20);
	    add(ready);
	    
	    
	}

	public JPanelTableTimeout getTimeout() {
		return timeout;
	}

	public void setTimeout(JPanelTableTimeout timeout) {
		this.timeout = timeout;
	}

	public JPanelTableDistroyed getDistroyed() {
		return distroyed;
	}

	public void setDistroyed(JPanelTableDistroyed distroyed) {
		this.distroyed = distroyed;
	}

	public JPanelTableRestart getRestart() {
		return restart;
	}

	public void setRestart(JPanelTableRestart restart) {
		this.restart = restart;
	}

	public JPanelTableComunicate getComunicate() {
		return comunicate;
	}

	public void setComunicate(JPanelTableComunicate comunicate) {
		this.comunicate = comunicate;
	}

	public JPanelTableRunning getRunning() {
		return running;
	}

	public void setRunning(JPanelTableRunning running) {
		this.running = running;
	}

	public JPanelTableLocked getLocked() {
		return locked;
	}

	public void setLocked(JPanelTableLocked locked) {
		this.locked = locked;
	}

	public JPanelTableFinished getFinished() {
		return finished;
	}

	public void setFinished(JPanelTableFinished finished) {
		this.finished = finished;
	}

	public JPanelReady getReady() {
		return ready;
	}

	public void setReady(JPanelReady ready) {
		this.ready = ready;
	}

	public JPanelProcess getProcess() {
		return process;
	}

	public void setProcess(JPanelProcess process) {
		this.process = process;
	}
	
	
	
}
