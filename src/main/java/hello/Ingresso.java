package hello;

import java.util.LinkedList;
import java.util.List;

public class Ingresso {
	private String nomeFilme;
	private double precoIngresso;
	private List<Cadeira> cadeiras = new LinkedList<Cadeira>();
	
	public Ingresso(String nomeFilme) {
		this.setNomeFilme(nomeFilme);
		this.setPrecoIngresso(23.50);
		this.setCadeiras(cadeiras);
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public double getPrecoIngresso() {
		return precoIngresso;
	}

	public void setPrecoIngresso(double precoIngresso) {
		this.precoIngresso = precoIngresso;
	}

	public List<Cadeira> getCadeiras() {
		return cadeiras;
	}

	public void setCadeiras(List<Cadeira> cadeiras) {
		this.cadeiras = cadeiras;
	}
}
