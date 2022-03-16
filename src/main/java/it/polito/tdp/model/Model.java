package it.polito.tdp.model;

import java.security.InvalidParameterException;
import java.util.*;

public class Model {

	// Variabili del modello
	private int segreto;
	private final int TMAX = 8;
	private final int NMAX = 100;
	private int tentativiFatti;
	private Set<Integer> tentativi;
	private boolean inGioco = false;
	
	public void nuovaPartita() {
		this.segreto = (int)((Math.random() * NMAX) +1);
		this.tentativiFatti = 0;
		this.inGioco = true;
		tentativi = new HashSet<Integer>();

	}

	public int tentativo(Integer n) {
		
		if(!inGioco)
			throw new IllegalStateException("HAI PERSO! La partita è terminata.");
		if(!tentativoValido(n)) {
			throw new InvalidParameterException("Devi inserire un numero tra 1 e "+NMAX+" che non hai ancora utilizzato.");
		}
		
		this.tentativiFatti++;
		this.tentativi.add(n);
		
		if(this.tentativiFatti == TMAX)
			this.inGioco = false;
		
		if(n == segreto) {
			this.inGioco = false;
			return 0;
		} else if(n < segreto) {
			return -1;
		} else {
			return 1;
		}
		
	}
	
	public boolean tentativoValido(Integer n) {
		if(n < 1 || n > NMAX || this.tentativi.contains(n))
			return false;
		
		return true;
	}
	
	public int getSegreto() {
		return segreto;
	}

	public void setSegreto(int segreto) {
		this.segreto = segreto;
	}

	public int getTentativiFatti() {
		return tentativiFatti;
	}

	public void setTentativiFatti(int tentativiFatti) {
		this.tentativiFatti = tentativiFatti;
	}

	public int getTMAX() {
		return TMAX;
	}

	public int getNMAX() {
		return NMAX;
	}
	
}
