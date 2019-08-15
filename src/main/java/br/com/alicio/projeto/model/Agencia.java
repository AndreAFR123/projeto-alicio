package br.com.alicio.projeto.model;

public class Agencia {
	private int numeroAgencia;

	private String nomeAgencia;

	public int getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(int numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}
	
	public String getNomeAgencia() {
		return nomeAgencia;
	}

	public void setNomeAgencia(String nomeAgencia) {
		this.nomeAgencia = nomeAgencia;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numeroAgencia;
		return result;
	}

	@Override
	public String toString() {
		return "Agencia [numeroAgencia=" + numeroAgencia + ", nomeAgencia=" + nomeAgencia + "]";
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
		if (nomeAgencia == null) {
			if (other.nomeAgencia != null)
				return false;
		} else if (!nomeAgencia.equals(other.nomeAgencia))
			return false;
		if (numeroAgencia != other.numeroAgencia)
			return false;
		return true;
	}

	

	
	
}
