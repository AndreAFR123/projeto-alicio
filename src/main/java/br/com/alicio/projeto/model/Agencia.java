package br.com.alicio.projeto.model;

public class Agencia {
	private int idAgencia;
	private int num_agencia;
	private String nm_agencia;
	
	
	public int getIdAgencia() {
		return idAgencia;
	}
	public void setIdAgencia(int idAgencia) {
		this.idAgencia = idAgencia;
	}
	public int getNum_agencia() {
		return num_agencia;
	}
	public void setNum_agencia(int num_agencia) {
		this.num_agencia = num_agencia;
	}
	public String getNm_agencia() {
		return nm_agencia;
	}
	public void setNm_agencia(String nm_agencia) {
		this.nm_agencia = nm_agencia;
	}
	
	@Override
	public String toString() {
		return "Agencia [idAgencia=" + idAgencia + ", num_agencia=" + num_agencia + ", nm_agencia=" + nm_agencia + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAgencia;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agencia other = (Agencia) obj;
		if (idAgencia != other.idAgencia)
			return false;
		if (nm_agencia == null) {
			if (other.nm_agencia != null)
				return false;
		} else if (!nm_agencia.equals(other.nm_agencia))
			return false;
		if (num_agencia != other.num_agencia)
			return false;
		return true;
	}	
}