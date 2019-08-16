package br.com.alicio.projeto.model;

public class Banco {
	private int num_banco;
	private int idBanco;
	private String nm_banco;
	
	public int getNum_banco() {
		return num_banco;
	}
	public void setNum_banco(int num_banco) {
		this.num_banco = num_banco;
	}
	public int getIdBanco() {
		return idBanco;
	}
	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}
	public String getNm_banco() {
		return nm_banco;
	}
	public void setNm_banco(String nm_banco) {
		this.nm_banco = nm_banco;
	}
	
	@Override
	public String toString() {
		return "Banco [num_banco=" + num_banco + ", idBanco=" + idBanco + ", nm_banco=" + nm_banco + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idBanco;
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
		Banco other = (Banco) obj;
		if (idBanco != other.idBanco)
			return false;
		if (nm_banco == null) {
			if (other.nm_banco != null)
				return false;
		} else if (!nm_banco.equals(other.nm_banco))
			return false;
		if (num_banco != other.num_banco)
			return false;
		return true;
	}
}