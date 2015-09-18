package com.sw1.logic;
/**
 * Universidad Pedagogica y Tecnologica de Colombia
 * Docente : Juan Jose Camargo Vega
 * @author Natalie Santiago, Eliana Ayala, Edgar Meneses
 * Sistemas Operativos
 * Version 1.0
 * Clase que contiene los procesos  que va a tener el sistema
 */
public class Process {
	
	/**
	 * Atributos de la clase Procesos
	 */
	private String name;
	private int time;
	private int priority;
	private boolean  locked;
	private boolean running;
	private boolean destroyed;
	private boolean comunicate ;
	private boolean restart;
	private State state;                        
	/**
	 * Constructor vacio  de la clase Procesos
	 */
	
	public Process(){
		
	}
	/**
	 * Constructor con los atributos de la clase Procesos
	 */
   
    /**
     * Getters y Setters 
     * @return
     */
	public String getName() {
		return name;
	}
	public Process(String name, int time, int priority,
			boolean running, boolean locked, boolean destroyed, boolean comunicate,
			boolean restart) {
		super();
		this.name = name;
		this.time = time;
		this.priority = priority;
		this.locked = locked;
		this.running = running;
		this.destroyed = destroyed;
		this.comunicate = comunicate;
		this.restart = restart;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public boolean isRunning() {
		return running;
	}
	public void setRunning(boolean running) {
		this.running = running;
	}
	public boolean isDestroyed() {
		return destroyed;
	}
	public void setDestroyed(boolean destroyed) {
		this.destroyed = destroyed;
	}
	public boolean isComunicate() {
		return comunicate;
	}
	public void setComunicate(boolean comunicate) {
		this.comunicate = comunicate;
	}
	public boolean isRestart() {
		return restart;
	}
	public void setRestart(boolean restart) {
		this.restart = restart;
	}
	@Override
	public String toString() {
		return "Process [name=" + name + ", time=" + time + ", priority="
				+ priority + ", locked=" + locked + ", running=" + running
				+ ", destroyed=" + destroyed + ", comunicate=" + comunicate
				+ ", restart=" + restart + ", state=" + state + "]";
	}  

}
