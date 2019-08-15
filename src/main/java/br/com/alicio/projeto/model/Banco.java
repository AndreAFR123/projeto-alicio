package br.com.alicio.projeto.model;

public class Banco {
	private int numeroBanco;

	private String nomeBanco;

	public int getNumeroBanco() {
		return numeroBanco;
	}

	public void setNumeroBanco(int numeroBanco) {
		this.numeroBanco = numeroBanco;
	}

	public String getNomeBanco() {
		return nomeBanco;
	}

	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}

	@Override
	public String toString() {
		return "Banco [numeroBanco=" + numeroBanco + ", nomeBanco=" + nomeBanco + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numeroBanco;
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
		if (nomeBanco == null) {
			if (other.nomeBanco != null)
				return false;
		} else if (!nomeBanco.equals(other.nomeBanco))
			return false;
		if (numeroBanco != other.numeroBanco)
			return false;
		return true;
	}
	
	

}
