package com.solutis.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Capsula {
	
	@Id
	@GeneratedValue
	private	long 	idCapsula;
	private String	nomeCapsula;
	private String	saborCapsula;
	
	public Capsula(String nomeCapsula, String saborCapsula) {
		this.nomeCapsula = nomeCapsula;
		this.saborCapsula = saborCapsula;
	}

	public Capsula() {

	}

	public long getIdCapsula() {
		return idCapsula;
	}

	public void setIdCapsula(long idCapsula) {
		this.idCapsula = idCapsula;
	}

	public String getNomeCapsula() {
		return nomeCapsula;
	}

	public void setNomeCapsula(String nomeCapsula) {
		this.nomeCapsula = nomeCapsula;
	}

	public String getSaborCapsula() {
		return saborCapsula;
	}

	public void setSaborCapsula(String saborCapsula) {
		this.saborCapsula = saborCapsula;
	}

	@Override
	public String toString() {
		return "Capsula [idCapsula=" + idCapsula + ", nomeCapsula=" + nomeCapsula + ", saborCapsula=" + saborCapsula
				+ "]";
	}
	
}
